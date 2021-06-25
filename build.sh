./mvnw clean package -Pnative
docker build -f src/main/docker/Dockerfile.native -t wenger-quarkus-function-knative-events .
docker tag wenger-quarkus-function-knative-events raulmeloferreira/wenger-quarkus-function-knative-events:0.0.3 
sudo docker push raulmeloferreira/wenger-quarkus-function-knative-events:0.0.3
kubectl apply -n knativetutorial -f src/main/resources/service.yaml
kubectl apply -n knativetutorial -f src/main/resources/trigger.yaml

kubectl --namespace knativetutorial run curl --image=radial/busyboxplus:curl -it

curl -v "http://broker-ingress.knative-eventing.svc.cluster.local/knativetutorial/default" \
-X POST \
-H "Ce-Id: 1234" \
-H "Ce-Specversion: 1.0" \
-H "Ce-Type: defaultFunc" \
-H "Ce-Source: curl" \
-H "Content-Type: application/json" \
-d "{'data': 'Hello World 2'}"


curl -v "http://broker-ingress.knative-eventing.svc.cluster.local/event-example/default" \
  -X POST \
  -H "Ce-Id: say-hello" \
  -H "Ce-Specversion: 1.0" \
  -H "Ce-Type: greeting" \
  -H "Ce-Source: not-sendoff" \
  -H "Content-Type: application/json" \
  -d '{"data":"Hello Knative!"}'


# kubectl get ns knativetutorial --show-labels
# kubectl label namespace knativetutorial istio-injection=enabled