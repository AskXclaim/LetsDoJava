package org.contactcentre.application.service;

import lombok.AllArgsConstructor;
import org.contactcentre.application.command.ChildCommand;
import org.contactcentre.application.command.RegisterChildCommand;
import org.contactcentre.application.contract.ChildRegistrationService;
import org.contactcentre.application.mapper.RegisterChildMapper;
import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.domain.model.client.Parent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RegisterChild implements ChildRegistrationService {
    private final RegisterChildMapper mapper;
    private final ClientRepository<Child> childRepository;
    private final ClientRepository<Parent> parentRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public String register(RegisterChildCommand registerChildCommand) throws PersonalDetailException, DateOfBirthException {
        var father = mapper.toParent(registerChildCommand.father());
        var mother = mapper.toParent(registerChildCommand.mother());

        var fatherId = parentRepository.add(father);
        var motherId = parentRepository.add(mother);

        Child child = getChild(registerChildCommand.child(), fatherId, motherId);

        return childRepository.add(child);
    }

    private Child getChild(ChildCommand childCommand, String fatherId, String motherId) throws PersonalDetailException, DateOfBirthException {
        var child = mapper.toChild(childCommand);
        child.setFatherId(fatherId);
        child.setMotherId(motherId);
        return child;
    }
}
