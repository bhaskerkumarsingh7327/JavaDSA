import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (p.length() > s.length()) {
            return result;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= s.length() - p.length(); i++) {
            if (Arrays.equals(sCount, pCount)) {
                result.add(i);
            }

            if (i + p.length() < s.length()) {
                sCount[s.charAt(i) - 'a']--;
                sCount[s.charAt(i + p.length()) - 'a']++;
            }
        }

        return result;
    }
}