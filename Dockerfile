# Dockerfile minimalista para Alpine + Java 17 + Gradle Wrapper
FROM alpine:3.18

# Directorio de trabajo
WORKDIR /app/test

# Instala Java 17 (openjdk17) y bash (normalmente requerido por gradlew)
RUN apk add --no-cache openjdk17 bash \
    && rm -rf /var/cache/apk/* /tmp/*

# Copiamos únicamente el wrapper: gradlew + directorio gradle/wrapper (con el .jar y .properties)
COPY gradlew gradlew
COPY gradle/wrapper gradle/wrapper
COPY build.gradle settings.gradle ./
COPY src src

# Damos permisos de ejecución al script gradlew
RUN chmod +x gradlew

RUN adduser -D -h /home/tests tests \
    && mkdir -p /home/tests/.cache \
    && chmod -R a+w /home/tests/.cache

USER tests
# No ejecutamos gradlew en esta fase, así evitamos descargar Gradle en la imagen
# y mantenemos la capa lo más liviana posible.

ENTRYPOINT ["./gradlew", "test"]
