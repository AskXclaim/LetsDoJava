package org.contactcentre.application.contract;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.dto.RegisterChildRequestDto;


/**
 * Service interface for registering a child along with their parent details.
 * This interface provides functionality to register a child by accepting the
 * relevant details encapsulated in a {@link RegisterChildRequestDto}.
 * <p>
 * The registration process involves:
 * - Mapping the parent's details from the DTO to their respective domain objects.
 * - Adding the parents (father and mother) to the respective repository.
 * - Mapping the child's details from the DTO to a domain object and associating
 *   it with the registered parents using their IDs.
 * <p>
 * - Storing the child in the child repository.
 * The implementation ensures transactional integrity during the registration process.
 */
public interface RegisterChildService {
    String register(RegisterChildRequestDto registerChildRequestDto)
            throws TitleException, PersonalDetailException, DateOfBirthException, AddressException;
}
