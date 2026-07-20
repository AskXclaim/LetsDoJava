package org.contactcentre.infrastructure.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.contactcentre.shared.Gender;
import org.contactcentre.shared.Title;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Getter
@AllArgsConstructor
@Builder
@Document("parents")
public class ParentDocument {
    @Id
    private final String id;
    @Field
    private final Title title;
    @Field
    private final String firstName;
    @Field
    private final String middleName;
    @Field
    private final String lastName;
    private Gender gender;
    @Field
    private String email;
    @Field
    private String phoneNumber;
    @Field
    private AddressDocument address;
}
