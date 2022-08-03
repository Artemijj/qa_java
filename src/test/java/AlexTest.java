import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.lenient;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {
    @Mock
    Feline feline;

    @Test
    public void testGetFriends() throws Exception {
        Alex alex = new Alex("Самец", new Feline());
        List<String> expectedList = List.of("Марти", "Глория", "Мелман");
        List<String> actualList = alex.getFriends();
        assertEquals(expectedList, actualList);
    }

    @Test
    public void testGetPlaceOfLiving() throws Exception {
        Alex alex = new Alex("Самец", new Feline());
        String expectedPlace = "Нью-Йоркский зоопарк";
        String actualPlace = alex.getPlaceOfLiving();
        assertEquals(expectedPlace, actualPlace);
    }

    @Test
    public void testGetKittens() throws Exception {
        Alex alex = new Alex("Самец", new Feline());
        int expectedKittensCount = 0;
        int actualKittensCount = alex.getKittens();
        lenient().when(feline.getKittens(0)).thenReturn(0);
        assertEquals(expectedKittensCount, actualKittensCount);
    }
}
