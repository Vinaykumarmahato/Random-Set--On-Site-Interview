import java.util.HashSet;
import java.util.Set;

public class Solution {

    public static int uniqueMorseRepresentations(String[] words) {
        String[] morseCodes = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        Set<String> transformations = new HashSet<>();

        for (String word : words) {
            StringBuilder morse = new StringBuilder();
            for (char c : word.toCharArray()) {
                morse.append(morseCodes[c - 'a']);
            }
            transformations.add(morse.toString());
        }

        return transformations.size();
    }

    public static void main(String[] args) {
        // Example usage:
        String[] words1 = {"gin", "zen", "gig", "msg"};
        System.out.println(uniqueMorseRepresentations(words1)); // Output: 2

        String[] words2 = {"a"};
        System.out.println(uniqueMorseRepresentations(words2)); // Output: 1
    }
}
