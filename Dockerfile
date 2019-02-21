FROM maven:latest as maven-build
WORKDIR /build
COPY . .
RUN mvn clean package
FROM java:8
WORKDIR /opt/website
EXPOSE 8087
COPY --from=maven-build /build/target/ApartmentManager-MongoRetriever-0.0.1-SNAPSHOT.jar mongoretiever.jar
ENTRYPOINT ["java", "-jar", "mongoretriever.jar"]
