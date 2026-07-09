package org.contactcentre.application.service;

import lombok.RequiredArgsConstructor;
import org.contactcentre.application.contract.ParentService;
import org.contactcentre.application.mapper.ParentMapper;
import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.presentation.api.dto.ParentDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddParentService implements ParentService {
    private final ParentMapper parentMapper;
    private final ClientRepository<Parent> parentClientRepository;

    public void add(ParentDto parentDto) throws PersonalDetailException, TitleException, AddressException {
        var parentEntity = parentMapper.toEntity(parentDto);
        parentClientRepository.add(parentEntity);
        IO.println(parentEntity);
    }
}
