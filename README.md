# iguana-k8

## Local Setup
Make sure to have the following CLI tools installed on your machine before getting started:
- docker
- minikube
- kubectl
- helm

Once you have these installed, start up your local kubernetes cluster and create a namespace to use for iguana-k8
```
minikube start 
kubectl create namespace iguana
``` 

## Running iguana-k8 Locally
With your minikube cluster up and running, execute the included ``localdeploy.sh`` script and provide the namespace created 
during setup as a parameter.

For Example:
```
sh localdeploy.sh iguana
```

The application will be deployed using the [simple-mongo-spring](https://github.com/dsm0014/simple-mongo-spring) Helm chart, and the console should output a tunnel 
to localhost through which the Spring Boot application can be reached.

## Deploy on DigitalOcean
Check out the [terraform instructions](tf/README.md) on how to deploy this application to DigitalOcean!