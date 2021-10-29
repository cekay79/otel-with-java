# OpenTelemetry in Java with Elastic Observability

This project showcase how to instrument a microservice written in Java using [OpenTelemetry](https://opentelemetry.io/), to produce telemetry data (traces and metrics) to [Elastic Observability](https://www.elastic.co/observability).

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/riferrei/otel-with-java)

## Run with the collector

Using this model, the Java application sends the traces and metrics to a collector that forwards them to Elastic APM.

```bash
docker compose -f run-with-collector.yaml up -d
```

## Run without the collector

Using this model, the Java application sends the traces and metrics directly to Elastic APM.

```bash
docker compose -f run-without-collector.yaml up -d
```

## Run with Elastic Cloud

The code is prepared to send data to [Elastic Cloud](https://www.elastic.co/cloud) as long you provide the correct endpoint and a bearer token for authentication. The [run-locally.sh](run-locally.sh) script has an example of how to provide those using environment variables.

## Visualizing the traces

After executing the services you can reach the Elastic APM application in the following URL:

```bash
http://localhost:5601/app/apm
```

## Invoking the microservice API

Once everything is running there will periodic requests being sent to the microservice so you don't need to issue any requests by yourself. However, if you want to do it anyway just execute:

```bash
curl -X GET http://localhost:8888/hello
```

# License

This project is licensed under the [Apache 2.0 License](./LICENSE).
