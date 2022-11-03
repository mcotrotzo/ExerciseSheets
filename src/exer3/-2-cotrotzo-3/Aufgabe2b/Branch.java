import java.security.InvalidParameterException;
import java.util.*;
import java.util.stream.Collectors;


public class Branch extends Company {
    private HashMap<Product, Integer> inventory = new HashMap<>();
    private String branchRegion;

    public Branch(String name, String branchRegion) {
        super(name);
        this.branchRegion = name;
    }
    @Override
    public List<Map.Entry<Product, Integer>> getInventory() {

        return inventory.entrySet().stream().toList();
    }

    @Override
    void addProduct(Product product) {
        if(inventory.containsKey(product)){
           int amount = inventory.get(product);
           amount += 1;
           inventory.put(product,amount);
        }
        else {
            inventory.put(product,1);
            messageCustomer(product, ProductState.NEW);
        }
    }

    @Override
    void removeProduct(Product product) {
        if(!inventory.containsKey(product)){
            throw new InvalidParameterException("Product doesn't exist in the inventory");
        }
        int amount = inventory.get(product);
        amount -= 1 ;
        inventory.put(product,amount);
        if(amount == 0){
            messageCustomer(product, ProductState.SOLDOUT);
        }

    }


}
