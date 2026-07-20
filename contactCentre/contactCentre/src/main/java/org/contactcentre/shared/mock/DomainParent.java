package org.contactcentre.shared.mock;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.domain.model.Address;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;

import java.util.List;

public final class DomainParent {
    public static Iterable<Parent> getParents() throws AddressException, PersonalDetailException, TitleException {
        return List.of(getParent("1", Title.MR, "John", "Doe", Gender.MALE),
                getParent("2", Title.MRS, "Joanne", "Doe", Gender.FEMALE),
                getParent("3", Title.MR, "Tim", "Graham", Gender.MALE),
                getParent("4", Title.MRS, "Sarah", "Gunter", Gender.FEMALE));
    }

    private static Parent getParent(String id, Title title, String firstName, String lastName, Gender gender) throws AddressException, PersonalDetailException, TitleException {
        return Parent.builder()
                .id(id).title(title)
                .firstName(firstName).lastName(lastName)
                .gender(gender)
                .address(Address.builder()
                        .addressLineOne("123 Main St")
                        .city("Leeds").county("West Yorkshire")
                        .country("United Kingdom").postCode("LS1 1AA")
                        .build())
                .build();
    }
}
