package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.dtos.CharacterDto;

public interface CharacterFilter {
    boolean support(CharacterDto oldCharacter, CharacterDto newCharacter);

    String process(CharacterDto oldCharacter, CharacterDto newCharacter);
}
