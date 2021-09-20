package models;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {
    private TrieNode[]         arr;
    private List<SearchResult> texts;

    public TrieNode() {
        this.arr = new TrieNode[26];
        this.texts = new ArrayList<>();
    }

    public TrieNode[] getArr() {
        return arr;
    }

    public List<SearchResult> getTexts() {
        return texts;
    }
}
