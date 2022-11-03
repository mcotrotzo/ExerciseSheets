import java.util.Objects;

public class Product {
    private Category category;
    private String name;

    public Product(Category category, String name) {
        this.category = category;
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return category == product.category && name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, name);
    }
}
