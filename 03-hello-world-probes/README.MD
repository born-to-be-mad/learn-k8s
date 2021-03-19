## Application health checks

* `kubectl get pods` to check the state
* `kubectl create -f helloworld-deployment-with-probes` to run the app with probes and it will be running after 5 seconds 
* `kubectl create -f helloworld-with-bad-liveness-probe` to simulate a bad helloworld pod that fails a liveness probe. 
  Instead of checking port 80 like the last example, we will run a liveness check on port 90 to simulate a failing scenario.
* `kubectl create -f helloworld-with-bad-readiness-probe` to simulate a failing deployment that fails a readiness probe.
  Instead of checking port 80 like the last example, we will run a readiness check on port 90 to simulate a failing scenario.
* `kubectl describe po/POD_NAME` to describe the pod will show that the pod failed readiness/liveness.
* `kubectl get deployments` when we check the deployment, we notice that deployment is not available as well.

We can use readiness and liveness probes to check the status of our pods and use them to restart pods when necessary and check pod health.
