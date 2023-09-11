package dev.br.breno.springartemisproducer;

import org.apache.activemq.artemis.commons.shaded.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import dev.br.breno.springartemisproducer.config.JmsConfig;

@Service
public class MessageService {

    @Autowired
    JmsConfig jms;

    public void send(String message, String queue) {
        JmsTemplate jmstemplate = jms.jmsTemplate();
        jmstemplate.convertAndSend(queue, message);
    }
}
