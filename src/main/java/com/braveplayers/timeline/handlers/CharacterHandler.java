package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;
import com.braveplayers.timeline.entities.Register;

public interface CharacterHandler {
    boolean support(Character oldCharacter, Character newCharacter);

    Register process(Character oldCharacter, Character newCharacter);
}
