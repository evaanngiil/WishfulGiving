FROM alpine:latest

RUN apk update \
    && JAVA_VERSION=$(wget -qO- "https://api.adoptium.net/v3/info/available_releases" | grep '"most_recent_lts":' | grep -o '[0-9]*') \
    && apk add --no-cache unzip openjdk${JAVA_VERSION} \
    && rm -rf /var/cache/apk/*

RUN GRADLE_VERSION=$(wget -qO- https://gradle.org/releases/ | grep -o 'v[0-9]\+\.[0-9]\+' | sed -n 4p | cut -c2-) \
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

ENV GRADLE_OPTS="-Dorg.gradle.project.buildDir=/home/tests/build -Dorg.gradle.projectcachedir=/home/tests/.gradle"

WORKDIR /app/test

USER tests

ENTRYPOINT [ "gradle" , "test" ]
