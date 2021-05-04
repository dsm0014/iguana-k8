provider "helm" {
  kubernetes {
    host = digitalocean_kubernetes_cluster.kubernetes-cluster.endpoint

    token = digitalocean_kubernetes_cluster.kubernetes-cluster.kube_config[0].token
    client_certificate     = base64decode(digitalocean_kubernetes_cluster.kubernetes-cluster.kube_config[0].client_certificate)
    client_key             = base64decode(digitalocean_kubernetes_cluster.kubernetes-cluster.kube_config[0].client_key)
    cluster_ca_certificate = base64decode(digitalocean_kubernetes_cluster.kubernetes-cluster.kube_config[0].cluster_ca_certificate)

  }

}



resource "helm_release" "app_release" {
  name = "${var.project_name}-release"
  repository = "https://dsm0014.github.io/${var.helm_chart}/"
  chart = var.helm_chart
  version = "1.0.0"
  create_namespace = true
  namespace = var.project_name

  values = [
    local.helm_chart_values
  ]
}