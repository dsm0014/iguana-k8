FROM openjdk:11-jre-slim
MAINTAINER "Daniel Morrison"
WORKDIR /app

COPY ./build/libs/*.jar ./app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

