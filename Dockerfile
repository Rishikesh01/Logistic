FROM alpine:latest

RUN  apk update \
  && apk upgrade \
  && apk add --update openjdk17 tzdata curl unzip bash \
  && rm -rf /var/cache/apk/

ARG JAR_FILE=build/libs/org-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} org-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/org-0.0.1-SNAPSHOT.jar"]