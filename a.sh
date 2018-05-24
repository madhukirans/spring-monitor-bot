kubectl delete svc monitor
kubectl delete replicationcontrollers monitor

kubectl create -f kubernetes/monitor-service.yaml 
