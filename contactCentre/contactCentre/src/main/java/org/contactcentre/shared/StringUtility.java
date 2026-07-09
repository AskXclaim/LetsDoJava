package org.contactcentre.shared;

public final class StringUtility {
    public static String cleanValue(String value) {
        if (value != null && !value.isEmpty())
            return value.trim();

        return value;
    }

}
