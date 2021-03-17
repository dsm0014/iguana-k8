#!/bin/bash
namespace=$1
[[ $2 = "upgrade" ]] && is_upgrade=true || is_upgrade=false

if [ $is_upgrade ]; then
  helm upgrade $namespace kube/simple-spring-mongo -n $namespace
else
  helm install $namespace kube/simple-spring-mongo -n $namespace
fi
minikube service spring-iguana --url -n $namespace