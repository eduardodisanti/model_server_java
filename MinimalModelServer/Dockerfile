FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
copy models/tree_regressor.pmml models/tree_regressor.pmml
expose 9090
ENTRYPOINT ["java","-jar","/app.jar"]