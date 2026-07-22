package org.contactcentre.application.contract;


import org.contactcentre.application.command.RegisterChildCommand;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;

public interface ChildRegistrationService {
    String register(RegisterChildCommand registerChildCommand) throws PersonalDetailException, DateOfBirthException;
}
