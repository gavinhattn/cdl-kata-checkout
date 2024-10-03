import org.example.Checkout;
import org.junit.Assert;
import org.junit.Test;

public class CheckoutTest {

    @Test
    public void testScanSingleItemA() {
        //given
        Checkout checkout = new Checkout();

        //when
        checkout.scan("A");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(50, total);
    }

    @Test
    public void testScanMultipleItems() {
        //given
        Checkout checkout = new Checkout();

        //when
        checkout.scan("A");
        checkout.scan("B");
        checkout.scan("C");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(100, total); //A+B+C
    }

    @Test
    public void testSpecialPriceForA(){

        //given
        Checkout checkout = new Checkout();

        //when
        checkout.scan("A");
        checkout.scan("A");
        checkout.scan("A");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(130, total);  // 3 A's for 130 pence
    }

    @Test
    public void testSpecialPriceForB(){

        //given
        Checkout checkout = new Checkout();

        //when
        checkout.scan("B");
        checkout.scan("B");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(45, total);  // 2 B's for 45 pence
    }
}
