package datastore;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DocumentStore {

    private final Map<Integer, String> documentMap;

    public DocumentStore() {
        this.documentMap = new ConcurrentHashMap<>();
        this.initializeMap();
    }

    private void initializeMap() {
        documentMap.put(32, "Ricky has a brown labrador");
        documentMap.put(45, "This skateboard is old");
        documentMap.put(62, "My neighbouring countries are poor");
        documentMap.put(39, "Brown folks were treated unequally in past America");
    }

    public Map<Integer, String> getDocumentMap() {
        return documentMap;
    }
}
