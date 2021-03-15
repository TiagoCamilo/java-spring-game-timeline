package com.braveplayers.timeline.handlers;

import com.braveplayers.timeline.entities.Character;
import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.enums.RegisterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterGuildNameHandlerTest {

    CharacterHandler handler;

    @BeforeEach
    public void setup() {
        handler = new CharacterGuildNameHandler();
    }

    @Test
    public void support_SameLevel_False() {
        Character oldCharacter = Character.builder().guildName("A").build();
        Character newCharacter = Character.builder().guildName("A").build();

        assertFalse(handler.support(oldCharacter, newCharacter));
    }

    @Test
    public void support_DifferentLevel_True() {
        Character oldCharacter = Character.builder().guildName("A").build();
        Character newCharacter = Character.builder().guildName("B").build();

        assertTrue(handler.support(oldCharacter, newCharacter));
    }

    @Test
    public void process_Register() {
        Character oldCharacter = Character.builder().guildName("A").build();
        Character newCharacter = Character.builder().guildName("B").build();

        Register registerCreated = handler.process(oldCharacter, newCharacter);

        assertEquals(RegisterType.CHARACTER_GUILD_UPDATED, registerCreated.getType());
        assertEquals(oldCharacter.getGuildName(), registerCreated.getOldValue());
        assertEquals(newCharacter.getGuildName(), registerCreated.getNewValue());
    }
}
