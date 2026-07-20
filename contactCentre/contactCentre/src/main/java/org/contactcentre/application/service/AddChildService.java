package org.contactcentre.application.service;

import lombok.RequiredArgsConstructor;
import org.contactcentre.application.contract.ChildService;
import org.contactcentre.application.mapper.ChildMapper;
import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.presentation.dto.ChildDto;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddChildService implements ChildService {
    private final ChildMapper childMapper;
    private final ClientRepository<Child> childClientRepository;

    public void add(ChildDto child) throws PersonalDetailException, DateOfBirthException, AddressException {
        var childEntity = childMapper.toEntity(child);
        var newChild = childClientRepository.add(childEntity);

        IO.println(childEntity);
    }

}
