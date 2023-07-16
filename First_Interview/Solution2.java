package First_Interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
            if (pMap.containsKey(c) && sMap.get(c) <= pMap.get(c)) {
                count++;
            }

            if (right - left + 1 == p.length()) {
                if (count == p.length()) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                if (pMap.containsKey(leftChar) && sMap.get(leftChar) <= pMap.get(leftChar)) {
                    count--;
                }
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                left++;
            }

            right++;
        }

        return result;
    }
}