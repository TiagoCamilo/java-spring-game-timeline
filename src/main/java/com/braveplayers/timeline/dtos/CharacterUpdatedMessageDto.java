package com.braveplayers.timeline.dtos;

import com.braveplayers.timeline.entities.Character;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterUpdatedMessageDto implements Serializable {
    private Character oldCharacter;
    private Character newCharacter;
}
