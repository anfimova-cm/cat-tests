package cat_tests.model;

public class CategoryData {

    private final String categoryName;
    private final String categoryId;

    public CategoryData(String categoryName, String categoryId) {
        this.categoryName = categoryName;
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

}
