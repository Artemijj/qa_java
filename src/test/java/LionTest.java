import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionTest {
    private final String sex;

    public LionTest(String sex) throws Exception {
        this.sex = sex;
    }

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getData() throws Exception {
        return new Object[][]{
                {"Самец"},
                {"Самка"}
        };
    }

    @Spy
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        int expectedKittensCount = 1;
        int actualKittensCount = lion.getKittens();
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(expectedKittensCount, actualKittensCount);
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

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(sex, new Feline());
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = lion.getFood();
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(expectedList, actualList);
    }

    @Test (expected = Exception.class)
    public void testConstructorException() throws Exception {
        Lion lion = new Lion("Оно", new Feline());
    }

}
