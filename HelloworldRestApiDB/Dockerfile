FROM openjdk:8
EXPOSE 8000
ADD target/*.jar App.jar

ENTRYPOINT ["sh","-c","java -jar -Dspring.profiles.active=inmemory /App.jar"]