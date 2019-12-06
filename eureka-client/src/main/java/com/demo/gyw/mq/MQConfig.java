package com.demo.gyw.mq;
 
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 /**
 * @Description:    rabbitMQ配置
 * @Author:         gyw
 * @CreateDate:     2019/6/6 9:07
 * @Version:        1.0
 */
@Configuration
public class MQConfig {
 
	public static final String QUEUE = "queue";
 
	@Bean
	public Queue queue(){
		return new Queue(QUEUE, true);
	}
 
}