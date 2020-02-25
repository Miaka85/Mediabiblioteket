package mediabiblioteket;

import collections.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {


    private Media mediaBook;
    private Media mediaDVD;
    private LinkedList<String> actors;

    @BeforeEach
    void setUp() {

        actors = new LinkedList<>();
        actors.add("Actor 1");
        actors.add("Actor 2");
        mediaBook = new Book("Book", "Book Title", "10", 2020, "Author");
        mediaDVD = new DVD("DVD", "DVD Title", "11", 2019,  actors);
    }



    @Test
    void getMediaType_test_MK() {
        assertEquals("Book", mediaBook.getMediaType());
        assertNotEquals("Book", mediaDVD.getMediaType());
    }

    @Test
    void setMediaType_test_MK() {
        mediaDVD.setMediaType("New DVD");
        assertEquals("New DVD", mediaDVD.getMediaType());
        assertNotEquals("Old DVD", mediaDVD.getMediaType());
    }

    @Test
    void testSetMediaTypeInvalidInput_KP() {

        mediaBook.setMediaType("");
        assertEquals("Book", mediaBook.getMediaType());
        mediaBook.setMediaType("12332");
        assertEquals("Book", mediaBook.getMediaType());
        mediaBook.setMediaType(null);
        assertEquals("Book", mediaBook.getMediaType());
        mediaBook.setMediaType("%#");
        assertEquals("Book", mediaBook.getMediaType());
    }

    @Test
    void getTitle_test_MK() {
        assertEquals("DVD Title", mediaDVD.getTitle());
        assertNotEquals("Book Title", mediaDVD.getTitle());
    }

    @Test
    void setTitle_test_MK() {
        mediaDVD.setTitle("New Title");
        assertEquals("New Title", mediaDVD.getTitle());
    }

    @Test
    void getObjectID_test_MK() {
        assertEquals("10", mediaBook.getObjectID());
        assertNotEquals("10", mediaDVD.getObjectID());

    }

    @Test
    void setObjectID_test_MK() {
        mediaBook.setObjectID("New ObjectID");
        assertEquals("New ObjectID", mediaBook.getObjectID());
    }

    @Test
    void getYear() {
    }

    @Test
    void setYear() {
    }

    @Test
    void getThisMediaBorrower() {
    }

    @Test
    void setThisMediaBorrower() {
    }

    @Test
    void isBorrowed() {
    }

    @Test
    void setBorrowed() {
    }

    @Test
    void listInfo() {
    }

    @Test
    void compareTo() {
    }

    @Test
    void equals() {
    }
}