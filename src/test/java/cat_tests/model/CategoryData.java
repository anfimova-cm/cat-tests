package cat_tests.model;

import java.util.Objects;

public class CategoryData {

    private String name;
    private String id;

    public String getName() {
        return name;
    }

    public CategoryData setName(String name) {
        this.name = name;
        return this;
    }

    public String getId() {
        return id;
    }

    public CategoryData setId(String id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryData that = (CategoryData) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
