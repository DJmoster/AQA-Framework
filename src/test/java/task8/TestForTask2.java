package task8;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import sviat.dev.task2.Task2;

public class TestForTask2 {
    private Task2 task2;

    @BeforeTest
    public void init() {
        task2 = new Task2();
    }

    @Test
    public void testConcatenateStringsUsingPlus() {
        Assert.assertEquals(
            task2.concatenateStringsUsingPlus("Hello ", "World"),
            "Hello World"
        );
    }

    @Test
    public void testConcatenateStringsUsingConcatFunction() {
        Assert.assertEquals(
            task2.concatenateStringUsingConcatFunction("Hello ", "World"),
            "Hello World"
        );
    }

    @Test(dataProvider = "stringsDataProvider")
    public void testConcatenateStringsUsingPlusWithProvider(String a, String b, String expected) {
        Assert.assertEquals(task2.concatenateStringsUsingPlus(a, b), expected);
    }

    @Test(dataProvider = "stringsDataProvider")
    public void testConcatenateStringsUsingConcatFunctionWithProvider(String a, String b, String expected) {
        Assert.assertEquals(task2.concatenateStringUsingConcatFunction(a, b), expected);
    }

    @DataProvider
    public Object[][] stringsDataProvider() {
        return new Object[][] {
            {"Hello ", "World", "Hello World"},
            {"Test", "123", "Test123"},
            {"123", " Test", "123 Test"},
        };
    }

    @Parameters({"a", "b", "expected"})
    @Test
    public void testConcatenateStringsUsingPlusWithParameters(String a, String b, String expected) {
        Assert.assertEquals(task2.concatenateStringsUsingPlus(a, b), expected);
    }

    @Parameters({"a", "b", "expected"})
    @Test
    public void testConcatenateStringsUsingConcatFunctionWithParameters(String a, String b, String expected) {
        Assert.assertEquals(task2.concatenateStringUsingConcatFunction(a, b), expected);
    }

}
