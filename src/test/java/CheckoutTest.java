import org.example.Checkout;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void testScanSingleItemC() {
        //given
        Checkout checkout = new Checkout();

        //when
        checkout.scan("C");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(20, total);
    }

    @Test
    public void testScanSingleItemD() {
        //given
        Checkout checkout = new Checkout();

        //when
        checkout.scan("D");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(15, total);
    }

    @Test
    public void testScanUnknownItem() {
        //given
        Checkout checkout = new Checkout();
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        //when
        checkout.scan("E");
        int total = checkout.getTotal();

        //then
        Assert.assertEquals(0, total);
        String output = outContent.toString().trim();
        Assert.assertEquals("Item E is not recognised.", output);
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
