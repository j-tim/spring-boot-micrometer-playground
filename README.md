# Spring Boot Mcrometer Playground

Playground project for Spring Boot, Micrometer including both Prometheus and Elasticsearch.

Meter registries: 

* Prometheus 
  * pull based
  * `io.micrometer:micrometer-registry-prometheus`
* Elasticsearch 
  * push based
  * `io.micrometer:micrometer-registry-elastic`

## Components in this example project

* [Spring Boot application](http://localhost:8080)

* [Kibana](http://localhost:5601)
* [Elasticsearch](http://localhost:9200)

* [Grafana](http://localhost:3000)
* [Prometheus](http://localhost:9090)
* [Alert Manager](http://localhost:9093)
* [Mailhog STMP testing tool](http://localhost:8025)

## Start project

First build the project:

```
./mvnw clean package
```

### Start / stop infrastructure

```
docker compose up -d
```

```
docker compose down -v
```

## Counter example

* Metric name: `random.names.created`
* Prometheus’s naming convention adds `_total` to the suffix of a `counter`. Name of metric in Prometheus: `random_names_created_total`
* A counter single metric, a count
* The count value can only increment and must be positive
* [Micrometer Counter documentation](https://micrometer.io/docs/concepts#_counters)

### Grafana

* Start the Spring Boot application
* Dashboard Grafana: [http://localhost:3000/dashboards](http://localhost:3000/dashboards)

### Elasticsearch

* Make sure Elasticsearch and Kibana are running.
* run `./import-kibana-dashboards.sh` to import the Index pattern and Kibana Dashboard

* Start the Spring Boot application
* Dashboard Elasticsearch: [http://localhost:5601/app/dashboards#/](http://localhost:5601/app/dashboards#/)
* Open dashboard with name `Dashboard - Counter - Random generated names`
* It might take up to one minute for Micrometer to push the metrics to Elasticsearch

### Start application

Run in your IDEA or start using Maven:

```
./mvnw spring-boot:run
```