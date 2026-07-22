package org.contactcentre.domain.model.client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.contactcentre.domain.contract.Addressable;
import org.contactcentre.domain.contract.entity.Person;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.Address;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;

@Getter
@ToString(callSuper = true)
public class Parent extends Person implements Addressable {
    private final Address address;
    private final String phone;
    private final String email;
    private final Title title;

    @Builder
    public Parent(String id, Title title, @NotBlank String firstName, String middleName, @NotBlank String lastName,
                  Gender gender, @NotNull Address address, String phone, String email) throws PersonalDetailException {
        super(id, firstName, middleName, lastName, gender);
        this.address = address;
        this.title = title;
        validateContactMeans(phone, email);
        this.phone = phone;
        this.email = email;

    }

    private void validateContactMeans(String phone, String email) throws PersonalDetailException {
        if ((phone == null || phone.isBlank()) && (email == null || email.isBlank())) {
            throw new PersonalDetailException("Both phone and email cannot be null or blank");
        }
    }

}
