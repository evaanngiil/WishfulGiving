FROM alpine:3.18

WORKDIR /app/test

RUN apk add --no-cache openjdk17 bash \
    && rm -rf /var/cache/apk/* /tmp/*

COPY gradlew gradlew
COPY ./gradle/wrapper ./gradle/wrapper
COPY build.gradle settings.gradle ./
COPY ./src ./src

RUN chmod +x gradlew

RUN adduser -D -h /home/tests tests \
        && mkdir -p /home/tests/.gradle \
        && chown -R tests:tests /home/tests

USER tests

ENV GRADLE_USER_HOME=/home/tests/.gradle

ENTRYPOINT ["./gradlew", "test"]
