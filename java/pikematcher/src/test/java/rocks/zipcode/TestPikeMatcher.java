package test.java.rocks.zipcode;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import main.java.rocks.zipcode.PikeMatcher;
import org.junit.jupiter.api.Test;

class PikeMatcherTest {

    @org.junit.jupiter.api.Test
    void t1_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "bar";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }

    @org.junit.jupiter.api.Test
    void t2_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "kris";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t3_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "bat";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t4_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "^foo";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void t5_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "baz$";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
    }
    @org.junit.jupiter.api.Test
    void t6_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "o*";
        String text = "foobarbaz";

        boolean actual = pm.match(pattern, text);
        assertTrue(actual);
        pattern="r*";
        actual = pm.match(pattern, text);
        assertTrue(actual);
        pattern="fo*";
        actual = pm.match(pattern, text);
        assertTrue(actual);

    }

    @org.junit.jupiter.api.Test
    void t7_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "jkl";
        String text = "foobarbazabcabdcabcdexyz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    @org.junit.jupiter.api.Test
    void t8_match() {
        PikeMatcher pm = new PikeMatcher();
        String pattern = "^cab";
        String text = "foobarbazabcabdcabcdexyz";

        boolean actual = pm.match(pattern, text);
        assertFalse(actual);
    }

    /*private PikeMatcher foo;

    @Before
    public void setUp() throws Exception {
        foo = new PikeMatcher();
    }

    @After
    public void tearDown() throws Exception {
    }*/

    @Test
    public void testmatch1() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("abc", "abc"));
    }

    @Test
    public void testmatch2() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a", "abc"));
    }

    @Test
    public void testmatch3() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("^b", "abc"));
    }

    @org.junit.jupiter.api.Test
    public void testmatch4() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("abc", "aaabcbbcc"));
    }

    @Test
    public void testmatch5() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("c$", "aaabcbbcc"));
    }

    @Test
    public void testmatch6() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match(".*cc", "aaabcbbcc"));
    }

    @Test
    public void testmatch7() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("jkl", "aaabcbbcc"));
    }
    @Test
    public void testmatch8() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("cb.", "aaabcbbcc"));
    }

    @Test
    public void testmatch9() {
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("cb.", "aaabcabcc"));
    }

    @Test
    public void testmatch10(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("h*cc", "ccaaababcc"));
    }
    @Test
    public void testmatch11(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("h*cc", "aaabhccab"));
    }
    @Test
    public void testmatch12(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("a*b", "aaabhcabcc"));
    }

    @Test
    public void testmatch13(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^aaab", "aaab hccabcc"));
    }
    @Test
    public void testmatch14(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a*bbc", "aaaaabbccbbhccabcc"));
    }
    @Test
    public void testmatch15(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^c.b", "cabaaaaabcbhccabcc"));
    }
    @Test
    public void testmatch16(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("^h*bbc", "aaaaabbccbbhccabcc"));
    }

    @Test
    public void testmatch17(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a.*bbc", "aaaaabbccbbhccabcc"));
    }

    @Test
    public void testmatch18(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(false, foo.match("^a.*bhc", "aaaaabbccbbccabcc"));
    }
    @Test
    public void testmatch19(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^abc$", "abc"));
    }
    @Test
    public void testmatch20(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a.c$", "abc"));
    }
    @Test
    public void testmatch21(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a.*c$", "abh219sc"));
    }
    @Test
    public void testmatch22(){
        PikeMatcher foo = new PikeMatcher();
        assertEquals(true, foo.match("^a*bc.*bcc$", "aaabcabcc"));
    }

}
