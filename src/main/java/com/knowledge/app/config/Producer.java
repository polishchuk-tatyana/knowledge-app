package com.knowledge.app.config;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Producer {
    public static void main(String[] args) throws InterruptedException {
        Logger logger = LoggerFactory.getLogger(Producer.class);

        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092"); // info about kafka server
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class.getName()); //info about Message Key
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName()); // info about sent messages

        KafkaProducer<Integer, String> producer = new KafkaProducer<>(properties); //creation new producer<key, message>

        for (int i = 0; i < 10000; i++) {
            ProducerRecord<Integer, String> record = new ProducerRecord<>("demo-topic", i % 3, " " + i); //send message into kafka broker(partition)
            producer.send(record, (metadata, exeption) -> {
                if (exeption == null) {
                    logger.info("received metadata, topic " + metadata.topic()
                            + " partition " + record.partition() + " offset " + metadata.offset()
                            + " time " + metadata.timestamp());
                } else {
                    logger.error("error", exeption);
                }

            });
            Thread.sleep(1000);
        }
        producer.flush();
        producer.close();
    }
}