FROM openjdk:latest
EXPOSE 8761
ADD target/*.jar eureka-server.jar
ENTRYPOINT ["sh", "-c", "java -jar /eureka-server.jar"]