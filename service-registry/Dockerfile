FROM openjdk:17
LABEL authors="Bijan Ghanei"
COPY target/service-registry-0.0.1-SNAPSHOT.jar service-registry.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar","/service-registry.jar"]