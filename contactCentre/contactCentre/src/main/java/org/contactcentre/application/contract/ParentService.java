package org.contactcentre.application.contract;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.dto.ParentDto;

public interface ParentService {
    void add(ParentDto parentDto) throws PersonalDetailException, TitleException, AddressException;
}
