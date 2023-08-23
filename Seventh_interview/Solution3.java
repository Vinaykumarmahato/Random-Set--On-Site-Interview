package First_Interview.Seventh_interview;

import java.util.*;

public class Solution3 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // The endWord is not in wordList
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int transformations = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                
                for (int j = 0; j < charArray.length; j++) {
                    char originalChar = charArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue;
                        }
                        charArray[j] = c;
                        String newWord = new String(charArray);
                        if (newWord.equals(endWord)) {
                            return transformations + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    charArray[j] = originalChar;
                }
            }
            transformations++;
        }
        
        return 0; // No valid transformation sequence found
    }
    
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList)); // Output: 5
        
        wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        System.out.println(solution.ladderLength(beginWord, endWord, wordList)); // Output: 0
    }
}