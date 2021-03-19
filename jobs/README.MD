# Jobs in Kubernetes
Jobs are a construct that run a pod once, and then stop.
Cron jobs are like jobs, but they run periodically.
However, unlike pods in deployments, the output of the job is kept around until you decide to remove it.

* `kubectl create -f simplejob.yaml` to start a job.
* `kubectl get jobs` to see the output of the job.
* `kubectl get pods` to find the pod that ran, and then get the logs from it as well.
* `kubectl create -f cronjob.yaml` to run cron job sdample.
* `kubectl get cronjobs` to view cronjobs by using the cronjob API. It adds the last schedule date.
