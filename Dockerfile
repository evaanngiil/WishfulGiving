FROM alpine:3.18

RUN apk add --no-cache openjdk17 bash \
    && rm -rf /var/cache/apk/* /tmp/*

RUN adduser -D -h /home/tests tests

WORKDIR /app/test

COPY gradlew gradlew
COPY gradle/wrapper gradle/wrapper
COPY build.gradle settings.gradle ./
COPY src src

RUN chmod +x gradlew

USER tests

ENV GRADLE_USER_HOME=/home/tests/.gradle

ENTRYPOINT ["./gradlew", "test"]
