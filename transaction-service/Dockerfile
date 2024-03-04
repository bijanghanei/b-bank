FROM openjdk:17
LABEL authors="Bijan Ghanei"
COPY target/wallet-service-0.0.1-SNAPSHOT.jar wallet-service.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","/wallet-service.jar"]