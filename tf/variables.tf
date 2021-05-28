# Read keys/tokens from env
variable "DO_TOKEN" {
  type = string
}

variable "DO_SPACES_ACCESS_KEY" {
  type = string
}

variable "DO_SPACES_SECRET_KEY" {
  type = string
}

variable "project_name" {
  type = string
  default = "iguana-k8"
}

variable "do_region" {
  type = string
  default = "nyc1"
}

variable "helm_chart" {
  type = string
  default = "simple-mongo-spring"
}