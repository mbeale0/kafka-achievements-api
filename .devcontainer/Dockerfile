FROM mcr.microsoft.com/devcontainers/java:17

RUN apt-get update && apt-get install -y maven

WORKDIR /workspace/backend

ENTRYPOINT ["mvn", "spring-boot:run"]
