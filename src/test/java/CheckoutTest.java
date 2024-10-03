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
}
