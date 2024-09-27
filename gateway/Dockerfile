FROM openjdk:21
LABEL authors="Bijan Ghanei"
COPY target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar","/gateway.jar"]