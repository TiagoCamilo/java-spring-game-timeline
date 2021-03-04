package com.braveplayers.timeline.filters;

import com.braveplayers.timeline.dtos.CharacterDto;
import com.braveplayers.timeline.entities.Register;
import com.braveplayers.timeline.services.RegisterService;

import java.util.List;

public class CharacterFilterManager {
    private final List<CharacterFilter> filters;
    private final RegisterService registerService;

    public CharacterFilterManager(RegisterService registerService, List<CharacterFilter> filters) {
        this.filters = filters;
        this.registerService = registerService;
    }

    public void execute(CharacterDto oldCharacter, CharacterDto newCharacter) {
        filters
                .stream()
                .filter(filter -> filter.support(oldCharacter, newCharacter))
                .map(filter -> filter.process(oldCharacter, newCharacter))
                .map(processResult -> Register
                        .builder()
                        .character(newCharacter)
                        .message(processResult)
                        .build()
                )
                .forEach(register ->
                        registerService.save(register).subscribe()
                );
    }
}
