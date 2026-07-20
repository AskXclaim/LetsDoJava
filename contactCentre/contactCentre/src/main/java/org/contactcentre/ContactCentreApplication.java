package org.contactcentre;

import org.contactcentre.application.service.RegisterChild;
import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.exception.TitleException;
import org.contactcentre.presentation.dto.AddressDto;
import org.contactcentre.presentation.dto.ChildDto;
import org.contactcentre.presentation.dto.ParentDto;
import org.contactcentre.presentation.dto.RegisterChildRequestDto;
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
        var registerChild = context.getBean(RegisterChild.class);
        var childToRegister = RegisterChildRequestDto.builder()
                .child(ChildDto.builder()
                        .firstName("Ryan").lastName("Smith").gender(Gender.MALE).genderAtBirth(Gender.MALE).dateOfBirth(LocalDate.of(2000, 1, 1))
                        .address(AddressDto.builder()
                                .addressLineOne("Flat 3").city("Leeds").county("West Yorkshire").country("UK").postCode("LS1 1AA").build()
                        ).build())
                .dad(ParentDto.builder()
                        .title(Title.MR).firstName("John").lastName("Smith").gender(Gender.MALE).email("john.smith@example.com").phone("+4478654638192")
                        .address(AddressDto.builder().addressLineOne("Flat 3").city("Leeds").county("West Yorkshire").country("UK").postCode("LS1 1AA").build())
                        .build())
                .mom(ParentDto.builder()
                        .title(Title.MRS).firstName("Jane").lastName("Smith").gender(Gender.FEMALE).email("jane.smith@example.com").phone("+4478654638192")
                        .address(AddressDto.builder().addressLineOne("Flat 23").city("Leeds").county("West Yorkshire").country("UK").postCode("LS1 1AA").build())
                        .build()).build();

        var childId = registerChild.register(childToRegister);
        System.out.println("Child ID: " + childId);

    }

}
