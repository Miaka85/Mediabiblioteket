package mediabiblioteket;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class LibraryControllerTest {

    private LibraryController controller;



@BeforeEach
 void setUp(){

controller = new LibraryController(true);}



    @Test
    void checkUserInput_validValue_true_MK() {

        boolean test = controller.checkUserInput("121212-1212");
        assertEquals(true, test);
    }

    @Test
    void checkUserInput_validInput_true_MK() {

        boolean test = controller.checkUserInput("Tolvan");
        assertEquals(true, test);
    }

    @Test
    void checkUserInput_invalidCharacter_false_MK() {

        Boolean test = controller.checkUserInput("#%¤%%#¤¤&");
        assertEquals(false, test);
    }

    //Testar inmatningen till mediaobjekt
    @Test
    void checkInputOnlyDigits_Digits_True_MK() {
        Boolean test = controller.checkInputOnlyDigits("121212");
        assertEquals(true, test);
    }
    @Test
    void checkInputOnlyDigits_Letters_False_MK() {
        Boolean test = controller.checkInputOnlyDigits("media");
        assertEquals(false, test);
    }
    @Test
    void checkInputOnlyDigits_Characters_False_MK() {
        Boolean test = controller.checkInputOnlyDigits("#¤#%#¤&");
        assertEquals(false, test);
    }
  /*  @Test
    void checkInputOnlyDigits_Null_False() {
        Boolean test = controller.checkInputOnlyDigits("null");//Hur ska jag få in värdet Null?
        assertNull();
    }*/
    @Test
    void checkInputOnlyDigits_MinValue_False_MK() {
        Boolean test = controller.checkInputOnlyDigits("-2147483649");
        assertEquals(false, test);
    }
    @Test
    void checkInputOnlyDigits_MaxValue_False_MK() {
        Boolean test = controller.checkInputOnlyDigits("2147483648");
        assertEquals(false, test);
    }


    @Test
    void test_writeToFile_writeMockdataToFile_checkIfMockdataRegistered_GS() {
        // Fyll på strukturen borrowed med data
        String testdata = "121212-1212;123456"; // Personnummer;MedieID
        controller.borrowed.add(testdata);

        // Skriv dessa data till fil
        controller.writeToFile();

        // Läs tillbaka filen. Efter loopen skall den sista posten ligga i theLine. Det är den vi vill titta närmare på
        String theLine="";
        try {
            Scanner theScanner = new Scanner(new File("Mediabiblioteket/files/Utlanade.txt"));

            while (theScanner.hasNext()){
                theLine = theScanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Jämför filens innehåll med det vi skickade till den
        assertEquals(testdata, theLine);

        // Ta bort inskriven testdata
        controller.borrowed.removeLast();
        controller.writeToFile();
    }

    @Test
    void test_borrowMedia_checkIfMediaIsBorrowed_trueIfBorrowed_GS() {
        // Skapa testdata
        Book testbok = new Book("Bok","Boktitel", "BokID", 1920, "Hermann Hesse");
        Borrower testB= new Borrower("testnamn", "121212-1212", "0700900909");

        // Registrera testboken som utlånad till testanvändaren
        controller.setCurrentBorrower(testB);
        controller.borrowMedia(testbok);

        // Verifiera att testboken är utlånad
        assertTrue(testbok.borrowed);

        // Rensa bort inskriven testdata
        controller.borrowed.removeLast();
        controller.writeToFile();

    }


    @Test
    void test_returnMedia_checkIfMediaReturnedAfterBorrowed_falseBorrowedIfReturned_GS() {
        // Skapa testdata, bok och låntagare
        Book testbok = new Book("Bok","Boktitel", "BokID", 1920, "Hermann Hesse");
        Borrower testB= new Borrower("testnamn", "121212-1212", "0700900909");

        // Registrera testboken som utlånad till testanvändaren
        controller.setCurrentBorrower(testB);
        controller.borrowMedia(testbok);
        controller.returnMedia(testbok);

        // Verifiera att testboken är utlånad
        assertFalse(testbok.borrowed);

        // Rensa bort inskriven testdata
        //libraryController.borrowed.removeLast();
        //libraryController.writeToFile();
    }

    @Test
    void test_checkIfBorrowerExist_invalidBorrower_false_MK() {

        String userID = "121212-1212";
        Boolean borrowerResult = controller.checkIfBorrowerExist(userID);

        assertFalse(borrowerResult);
    }
    @Test
    void checkIfBorrowerExist_validBorrower_true_MK(){
        String userID = "900118-5555";
        Boolean borrowerResult = controller.checkIfBorrowerExist(userID);

        assertTrue(borrowerResult);
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
    void getMediaFromSearchResult_validMedia_MK() {

            GUI gui = new GUI();
        LibraryController test = new LibraryController(gui);
        test.searchMediaAllByString("DVD");
        String searchString = "DVD - Free\n - The office - 2002 - Ricky Gervais - Martin Freeman - Meckenzie Crook - Lucy Davis";
        Media searchResult = test.getMediaFromSearchResult(searchString);


        assertEquals(searchResult.getTitle(),"The office");


    }

    @Test
    void searchMediaTitleByString() {
    }

    @Test
    void getBorrower() {

        GUI gui = new GUI();
        LibraryController test = new LibraryController(gui);
        Borrower searchResult = test.getBorrower("681102-9999");

        assertEquals(searchResult.getSsn(),"681102-9999");

    }

    @Test
    void loadBorrowedMedia() {
    }

    @Test
    void searchBorrowed() {
    }
}