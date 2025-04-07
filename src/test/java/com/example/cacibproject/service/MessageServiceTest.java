package com.example.cacibproject.service;

import com.example.cacibproject.model.Message;
import com.example.cacibproject.repositorie.MessageRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    private Message message;
    private List<Message> messages;

    @BeforeEach
    public void setUp() {
        // Setup mock data
        message = new Message();
        message.setId(1L);
        message.setMessageContent("Test Message");

        messages = new ArrayList<>();
        messages.add(message);
    }

    @Test
    public void testGetAllMessages() {
        // Mock the repository method to return a list of messages
        when(messageRepository.findAll()).thenReturn(messages);

        // Call the service method
        List<Message> result = messageService.getAllMessages();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("Test Message", result.get(0).getMessageContent());
        verify(messageRepository, times(1)).findAll();
    }

    @Test
    public void testSaveMessage() {
        // Mock the repository method to return the saved message
        when(messageRepository.save(Mockito.any(Message.class))).thenReturn(message);

        // Call the service method
        Message result = messageService.saveMessage(message);

        // Verify the result
        assertEquals("Test Message", result.getMessageContent());
        verify(messageRepository, times(1)).save(Mockito.any(Message.class));
    }
}
