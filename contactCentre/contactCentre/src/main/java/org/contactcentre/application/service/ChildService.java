package org.contactcentre.application.service;

import lombok.RequiredArgsConstructor;
import org.contactcentre.application.mapper.ChildMapper;
import org.contactcentre.presentation.api.dto.ChildDto;

@RequiredArgsConstructor
public class AddChildService {
    private final ChildMapper childMapper;

    public void addChild(ChildDto child) {
        var childEntity = childMapper.toEntity(child);
        IO.println(childEntity);

    }
}
