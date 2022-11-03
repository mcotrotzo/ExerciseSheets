import org.junit.jupiter.api.IndicativeSentencesGeneration;

import java.util.*;

public class Client implements Customers {

    private String firstName;
    private String lastName;
    private Company branch;
    private List<String> feed = new ArrayList<>();

    public Client(String firstName,String lastName, Company branch) {
        this.branch = branch;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return firstName.equals(client.firstName) && lastName.equals(client.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public void updateProductStates(Product product, ProductState state) {
        feed.add(product + " is " + state + "!");
    }
    public List<String> returnFeed(){
        return Collections.unmodifiableList(feed);
    }



}
