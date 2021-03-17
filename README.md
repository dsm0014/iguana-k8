# iguana-k8

## Setup
Make sure to have the following CLI tools installed on your machine before getting started:
- docker
- minikube
- kubectl

Once you have these installed, start up your local kubernetes cluster and create a namespace to use for iguana-k8
```
minikube start 
kubectl create namespace iguana
``` 

## Running iguana-k8
With your minikube cluster up and running, execute the included ``localdeploy.sh`` script and provide the namespace created 
during setup as a parameter.

For Example:
```
sh localdeploy.sh iguana
```

The console should output a tunnel to localhost through which the Spring Boot application can be reached. Give it a try,
and start interacting with the IguanaAPI from the ``localhost:<PORT>/api/iguana`` endpoint!