package refactoring;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        Enumeration eRentals = rentals.elements();
        String result = "Rental record for " + getName() + "\n";
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental)eRentals.nextElement();

            // show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }

        // add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";

        return result;
    }

    public String htmlStatement() {
        Enumeration eRentals = rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental)eRentals.nextElement();

            // show figures for each rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(each.getCharge()) + "<BR>\n";
        }
        // add footer lines
        result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(getTotalFrequentRenterPoints()) + "</EM> frequent rental points<P>";
        return result;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration eRentals = rentals.elements();
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental)eRentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration eRentals = rentals.elements();
        while (eRentals.hasMoreElements()) {
            Rental each = (Rental)eRentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }
}