package com.example.cacibproject.controller;

import com.example.cacibproject.model.Message;
import com.example.cacibproject.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;

    @GetMapping
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping
    public Message createMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }
}