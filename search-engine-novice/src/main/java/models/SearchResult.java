package models;

public class SearchResult {
    private int    id;
    private String text;

    public SearchResult(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "\n\ndocumentId : " + this.id + "\ntext :" + this.text;
    }
}