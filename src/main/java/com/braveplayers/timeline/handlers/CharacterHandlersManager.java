package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;
import com.braveplayers.timeline.services.RegisterService;

import java.util.Arrays;
import java.util.List;

public class CharacterHandlersManager {
    private final List<CharacterHandler> handlers;
    private final RegisterService registerService;

    public CharacterHandlersManager(RegisterService registerService, CharacterHandler... handlers) {
        this.handlers = Arrays.asList(handlers.clone());
        this.registerService = registerService;
    }

    public void execute(Character oldCharacter, Character newCharacter) {
        handlers
                .stream()
                .filter(handler -> handler.support(oldCharacter, newCharacter))
                .map(handler -> handler.process(oldCharacter, newCharacter))
                .forEach(register ->
                        registerService.save(register).subscribe()
                );
    }
}
