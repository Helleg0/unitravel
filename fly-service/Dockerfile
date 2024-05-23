FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} fly-service.jar
ENTRYPOINT ["java", "-jar", "/fly-service.jar"]