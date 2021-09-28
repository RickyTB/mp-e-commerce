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
ADD ./service-sales/settings.gradle .
ADD ./service-sales/build.gradle .

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
ADD ./service-sales/src src
RUN gradle assemble
RUN echo "done!"

# 2nd stage, build the runtime image
FROM openjdk:11-jre-slim
WORKDIR /helidon

# Copy the binary built in the 1st stage
COPY --from=build /helidon/build/libs/service-sales.jar ./
COPY --from=build /helidon/build/libs/libs ./libs

CMD ["java", "-jar", "service-sales.jar"]

EXPOSE 8003