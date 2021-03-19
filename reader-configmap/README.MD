# Working with configmaps
Configmap are useful to send dynamic values to deployments.

We will take an example of "log_level", and pass the value "debug" to a pod via a configmap in this example.

* `kubectl create configmap logger --from-literal=log_level=debug` to create a configmap for this literal type.
* `kubectl get configmaps` to see all configmaps.
* `kubectl get configmap/logger -o yaml` to read the value in the logger configmap.
* `kubectl edit configmap/logger` to edit the value.


