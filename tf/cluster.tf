provider "digitalocean" {
  token = var.DO_TOKEN
}

resource "digitalocean_kubernetes_cluster" "kubernetes-cluster" {
  name = "${var.project_name}-cluster"
  region = var.do_region
  version = "1.20.2-do.0"

  node_pool {
    name = "${var.project_name}-pool"
    size = "s-1vcpu-2gb"
    node_count = 1
    auto_scale = true
    min_nodes = 1
    max_nodes = 2
    labels = {
      app = var.project_name
    }
  }
}

