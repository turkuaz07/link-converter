FROM adoptopenjdk:11-jre-hotspot
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} link-converter.jar
ENTRYPOINT ["java","-jar","/link-converter.jar"]