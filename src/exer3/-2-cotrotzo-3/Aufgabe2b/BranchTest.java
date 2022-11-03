import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class BranchTest {

    @Test
    void addProductMultipleTimes() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        branch_kappl.followShop(marco);

        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");


        branch_kappl.addProduct(cucumber);
        branch_kappl.addProduct(cucumber);
        assertEquals(branch_kappl.getInventory().get(0).getValue(),2);
        branch_kappl.addProduct(cucumber);
        branch_kappl.addProduct(cucumber);
        assertEquals(branch_kappl.getInventory().get(0).getValue(),4);

    }
    @Test
    void addProduct() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        branch_kappl.followShop(marco);

        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");
        Product tomato = new Product(Category.VEGETABLES, "Tomato");


        branch_kappl.addProduct(cucumber);
        branch_kappl.addProduct(tomato);
        assertEquals(branch_kappl.getInventory().get(0).getValue(),1);
        assertEquals(branch_kappl.getInventory().get(1).getValue(),1);
        assertEquals(marco.returnFeed(), List.of("Cucumber is NEW!","Tomato is NEW!"));


    }

    @Test
    void removeNotExistingProduct() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        branch_kappl.followShop(marco);

        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");
        Product tomato = new Product(Category.VEGETABLES, "Tomato");


        branch_kappl.addProduct(cucumber);
        assertThrows(InvalidParameterException.class, () -> branch_kappl.removeProduct(tomato));
    }
    @Test
    void removeProduct() {
        Company branch_kappl = new Branch("MehrRettich", "Kappl");
        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        branch_kappl.followShop(marco);

        Product banana = new Product(Category.VEGETABLES, "Banana");
        Product apple = new Product(Category.VEGETABLES, "Apple");


        branch_kappl.addProduct(banana);
        branch_kappl.addProduct(apple);
        branch_kappl.addProduct(banana);
        branch_kappl.removeProduct(apple);

        if(branch_kappl.getInventory().get(0).equals(banana)){
            assertEquals(branch_kappl.getInventory().get(0).getKey(),2);
        }
        if(branch_kappl.getInventory().get(1).equals(apple)) {
            assertEquals(branch_kappl.getInventory().get(1).getValue(), 0);
        }
        assertEquals(marco.returnFeed(), List.of("Banana is NEW!","Apple is NEW!","Apple is SOLDOUT!"));


    }
}