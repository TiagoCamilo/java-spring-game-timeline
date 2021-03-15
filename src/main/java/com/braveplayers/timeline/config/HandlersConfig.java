package com.braveplayers.timeline.config;

import com.braveplayers.timeline.handlers.CharacterGuildNameHandler;
import com.braveplayers.timeline.handlers.CharacterHandlersManager;
import com.braveplayers.timeline.handlers.CharacterLevelHandler;
import com.braveplayers.timeline.services.RegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlersConfig {

    @Bean
    public CharacterHandlersManager characterHandlersManager(RegisterService registerService) {
        return new CharacterHandlersManager(
                registerService,
                new CharacterLevelHandler()
                , new CharacterGuildNameHandler()
        );
    }

}
