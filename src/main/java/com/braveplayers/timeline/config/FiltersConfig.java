package com.braveplayers.timeline.config;

import com.braveplayers.timeline.filters.CharacterFilterManager;
import com.braveplayers.timeline.filters.CharacterGuildNameFilter;
import com.braveplayers.timeline.filters.CharacterLevelFilter;
import com.braveplayers.timeline.services.RegisterService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class FiltersConfig {

    @Bean
    public CharacterFilterManager characterUpdatedFilterManager(RegisterService registerService) {
        return new CharacterFilterManager(
                registerService,
                List.of(
                        new CharacterLevelFilter()
                        , new CharacterGuildNameFilter()
                ));
    }

}
