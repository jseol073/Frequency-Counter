import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class FrequencyCounterTest {
    private String test = "_Stomach and Intestine._--Provided the peritoneal surfaces are\n" +
            "accurately apposed, wounds of the stomach and intestine heal with great\n" +
            "rapidity. Within a few hours the peritoneal surfaces are glued together\n" +
            "by a thin layer of fibrin and leucocytes, which is speedily organised\n" +
            "and replaced by fibrous tissue. Fibrous tissue takes the place of the\n" +
            "muscular elements, which are not regenerated. The mucous lining is\n" +
            "restored by ingrowth from the margins, and there is evidence that some\n" +
            "of the secreting glands may be reproduced.";
    private String test2 = "_Artificial or Passive Immunity._--A form of immunity can be induced by\n" +
            "the introduction of protective substances obtained from an animal which";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getText() {
    }

    @Test
    public void removeSpecialCharacters() {
        List<String> testList = FrequencyCounter.textToList(test2);
        List<String> output = new ArrayList<>();
        System.out.println(FrequencyCounter.removeSpecialCharacters(testList));
        //assertEquals(output, FrequencyCounter.removeCharacters(test));
    }

    @Test
    public void removeSpecialCharactersTest() {
        List<String> testList = FrequencyCounter.textToList(test);
        List<String> output = new ArrayList<>();
        System.out.println(FrequencyCounter.removeSpecialCharacters(testList));
        //assertEquals(output, FrequencyCounter.removeCharacters(test));
    }

    @Test
    public void textToListShortTest() {
        System.out.println(FrequencyCounter.textToList(test2));
    }

    @Test
    public void textToListAnotherTest() {
        System.out.println(FrequencyCounter.textToList(test));
    }

    @Test
    public void textToListTest() {
        String test = "test    test    \n test";
        String[] output = {"test", "test", "test"};
        assertEquals(new ArrayList<>(Arrays.asList(output)), FrequencyCounter.textToList(test));
    }

    @Test
    public void countFrequency() {
        String textLowerCased = test.toLowerCase();
        List<String> testList = FrequencyCounter.textToList(textLowerCased);
        List<String> anotherTest = FrequencyCounter.removeSpecialCharacters(testList);
        System.out.println(anotherTest.size());
        FrequencyCounter.countFrequency(anotherTest);
    }

    @Test
    public void getHighestFrequencyTest() {
        String textLowerCased = test2.toLowerCase();
        List<String> testList = FrequencyCounter.textToList(textLowerCased);
        List<String> anotherTest = FrequencyCounter.removeSpecialCharacters(testList);
        Map<String, Integer> frequencyMap = FrequencyCounter.countFrequency(anotherTest);
        System.out.println(FrequencyCounter.getHighestFrequency(frequencyMap));
    }
}