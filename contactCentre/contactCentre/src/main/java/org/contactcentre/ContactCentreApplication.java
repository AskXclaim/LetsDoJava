package org.contactcentre;

import org.contactcentre.application.service.AddChildService;
import org.contactcentre.application.service.AddParentService;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.api.dto.ChildDto;
import org.contactcentre.presentation.api.dto.ParentDto;
import org.contactcentre.shared.Title;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ContactCentreApplication {

    public static void main(String[] args) throws DateOfBirthException, TitleException {

        //SpringApplication.run(ContactCentreApplication.class, args);
        var context = SpringApplication.run(ContactCentreApplication.class, args);
        var childService = context.getBean(AddChildService.class);
        childService.add(ChildDto.builder()
                .id(1L).firstName("John")
                .lastName("Doe").middleName("")
                .gender("Male").genderAtBirth("Male")
                .dateOfBirth(LocalDate.of(1991, 2, 1)).build());

        var parentService = context.getBean(AddParentService.class);
        parentService.add(ParentDto.builder()
                .id(1L)
                .title(Title.MR).firstName("John")
                .lastName("Doe").middleName("")
                .gender("Male")
                .build());
    }

}
