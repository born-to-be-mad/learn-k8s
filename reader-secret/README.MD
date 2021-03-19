# Working with secrets

Just like configuration data, applications might also require other data that might be of more sensitive in nature- for example database passwords, or API tokens. 
Passing these in the yaml for a deployment or pod would make them visible to everyone.

In these use cases, use a secret to encapsulate sensitive data.

* `kubectl create secret generic apikey --from-literal=api_key=123456789` to create a secret:
* `kubectl get secret apikey -o yaml` to notice that we can't read the value of the secret directly
* `kubectl create -f secretreader-deployment.yaml` to add a secret to the env portion, and start up the deployment.
