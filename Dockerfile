FROM alpine:latest

WORKDIR /app/test

RUN apk update \
    && apk add --no-cache unzip openjdk17-jre \
    && rm -rf /var/cache/apk/*

RUN GRADLE_VERSION=$(wget -qO- https://gradle.org/releases/ | grep -o 'v[0-9]\+\.[0-9]\+' | head -n1 | cut -c2-) \
    && wget -q "https://services.gradle.org/distributions/gradle-${GRADLE_VERSION}-bin.zip" -O gradle.zip \
    && unzip gradle.zip -d /opt \
    && mv /opt/gradle-${GRADLE_VERSION} /opt/gradle \
    && rm gradle.zip

ENV GRADLE_HOME=/opt/gradle
ENV PATH="${PATH}:${GRADLE_HOME}/bin"

RUN adduser -D -h /home/tests tests \
    && mkdir -p /home/tests/.gradle \
    && mkdir -p /home/tests/build \
    && chown -R tests:tests /home/tests

USER tests

ENTRYPOINT ["gradle", "test", "--project-cache-dir", "/home/tests/.gradle"]

