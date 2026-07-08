package org.contactcentre.application.service;

import lombok.RequiredArgsConstructor;
import org.contactcentre.application.mapper.ParentMapper;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.api.dto.ParentDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddParentService implements org.contactcentre.application.contract.ParentService {
    private final ParentMapper parentMapper;

    public void add(ParentDto parentDto) throws TitleException {
        var parentEntity = parentMapper.toEntity(parentDto);
        IO.println(parentEntity);
    }
}
