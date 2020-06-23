import org.junit.jupiter.api.Test;

public class JavaPractice {
  @Test
   public void firstJavacode() {
        Double distance = 135.7;
        Double fuelAmount = 20.00;

        int zojasRidesCounts = 2;


        double ticketMonthPrice = 50.00;
        int ridesCounts = 80;

        //тип данный, название переменой , значение
        double counsumption = fuelAmount / distance * 100;

        double pricePerRide = calculatePricePerRide(ridesCounts);
        double pricePerRideForZoja = calculatePricePerRide(zojasRidesCounts);



      System.out.println("Current fuel consumption is " + counsumption +
              "but using Trolley it costs " + pricePerRide + " EUR per month" +
              "and now Zoja spend " + pricePerRideForZoja + " per ride");

      int a = 15;
      int b = 10;

      String c = "15";
      String d = "10";

      System.out.println(a + b);
      System.out.println(c + d);
  }

  private double calculatePricePerRide(int ridesCount) {
      final double PRICE = 50.00;

      double pricePerRide = PRICE / ridesCount;
      return pricePerRide;
  }
}
