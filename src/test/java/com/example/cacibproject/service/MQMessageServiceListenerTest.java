package com.example.cacibproject.service;

import com.example.cacibproject.model.Message;
import com.example.cacibproject.repositorie.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.jms.core.JmsTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MQMessageServiceListenerTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MQMessageServiceListener mqMessageServiceListener;

    @Mock
    private JmsTemplate jmsTemplate;

    private String messageContent;

    @BeforeEach
    public void setUp() {
        // Setup the mock message content
        messageContent = "Test message content";
    }

    @Test
    public void testReceiveMessage() {
        // Call the receive method (simulating the JMS listener receiving a message)
        mqMessageServiceListener.receive(messageContent);

        // Verify that the messageRepository.save method is called once
        verify(messageRepository, times(1)).save(any(Message.class));

        // Optionally, you can verify that the message object has been created with expected content
        Message messageCaptor = new Message();
        messageCaptor.setMessageContent(messageContent);
        messageCaptor.setMessageType("TEXT");
        messageCaptor.setStatus("PENDING");

        // Capture the argument passed to the save method
        verify(messageRepository).save(messageCaptor);
    }

    @Test
    public void testReceiveMessageNoContent() {
        // Test with an empty message content
        String emptyMessageContent = "";

        // Call the receive method (simulating the JMS listener receiving a message)
        mqMessageServiceListener.receive(emptyMessageContent);

        // Verify that the messageRepository.save method is called once
        verify(messageRepository, times(1)).save(any(Message.class));

        // Optionally, verify that the message is still saved with empty content
        verify(messageRepository).save(any(Message.class));
    }
}
