# Learn Kubernetes(K8S) by Samples
*Kubernetes* is an open-source platform designed to automate deploying, scaling, and operating application containers.
*Kubernetes* is an open-source container-orchestration system for automating computer application deployment, scaling, and management. It was originally designed by Google and is now maintained by the Cloud Native Computing Foundation.

Two main features that allow Kubernetes Clusters to scale are registration and discovery.

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
## Install on windows
* go to https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/ and install `kubectl`
  * open powershel and check it `kubectl version --client`
* go to https://minikube.sigs.k8s.io/docs/start/  and install `minikube`
  * `systeminfo`

## Alternative Implementations to K8S
* Mesos
* Docker Swarm
* Rancher - fullstack container management platform
* Nomad


# Samples
## hello world
* `minikube start` to get minikube up and running. This command sets up a Kubernetes dev environment via VirtualBox.
The last statement in the output states that kubectl can talk to minikube.
* `kubectl get nodes` to check nodes
* `kubectl get all` to see all our resources running
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
