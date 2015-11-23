package refactoring;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("영화", 0);
        Rental rental = new Rental(movie, 3);
        Customer customer = new Customer("권정호");
        customer.addRental(rental);
        System.out.println(customer.statement());
    }
}
