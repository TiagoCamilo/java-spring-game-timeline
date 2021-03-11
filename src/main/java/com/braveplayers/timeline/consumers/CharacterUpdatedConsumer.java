package com.braveplayers.timeline.consumers;

import com.braveplayers.timeline.dtos.CharacterUpdatedMessageDto;
import com.braveplayers.timeline.handlers.CharacterHandlersManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CharacterUpdatedConsumer {

    private final CharacterHandlersManager characterHandlersManager;

    public CharacterUpdatedConsumer(CharacterHandlersManager characterHandlersManager) {
        this.characterHandlersManager = characterHandlersManager;
    }

    @SneakyThrows
    @RabbitListener(queues = {"${messaging.queue.name}"})
    public void receive(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        CharacterUpdatedMessageDto characterUpdatedMessageDto = objectMapper.readValue(message, CharacterUpdatedMessageDto.class);
        System.out.println(characterUpdatedMessageDto);

        characterHandlersManager.execute(characterUpdatedMessageDto.getOldCharacter(), characterUpdatedMessageDto.getNewCharacter());
    }

}
