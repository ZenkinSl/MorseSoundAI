package com.BMPProgramm;

import java.util.HashMap;
import java.util.Map;

public class MorseConverter {
    private static final Map<Character, String> MORSE = new HashMap<>();

    static {
        MORSE.put(' ', "/");
        MORSE.put('a',".-");
        MORSE.put('b',"-...");
        MORSE.put('c', "-.-.");
        MORSE.put('d', "-..");
        MORSE.put('e', ".");
        MORSE.put('f', "..-.");
        MORSE.put('g', "--.");
        MORSE.put('h', "....");
        MORSE.put('i', "..");
        MORSE.put('j', ".---");
        MORSE.put('k', "-.-");
        MORSE.put('l', ".-..");
        MORSE.put('m', "--");
        MORSE.put('n', "-.");
        MORSE.put('o', "---");
        MORSE.put('p', ".--.");
        MORSE.put('q', "--.-");
        MORSE.put('r', ".-.");
        MORSE.put( 's',"...");
        MORSE.put('t', "-");
        MORSE.put('u', "..-");
        MORSE.put('v', "...-");
        MORSE.put('w', ".--");
        MORSE.put('x', "-..-");
        MORSE.put('y', "-.--");
        MORSE.put('z', "--..");
        MORSE.put('0', "-----");
        MORSE.put('1', ".----");
        MORSE.put('2', "..---");
        MORSE.put('3', "...--");
        MORSE.put('4', "....-");
        MORSE.put('5', ".....");
        MORSE.put('6', "-....");
        MORSE.put('7', "--...");
        MORSE.put('8', "---..");
        MORSE.put('9', "----.");
        MORSE.put('.', ".-.-");
        MORSE.put(',', "--..--");
        MORSE.put('?', "..--..");
    }

    public static String toMorse(String text) {
        StringBuilder result = new StringBuilder();

        for (char c : text.toLowerCase().toCharArray()) {
            result.append(MORSE.getOrDefault(c, "")).append(" ");
        }

        return result.toString();
    }
}
