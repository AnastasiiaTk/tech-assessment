package task1.dictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordDefinition {

    private int size;
    private int DEFAULT_CAPACITY = 16;

    private WordDefinitionItem[] wordDefinitionItems = new WordDefinitionItem[DEFAULT_CAPACITY];


    public String findDefinition(String word) {
        for (int i = 0; i < size; i++) {
            if (wordDefinitionItems[i] != null) {
                if (wordDefinitionItems[i].getWord().equals(word)) {
                    return wordDefinitionItems[i].getDefinition();
                }
            }
        }
        return null;
    }

    public List<String> partialSearch(String partialWord) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (wordDefinitionItems[i] != null) {
                if (wordDefinitionItems[i].getWord().startsWith(partialWord)) {
                    result.add(wordDefinitionItems[i].getDefinition());
                }
            }
        }
        return result;
    }


    public void insertWord(String word, String definition) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (wordDefinitionItems[i].getWord().equals(word)) {
                wordDefinitionItems[i].setDefinition(definition);
                insert = false;
            }
        }
        if (insert) {
            ensureCapacity();
            wordDefinitionItems[size++] = new WordDefinitionItem(word, definition);
        }
    }


    public void remove(String word) {
        for (int i = 0; i < size; i++) {
            if (wordDefinitionItems[i].getWord().equals(word)) {
                wordDefinitionItems[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    private void ensureCapacity() {
        if (size == wordDefinitionItems.length) {
            int newSize = wordDefinitionItems.length * 2;
            wordDefinitionItems = Arrays.copyOf(wordDefinitionItems, newSize);
        }
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            wordDefinitionItems[i] = wordDefinitionItems[i + 1];
        }
    }

}
