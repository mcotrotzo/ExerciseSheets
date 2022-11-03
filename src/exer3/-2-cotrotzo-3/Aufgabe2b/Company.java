import java.security.InvalidParameterException;
import java.util.*;

public abstract class Company {
    private String name;
    private List<Customers> customers = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void followShop(Customers customer){
        if(customers.contains(customer)){
            throw new InvalidParameterException("Customer is already a follower! ");
        }
        customers.add(customer);
    }

    abstract void addProduct(Product product);
    abstract void removeProduct(Product product);

    public void messageCustomer(Product product, ProductState productState){
        if(customers.isEmpty()){
            throw new IllegalStateException("No customers");
        }
        for(Customers customer:customers){
            customer.updateProductStates(product, productState);
        }

    }

    public List<Customers> getCustomers() {
        return Collections.unmodifiableList(customers);
    }

    abstract List<Map.Entry<Product,Integer>>getInventory();
}
