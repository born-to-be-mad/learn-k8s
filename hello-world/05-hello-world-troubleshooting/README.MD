# Basic troubleshooting techniques

* `kubectl create -f helloworld-with-bad-pod.yaml`
* `kubectl get deployments` 

### Describing
Describing the pod with `kubectl describe pod bad-helloworld-deployment-7bb4b7466-f6nkm`, will show me that kubernetes is having trouble pull the pod from the repository, either because it doesn't exist, or because we're missing the repository credentials.
* `kubectl describe deployment bad-helloworld-deployment`
If we introspect pods with a `kubectl get pods`, we see that the `bad-helloworld-deployment` pod is in an image pull backoff state and isn't ready.

### Looking at log files
Another technique I end up using a lot to track pod progress is looking at the log files for a pod. 
If you write your logs to standard out, you can get to them by the command `kubectl logs <pod_name>`. 
This will return the log statements that are being written by your application in the pod.

### Executing commands in a container
Finally, sometimes it is necessary to exec into the actual container running the pod to look for errors, or state. 
To do this, run the exec command `kubectl exec -it <pod-name> -c <container-name> /bin/bash` 
where -it is an interactive terminal and -c is the flag to specify the container name. 
Finally we want a bash style terminal.

This drops us into the container, and we can introspect into the details of our application.
