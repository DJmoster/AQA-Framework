package sviat.dev.task4;

import jdk.jfr.Description;
import jdk.jfr.Enabled;
import jdk.jfr.Label;


@Enabled
@Label("AnnotationsClass")
public class AnnotationsTest {

    @Label("Foo")
    @Description("Test method")
    public void foo() {

    }
}
