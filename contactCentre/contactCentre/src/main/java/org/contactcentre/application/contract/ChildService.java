package org.contactcentre.application.contract;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.presentation.api.dto.ChildDto;

public interface ChildService {
    void add(ChildDto child) throws DateOfBirthException, PersonalDetailException, AddressException;
}
