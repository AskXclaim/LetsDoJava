package org.contactcentre.infrastructure.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.contactcentre.shared.Gender;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Builder
@Document("children")
public class ChildDocument {
    @Id
    private final String id;
    @Field
    private final String firstName;
    @Field
    private final String middleName;
    @Field 
    private final String lastName;
    private final Gender gender;
    @Field
    private final Gender genderAtBirth;
    @Field
    private final LocalDate dateOfBirth;
    @Field
    private final AddressDocument address;
    @Field
    private final String fatherId;
    @Field
    private final String motherId;
}
