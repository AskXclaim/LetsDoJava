package org.contactcentre.application.command;

import lombok.Builder;

@Builder
public record AddressCommand(String addressLineOne, String addressLineTwo, String city, String county, String country,
                             String postCode) {
}
