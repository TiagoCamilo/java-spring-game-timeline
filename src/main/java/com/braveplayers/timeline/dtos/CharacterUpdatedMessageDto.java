package com.braveplayers.timeline.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterUpdatedMessageDto implements Serializable {
    private CharacterDto oldCharacter;
    private CharacterDto newCharacter;
}
