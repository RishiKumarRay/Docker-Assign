FROM maven:ibmjava-alpine AS builder

WORKDIR /opt/Producer

COPY . .

RUN mvn clean package

FROM openjdk
WORKDIR /opt/Cons
COPY --from=builder /opt/Producer/target/Kafka-Assignment-1.0-SNAPSHOT-jar-with-dependencies.jar .
ENV SERVER=broker
ENTRYPOINT ["java", "-jar"]
CMD ["Kafka-Assignment-1.0-SNAPSHOT-jar-with-dependencies.jar"]
