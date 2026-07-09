package org.contactcentre.domain.model.client;

import lombok.Getter;
import lombok.ToString;
import org.contactcentre.domain.contract.Client;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;

@Getter
@ToString(callSuper = true)
public class Parent extends Client {
    private final Address address;
    private final Title title;

    public Parent(Long id, Title title, String firstName, String middleName, String lastName,
                  Gender gender, Address address) throws PersonalDetailException, TitleException {
        super(id, firstName, middleName, lastName, gender);
        this.address = address;
        validateTitle(title);
        this.title = title;

    }

    private void validateTitle(Title title) throws TitleException {
        if (!Title.isValid(title)) {
            throw new TitleException("Invalid title");
        }
    }

}
