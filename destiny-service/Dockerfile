FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} destiny-service.jar
ENTRYPOINT ["java", "-jar", "/destiny-service.jar"]