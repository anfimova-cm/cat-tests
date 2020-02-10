package cat_tests.model;

import java.util.Objects;

public class CategoryData {

    private String uid;
    private String title;
    private int priority;

    public CategoryData(String title) {
        this.uid = null;
        this.title = title;
        this.priority = 1;
    }

    public CategoryData(String uid, String title, int priority) {
        this.uid = uid;
        this.title = title;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryData that = (CategoryData) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "title='" + title + '\'' +
                '}';
    }
}
