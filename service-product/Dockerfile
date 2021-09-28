# 1st stage, build the app
FROM gradle:7.2.0-jdk11 as build

# Copy shared lib
WORKDIR /service-domain

ADD ./service-domain/settings.gradle .
ADD ./service-domain/build.gradle .
ADD ./service-domain/src src

WORKDIR /helidon

# Create a first layer to cache the "Maven World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD ./service-product/settings.gradle .
ADD ./service-product/build.gradle .

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
ADD ./service-product/src src
RUN gradle assemble
RUN echo "done!"

# 2nd stage, build the runtime image
FROM openjdk:11-jre-slim
WORKDIR /helidon

# Copy the binary built in the 1st stage
COPY --from=build /helidon/build/libs/service-product.jar ./
COPY --from=build /helidon/build/libs/libs ./libs

CMD ["java", "-jar", "service-product.jar"]

EXPOSE 8002