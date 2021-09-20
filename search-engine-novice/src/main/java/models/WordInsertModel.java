package models;

public class WordInsertModel {
    private char[] wordAsArr;
    private String title;
    private int    indexId;

    public WordInsertModel(char[] wordAsArr, String title, int indexId) {
        this.wordAsArr = wordAsArr;
        this.title = title;
        this.indexId = indexId;
    }

    public char[] getWordAsArr() {
        return wordAsArr;
    }

    public String getTitle() {
        return title;
    }

    public int getIndexId() {
        return indexId;
    }
}