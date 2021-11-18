FROM maven:ibmjava-alpine AS builder

WORKDIR /opt/Consumer

COPY . .

RUN mvn clean package

FROM openjdk
WORKDIR /opt/Consumer
COPY --from=builder /opt/Consumer/target/Kafka-Assignment-1.0-SNAPSHOT-jar-with-dependencies.jar .
ENV SERVER=broker
ENTRYPOINT ["java", "-jar"]
CMD ["Kafka-Assignment-1.0-SNAPSHOT-jar-with-dependencies.jar"]
