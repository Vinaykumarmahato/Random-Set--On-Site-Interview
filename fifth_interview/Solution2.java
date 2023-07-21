package First_Interview.fifth_interview;

class Solution {
    public int expressiveWords(String s, String[] words) {
        int res = 0;
        for (String w : words) {
            if (check(s, w)) {
                res++;
            }
        }
        return res;
    }

    private boolean check(String s, String w) {
        int i = 0, j = 0;
        while (i < s.length() && j < w.length()) {
            if (s.charAt(i) == w.charAt(j)) {
                int len1 = getLen(s, i);
                int len2 = getLen(w, j);
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                i += len1;
                j += len2;
            } else {
                return false;
            }
        }
        return i == s.length() && j == w.length();
    }

    private int getLen(String s, int i) {
        int j = i + 1;
        while (j < s.length() && s.charAt(j) == s.charAt(i)) {
            j++;
        }
        return j - i;
    }
}

public class Solution2 {
    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};

        Solution solution = new Solution();
        int stretchyCount = solution.expressiveWords(s, words);
        System.out.println(stretchyCount);
    }
}

