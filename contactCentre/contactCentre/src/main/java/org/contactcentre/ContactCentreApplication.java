package org.contactcentre;

import org.contactcentre.application.service.AddChildService;
import org.contactcentre.application.service.AddParentService;
import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.api.dto.AddressDto;
import org.contactcentre.presentation.api.dto.ChildDto;
import org.contactcentre.presentation.api.dto.ParentDto;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ContactCentreApplication {

    public static void main(String[] args) throws PersonalDetailException, DateOfBirthException, TitleException, AddressException {

        //SpringApplication.run(ContactCentreApplication.class, args);
        var context = SpringApplication.run(ContactCentreApplication.class, args);
        var childService = context.getBean(AddChildService.class);
        childService.add(ChildDto.builder()
                .id(1L).firstName("John")
                .lastName("Doe").middleName("")
                .gender(Gender.MALE).genderAtBirth("Male")
                .dateOfBirth(LocalDate.of(1991, 2, 1))
                .address(AddressDto.builder()
                        .addressLineOne("123 Main St")
                        .city("Anytown")
                        .county("County")
                        .country("UK")
                        .postCode("12345")
                        .build())
                .build());

        var parentService = context.getBean(AddParentService.class);
        parentService.add(ParentDto.builder()
                .id(1L)
                .title(Title.MRS).firstName("Jenny")
                .lastName("Doe").middleName("")
                .gender(Gender.FEMALE)
                .address(AddressDto.builder()
                        .addressLineOne("123 Main St")
                        .city("Anytown")
                        .county("County")
                        .country("UK")
                        .postCode("12345")
                        .build())
                .build());
    }

}
