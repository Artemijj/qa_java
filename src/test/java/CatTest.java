import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    Cat cat = new Cat(new Feline());

    @Test
    public void testGetSound() {
        Cat cat = new Cat(new Feline());
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void testGetFood() throws Exception {
        Feline feline = new Feline();
        List<String> expectedList = List.of("Животные", "Птицы", "Рыба");
        List<String> actualList = cat.getFood();
        lenient().when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        assertEquals(expectedList, actualList);

    }
}
