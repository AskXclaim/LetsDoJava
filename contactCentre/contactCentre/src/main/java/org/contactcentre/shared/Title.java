package org.contactcentre.shared;

import java.util.Arrays;

public enum Title {
    MR,
    MRS,
    MISS,
    MS,
    PREFER_NOT_TO_SAY;

    public static boolean isValid(Title title) {
        return title != null && Arrays.stream(Title.values()).anyMatch(t -> t == title);
    }
}
