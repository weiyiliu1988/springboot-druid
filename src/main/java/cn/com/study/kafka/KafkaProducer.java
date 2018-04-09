
package cn.com.study.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author LIU
 *
 */
@Service
public class KafkaProducer {

	@Autowired
	private KafkaTemplate<?, ?> kafkaTemplate;

	String topic = "test";

	public void sendMessage(String key, String data) {
		ListenableFuture<SendResult<?, ?>> future = kafkaTemplate.send(new ProducerRecord(topic, key, data));
		future.addCallback(new ListenableFutureCallback() {

			@Override
			public void onSuccess(Object result) {
				System.out.println("------------success sent------------");
				System.out.println(result);
				SendResult res = (SendResult) result;
				System.out.println("------------success sent topic------------");
				System.out.println(res.getProducerRecord().topic());
				System.out.println("success sent!");

			}

			@Override
			public void onFailure(Throwable ex) {
				System.out.println("------------failure sent------------");
				ex.printStackTrace();
				System.out.println("failure sent!");
			}

		});
	}
}
