import org.junit.Assert;
import org.junit.Test;
import Homework_13.Pair;
import Homework_13.Main;
import Homework_13.StringHandler;

public class Tester {
    @Test
    public void test1() {
        Assert.assertEquals("curuul",new Main().transform("caraul", new Pair('a','u'),false));
    }

}
