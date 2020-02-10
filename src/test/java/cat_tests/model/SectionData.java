package cat_tests.model;

import java.util.Objects;

public class SectionData {

    private String id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionData that = (SectionData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "SectionData{" +
                "name='" + name + '\'' +
                '}';
    }
}
