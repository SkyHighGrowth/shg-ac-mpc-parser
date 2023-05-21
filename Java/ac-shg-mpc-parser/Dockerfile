FROM adoptopenjdk/maven-openjdk11:latest
EXPOSE 8080
ARG JAR_FILE="target/elc-csco-sync-0.2.12.jar"
ADD ${JAR_FILE} elc-csco-sync.jar
ENTRYPOINT [ "java", "-jar", "/elc-csco-sync.jar" ]