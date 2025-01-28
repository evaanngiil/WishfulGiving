FROM alpine:latest

WORKDIR /app/test

RUN apk add --no-cache openjdk17 bash make curl unzip \
    && rm -rf /var/cache/apk/*

ARG GRADLE_VERSION=8.10

RUN curl -Ls "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o gradle.zip \
    && unzip gradle.zip -d /opt \
    && rm gradle.zip

ENV GRADLE_HOME=/opt/gradle-${GRADLE_VERSION}
ENV PATH="${PATH}:${GRADLE_HOME}/bin"

RUN adduser -D  -h /home/tests tests \
    && mkdir -p /home/tests/.gradle \
    && chown -R tests:tests /home/tests

RUN chmod -R a+r .

USER tests

WORKDIR /home/tests

COPY build.gradle .
COPY settings.gradle .
COPY src src

ENTRYPOINT ["gradle", "test"]
