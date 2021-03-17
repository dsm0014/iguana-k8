#!/bin/bash
namespace=$1
[[ $(helm list -q -n $namespace) = "" ]] && is_upgrade=false || is_upgrade=true

if [ $is_upgrade ]; then
  helm upgrade $namespace kube/simple-spring-mongo -n $namespace
else
  helm install $namespace kube/simple-spring-mongo -n $namespace
fi
minikube service spring-iguana --url -n $namespace