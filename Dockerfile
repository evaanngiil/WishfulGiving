FROM alpine:3.18

WORKDIR /app/test

RUN apk add --no-cache openjdk17 bash make curl unzip

ARG GRADLE_VERSION=8.10

RUN curl -Ls "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -o gradle.zip \
    && unzip gradle.zip -d /opt \
    && rm gradle.zip

ENV GRADLE_HOME=/opt/gradle-${GRADLE_VERSION}
ENV PATH="${PATH}:${GRADLE_HOME}/bin"

RUN adduser -D -h /home/tests tests
RUN mkdir -p /home/tests/.gradle && chown -R tests:tests /home/tests/.gradle

ENV GRADLE_USER_HOME=/home/tests/.gradle

RUN chmod -R a+w /app/test

COPY build.gradle /app/test/build.gradle
COPY settings.gradle /app/test/settings.gradle

USER tests

WORKDIR /app/test

ENTRYPOINT ["gradle", "test"]
