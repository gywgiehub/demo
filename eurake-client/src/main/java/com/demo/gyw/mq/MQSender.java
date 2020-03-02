package com.demo.gyw.mq;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 

@Service
public class MQSender {
 
	private Logger logger = LoggerFactory.getLogger(MQSender.class);
 
	//@Autowired
	//private RedisService redisService;

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	/**
	 * Direct 模式交换机
	 * @param obj
	 */
	public void send(Object obj){
		logger.info("sender send:" + obj);
		amqpTemplate.convertAndSend(MQConfig.QUEUE, obj);
	}
}