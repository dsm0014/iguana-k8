#!/bin/bash
docker_tag="gigabyteme/iguana-service:$(./gradlew getProjectVersion -q)"

./gradlew clean build
docker build . -t $docker_tag
docker push $docker_tag