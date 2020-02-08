package cat_tests.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Sections extends ForwardingSet<SectionData> {

    private Set<SectionData> delegate;

    public Sections(Sections sections) {
        this.delegate = new HashSet<SectionData>(sections.delegate);
    }

    @Override
    protected Set<SectionData> delegate() {
        return delegate;
    }

    public Sections withRenamed(SectionData section) {
        Sections sections = new Sections(this);
        sections.add(section);
        return sections;
    }

    public Sections without(SectionData section) {
        Sections sections = new Sections(this);
        sections.remove(section);
        return sections;
    }
}
