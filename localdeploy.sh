#!/bin/bash
namespace=$1
deployment=$(helm list -q -n $namespace)
if [ "$deployment" = "$namespace" ]; then
  helm upgrade "$namespace" --repo https://dsm0014.github.io/simple-mongo-spring/ simple-mongo-spring -f localdeploy.yaml -n $namespace
else
  helm install "$namespace" --repo https://dsm0014.github.io/simple-mongo-spring/ simple-mongo-spring -f localdeploy.yaml -n $namespace
fi
minikube service spring-iguana-service --url -n $namespace
