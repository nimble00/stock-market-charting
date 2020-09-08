FROM openjdk:latest
EXPOSE 8088
ADD target/*.jar zuul-gw.jar
ENTRYPOINT ["sh", "-c", "java -jar /zuul-gw.jar"]