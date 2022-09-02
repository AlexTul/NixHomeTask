import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.*;

public class ForwardLinkedListTest {
    protected static ForwardLinkedList<Integer> listInteger;
    protected static ForwardLinkedList<String> listString;

    @Before
    public void init() {
        listInteger = new ForwardLinkedList<>();
        listString = new ForwardLinkedList<>();
    }

    @After
    public void cleaningData() {
        listInteger = null;
        listString = null;
    }

    @org.junit.Test
    public void validGetElement() {
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        assertEquals(3, listInteger.size());
        assertEquals(1, (long) listInteger.get(0));
        assertEquals(2, (long) listInteger.get(1));
        assertEquals(3, (long) listInteger.get(2));
    }

    @org.junit.Test
    public void validSize() {
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        assertEquals(3, listInteger.size());
        assertEquals(0, listString.size());
    }

    @org.junit.Test
    public void validAdd() {
        listString.add("str1");
        assertEquals(1, listString.size());
        listString.add(0, "str2");
        assertEquals(2, listString.size());
    }

    @org.junit.Test
    public void validSet() {
        listString.add("str1");
        listString.add("str2");
        assertEquals("str1", listString.get(0));
        assertEquals(2, listString.size());
        listString.set(0,"s");
        assertEquals("s", listString.get(0));
        assertEquals(2, listString.size());
    }

    @org.junit.Test
    public void validRemove() {
        listInteger.add(1);
        listInteger.add(2);
        listInteger.add(3);
        assertEquals(3, listInteger.size());
        listInteger.remove(0);
        assertEquals(2, listInteger.size());
    }

}