spring:
  healthcheckEndpoint: ${spring_healthcheck_endpoint}
  replicas: ${spring_replicas}
  docker:
    image: ${spring_docker_image}
    tag: ${spring_docker_tag}

mongo:
  dbname: ${mongo_dbname}
  replicas: ${mongo_replicas}
  port: ${mongo_port}
  docker:
    image: ${mongo_docker_image}
    tag: ${mongo_docker_tag}
