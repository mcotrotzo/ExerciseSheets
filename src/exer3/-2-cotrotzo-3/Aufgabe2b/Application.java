import java.util.List;

public class Application {
    public static void main(String[] args) {



        Product cucumber = new Product(Category.VEGETABLES, "Cucumber");
        Product tomato = new Product(Category.VEGETABLES, "Tomato");
        Product carrot = new Product(Category.VEGETABLES, "Carrot");

        Product apple = new Product(Category.VEGETABLES, "Cucumber");
        Product banana = new Product(Category.VEGETABLES, "Tomato");
        Product grape = new Product(Category.VEGETABLES, "Grape");
        Company branch_kappl = new Branch("MehrRettich", "Kappl");

        Client marco = new Client("Marco","Cotrotzo",branch_kappl);
        Client jedin = new Client("Jedin","Müller",branch_kappl);
        branch_kappl.followShop(marco);
        branch_kappl.followShop(jedin);

        branch_kappl.addProduct(cucumber);
        branch_kappl.addProduct(tomato);
        branch_kappl.addProduct(carrot);
        branch_kappl.addProduct(cucumber);
        branch_kappl.addProduct(apple);
        branch_kappl.addProduct(banana);
        branch_kappl.addProduct(grape);
        branch_kappl.removeProduct(grape);

        System.out.println(marco.returnFeed());
        System.out.println(marco.returnFeed().equals(jedin.returnFeed()));


    }
}
