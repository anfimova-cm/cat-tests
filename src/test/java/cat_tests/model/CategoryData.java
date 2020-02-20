package cat_tests.model;

import java.util.Objects;

public class CategoryData {

    private String uid;
    private String title;
    private int priority;

    public String getTitle() {
        return title;
    }

    public CategoryData withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public CategoryData withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public CategoryData withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryData that = (CategoryData) o;
        return Objects.equals(uid, that.uid) &&
                Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, title);
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "uid='" + uid + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
