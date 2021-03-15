package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;
import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.enums.RegisterType;

public class CharacterGuildNameHandler implements CharacterHandler {
    @Override
    public boolean support(Character oldCharacter, Character newCharacter) {
        return !oldCharacter.getGuildName().equals(newCharacter.getGuildName());
    }

    @Override
    public Register process(Character oldCharacter, Character newCharacter) {
        return Register.builder()
                .type(RegisterType.CHARACTER_GUILD_UPDATED)
                .worldName(newCharacter.getWorldName())
                .character(newCharacter)
                .newValue(newCharacter.getGuildName())
                .oldValue(oldCharacter.getGuildName())
                .build();
    }
}
