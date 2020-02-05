package cat_tests.model;

import java.util.Objects;

public class CategoryData {

    private String categoryName;
    private final String categoryId;

    public CategoryData(String categoryName) {
        this.categoryId = null;
        this.categoryName = categoryName;
    }

    public CategoryData(String categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return "CategoryData{" +
                "categoryName='" + categoryName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryData that = (CategoryData) o;
        return Objects.equals(categoryName, that.categoryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryName);
    }

}
