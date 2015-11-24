package refactoring;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

    @Test
    public void testStatement() {
        Customer customer = new Customer("test");
        Movie movie = new Movie("Movie", 0);
        Rental rental = new Rental(movie, 3);
        customer.addRental(rental);
        System.out.println(customer.statement());
        assertTrue(customer.statement().contains("3.5"));
    }
}
