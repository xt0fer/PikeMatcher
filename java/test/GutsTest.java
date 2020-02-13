import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GutsTest {
    private Guts foo;

    @Before
    public void setUp() throws Exception {
        foo = new Guts();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testmatch1() {
        assertEquals(true, foo.match("abc", "abc"));
    }

    @Test
    public void testmatch2() {
        assertEquals(true, foo.match("^a", "abc"));
    }

    @Test
    public void testmatch3() {
        assertEquals(false, foo.match("^b", "abc"));
    }

    @Test
    public void testmatch4() {
        assertEquals(true, foo.match("abc", "aaabcbbcc"));
    }

    @Test
    public void testmatch5() {
        assertEquals(true, foo.match("c$", "aaabcbbcc"));
    }

    @Test
    public void testmatch6() {
        assertEquals(true, foo.match(".*cc", "aaabcbbcc"));
    }

    @Test
    public void testmatch7() {
        assertEquals(false, foo.match("jkl", "aaabcbbcc"));
    }
}