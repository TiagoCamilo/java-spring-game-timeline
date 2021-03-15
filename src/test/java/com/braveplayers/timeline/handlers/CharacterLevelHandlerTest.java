package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;
import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.enums.RegisterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterLevelHandlerTest {

    CharacterHandler handler;

    @BeforeEach
    public void setup() {
        handler = new CharacterLevelHandler();
    }

    @Test
    public void support_SameLevel_False() {
        Character oldCharacter = Character.builder().level(100).build();
        Character newCharacter = Character.builder().level(100).build();

        assertFalse(handler.support(oldCharacter, newCharacter));
    }

    @Test
    public void support_DifferentLevelGreaterEquals100_True() {
        Character oldCharacter = Character.builder().level(100).build();
        Character newCharacter = Character.builder().level(101).build();

        assertTrue(handler.support(oldCharacter, newCharacter));
    }

    @Test
    public void process_Register() {
        Character oldCharacter = Character.builder().level(1).build();
        Character newCharacter = Character.builder().level(2).build();

        Register registerCreated = handler.process(oldCharacter, newCharacter);

        assertEquals(RegisterType.CHARACTER_LEVEL_UPDATED, registerCreated.getType());
        assertEquals(oldCharacter.getLevel().toString(), registerCreated.getOldValue());
        assertEquals(newCharacter.getLevel().toString(), registerCreated.getNewValue());
    }


    @Test
    public void support_NewLevelLesser100_False() {
        Character oldCharacter = Character.builder().level(1).build();
        Character newCharacter = Character.builder().level(99).build();

        assertFalse(handler.support(oldCharacter, newCharacter));
    }
}
