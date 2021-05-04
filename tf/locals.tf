locals {
  template_vars = {
    spring_healthcheck_endpoint = "/api/health",
    spring_replicas = 1,
    spring_docker_repo = "gigabyteme",
    spring_docker_image = "iguana-service",
    spring_docker_tag = "1.0.0-SNAPSHOT",
    mongo_dbname = "iguanas-anywhere",
    mongo_replicas = 1,
    mongo_port = 27017,
    mongo_docker_image = "mongo",
    mongo_docker_tag = "latest"
  }
  helm_chart_values = templatefile(
  "${path.module}/values.yaml.tpl",
  local.template_vars
  )
}