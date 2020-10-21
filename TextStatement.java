import java.util.Enumeration;

public class TextStatement extends Statement {

  public String valueHeader(Customer aCustomer){
    return "Rental Record for " + aCustomer.getName() +
    "\n";
  }

  public String valueRental(Rental each){
    return each.getMovie().getTitle()+ ": " +
        String.valueOf(each.getCharge()) + "<BR>\n";
  }

  public String valueFooter(Customer aCustomer){
    String footer = "Amount owed is " +
        String.valueOf(aCustomer.getTotalCharge()) + "\n";
    footer += "You earned " +
        String.valueOf(aCustomer.getTotalFrequentRenterPoints()) +
        " frequent renter points";
    return footer;
  }

  public String value(Customer aCustomer) {
    Enumeration rentals = aCustomer.getRentals();
    String result = valueHeader(aCustomer);
    while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();
        //show figures for this rental
        result += valueRental(each);
    }
    //add footer lines
    result += valueFooter(aCustomer);
    return result;
  }

}