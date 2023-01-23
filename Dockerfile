FROM gradle:7.6.0-jdk17-focal

COPY . /app
WORKDIR /app

COPY ./opentelemetry-javaagent.jar /app

ENV OTEL_EXPORTER_OTLP_PROTOCOL=http/protobuf 
CMD ["java",  "-javaagent:/app/opentelemetry-javaagent.jar" , "-jar",  "/app/build/libs/demo-0.0.1-SNAPSHOT.jar"]


