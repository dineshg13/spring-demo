#!/usr/bin/env bash
 java -javaagent:opentelemetry-javaagent.jar \
      -Dotel.resource.attributes=service.name=your-service-name \
      -Dotel.traces.exporter=logging\
      -Dotel.metrics.exporter=logging\
      -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar
