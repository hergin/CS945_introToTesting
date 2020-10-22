import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    ATM atm;
    int initialBalance = 100;

    @BeforeEach
    void setup() {
        atm = new ATM(initialBalance);
    }

    @Test
    void deposit50() {
        assertTrue(atm.deposit(50));
        assertEquals(150, atm.getBalance());
    }

    @Test
    void depositMinus50() {
        boolean result = atm.deposit(-50);
        assertFalse(result);
    }

    @Test
    void withdraw50() throws InsufficientFundsException {
        assertTrue(atm.withdraw(50));
        assertEquals(50, atm.getBalance());
    }

    @Test
    void withdrawMinus50() {
        assertThrows(IllegalArgumentException.class,() -> {
            atm.withdraw(-50);
        });
    }

    @Test
    void withdrawInsufficientFund() {
        assertThrows(InsufficientFundsException.class,() -> {
            atm.withdraw(200);
        });
    }

    @Test
    void testWithdrawFirstDepositSecond() throws InsufficientFundsException {
        assertTrue(atm.withdraw(50));
        assertTrue(atm.deposit(50));
        assertEquals(initialBalance, atm.getBalance());
    }
}