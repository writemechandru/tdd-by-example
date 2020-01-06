package guru.springframework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by Pooranachandran Muthusamy on 01-Jan-2020
 */
public class MoneyTest {
    @Test
    void testMultiplication() {
        //Method to test Multiplication
        Money fiveDollar=Money.dollar(5);
        assertEquals(Money.dollar(10),fiveDollar.times(2));
        assertEquals(Money.dollar(15),fiveDollar.times(3));

        Money fiveFranc=Money.franc(5);
        assertEquals(Money.franc(10),fiveFranc.times(2));
        assertEquals(Money.franc(15),fiveFranc.times(3));
    }

    @Test
    void testEquality() {
        //Test for checking Dollar equality
        assertEquals(Money.dollar(5),Money.dollar(5));
        assertNotEquals(Money.dollar(5),Money.dollar(10));
        assertEquals(Money.franc(5),Money.franc(5));
        assertNotEquals(Money.dollar(5),Money.franc(5));
    }


    @Test
    void testCurrency() {
        assertEquals("USD",Money.dollar(5).currency());
        assertEquals("CHF",Money.franc(5).currency());
    }

    @Test
    void testSimpleAddition() {
        Money fiveDollar=Money.dollar(5);
        Expression sum=fiveDollar.plus(fiveDollar);
        Bank bank=new Bank();
        Money reduced=bank.reduce(sum,"USD");
        assertEquals(Money.dollar(10),reduced);
    }

    @Test
    void testPlusReturnsSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augmend);
        assertEquals(five, sum.addmend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }
}
