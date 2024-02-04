package com.ipap.springboot3ai.controller;

import com.ipap.springboot3ai.dto.SingersResponse;
import com.ipap.springboot3ai.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/topsingers/{country}")
    public ResponseEntity<String> getTopSingers(@PathVariable String country) {
        return ResponseEntity.ok(chatService.getTopSingers(country));
    }

    @GetMapping("/topsingers/structured/{country}")
    public ResponseEntity<SingersResponse> getTopSingersStructured(@PathVariable String country) {
        return ResponseEntity.ok(chatService.getTopSingersStructured(country));
    }
}
