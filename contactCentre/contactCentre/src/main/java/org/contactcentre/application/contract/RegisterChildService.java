package org.contactcentre.application.contract;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.dto.RegisterChildRequestDto;

public interface RegisterChildService {
    String register(RegisterChildRequestDto registerChildRequestDto)
            throws TitleException, PersonalDetailException, DateOfBirthException, AddressException;
}
