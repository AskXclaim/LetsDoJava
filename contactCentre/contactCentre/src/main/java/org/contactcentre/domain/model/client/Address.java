package org.contactcentre.domain.model.client;

import lombok.Getter;
import lombok.ToString;
import org.contactcentre.domain.exception.AddressException;

import static org.contactcentre.shared.StringUtility.cleanValue;

@Getter
@ToString
public class Address {
    private final String addressLineOne;
    private final String addressLineTwo;
    private final String city;
    private final String county;
    private final String country;
    private final String postCode;

    public Address(String addressLineOne, String addressLineTwo, String city, String county, String country, String postCode)
            throws AddressException {
        validateField(addressLineOne, "Address Line One");
        this.addressLineOne = cleanValue(addressLineOne);
        this.addressLineTwo = cleanValue(addressLineTwo);
        validateField(city, "City");
        this.city = cleanValue(city);
        validateField(county, "County");
        this.county = cleanValue(county);
        validateField(country, "Country");
        this.country = cleanValue(country);
        validateField(postCode, "Post Code");
        this.postCode = cleanValue(postCode);
    }

    private void validateField(String fieldValue, String fieldName) throws AddressException {
        if (fieldValue == null || fieldValue.isEmpty()) {
            throw new AddressException(fieldName + " cannot be null or empty");
        }
    }
}
