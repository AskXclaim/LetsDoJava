package org.contactcentre.infrastructure.model.mongo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@Builder
@Getter
@Document("addresses")
public class AddressDocument {
    @Id
    private final String id;
    @Field
    private final String addressLineOne;
    @Field
    private final String addressLineTwo;
    @Field
    private final String city;
    @Field
    private final String county;
    @Field
    private final String country;
    @Field
    private final String postCode;
}
