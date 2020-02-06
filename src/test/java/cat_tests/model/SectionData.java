package cat_tests.model;

public class SectionData {

    private final String id;
    private String name;
    private String url;

    public SectionData(String name) {
        this.id = null;
        this.name = name;
        this.url = null;
    }

    public SectionData(String id, String name, String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

}
