package com.BMPProgramm;

import java.util.HashMap;
import java.util.Map;

public class MorseConverter {
    private static final Map<Character, String> MORSE = new HashMap<>();

    static {
        MORSE.put('A', ".-");
        MORSE.put('B', "-...");
        MORSE.put('C', "-.-.");
        MORSE.put('D', "-..");
        MORSE.put('E', ".");
        MORSE.put(' ', "/");
    }

    public static String toMorse(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toUpperCase().toCharArray()) {
            result.append(MORSE.getOrDefault(c, "")).append(" ");
        }

        return result.toString();
    }
}
