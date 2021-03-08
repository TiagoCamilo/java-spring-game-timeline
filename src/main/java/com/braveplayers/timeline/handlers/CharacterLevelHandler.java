package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;
import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.enums.RegisterType;

public class CharacterLevelHandler implements CharacterHandler {
    @Override
    public boolean support(Character oldCharacter, Character newCharacter) {
        return !oldCharacter.getLevel().equals(newCharacter.getLevel());
    }

    @Override
    public Register process(Character oldCharacter, Character newCharacter) {
        return Register.builder()
                .type(RegisterType.CHARACTER_LEVEL_UPDATED)
                .worldName(newCharacter.getWorldName())
                .character(newCharacter)
                .newValue(newCharacter.getLevel().toString())
                .oldValue(oldCharacter.getLevel().toString())
                .build();
    }
}
