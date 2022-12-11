#!/usr/bin/env bash

java -javaagent:opentelemetry-javaagent.jar \
      -Dotel.resource.attributes=service.name=java-service \
      -Dotel.exporter.otlp.compression=gzip \
      -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar

#      -Dotel.metrics.exporter=logging\

