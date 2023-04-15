package com.kafka;

import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

public class ExceptionReceiver {

  public static void main(String[] args) {
    Properties props = PropetiesUtil.getExceptionReceiverProperties();

    KafkaConsumer<String, String> kafkaConsumer = new KafkaConsumer<>(props);
    kafkaConsumer.subscribe(Arrays.asList("ExceptionBot"));
    while (true) {
      ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
      for (ConsumerRecord<String, String> record : records) {
        System.out.println("Partition: " + record.partition() + " Offset: " + record.offset()
            + " Value: " + record.value() + " ThreadID: " + Thread.currentThread().getId());
      }
    }

  }

}
