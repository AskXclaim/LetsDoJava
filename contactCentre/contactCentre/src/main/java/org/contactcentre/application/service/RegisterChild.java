package org.contactcentre.application.service;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.contactcentre.application.contract.RegisterChildService;
import org.contactcentre.application.mapper.PersonMapper;
import org.contactcentre.domain.contract.repository.ClientRepository;
import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.domain.model.client.Child;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.presentation.dto.RegisterChildRequestDto;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterChild implements RegisterChildService {
    private final PersonMapper mapper;
    private final ClientRepository<Child> childRepository;
    private final ClientRepository<Parent> parentRepository;
    //Get Child details
    // Address, DOB, Personal details
    //Get Parent(s) details
    //Validate Child details
    //validate parent details
    //save child details
    //make sure, address and parents details are saved

    @Override
    public String register(@NotNull RegisterChildRequestDto registerChildRequestDto)
            throws TitleException, PersonalDetailException, DateOfBirthException, AddressException {
        Child child = mapper.toChild(registerChildRequestDto.child());
        Parent dad = mapper.toParent(registerChildRequestDto.dad());
        Parent mom = mapper.toParent(registerChildRequestDto.mom());

        var fatherId = parentRepository.add(dad);
        var motherId = parentRepository.add(mom);
        child.setFatherId(fatherId);
        child.setMotherId(motherId);

        return childRepository.add(child);
    }
}
