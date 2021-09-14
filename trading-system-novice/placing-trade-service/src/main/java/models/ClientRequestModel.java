package models;

public class ClientRequestModel {
    private String userId;
    private String coinType;
    private int    count;

    public ClientRequestModel(String userId, String coinType, int count) {
        this.userId = userId;
        this.coinType = coinType;
        this.count = count;
    }

    public String getUserId() {
        return userId;
    }

    public String getCoinType() {
        return coinType;
    }

    public int getCount() {
        return count;
    }
}
