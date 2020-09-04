FROM openjdk:latest
EXPOSE 8080
ADD target/docker-app-0.0.1-SNAPSHOT.jar docker-app.jar
ENTRYPOINT ["sh", "-c", "java -jar /docker-app.jar"]