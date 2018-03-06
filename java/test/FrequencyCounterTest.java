import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class FrequencyCounterTest {
    //paragraphs from text file
    private String test =
            "_Stomach and Intestine._--Provided the peritoneal surfaces are\n" +
            "accurately apposed, wounds of the stomach and intestine heal with great\n" +
            "rapidity. Within a few hours the peritoneal surfaces are glued together\n" +
            "by a thin layer of fibrin and leucocytes, which is speedily organised\n" +
            "and replaced by fibrous tissue. Fibrous tissue takes the place of the\n" +
            "muscular elements, which are not regenerated. The mucous lining is\n" +
            "restored by ingrowth from the margins, and there is evidence that some\n" +
            "of the secreting glands may be reproduced.";
    private String test2 =
            "_Artificial or Passive Immunity._--A form of immunity can be induced by\n" +
            "the introduction of protective substances obtained from an animal which";

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void removeSpecialCharacters() {
        List<String> testList = FrequencyCounter.textToList(test2.toLowerCase());
        String expected =
                "[artificial, or, passive, immunity, a, form, of, immunity, can, be, " +
                "induced, by, the, introduction, of, protective, substances, obtained, from, an, animal, which]";
        String actual = FrequencyCounter.removeSpecialCharacters(testList).toString();
        System.out.println(FrequencyCounter.removeSpecialCharacters(testList));
        assertEquals(expected, actual);
    }

    @Test
    public void removeSpecialCharactersTest() {
        List<String> testList = FrequencyCounter.textToList(test.toLowerCase());
        String expectedAsString =
                "[stomach, and, intestine, provided, the, peritoneal, surfaces, are, " +
                "accurately, apposed, wounds, of, the, stomach, and, intestine, heal, with, great, " +
                "rapidity, within, few, hours, the, peritoneal, surfaces, are, glued, together, by, " +
                "thin, layer, of, fibrin, and, leucocytes, which, is, speedily, organised, and, replaced, " +
                "by, fibrous, tissue, fibrous, tissue, takes, the, place, of, the, muscular, elements, which, " +
                "are, not, regenerated, the, mucous, lining, is, restored, by, ingrowth, from, the, margins, and, " +
                "there, is, evidence, that, some, of, the, secreting, glands, may, be, reproduced]";
        String actualAsString = FrequencyCounter.removeSpecialCharacters(testList).toString();
        assertEquals(expectedAsString, actualAsString);
    }

    @Test
    public void textToListShortTest2() {
        String expected =
                "[Artificial, or, Passive, Immunity., --A, form, of, immunity, can, " +
                "be, induced, by, the, introduction, of, protective, substances, obtained, from, " +
                "an, animal, which]";
        assertEquals(expected, FrequencyCounter.textToList(test2).toString());
    }

    @Test
    public void textToListLongTest2() {
        String expected =
                "[Stomach, and, Intestine., --Provided, the, peritoneal, surfaces, are, accurately," +
                " apposed,, wounds, of, the, stomach, and, intestine, heal, with, great, rapidity., Within, a, " +
                "few, hours, the, peritoneal, surfaces, are, glued, together, by, a, thin, layer, of, fibrin, and, " +
                "leucocytes,, which, is, speedily, organised, and, replaced, by, fibrous, tissue., Fibrous, tissue, " +
                "takes, the, place, of, the, muscular, elements,, which, are, not, regenerated., The, mucous, " +
                "lining, is, restored, by, ingrowth, from, the, margins,, and, there, is, evidence, that, some, " +
                "of, the, secreting, glands, may, be, reproduced.]";
        assertEquals(expected, FrequencyCounter.textToList(test).toString());
        System.out.println(FrequencyCounter.textToList(test));
    }

    @Test
    public void textToListTest() {
        String test = "test    test     test";
        String[] output = {"test", "test", "test"};
        assertEquals(new ArrayList<>(Arrays.asList(output)), FrequencyCounter.textToList(test));
    }

    @Test
    public void countFrequencyTest2() {
        String textLowerCased = test2.toLowerCase();
        List<String> textList = FrequencyCounter.textToList(textLowerCased);
        List<String> finalTextList = FrequencyCounter.removeSpecialCharacters(textList);
        FrequencyCounter.countFrequency(finalTextList);
        String expected =
                "{which=1, a=1, or=1, be=1, substances=1, immunity=2, passive=1, an=1, " +
                "the=1, can=1, artificial=1, form=1, of=2, induced=1, by=1, animal=1, protective=1, " +
                "from=1, obtained=1, introduction=1}";
        assertEquals(expected, FrequencyCounter.countFrequency(finalTextList).toString());
    }

    @Test
    public void getTopTenFrequencyTest() {
        String textLowerCased = test.toLowerCase();
        List<String> testList = FrequencyCounter.textToList(textLowerCased);
        List<String> anotherTest = FrequencyCounter.removeSpecialCharacters(testList);
        Map<String, Integer> frequencyMap = FrequencyCounter.countFrequency(anotherTest);
        String output =
                "1) word: the, Frequency: 8 \n" +
                "2) word: and, Frequency: 5 \n" +
                "3) word: of, Frequency: 4 \n" +
                "4) word: is, Frequency: 3 \n" +
                "5) word: are, Frequency: 3 \n" +
                "6) word: by, Frequency: 3 \n" +
                "7) word: stomach, Frequency: 2 \n" +
                "8) word: tissue, Frequency: 2 \n" +
                "9) word: fibrous, Frequency: 2 \n" +
                "10) word: peritoneal, Frequency: 2 \n";
        assertEquals(output, FrequencyCounter.getTopTenFrequencies(frequencyMap));
    }
}