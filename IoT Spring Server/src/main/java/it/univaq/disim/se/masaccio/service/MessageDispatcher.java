package it.univaq.disim.se.masaccio.service;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import it.univaq.disim.se.masaccio.data.MessageList;

@Service
public class MessageDispatcher {

    @Autowired
    private KafkaTemplate<String, MessageList> messageKafkaTemplate;


    private static final Logger LOGGER = LoggerFactory.getLogger(MessageDispatcher.class);

    public boolean dispatch(MessageList messageList) {
        try {
            SendResult<String, MessageList> sendResult = messageKafkaTemplate.sendDefault(messageList.getId(), messageList).get();
            RecordMetadata recordMetadata = sendResult.getRecordMetadata();
            LOGGER.info("topic = {}, partition = {}, offset = {}, workUnit = {}",
                    recordMetadata.topic(), recordMetadata.partition(), recordMetadata.offset(), messageList);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
