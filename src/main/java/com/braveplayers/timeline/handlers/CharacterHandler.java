package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;

public interface CharacterHandler {
    boolean support(Character oldCharacter, Character newCharacter);

    String process(Character oldCharacter, Character newCharacter);
}
