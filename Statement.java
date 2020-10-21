import java.util.Enumeration;

public abstract class Statement {

  public abstract String valueHeader(Customer aCustomer);
  public abstract String valueRental(Rental aRental);
  public abstract String valueFooter(Customer aCustomer);
  
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