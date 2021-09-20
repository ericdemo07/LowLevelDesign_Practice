package datastore;

import java.util.ArrayList;
import java.util.List;

import models.SearchResult;
import models.TrieNode;
import models.WordInsertModel;

public class InMemSearchDataStore {
    private final TrieNode trieNode;

    public InMemSearchDataStore() {
        this.trieNode = new TrieNode();
    }

    public void insert(WordInsertModel wordInsertModel) {
        insert(trieNode, wordInsertModel, 0);
    }

    private void insert(TrieNode node, WordInsertModel model, int index) {
        int it = model.getWordAsArr()[index] - 'a';

        if (node.getArr()[it] == null) {
            node.getArr()[it] = new TrieNode();
        }

        if (index == model.getWordAsArr().length - 1) {
            SearchResult searchResult = new SearchResult(model.getIndexId(), model.getTitle());
            node.getArr()[it].getTexts().add(searchResult);
            return;
        }

        insert(node.getArr()[it], model, index + 1);
    }

    public List<SearchResult> search(String word) {
        return search(trieNode, word.toLowerCase().toCharArray(), 0);
    }

    private List<SearchResult> search(TrieNode node, char[] arr, int index) {
        for (char ch : arr) {
            if (node == null) {
                return new ArrayList<>();
            }
            node = node.getArr()[ch - 'a'];
        }
        return node.getTexts();
    }

    public void print() {
        print(trieNode);
    }

    private void print(TrieNode node) {
        if (node == null) {
            return;
        }

        System.out.println(node.getTexts());

        TrieNode[] trieNodes = node.getArr();

        for (TrieNode node1 : trieNodes) {
            print(node1);
        }
    }
}
