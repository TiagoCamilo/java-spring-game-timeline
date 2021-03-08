package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.entities.Character;

public class CharacterLevelHandler implements CharacterHandler {
    @Override
    public boolean support(Character oldCharacter, Character newCharacter) {
        return !oldCharacter.getLevel().equals(newCharacter.getLevel());
    }

    @Override
    public String process(Character oldCharacter, Character newCharacter) {
        return "Changed Level from " +
                oldCharacter.getLevel() +
                " to " +
                newCharacter.getLevel();
    }
}
