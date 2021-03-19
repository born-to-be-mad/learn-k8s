## Understand the basics of the deployment and service
When working with Kubernetes, you should get familiar with these YAML files.

* `kubectl get all` shows us pods, services and deployments that are running that build the helloworld application. 
  Let's peel this onion and figure out what's going on.
* `kubectl get deploy/helloworld -o yaml` to take a look at the deployment YAML that runs the application, run . 
  This will return the YAML that composes the helloworld service.
* `kubectl get service helloworld-service -o yaml`  to take a look at the service YAML.
* `kubectl create -f helloworld-deployment.yml` to create the deployment. 
* `kubectl create -f helloworld-service.yml` to create the service. 
  This will take the contents of the YAML file and create the necessary components in the file.  
* `minikube service helloworld-service` to run the minikube command to expose the service in the browser.
* `kubectl get nodes` to verify that Minikube and VirtualBox are talking to each other.


Typically, in the real world, you would mostly not use separate files to break up your application and would have it in a single file 
that encompasses the entire application with both the deployment and the service component. 
An example of this YAML file is shown here('helloworld-all.yml'):
```
apiVersion: apps/v1
kind: Deployment
metadata:
  name: helloworld-deployment
spec:
  selector:
    matchLabels:
      app: helloworld
  replicas: 1 # tells deployment to run 1 pods matching the template
  template: # create pods using pod definition in this template
    metadata:
      labels:
        app: helloworld
    spec:
      containers:
      - name: helloworld
        image: karthequian/helloworld:latest
        ports:
        - containerPort: 80
---
apiVersion: v1
kind: Service
metadata:
  name: helloworld-service
spec:
  # if your cluster supports it, uncomment the following to automatically create
  # an external load-balanced IP for the frontend service.
  type: LoadBalancer
  ports:
  - port: 80
    protocol: TCP
    targetPort: 80
  selector:
    app: helloworld
```

Notice the `---` that marks the end of one section and starts another.

### Verify that the application is working as expected
