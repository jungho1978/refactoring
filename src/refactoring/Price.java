package refactoring;

abstract public class Price {
    abstract int getPriceCode();

    abstract double getCharge(int daysRented);

    abstract int getFrequentRenterPoints(int daysRented);
}
