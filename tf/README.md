# Terraforming Digital Ocean Kubernetes with Helm

## Digital Ocean Setup
Make sure to have your Digital Ocean token and spaces access/secret keys.
The project is expecting them as the following environment variables:
- DO_TOKEN
- DO_SPACES_ACCESS_KEY
- DO_SPACES_SECRET_KEY

We will also need a Digital Ocean Space to store our Terraform Statefile. 
The project is expecting a space named ``iguana-k8`` in the ``nyc3`` region.

This can be easily modified in the main.tf file to fit your region/space.

## Local Setup
Make sure to have the following CLI tools installed on your machine before getting started:
- terraform
- helm

## Deploying to DigitalOcean

With our environment variables set and everything installed we are ready to get started.

First, initialize Terraform with the following command:

``terraform init -backend-config="access_key=$DO_SPACES_ACCESS_KEY" -backend-config="secret_key=$DO_SPACES_SECRET_KEY"``


Next, we pull in the helm chart we'll use to deploy our application on DigitalOcean's Kubernetes platform:

``helm repo add myhelmchart https://dsm0014.github.io/simple-mongo-spring/``


Finally, we can deploy the application:

``terraform apply -auto-approve``

Explore the application and helm repositories for more details, or feel free to reach out if you'd like to chat about any 
of the technologies or approaches included in this Kubernetes demo!