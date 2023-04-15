package com.kafka;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

public class ExceptionNotifier {

	public static void main(String[] args) {
		
		//Start zookeeper 	
		//bin/zookeeper-server-start.sh config/zookeeper.properties
		//bin/kafka-server-start.sh config/server.properties
		
		Properties props = PropetiesUtil.getExceptionNotifierProperties();
		Producer<String, String> producer = null;
		try {
			producer = new KafkaProducer<>(props);
			for (int i = 0; i < 100; i++) {
				//Need to decide message inputs
				
				String msg = "Message " + i;
				producer.send(new ProducerRecord<String, String>("ExceptionBot", msg));
				System.out.println("Sent:" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			producer.close();
		}

	}

}