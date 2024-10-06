package com.example.textcounterjava;

public class TextCounter {

    public int countWords(String text) {
        // Split text by spaces, commas, or dots
        String[] words = text.split("[\\s,\\.]+");
        return words.length;
    }

    public int countCharacters(String text) {
        // Return the length of the text
        return text.length();
    }
}
