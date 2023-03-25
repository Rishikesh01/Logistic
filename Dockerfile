FROM openjdk:17-alpine

ARG JAR_FILE=build/libs/org-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} org-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/org-0.0.1-SNAPSHOT.jar"]