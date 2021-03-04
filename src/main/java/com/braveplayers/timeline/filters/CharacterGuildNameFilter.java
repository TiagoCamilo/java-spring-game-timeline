package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.dtos.CharacterDto;

public class CharacterGuildNameFilter implements CharacterFilter {
    @Override
    public boolean support(CharacterDto oldCharacter, CharacterDto newCharacter) {
        return !oldCharacter.getGuildName().equals(newCharacter.getGuildName());
    }

    @Override
    public String process(CharacterDto oldCharacter, CharacterDto newCharacter) {
        return "Changed Guild from " +
                oldCharacter.getGuildName() +
                " to " +
                newCharacter.getGuildName();
    }
}
