package org.contactcentre;

import org.contactcentre.application.command.AddressCommand;
import org.contactcentre.application.command.ChildCommand;
import org.contactcentre.application.command.ParentCommand;
import org.contactcentre.application.command.RegisterChildCommand;
import org.contactcentre.application.service.RegisterChild;
import org.contactcentre.domain.exception.DateOfBirthException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class ContactCentreApplication {

    public static void main(String[] args) throws PersonalDetailException, DateOfBirthException {

        //SpringApplication.run(ContactCentreApplication.class, args);
        var context = SpringApplication.run(ContactCentreApplication.class, args);
        var registerChild = context.getBean(RegisterChild.class);
        var childToRegister = RegisterChildCommand.builder()
                .child(ChildCommand.builder()
                        .firstName("Ryan").lastName("Smith").gender(Gender.MALE).genderAtBirth(Gender.MALE).dateOfBirth(LocalDate.of(2000, 1, 1))
                        .address(AddressCommand.builder()
                                .addressLineOne("Flat 3").city("Leeds").county("West Yorkshire").country("UK").postCode("LS1 1AA").build()
                        ).build())
                .father(ParentCommand.builder()
                        .title(Title.MR).firstName("John").lastName("Smith").gender(Gender.MALE).email("john.smith@example.com").phoneNumber("+4478654638192")
                        .address(AddressCommand.builder().addressLineOne("Flat 3").city("Leeds").county("West Yorkshire").country("UK").postCode("LS1 1AA").build())
                        .build())
                .mother(ParentCommand.builder()
                        .title(Title.MRS).firstName("Jane").lastName("Smith").gender(Gender.FEMALE).email("jane.smith@example.com").phoneNumber("+4478654638192")
                        .address(AddressCommand.builder().addressLineOne("Flat 23").city("Leeds").county("West Yorkshire").country("UK").postCode("LS1 1AA").build())
                        .build()).build();

        var childId = registerChild.register(childToRegister);
        System.out.println("Child ID: " + childId);

    }

}
