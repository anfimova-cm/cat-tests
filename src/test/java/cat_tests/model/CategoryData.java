package cat_tests.model;

import java.util.Objects;

public class CategoryData {

    private String uid;
    private String title;
    private int priority;

    public String getUid() {
        return uid;
    }

    public CategoryData withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public CategoryData withName(String name) {
        this.title = name;
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
        return Objects.equals(title, that.title) &&
                Objects.equals(uid, that.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, uid);
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "title='" + title + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

}
