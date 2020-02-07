package mediabiblioteket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {

LibraryController controller = new LibraryController();

    @Test
    void checkUserInput_validValue_True() {

        boolean test = controller.checkUserInput("bokTitel-1212");
        assertEquals(true, test);
    }

    @Test
    void checkUserInput_invalidCharacter_False() {

        Boolean test = controller.checkUserInput("#%¤%%#¤¤&");
        assertEquals(false, test);
    }

    @Test
    void checkInputOnlyDigits() {
        Boolean test = controller.checkInputOnlyDigits("121212");
        assertEquals(true, test);
    }
    @Test
    void checkInputOnlyDigitsFalse() {
        Boolean test = controller.checkInputOnlyDigits("bokstav");
        assertEquals(false, test);
    }
    @Test
    void checkInputOnlyDigitsFalseTecken() {
        Boolean test = controller.checkInputOnlyDigits("#¤#%#¤&");
        assertEquals(false, test);
    }
    @Test
    void checkInputOnlyDigitsFalseNull() {
        Boolean test = controller.checkInputOnlyDigits("");//Hur ska jag få in värdet Null?
        assertEquals(false, test);
    }
    @Test
    void writeToFile() {
    }

    @Test
    void borrowMedia() {
    }

    @Test
    void returnMedia() {
    }

    @Test
    void checkIfBorrowerExist() {
    }

    @Test
    void sortMedia() {
    }

    @Test
    void getMedia() {
    }

    @Test
    void showSelectedMediaInfo() {
    }

    @Test
    void searchMediaAllByString() {
    }

    @Test
    void getMediaFromSearchResult() {
    }

    @Test
    void searchMediaTitleByString() {
    }

    @Test
    void getBorrower() {
    }

    @Test
    void loadBorrowedMedia() {
    }

    @Test
    void searchBorrowed() {
    }
}