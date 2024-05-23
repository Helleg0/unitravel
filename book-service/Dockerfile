FROM eclipse-temurin:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} book-service.jar
ENTRYPOINT ["java", "-jar", "/book-service.jar"]