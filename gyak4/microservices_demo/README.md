# Eureka microservices demo project

##Projekt felépítése:

A projekt az alábbi modulokból épül fel:
* `eureka-server`
* `order-service`
* `storage-service`
* `gateway-service`

## Projekt futtatása:

1. microservices_demo `pom.xml` -> Maven build
2. `eureka-server` futtatása Spring Boot alkalmazásént
([http://localhost:8761/](http://localhost:8761/) címen szerver manager felület.)
3.`order-service` és a `storage-service` futtatása külön terminálokban Spring Boot alkalmazásként.
4. `gateway-service` futtatása külön terminálban Spring Boot alkalmazásként
A Gateway szolgáltatás közvetíti a kéréseket a microservice-ek felé, továbbítja a válaszokat és felel a load balance-olásért is.

Miután elindultak a servicek, a [http://localhost:8080/order](http://localhost:8080/order) címen visszakapunk egy számlálót, amely minden látogatással eggyel csökken.