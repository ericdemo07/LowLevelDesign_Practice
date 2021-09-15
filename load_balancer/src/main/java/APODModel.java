import com.fasterxml.jackson.annotation.JsonProperty;

public class APODModel {
    public final String copyright;
    public final String date;
    public final String explanation;
    public final String hdUrl;
    public final String mediaType;
    public final String serviceVersion;
    public final String title;
    public final String url;

    public APODModel(@JsonProperty("copyright") String copyright,
                     @JsonProperty("date") String date,
                     @JsonProperty("explanation") String explanation,
                     @JsonProperty("hdurl") String hdUrl,
                     @JsonProperty("media_type") String mediaType,
                     @JsonProperty("service_version") String serviceVersion,
                     @JsonProperty("title") String title,
                     @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdUrl = hdUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return "APODModel{" +
                "copyright='" + copyright + '\'' +
                ", date='" + date + '\'' +
                ", explanation='" + explanation + '\'' +
                ", hdUrl='" + hdUrl + '\'' +
                ", mediaType='" + mediaType + '\'' +
                ", serviceVersion='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}

