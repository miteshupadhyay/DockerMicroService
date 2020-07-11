FROM openjdk:8
EXPOSE 8100
ADD target/*.jar App.jar
ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=inmemory /App.jar"]