package com.knoldus.userMessagingSystem;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.io.*;

public class Producer {

    public static void main(String[] args) throws InterruptedException, IOException {

        String topic = "Kafka-Assignment-User-Data";
        int id, age;
        String name, course;
        String value = System.getenv("SERVER");
        Properties properties = new Properties();
        properties.put("bootstrap.servers", value+":9092");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(properties);
        Thread.sleep(1000);


        //File file = new File(
         //       "/home/knoldus/file.txt");

        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BuffferedReader class
        //BufferedReader br
          //      = new BufferedReader(new FileReader(file));

        // Declaring a string variable
        //String st;
        String st[] = {"Message1","Message2","Message3","Message4","Message5"};
        // Consition holds true till
        // there is character in a string
        //while ((st = br.readLine()) != null) {
        for(int i=0; i< st.length; i++){
            ProducerRecord producerRecord = new ProducerRecord(topic, st[i]);
            kafkaProducer.send(producerRecord);
            System.out.println("Message\t{ " + st[i] + " }\t Sent To Consumer");
            Thread.sleep(500);
        }



        kafkaProducer.close();

    }
}


