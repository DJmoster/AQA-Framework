package sviat.dev.task2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Task2TestCase {

    @Test
    public void whenUsingPlusSignThenAssertEquals() {
        String a = "Hello";
        String b = " World!";
        String r = a + b;

        System.out.println(r);
        assertEquals("Hello World!", r);
    }

    @Test
    public void whenUsingConcatThenAssertEquals() {
        String a = "Hello";
        String b = " World!";
        String r = a.concat(b);

        System.out.println(r);
        assertEquals("Hello World!", r);
    }
}
