package com.braveplayers.timeline.config;

import com.braveplayers.timeline.filters.CharacterHandlersManager;
import com.braveplayers.timeline.filters.CharacterGuildNameHandler;
import com.braveplayers.timeline.filters.CharacterLevelHandler;
import com.braveplayers.timeline.services.RegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class HandlersConfig {

    @Bean
    public CharacterHandlersManager characterHandlersManager(RegisterService registerService) {
        return new CharacterHandlersManager(
                registerService,
                List.of(
                        new CharacterLevelHandler()
                        , new CharacterGuildNameHandler()
                ));
    }

}
