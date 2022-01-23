## How to run
1) Build docker images by executing `mvn spring-boot:build-image -DskipTests` for:
   - [currency-conversion-service](currency-conversion-service/)
   - [currency-exchange-service](currency-exchange-service/)
   - [limits-service](limits-service/)

2) Start minikube and create a cluster: `minikube start`
3) Deploy microservices to a cluster: `kubectl apply -f deployment --recursive`

## Usage 
To be able to access all services via `http://currency-operations.all/`:
1) Enable ingress: `minikube addons enable ingress`
2) Update /etc/hosts file: `echo "$(minikube ip) currency-operations.all" | sudo tee -a /etc/hosts`

## API Reference
- swagger-ui for Currency Conversion API: `http://currency-operations.all/currency-conversion/swagger-ui.html`
- json for Currency Conversion API: `http://currency-operations.all/currency-conversion/v3/api-docs`
- swagger-ui for Currency Exchange API: `http://currency-operations.all/currency-exchange/swagger-ui.html`
- json for Currency Exchange API: `http://currency-operations.all/currency-exchange/v3/api-docs`