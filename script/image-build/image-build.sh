./gradlew spotlessApply clean build -x test
docker build -t klindziuk/taf-orchestrator:1.0.0 ./taf-orchestrator -f Dockerfile.orchestrator
docker build -t klindziuk/taf-mock-provider:1.0.0 ./taf-mock-provider -f Dockerfile.mock-provider