FROM openjdk:17 as builder
WORKDIR /app
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw clean install -DskipTests=true

FROM openjdk:17-alpine
COPY --from=builder /app/target/*.jar /app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "app.jar"]
