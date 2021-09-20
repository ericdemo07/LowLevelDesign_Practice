package service;

import java.util.List;

import dataprocesser.Indexer;
import datastore.InMemSearchDataStore;
import models.SearchResult;

public class App {

    private final InMemSearchDataStore searchDataStore;

    private App() {
        this.searchDataStore = new InMemSearchDataStore();
        new Indexer(this.searchDataStore);
    }

    public static void main(String... args) {
        App app = new App();
        app.run();
    }

    private void run() {
        System.out.println(search("BROWN"));
        System.out.println(search("poor"));
    }

    private List<SearchResult> search(String word) {
        return searchDataStore.search(word);
    }
}
