package com.example.cacibproject.controller;

import com.example.cacibproject.model.Message;
import com.example.cacibproject.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MessageControllerTest {

    @Mock
    private MessageService messageService;

    @InjectMocks
    private MessageController messageController;

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
    public void testGetMessages() {
        // Mock the service method to return a list of messages
        when(messageService.getAllMessages()).thenReturn(messages);

        // Call the controller method
        List<Message> result = messageController.getMessages();

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("Test Message", result.get(0).getMessageContent());
        verify(messageService, times(1)).getAllMessages();
    }

    @Test
    public void testCreateMessage() {
        // Mock the service method to return the saved message
        when(messageService.saveMessage(Mockito.any(Message.class))).thenReturn(message);

        // Call the controller method
        Message result = messageController.createMessage(message);

        // Verify the result
        assertEquals("Test Message", result.getMessageContent());
        verify(messageService, times(1)).saveMessage(Mockito.any(Message.class));
    }
}
