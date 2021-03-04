package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.dtos.CharacterDto;

public class CharacterLevelFilter implements CharacterFilter {
    @Override
    public boolean support(CharacterDto oldCharacter, CharacterDto newCharacter) {
        return !oldCharacter.getLevel().equals(newCharacter.getLevel());
    }

    @Override
    public String process(CharacterDto oldCharacter, CharacterDto newCharacter) {
        return "Changed Level from " +
                oldCharacter.getLevel() +
                " to " +
                newCharacter.getLevel();
    }
}
