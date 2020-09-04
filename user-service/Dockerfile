FROM openjdk:latest
EXPOSE 8080
ADD target/*.jar user-api.jar
ENTRYPOINT ["sh", "-c", "java -jar /user-api.jar"]