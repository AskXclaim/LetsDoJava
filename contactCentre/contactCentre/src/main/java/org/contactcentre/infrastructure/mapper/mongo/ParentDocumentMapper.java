package org.contactcentre.infrastructure.mapper.mongo;

import org.contactcentre.domain.exception.AddressException;
import org.contactcentre.domain.exception.PersonalDetailException;
import org.contactcentre.domain.model.Address;
import org.contactcentre.domain.model.client.Parent;
import org.contactcentre.infrastructure.model.mongo.AddressDocument;
import org.contactcentre.infrastructure.model.mongo.ParentDocument;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {AddressDocumentMapper.class})

public interface ParentDocumentMapper {
    @Mapping(source = "phone", target = "phoneNumber")
    ParentDocument toParentDocument(Parent parent);

    default Parent toParent(ParentDocument parentDocument) {
        if (parentDocument == null) {
            return null;
        }
        try {
            return Parent.builder()
                    .id(parentDocument.getId() == null ? null : parentDocument.getId().toString())
                    .title(parentDocument.getTitle())
                    .firstName(parentDocument.getFirstName())
                    .middleName(parentDocument.getMiddleName())
                    .lastName(parentDocument.getLastName())
                    .gender(parentDocument.getGender())
                    .address(toAddress(parentDocument.getAddress()))
                    .phone(parentDocument.getPhoneNumber())
                    .email(parentDocument.getEmail())
                    .build();
        } catch (AddressException | PersonalDetailException e) {
            throw new IllegalStateException("Persisted parent document is invalid", e);
        }
    }

    private static Address toAddress(AddressDocument addressDocument) throws AddressException {
        if (addressDocument == null) {
            return null;
        }
        return Address.builder()
                .addressLineOne(addressDocument.getAddressLineOne())
                .addressLineTwo(addressDocument.getAddressLineTwo())
                .city(addressDocument.getCity())
                .county(addressDocument.getCounty())
                .country(addressDocument.getCountry())
                .postCode(addressDocument.getPostCode())
                .build();
    }
}
