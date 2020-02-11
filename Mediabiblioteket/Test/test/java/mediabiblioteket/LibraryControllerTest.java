package mediabiblioteket;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {

LibraryController controller = new LibraryController();

    @Test
    void checkUserInput_validValue_true() {

        boolean test = controller.checkUserInput("121212-1212");
        assertEquals(true, test);
    }

    @Test
    void checkUserInput_validInput_true() {

        boolean test = controller.checkUserInput("Tolvan");
        assertEquals(true, test);
    }

    @Test
    void checkUserInput_invalidCharacter_false() {

        Boolean test = controller.checkUserInput("#%¤%%#¤¤&");
        assertEquals(false, test);
    }

    //Testar inmatningen till mediaobjekt
    @Test
    void checkInputOnlyDigits_Digits_True() {
        Boolean test = controller.checkInputOnlyDigits("121212");
        assertEquals(true, test);
    }
    @Test
    void checkInputOnlyDigits_Letters_False() {
        Boolean test = controller.checkInputOnlyDigits("media");
        assertEquals(false, test);
    }
    @Test
    void checkInputOnlyDigits_Characters_False() {
        Boolean test = controller.checkInputOnlyDigits("#¤#%#¤&");
        assertEquals(false, test);
    }
  /*  @Test
    void checkInputOnlyDigits_Null_False() {
        Boolean test = controller.checkInputOnlyDigits("null");//Hur ska jag få in värdet Null?
        assertNull();
    }*/
    @Test
    void checkInputOnlyDigits_MinValue_False() {
        Boolean test = controller.checkInputOnlyDigits("-2147483649");
        assertEquals(false, test);
    }
    @Test
    void checkInputOnlyDigits_MaxValue_False() {
        Boolean test = controller.checkInputOnlyDigits("2147483648");
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