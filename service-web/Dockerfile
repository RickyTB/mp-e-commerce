# 1st stage, build the app
FROM gradle:7.2.0-jdk11 as build

WORKDIR /helidon

# Create a first layer to cache the "Maven World" in the local repository.
# Incremental docker builds will always resume after that, unless you update
# the pom
ADD ./service-web/settings.gradle .
ADD ./service-web/build.gradle .

# Do the Maven build!
# Incremental docker builds will resume here when you change sources
ADD ./service-web/src src
RUN gradle assemble
RUN echo "done!"

# 2nd stage, build the runtime image
FROM openjdk:11-jre-slim
WORKDIR /helidon

# Copy the binary built in the 1st stage
COPY --from=build /helidon/build/libs/ecommerce-web.jar ./
COPY --from=build /helidon/build/libs/libs ./libs

CMD ["java", "-jar", "ecommerce-web.jar"]

EXPOSE 8180