
package cn.com.study.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author LIU
 *
 */
@Service
public class KafkaConsumer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@KafkaListener(topics = { "test" })
	public void listen(ConsumerRecord<?, ?> record) {
		logger.debug("kafka1-------------------------kafka1");
		System.out.printf("offset = %d,key =%s,value=%s\n", record.offset(), record.key(), record.value());
	}

	@KafkaListener(topics = { "test" })
	public void listen2(ConsumerRecord<?, ?> record) {
		logger.debug("kafka2-------------------------kafka2");
		System.out.printf("offset = %d,key =%s,value=%s\n", record.offset(), record.key(), record.value());
	}

	@KafkaListener(topics = { "oms" })
	public void omsListen(ConsumerRecord<?, ?> record) {
		logger.debug("kafka2-------------------------kafka2");
		System.out.printf("offset = %d,key =%s,value=%s\n", record.offset(), record.key(), record.value());
	}
}
