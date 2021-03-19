## Manage labels
Labels in Kubernetes is a powerful concept! Use the labeling feature to your advantage to build your infrastructure in an organized fashion.

* `kubectl create -f helloworld-pod-with-labels.yml` to deploy.
* `kubectl get services/deployments/all --show-labels` will return labels for your services, deployments or all objects.
* `kubectl get pods --show-labels` to view labels
* `kubectl label po/helloworld app=helloworld` to add labels to a running pod. This adds the label `app` with the value `helloworld` to the pod.
* `kubectl label po/helloworld app=helloworldapp --overwrite` to update the value of a label, use the `--overwrite` flag. 
* `kubectl label po/helloworld app-` to remove an existing label, just add a `-`. This will remove the app label from the helloworld pod.
* `kubectl create -f sample-infrastructure-with-labels.yml` to creta a test infrastructure with  a lot of labels
* `kubectl get pods --selector env=production` to search for all the pods that are running in production.
You can search for labels with the flag `--selector` (or `-l`). , you can run  as shown below:
* `kubectl get pods --selector dev-lead=karthik` to get all pods by dev lead 'Karthik', you'd add `dev-lead=karthik` to the selector.
* `kubectl get pods -l dev-lead=karthik,env=staging` to do more complicated searches, like finding any pods owned by 'Karthik' in the 'development' tier by the following query `dev-lead=karthik,env=staging`.
* `kubectl get pods -l dev-lead!=karthik,env=staging` to find any apps not owned by Karthik in staging (using the ! construct):
* `kubectl get pods -l 'release-version in (1.0,2.0)'` - querying also supports the `in` keyword.
* `kubectl get pods -l "release-version in (1.0,2.0),team in (marketing,ecommerce)"` - to make complex search
* `kubectl get pods -l 'release-version notin (1.0,2.0)'` - the opposite of "in" is "notin". 
* `kubectl get pods -l 'release-version'` if your label might not have a value assigned to it, but you can still search by label name.
* `kubectl delete pods -l dev-lead=karthik` to delete all pods who's dev-lead was Karthik.
