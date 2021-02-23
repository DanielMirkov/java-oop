package bankAccount;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class BankAccountTest {
    private BankAccount bankAccount;


    @Before
    public void setUp() {
        bankAccount = new BankAccount("Peshko", BigDecimal.valueOf(300));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testSetNameThrowsWhenNameIsWithInvalidLengthLessThan3Chars() {
        bankAccount = new BankAccount("az", BigDecimal.valueOf(200.00));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameThrowsWhenNameIsWithInvalidLengthMoreThen25Chars() {
        bankAccount = new BankAccount("azqwtegaefagagasgagahsjdsgafeqtyrtukuytjydrswtruiohddry", BigDecimal.valueOf(200.00));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetBalanceThrowsWhenNegative() {
        bankAccount = new BankAccount("test", BigDecimal.valueOf(-100));
    }

    @Test
    public void testSetBalanceReturnCorrectValue() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<BankAccount> clazz =BankAccount.class;
        Method ctr = clazz.getDeclaredMethod("setBalance", BigDecimal.class);
        ctr.setAccessible(true);
        ctr.invoke(bankAccount, BigDecimal.valueOf(250));
        Assert.assertEquals(BigDecimal.valueOf(250), bankAccount.getBalance());

    }

    @Test
    public void testGetNameReturnsCorrectName() {
        Assert.assertEquals("Peshko", bankAccount.getName());
    }
    @Test
    public void testGetBalnceReturnsCorrectBalance() {
        Assert.assertEquals(BigDecimal.valueOf(300), bankAccount.getBalance());
    }


    @Test
    public void testSetNmeReturnsCorrectName() {
        String expectedName = "PeshoBe";
        BankAccount expectedBankAccount = new BankAccount(expectedName, BigDecimal.valueOf(200.00));
        bankAccount = expectedBankAccount;
        Assert.assertEquals(expectedBankAccount.getName(), bankAccount.getName());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDepositThrowsWhenValueBelowZero() {
        bankAccount.deposit(BigDecimal.valueOf(-100));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDepositThrowsWhenZero() {
        bankAccount.deposit(BigDecimal.valueOf(0));
    }

    @Test
    public void testDepositWorksProperly() {
        bankAccount.deposit(BigDecimal.valueOf(50));
        Assert.assertEquals(BigDecimal.valueOf(350), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawThrowsWhenZero() {
        bankAccount.withdraw(BigDecimal.valueOf(0));
        Assert.assertEquals(BigDecimal.valueOf(0), bankAccount.withdraw(BigDecimal.valueOf(0)));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testWithdrawThrowsWhenMoreThanBalance() {
        bankAccount.withdraw(BigDecimal.valueOf(400));

    }

    @Test
    public void testWithdrawReturnsCorrectValue() {
        bankAccount.withdraw(BigDecimal.valueOf(50));
        Assert.assertEquals(BigDecimal.valueOf(250), bankAccount.getBalance());
    }

    @Test
    public void testWithdrawReturnsCorrectAmount() {
        BigDecimal moneyWithdrawn = bankAccount.withdraw(BigDecimal.valueOf(50));
        Assert.assertEquals(moneyWithdrawn, bankAccount.withdraw(BigDecimal.valueOf(50)));
    }
}