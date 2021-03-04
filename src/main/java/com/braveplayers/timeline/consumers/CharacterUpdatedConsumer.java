package com.braveplayers.timeline.consumers;

import com.braveplayers.timeline.dtos.CharacterUpdatedMessageDto;
import com.braveplayers.timeline.filters.CharacterFilterManager;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CharacterUpdatedConsumer {

    private final CharacterFilterManager characterFilterManager;

    public CharacterUpdatedConsumer(CharacterFilterManager characterFilterManager) {
        this.characterFilterManager = characterFilterManager;
    }

    @SneakyThrows
    @RabbitListener(queues = {"game_queue"})
    public void receive(String message) {
        ObjectMapper objectMapper = new ObjectMapper();
        CharacterUpdatedMessageDto characterUpdatedMessageDto = objectMapper.readValue(message, CharacterUpdatedMessageDto.class);
        System.out.println(characterUpdatedMessageDto);

        characterFilterManager.execute(characterUpdatedMessageDto.getOldCharacter(), characterUpdatedMessageDto.getNewCharacter());
    }

}
