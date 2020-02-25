package mediabiblioteket;

import collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerTest {

    private Borrower borrower;

    @BeforeEach
    void setUp_MK() {

        borrower = new Borrower("Tolvan", "121212-1212", "1212-121212");
    }

    @Test
    void setName_test_MK() {
        borrower.setName("New Tolvan");
        assertEquals("New Tolvan", borrower.getName());
    }

    @Test
    void setSsn_test_MK() {
        borrower.setSsn("222222-2222");
        assertEquals("222222-2222", borrower.getSsn());
    }

    @Test
    void setphoneNumber_test_MK() {
        borrower.setphoneNumber("2222-222222");
        assertEquals("2222-222222", borrower.getphoneNumber());
    }

    @Test
    void getSsn_test_MK() {
        assertEquals("121212-1212", borrower.getSsn());
        assertNotEquals("222222-2222", borrower.getSsn());
    }

    @Test
    void getName_test_MK() {
        assertEquals("Tolvan", borrower.getName());
        assertNotEquals("TolvanTolvsson", borrower.getName());
    }

    @Test
    void getphoneNumber_test_MK() {
        assertEquals("1212-121212", borrower.getphoneNumber());
    }
}