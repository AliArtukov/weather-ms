FROM openjdk:11

COPY target/weather-ms-1.0.1.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java","-jar","weather-ms-1.0.1.jar"]
EXPOSE 8091