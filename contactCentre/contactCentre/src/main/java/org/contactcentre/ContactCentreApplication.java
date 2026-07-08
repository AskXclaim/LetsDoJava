package org.contactcentre;

import org.contactcentre.application.service.ChildService;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.presentation.api.dto.ChildDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ContactCentreApplication {

    public static void main(String[] args) throws DateOfBirthException {

        //SpringApplication.run(ContactCentreApplication.class, args);
        var context = SpringApplication.run(ContactCentreApplication.class, args);
        var childService = context.getBean(ChildService.class);
        childService.add(ChildDto.builder()
                .id(1L).firstName("John")
                .lastName("Doe").middleName("")
                .gender("Male").genderAtBirth("Male")
                .dateOfBirth(LocalDate.of(1991, 2, 1)).build());
    }

}
