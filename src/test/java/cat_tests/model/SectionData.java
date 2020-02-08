package cat_tests.model;

public class SectionData {

    private String id;
    private String name;
    private String url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public SectionData setName(String name) {
        this.name = name;
        return this;
    }

    public SectionData setId(String id) {
        this.id = id;
        return this;
    }

    public SectionData setUrl(String url) {
        this.url = url;
        return this;
    }

}
