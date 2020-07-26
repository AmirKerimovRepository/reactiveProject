package com.meaWallet.reactiveProject.listener;

import com.meaWallet.reactiveProject.config.ConfigureRabbitMq;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;


public class CardMessageListener {

    private static final Logger log = (Logger) LogManager.getLogger(CardMessageListener.class);

    @RabbitListener(queues = ConfigureRabbitMq.SFG_MESSAGE_QUEUE)
    public String process(@Payload String payload) {
        final String replay = " ";
        log.info("Processed message: {}", replay);
        return replay;
    }
}
