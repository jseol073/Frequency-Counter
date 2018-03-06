import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
        List<String> testList = FrequencyCounter.textToList(test2.toLowerCase());
        List<String> output = new ArrayList<>();
        System.out.println(FrequencyCounter.removeSpecialCharacters(testList));
        //assertEquals(output, FrequencyCounter.removeCharacters(test));
    }

    @Test
    public void removeSpecialCharactersTest() {
        List<String> testList = FrequencyCounter.textToList(test.toLowerCase());
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
        String textLowerCased = test2.toLowerCase();
        List<String> textList = FrequencyCounter.textToList(textLowerCased);
        List<String> finalTextList = FrequencyCounter.removeSpecialCharacters(textList);
        FrequencyCounter.countFrequency(finalTextList);
        Map<String, Integer> output = new HashMap<>();

    }

    @Test
    public void getHighestFrequencyTest() {
        String textLowerCased = test.toLowerCase();
        List<String> testList = FrequencyCounter.textToList(textLowerCased);
        List<String> anotherTest = FrequencyCounter.removeSpecialCharacters(testList);
        Map<String, Integer> frequencyMap = FrequencyCounter.countFrequency(anotherTest);
        String output = "1) word: the, Frequency: 8 \n" +
                "2) word: and, Frequency: 5 \n" +
                "3) word: of, Frequency: 4 \n" +
                "4) word: is, Frequency: 3 \n" +
                "5) word: are, Frequency: 3 \n" +
                "6) word: by, Frequency: 3 \n" +
                "7) word: stomach, Frequency: 2 \n" +
                "8) word: tissue, Frequency: 2 \n" +
                "9) word: fibrous, Frequency: 2 \n" +
                "10) word: peritoneal, Frequency: 2 \n";
        assertEquals(output, FrequencyCounter.getHighestFrequency(frequencyMap));
    }
}