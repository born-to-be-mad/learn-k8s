# Handling application upgrades
* `kubectl create -f helloworld-black.yaml --record` to deploy the initial version of our application.
  We added the `--record` to this because we want to record our rollout history.
*`minikube service navbar-service` will bring up the helloworld UI. 
* `kubectl get deployments` to check 'navbar-deployment'. There are 3 desired, current and ready replicas.
* `kubectl get rs` to see replicasets.
* `kubectl get po` to see pods. One pod for every replicaset of 'navbar-deployment'.
* `kubectl set image deployment/navbar-deployment helloworld=karthequian/helloworld:blue` to set the image from what it is currently (karthequian/helloworld:black) to karthequian/helloworld:blue.
  The deployment will update, and if you look at the webpage, you'll see the updated text.
* `kubectl rollout history deployment/navbar-deployment` to take a look at the rollout history.
* `kubectl rollout undo deployment/navbar-deployment` to rollback the deployment.
   Our webpage will be back to the Lionel version of the deployment.

In a real world setting, you might have a longer history, and might want to rollback to a specific version. 
To do this, add a `--to-revision=version` to the specific version you want to.
