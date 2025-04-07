package com.example.cacibproject.service;

import com.example.cacibproject.model.Message;
import com.example.cacibproject.repositorie.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class MQMessageServiceListener {

    @Autowired
    private MessageRepository messageRepository;

    @JmsListener(destination = "${ibm.mq.queue-name}")  // Uses the queue name from the config
    @Transactional
    public void receive(String message) {
        // Log the incoming message (optional)
        System.out.println("Received message: " + message);

        // Here, you can parse or process the message as needed
        Message msgEntity = new Message();
        msgEntity.setMessageContent(message);
        msgEntity.setMessageType("TEXT");  // Assuming message is plain text, you can adjust accordingly
        msgEntity.setDateReceived(LocalDateTime.now());
        msgEntity.setStatus("PENDING");

        messageRepository.save(msgEntity);

        System.out.println("Received message: " +messageRepository.findAll().size());

        // If any other processing is needed, you can handle it here
    }
}
