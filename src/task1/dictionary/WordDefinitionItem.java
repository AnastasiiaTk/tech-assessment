package task1.dictionary;

public class WordDefinitionItem {
    private final String word;
    private String definition;

    public WordDefinitionItem(String word, String definition) {
        this.word = word;
        this.definition = definition;
    }

    public String getWord() {
        return word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }
}
