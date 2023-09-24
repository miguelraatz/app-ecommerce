FROM maven:3-openjdk-17 as build-image

WORKDIR /app

COPY . .

RUN mvn dependency:go-offline

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build-image /app/target/*.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
