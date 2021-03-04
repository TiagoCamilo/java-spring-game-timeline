package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.entities.Character;

public interface CharacterFilter {
    boolean support(Character oldCharacter, Character newCharacter);

    String process(Character oldCharacter, Character newCharacter);
}
