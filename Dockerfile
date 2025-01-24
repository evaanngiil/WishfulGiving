FROM alpine:3.18

WORKDIR /app/test

RUN apk add --no-cache openjdk17 bash \
    && rm -rf /var/cache/apk/* /tmp/*


COPY gradlew gradlew
COPY gradle/wrapper gradle/wrapper
COPY build.gradle settings.gradle ./
COPY src src

RUN chmod +x gradlew

RUN adduser -D -h /home/tests tests \
    && mkdir -p /home/tests/.cache \
    && chmod -R a+w /home/tests/.cache

USER tests

ENTRYPOINT ["./gradlew", "test"]
