FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} accommodation-service.jar
ENTRYPOINT ["java", "-jar", "/accommodation-service.jar"]