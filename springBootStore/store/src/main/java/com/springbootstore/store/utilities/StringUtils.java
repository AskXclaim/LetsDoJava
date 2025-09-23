package com.springbootstore.store.utilities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtils {
    public static String toProperCase(String wordOrPhrase) {
        if (wordOrPhrase == null || wordOrPhrase.isBlank()) {
            return wordOrPhrase;
        }
        var words = wordOrPhrase.replaceAll("^\\s+", "").split(" ");
        if (words.length > 0) {
            List<String> result = new ArrayList<>();
            Arrays.stream(words).forEach(word -> {
                word = word.trim();
                var properCasedWord = getProperCasedWord(word);
                result.add(properCasedWord);
            });
            return String.join(" ", result);
        }
        return getProperCasedWord(wordOrPhrase);
    }

    private static String getProperCasedWord(String word) {
        return word.substring(0, 1).toUpperCase() + word.toLowerCase().substring(1);
    }
}
