import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Spy
    Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedKittensCount = 1;
        Mockito.doReturn(1).when(feline).getKittens();
        int actualKittensCount = lion.getKittens();
        assertEquals(expectedKittensCount, actualKittensCount);
    }



    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        Mockito.doReturn(expectedList).when(feline).getFood(Mockito.anyString());
        List<String> actualList = lion.getFood();
        assertEquals(expectedList, actualList);
    }

    @Test (expected = Exception.class)
    public void testConstructorException() throws Exception {
        try {
            Lion lion = new Lion("Оно", new Feline());
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            throw e;
        }
    }

}
