package cat_tests.model;

public class SectionData {

    private String uid;
    private String name;
    private int priority;

    public String getUid() {
        return uid;
    }

    public SectionData withUid(String uid) {
        this.uid = uid;
        return this;
    }

    public String getName() {
        return name;
    }

    public SectionData withName(String name) {
        this.name = name;
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
    public String toString() {
        return "SectionData{" +
                "name='" + name + '\'' +
                '}';
    }
}
