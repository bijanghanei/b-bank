FROM openjdk:21
LABEL authors="Bijan Ghanei"
COPY target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service.jar
#EXPOSE 8081
ENTRYPOINT ["java", "-jar","/transaction-service.jar"]