#!/bin/bash
docker_tag=$1

./gradlew clean build
docker build . -t $docker_tag
docker push $docker_tag