package cat_tests.model;

import com.google.gson.annotations.Expose;

import java.util.Objects;

public class SectionData {

    @Expose
    private String uid;
    @Expose
    private String title;
    private int priority;

    public String getUid() {
        return uid;
    }

    public SectionData withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public SectionData withTitle(String title) {
        this.title = title;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public SectionData withPriority(int priority) {
        this.priority = priority;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionData that = (SectionData) o;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public String toString() {
        return "SectionData{" +
                "title='" + title + '\'' +
                '}';
    }
}
