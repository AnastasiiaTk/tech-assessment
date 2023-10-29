package task1;

import task1.dictionary.WordDefinition;

public class Main {

    public static void main(String[] args) {
        WordDefinition wordDefinition = new WordDefinition();
        wordDefinition.insertWord("Test", "Test word definition");
        wordDefinition.insertWord("Test", "Test word definition 2");
        System.out.println(wordDefinition.findDefinition("Test"));
        for (String definition : wordDefinition.partialSearch("Tes")) {
            System.out.println(definition);
        }
        wordDefinition.remove("Test");
    }

}
