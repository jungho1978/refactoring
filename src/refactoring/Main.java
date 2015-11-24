package refactoring;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Movie", 0);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("Customer");
        customer.addRental(rental);
        System.out.println(customer.statement());
    }
}
