import org.junit.jupiter.api.Test;

public class FirstHomeWorks {
    @Test

    public void creditApartment() {

        Double apartmentCena = 37500.00;
        Double fivePercent = 0.05;
        Double percentRate = 0.36;
        int creditReturnMonth = 240;

        double firstAmount = apartmentCena * fivePercent;
        double creditAmount = apartmentCena - firstAmount;
        double creditPercentFor240month = creditAmount * percentRate;
        double finishSummFor240month = creditAmount * creditReturnMonth;
        double percentSumm = finishSummFor240month - creditAmount;
        double totalSumm = creditAmount + creditPercentFor240month;

        System.out.println("Apartment Cena" + apartmentCena
                + "First Amount:" + firstAmount
                + "Percent summ:" + creditPercentFor240month
                + "Total summ for 240 month" + totalSumm);

    }

    public static void main(String args[]){
        String Str1 = new String("Welcome to Lindrett.ru");

        System.out.println("В строке: " + Str1 + " символов:");
        System.out.print(Str1.length());

    }

    @Test
    public void twoPoints() {

        double x1 = 6.33;
        double y1 = 2.14;
        double x2 = 17.76;
        double y2 = 8.74;

        double a = Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));

        System.out.println(a);
    }
}
