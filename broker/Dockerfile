FROM openjdk

WORKDIR /opt/kafka

ADD https://dlcdn.apache.org/kafka/3.0.0/kafka_2.13-3.0.0.tgz .

RUN tar -xzf kafka_2.13-3.0.0.tgz

WORKDIR /opt/kafka/kafka_2.13-3.0.0

COPY . .

CMD ["./entrypoint"]
