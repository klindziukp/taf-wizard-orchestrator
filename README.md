# taf-orchestrator
Service which orchestrates TAFs generation for different language platforms

## Supported platforms:
- JAVA
- MOCK

## Orchestrator + Mock service set up via Gradle
- Install JDK 21
- Build service via command
```bash
./gradlew clean build
```
- Run `taf-orchestrator`  via command
```bash
./gradlew :taf-orchestrator:bootRun
```

- Run `taf-mock-provider`  via command
```bash
./gradlew :taf-mock-provider:bootRun
```

## Orchestrator + Mock service set up via docker-compose
- Install JDK 21
- Build Docker images via command(it will take time)
```bash
sh script/image-build/image-build.sh
```
- Start system with docker compose
```bash
docker-compose -f docker-compose.yml up
```

## Orchestrator + Mock + Java TAF provider service set up via docker-compose
- Install JDK 21
- Build Docker images via command(it will take time)
```bash
sh script/image-build/image-build.sh
```
- Build Java TAF provider docker image
 [Java TAF provider](https://github.com/klindziukp/java-taf-provider#readme)
- Start system with docker compose
```bash
docker-compose -f docker-compose-all.yml up
```

## Open API documentation
- Open `http://{server}:{port}/api-docs` to view documentation in JSON format for TDM service
```bash
http://localhost:8080/v3/api-docs
```
- Open `http://{server}:{port}/webjars/swagger-ui.html` to view api endpoints for TDM service
```bash
http://localhost:8080/webjars/swagger-ui/index.html
```
