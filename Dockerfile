FROM openjdk:11-jre-slim
MAINTAINER "Daniel Morrison"
WORKDIR /app
ADD ./data/iguanas.json /app/data/
COPY ./build/libs/*.jar ./app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

