package dataprocesser;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.concurrent.ConcurrentSkipListSet;

import datastore.DocumentStore;
import datastore.InMemSearchDataStore;
import models.WordInsertModel;

import static constants.StopWords.STOP_WORDS;

public class Indexer {

    private final DocumentStore        documentStore;
    private final InMemSearchDataStore searchDataStore;

    public Indexer(InMemSearchDataStore searchDataStore) {
        this.documentStore = new DocumentStore();
        this.searchDataStore = searchDataStore;
        this.process();
    }

    private void process() {
        Iterator<Map.Entry<Integer, String>> iterator = documentStore.getDocumentMap().entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            Set<String> tokens = tokenizeCleaningStopWords(entry.getValue());
            insert(entry.getKey(), tokens, entry.getValue());
        }
    }

    private void insert(int id, Set<String> token, String text) {
        Iterator<String> iterator = token.iterator();

        while (iterator.hasNext()) {
            WordInsertModel model = new WordInsertModel(iterator.next().toLowerCase().toCharArray(), text, id);
            searchDataStore.insert(model);
        }
    }

    private Set<String> tokenizeCleaningStopWords(String str) {
        StringTokenizer tokenizer = new StringTokenizer(str, " ");

        Set<String> set = new ConcurrentSkipListSet<>();

        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();

            if (!STOP_WORDS.contains(token)) {
                set.add(token);
            }
        }

        return set;
    }
}
