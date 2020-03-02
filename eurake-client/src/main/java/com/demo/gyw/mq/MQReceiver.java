package com.demo.gyw.mq;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
 
@Service
public class MQReceiver {
 
	private Logger logger = LoggerFactory.getLogger(MQReceiver.class);
	
	@RabbitListener(queues = MQConfig.QUEUE)
	public void receive(Object object){
		logger.info("receive:" + object.toString());
	}
 
}