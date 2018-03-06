import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

public class FrequencyCounter {

    /**
     * Checks if contents of the url are in the command line, if not then make String content
     * equal to contents of url
     * Then prints top ten word frequencies
     * @param args, contents of url in commandline
     */
    public static void main(String[] args) {
        String urlString = "https://gist.githubusercontent.com/nicknytko/70004f44176a92d11612f62318ddb830" +
                "/raw/5b684a9e15c9e6cbf2cc031c5a489b328f259908/17921-0.txt";

        String content;
        if (args.length <= 0) {
            content = getText(urlString);
        } else {
            content = getText(args[0]);
        }

        List<String> textList = textToList(content); //turns content into arraylist
        List<String> textFinalList = removeSpecialCharacters(textList); //no special characters
        Map<String, Integer> frequencyMap = countFrequency(textFinalList); //map that takes in frequency
        System.out.println(getTopTenFrequencies(frequencyMap)); //lists top ten frequencies
    }

    /**
     * Takes frequency map and sorts the values in increasing order by making an object array of the map's entryset
     * and use the comparater to sort those values
     * Then use a loop of the array and list only the top ten elements
     * @param frequencyMap, output of countFrequency method
     * @return String that ranks the top ten frequencies
     */
    public static String getTopTenFrequencies(Map<String, Integer> frequencyMap) {
        Object[] frequencyArr = frequencyMap.entrySet().toArray();

        //Got comparator from https://stackoverflow.com/questions/21054415/how-to-sort-a-hashmap-by-the-integer-value
        Arrays.sort(frequencyArr, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Map.Entry<String, Integer>) o2).getValue()
                        .compareTo(((Map.Entry<String, Integer>) o1).getValue());
            }
        });

        StringBuilder topTen = new StringBuilder();
        for (int i = 0; i <= frequencyArr.length - 1; i++) {
            if (i < 10) {
                String key = ((Map.Entry<String, Integer>) frequencyArr[i]).getKey();
                int value = ((Map.Entry<String, Integer>) frequencyArr[i]).getValue();
                topTen.append(String.format("%d) word: %s, Frequency: %d \n", i + 1, key, value));
            } else {
                break;
            }
        }
        return topTen.toString();
    }

    /**
     * Takes in String of the url and return the String contents of the url
     * @param urlString, the url as a String
     * @return the contents of the url text file as a String
     */
    public static String getText(String urlString) {
        StringBuilder content = new StringBuilder();
        try {
            URL url = new URL(urlString);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = in.readLine()) != null) {
                content.append(line);
            }
            in.close();
        }
        catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        }
        catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
        return content.toString().toLowerCase();
    }

    /**
     * removes the certain characters from each element of contentList
     * @param contentList, ArrayList<String> in which each word is an element
     * @return A List<String> that have those characters removed from each element
     */
    public static List<String> removeSpecialCharacters(List<String> contentList) {
        List<String> justWords = new ArrayList<>();
        for (int i = 0; i < contentList.size(); i++) {
            if (contentList.get(i).matches("[a-zA-Z]")) { //letter a-z
                continue;
            }
            justWords.add(contentList.get(i));
        }
        List<String> noSpecialCharList = new ArrayList<>();
        for (String s : justWords) {
            String noSpecialChar = s.replaceAll("[0-9,.?_*#'\\-()\\[\\]]", "");
            noSpecialCharList.add(noSpecialChar);
        }

        for (int i = 0; i < noSpecialCharList.size(); i++) { //removes elements that are empty
            if (noSpecialCharList.get(i).isEmpty()) {
                noSpecialCharList.remove(i);
            }
        }
        return noSpecialCharList;
    }

    /**
     * Iterates through contentList and adds the words into the map and adds the frequency
     * by 1 (makes it 1 if its null) if the same word is encountered
     * @param contentList, ArrayList<String> in which each word is an element
     * @return a Map that has the frequencies as its values
     */
    public static Map<String, Integer> countFrequency(List<String> contentList) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : contentList) {
            Integer frequency = frequencyMap.get(word);
            if (frequency == null) {
                frequency = 1;
            } else {
                ++frequency;
            }
            frequencyMap.put(word, frequency);
        }
        System.out.println(frequencyMap.size());
        System.out.println(frequencyMap.toString());
        return frequencyMap;
    }

    /**
     * Takes the contents of the text file and return an ArrayList in which each element is a word
     * Also replaces special characters with whitespace
     * @param text, contents of the text file
     * @return ArrayList in which each element is a word
     */
    public static List<String> textToList(String text) {
        String removeCharacters = text.replaceAll("[/_*#]", " ");
        String[] splitText = removeCharacters.split("\\s+");
        List<String> textList = new ArrayList<>(Arrays.asList(splitText));

        for (int i = 0; i < textList.size(); i++) { //removes elements that are empty
            if (textList.get(i).isEmpty()) {
                textList.remove(i);
            }
        }
        return textList;
    }
}
