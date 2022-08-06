import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;

    public LionParameterizedTest(String sex) throws Exception {
        this.sex = sex;
    }

    @Parameterized.Parameters
    public static Object[][] getData() throws Exception {
        return new Object[][]{
                {"Самец"},
                {"Самка"}
        };
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        boolean actualMane = lion.doesHaveMane();
        if (sex.equals("Самец")) {
            assertTrue(actualMane);
        } else if (sex.equals("Самка")) {
            assertFalse(actualMane);
        }
    }

}
