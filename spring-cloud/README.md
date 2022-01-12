## Architecture
![Currency Operations Microservices architecture](docs/images/architecture-diagram.png)

## Run locally
1) Build docker images by executing `mvn spring-boot:build-image -DskipTests` for:
   - [api-gateway](api-gateway/)
   - [config-server](config-server/)
   - [naming-server](naming-server/)
   - [currency-conversion-service](currency-conversion-service/)
   - [currency-exchange-service](currency-exchange-service/)
   - [limits-service](limits-service/)

2) Start docker containers: `docker-compose up`

## Usage
- Eureka Naming Server - http://localhost:8762
- Config Server - http://localhost:8888
- Zipkin Tracing Server - http://localhost:9411
- RabbitMQ Management - http://localhost:15672
- Currency Conversion, Currency Exchange - [postman collections]

## API Reference