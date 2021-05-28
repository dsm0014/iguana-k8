provider "helm" {
  kubernetes {
    host = data.digitalocean_kubernetes_cluster.dsm-k8-cluster.endpoint

    token = data.digitalocean_kubernetes_cluster.dsm-k8-cluster.kube_config[0].token
    client_certificate     = base64decode(data.digitalocean_kubernetes_cluster.dsm-k8-cluster.kube_config[0].client_certificate)
    client_key             = base64decode(data.digitalocean_kubernetes_cluster.dsm-k8-cluster.kube_config[0].client_key)
    cluster_ca_certificate = base64decode(data.digitalocean_kubernetes_cluster.dsm-k8-cluster.kube_config[0].cluster_ca_certificate)

  }

}



resource "helm_release" "app_release" {
  name = "${var.project_name}-app"
  repository = "https://dsm0014.github.io/${var.helm_chart}/"
  chart = var.helm_chart
  version = "1.1.0"
  create_namespace = true
  namespace = var.project_name

  values = [
    local.helm_chart_values
  ]
}
