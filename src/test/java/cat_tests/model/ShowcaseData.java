package cat_tests.model;

import java.io.File;

public class ShowcaseData {

    private String title;
    private String uid;
    private File image;

    public String getTitle() {
        return title;
    }

    public ShowcaseData setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public ShowcaseData setUid(String uid) {
        this.uid = uid;
        return this;
    }

    public File getImage() {
        return image;
    }

    public ShowcaseData setImage(File image) {
        this.image = image;
        return this;
    }

}
