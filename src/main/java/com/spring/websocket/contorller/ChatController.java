package com.spring.websocket.contorller;

import com.spring.websocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    //User 등록에 관한 controller
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage regieter(@Payload ChatMessage chatmessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatmessage.getSender());
        return chatmessage;
    }

    //메시지 전송에 관한 Controller
    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }
}
