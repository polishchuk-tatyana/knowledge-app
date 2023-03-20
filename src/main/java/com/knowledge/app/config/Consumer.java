package com.knowledge.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Consumer {
    public static void main(String[] args){
        Logger logger = LoggerFactory.getLogger(Consumer.class);

        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092"); // info about kafka server
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName()); //info about Message Key
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName()); // info about sent messages
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group2"); // in which group will be added new consumer
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        KafkaConsumer<Integer, String> consumer = new KafkaConsumer<>(properties); //creation new consumer<key, message>
        consumer.subscribe(Collections.singleton("demo-topic"));

        while (true){
            ConsumerRecords<Integer, String> records = consumer.poll(Duration.ofMillis(100)); // pull messages from kafka
            for(ConsumerRecord<Integer, String> record : records){
                logger.info("key " + record.key() + " value " + record.value() +
                        " partition " + record.partition() + " offset " + record.offset());
            }
        }

    }
}
