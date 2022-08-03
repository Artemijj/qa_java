import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = feline.eatMeat();
        lenient().when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(expectedList, actualList);

    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();
        assertEquals(expectedFamily, actualFamily);
    }

    @Test
    public void testGetKittens() {
        int expectedKittensCount = 1;
        int actualKittensCount = feline.getKittens();
        lenient().when(feline.getKittens(1)).thenReturn(1);
        assertEquals(expectedKittensCount, actualKittensCount);
    }

    @Test
    public void testGetKittensWithKittensCount() {
        Feline feline = new Feline();
        int kittensCount = 2;
        int expectedKittensCount = kittensCount;
        int actualKittensCount = feline.getKittens(kittensCount);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}
