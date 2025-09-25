FROM eclipse-temurin:21-jre-jammy

RUN useradd -m -s /bin/bash springusr
USER springusr

WORKDIR /app

COPY target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]