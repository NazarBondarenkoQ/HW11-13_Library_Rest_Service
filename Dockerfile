FROM openjdk:8
ADD target/restapilibrary-0.0.1-SNAPSHOT.jar restapilibrary-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "restapilibrary-0.0.1-SNAPSHOT.jar"]
