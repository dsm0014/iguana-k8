# iguana-k8

## Setup
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

## Running iguana-k8
With your minikube cluster up and running, execute the included ``localdeploy.sh`` script and provide the namespace created 
during setup as a parameter.

For Example:
```
sh localdeploy.sh iguana
```

The application will be deployed using the Helm chart included in this project, and the console should output a tunnel 
to localhost through which the Spring Boot application can be reached. Check out the API docs of the application
at ``<YOUR_TUNNEL_ADDRESS>/swagger-ui/`` and give it a try!