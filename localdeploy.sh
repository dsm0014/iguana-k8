#!/bin/bash
namespace=$1

kubectl apply -f kube/ -n $namespace
minikube service spring-iguana --url -n $namespace