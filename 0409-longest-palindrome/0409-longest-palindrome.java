class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        int length = 0;

        for (int freq : count) {
            length += (freq / 2) * 2;

            if (freq % 2 == 1 && length % 2 == 0) {
                length++;
            }
        }

        return length;
    }
}