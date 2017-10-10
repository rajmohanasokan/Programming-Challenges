import java.util.*;
import java.util.Arrays;
import java.util.Scanner;

public class WordBreakAdvanced {

    public static List<String> wordBreak(String s, Set<String> wordDict) {
        return word_Break(s, wordDict, 0);
    }
    public static HashMap<Integer, List<String>> map = new HashMap<>();

    public static List<String> word_Break(String s, Set<String> wordDict, int start) {
        // System.out.println("The start is: " + start);

        if (map.containsKey(start)) {
            return map.get(start);
        }

        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            // System.out.println("The end is: " + end);
            System.out.println(s.substring(start, end) + " is present in dict: " + wordDict.contains(s.substring(start, end)) + ", " + start + ", " + end);
            if (wordDict.contains(s.substring(start, end))) {
                System.out.println("The start and end are: " + start + ", " + end);
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    // System.out.println("String is: " + l);
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        // System.out.println(start + " " + res.get(0));
        map.put(start, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<String>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("sand");
        wordDict.add("dog");
        wordDict.add("and");

        List<String> result = new LinkedList<String>();

        result = wordBreak(s, wordDict);

        System.out.println(result.get(0));
        System.out.println(result.get(1));
    }
}