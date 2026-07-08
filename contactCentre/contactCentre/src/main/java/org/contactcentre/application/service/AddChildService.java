package org.contactcentre.application.service;

import lombok.RequiredArgsConstructor;
import org.contactcentre.application.mapper.ChildMapper;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.presentation.api.dto.ChildDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddChildService implements org.contactcentre.application.contract.ChildService {
    private final ChildMapper childMapper;

    public void add(ChildDto child) throws DateOfBirthException {
        var childEntity = childMapper.toEntity(child);
        IO.println(childEntity);

    }
}
