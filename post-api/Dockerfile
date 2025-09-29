FROM maven:3.9-eclipse-temurin-21-alpine AS build

WORKDIR /workspace

COPY pom.xml ./

RUN mvn -B dependency:go-offline

COPY src ./src

RUN mvn -B -T 1C clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine as runtime

RUN addgroup -S springgrp \ 
	&& adduser -S springusr -G springgrp

USER springusr

WORKDIR /app

COPY --from=build /workspace/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT [ "java", "-jar", "app.jar" ]