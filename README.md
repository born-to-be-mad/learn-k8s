# Learn Kubernetes(K8S) by Samples
*Kubernetes* is an open-source platform designed to automate deploying, scaling, and operating application containers.
*Kubernetes* is an open-source container-orchestration system for automating computer application deployment, scaling, and management. It was originally designed by Google and is now maintained by the Cloud Native Computing Foundation.

Two main features that allow Kubernetes Clusters to scale are 'registration' and 'discovery'.

*KS Architecture Overview*:
* Master Node (APi server, scheduler, Controller Manager)
* etcd (storage);
* Kubectl (kubeconfig);
* Work Node (kubelet, kube-proxy, Docker (pods and containers)).

*Terminology*
* *Node* - a working machine in a K8S cluster: a physical computer or a virtual machine. It has: kubelet, container-tooling(like Docker), kube-proxy, supervisord
* *Minicube* -  lightweight Kubernetes implementation that creates a VM on your local machine and deploys a simple cluster with one node.
* *Pod*  - the simplest unit that we can interact with. It represents one running process in the cluster.
* *Pod States*: Pending, Running, Succeeded, Failed, CrashLoppBackOff
* *Kinds of Controllers*:
  * ReplicaSets
  * Deployments
  * DaemonSets
  * Jobs
  * Services(internal, external and load balancers)
* *Labels* - key/value pairs  that are attached to objects like pods, services and deployments. 
  Examples: 1) "release": "canary", "stable", "release"; 2) "environment": "dev", "stage", "qa", "prod"; 3) "tier": "frontend", "backend", "cache", "tier".
* Selectors are used with `kubectl`: 1) equality-based; 2) set-based (IN, NOTIN, EXISTS) 
* *Namespaces*. "Default" is created when we launch K8S and where all objects placed at start
* *Kubelet* - is the "Kubernetes node agent" that runs on each node
* *Podspec*: YAML file that describes a pod
* "kube-proxy" a process that runs on all worker nodes. It has 3 modes: User-space, Iptables, Ipvs.

# How to install
## Install on Windows
* go to https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/ and install `kubectl`
  * open powershel and check it `kubectl version --client`
* go to https://minikube.sigs.k8s.io/docs/start/  and install `minikube`
  * `systeminfo`

## Alternative Implementations to K8S
* Mesos (Mesosphere DC/OS)
* Docker Swarm
* Rancher - fullstack container management platform
* Nomad

# K8S  commands
* `kubectl version` to check versions.
* `kubectl config get-contexts` to check the context.
* `kubectl config use-context docker-desktop` to switch the context.
* `kubectl config use-context minikube` to switch the context.
* `kubectl get nodes` to check nodes.
* `kubectl get all` to see all our resources running.
* `kubectl get svc,deployment,pods`

# Minikube configuration
* Delete and setup
```
minikube delete
minikube config set memory 8192
minikube config set cpus 4
minikube start --vm-driver="hyperv" --hyperv-virtual-switch="minikube"
```

* start without driver `minikube start --vm-driver=none`

# Samples
## hello world
* `minikube start` to get minikube up and running. This command sets up a Kubernetes dev environment via VirtualBox.
The last statement in the output states that kubectl can talk to minikube.
* `kubectl create -f helloworld.yaml` this command creates a deployment resource from the file helloworld.yaml, 
  which contains a deployment called "helloworld", pulling from the image karthequian/helloworld, and exposes port 80 of the container to the pod. 
* `kubectl expose deployment helloworld --type=NodePort` to expose the pod to the public internet using the kubectl expose command.
  The `--type=NodePort` flag exposes the deployment outside of the cluster. If you're using this on a cloud provider, you can use a `--type=LoadBalancer` that will provision an external IP address would be provisioned to access the service.
* `minikube service helloworld` will open your web browser to your application that is running in Kubernetes!

# Minikube commands

* `minikube addons list`  to view all addons. The Kubernetes Dashboard comes bundled as an addon.
* `minikube addons enable dashboard` to enable the dashboard.
* `minikube addons enable metrics-server` to enable the metrics server.
* `minikube dashboard` to open the page with dashboard.


#### Handout Links

[Kubernetes Dashboard doc] https://kubernetes.io/docs/tasks/access-application-cluster/web-ui-dashboard/
[Dashboard - Full Featured Web Interface for Kubernetes] http://blog.kubernetes.io/2016/07/dashboard-web-interface-for-kubernetes.html
[Dashboard Github] https://github.com/kubernetes/dashboard

# Linux tricks
* `chmod +x ./kubectl` to make the kubectl executable.

# Useful links
* [What is K8s] https://enterprisersproject.com/article/2017/10/how-explain-kubernetes-plain-english
  * Kubernetes intro: https://www.slideshare.net/RohitJnagal/kubernetes-intro-public-kubernetes-meetup-4212015
* Features: https://www.openshift.com/container-platform/kubernetes.html
* Pods: https://kubernetes.io/docs/concepts/workloads/pods/pod-overview/
* Kubelet: https://kubernetes.io/docs/admin/kubelet/
* Kube-proxy: https://kubernetes.io/docs/admin/kube-proxy/
* K8s blog: http://blog.kubernetes.io/
* Kubernetes versus swarm: https://platform9.com/blog/kubernetes-docker-swarm-compared/
* Docker versus mesos versus kubernetes: https://mesosphere.com/blog/docker-vs-kubernetes-vs-apache-mesos/
* Docker support for k8s: https://www.docker.com/kubernetes
* Kubernetes the hard way: https://github.com/kelseyhightower/kubernetes-the-hard-way
* Kubeadm: http://blog.kubernetes.io/2016/09/how-we-made-kubernetes-easy-to-install.html
* Kops: https://github.com/kubernetes/kops
  * Get started with Kops: https://cloudacademy.com/blog/kubernetes-operations-with-kops/
* Azure container
  service: https://docs.microsoft.com/en-us/azure/container-service/kubernetes/container-service-kubernetes-walkthrough
  * Azure container
    service: https://azure.microsoft.com/en-us/blog/introducing-azure-container-service-aks-managed-kubernetes-and-azure-container-registry-geo-replication/?cdn=disable
  * Azure Container service + Kubernetes: https://azure.microsoft.com/en-us/services/container-service/
* Oracle Container
  Engine: https://blogs.oracle.com/developers/announcing-oracle-container-engine-and-oracle-container-registry-service
* K8s v/s openshift: https://www.openshift.com/container-platform/kubernetes.html
* Addon list: https://kubernetes.io/docs/concepts/cluster-administration/addons/
* Rancher: https://github.com/rancher/rancher#installation
* Nomad: https://www.nomadproject.io/
* Minikube: https://github.com/kubernetes/minikube

ARCHITECT: http://news.architecht.io/issues/with-oracle-on-board-kubernetes-has-to-be-the-de-facto-standard-for-container-orchestration-73880

Rolling deployments: https://tachingchen.com/blog/Kubernetes-Rolling-Update-with-Deployment/
Kubernetes examples: http://kubernetesbyexample.com/deployments/
Jobs: https://kubernetes.io/docs/tasks/job/coarse-parallel-processing-work-queue/
Service Definition: https://kubernetes.io/docs/concepts/services-networking/service/#defining-a-service
Using a service to expose your applications: https://kubernetes.io/docs/tutorials/kubernetes-basics/expose-intro/
Networking with Services: https://kubernetes.io/docs/concepts/services-networking/service/
Pods + Services: https://thenewstack.io/kubernetes-way-part-one/
Connecting applications with
services : https://kubernetes.io/docs/concepts/services-networking/connect-applications-service/

Service networking: https://kubernetes.io/docs/concepts/services-networking/service/#the-gory-details-of-virtual-ips

Kubeadm: http://blog.kubernetes.io/2016/09/how-we-made-kubernetes-easy-to-install.html

Kubernetes networks: https://kubernetes.io/docs/concepts/cluster-administration/networking/


Logging with kibana and elasticsearch: https://kubernetes.io/docs/tasks/debug-application-cluster/logging-elasticsearch-kibana/

Logging with fluentd, kibana and elasticsearch: https://logz.io/blog/kubernetes-log-analysis/

Fluent chart: https://github.com/kubernetes/charts/tree/master/stable/fluent-bit

Fluentd architecture: https://www.fluentd.org/architecture

ELK stack on kubernetes: https://crondev.com/elk-stack-kubernetes/

cAdvisor: https://hub.docker.com/r/google/cadvisor/

Monitoring: http://blog.kubernetes.io/2017/05/kubernetes-monitoring-guide.html

Comparing monitoring options: http://rancher.com/comparing-monitoring-options-for-docker-deployments/

Monitoring: https://sysdig.com/blog/monitoring-kubernetes-with-sysdig-cloud/

Prometheus: https://jaxenter.com/prometheus-monitoring-pros-cons-136019.html

Heapster: https://deis.com/blog/2016/monitoring-kubernetes-with-heapster/

Helm charts: https://github.com/kubernetes/charts/tree/master/stable

Kubernetes authentication: https://kubernetes.io/docs/admin/authentication/

RBAC+ABAC: http://blog.kubernetes.io/2017/04/rbac-support-in-kubernetes.html

RBAC Support: http://blog.kubernetes.io/2017/04/rbac-support-in-kubernetes.html

RBAC config: https://docs.bitnami.com/kubernetes/how-to/configure-rbac-in-your-kubernetes-cluster/


