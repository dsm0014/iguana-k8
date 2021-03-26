#!/bin/bash
namespace=$1
deployment=$(helm list -q -n $namespace)
if [ $deployment = $namespace ]; then
  helm upgrade $namespace tf/helm/simple-spring-mongo -n $namespace
else
  helm install $namespace tf/helm/simple-spring-mongo -n $namespace
fi
minikube service spring-iguana --url -n $namespace
