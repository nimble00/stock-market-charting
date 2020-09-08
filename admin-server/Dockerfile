FROM openjdk:latest
EXPOSE 7777
ADD target/*.jar admin-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /admin-server.jar"]