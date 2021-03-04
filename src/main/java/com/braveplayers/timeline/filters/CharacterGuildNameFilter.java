package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.entities.Character;

public class CharacterGuildNameFilter implements CharacterFilter {
    @Override
    public boolean support(Character oldCharacter, Character newCharacter) {
        return !oldCharacter.getGuildName().equals(newCharacter.getGuildName());
    }

    @Override
    public String process(Character oldCharacter, Character newCharacter) {
        return "Changed Guild from " +
                oldCharacter.getGuildName() +
                " to " +
                newCharacter.getGuildName();
    }
}
