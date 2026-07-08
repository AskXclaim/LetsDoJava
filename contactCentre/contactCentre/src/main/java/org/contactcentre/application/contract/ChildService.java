package org.contactcentre.application.contract;

import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.NameException;
import org.contactcentre.presentation.api.dto.ChildDto;

public interface ChildService {
    void add(ChildDto child) throws DateOfBirthException, NameException;
}
