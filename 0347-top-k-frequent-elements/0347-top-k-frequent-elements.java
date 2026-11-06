
import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create buckets
        List<Integer>[] buckets = new ArrayList[nums.length + 1];

        for (int num : map.keySet()) {

            int freq = map.get(num);

            if (buckets[freq] == null) {
                buckets[freq] = new ArrayList<>();
            }

            buckets[freq].add(num);
        }

        // Get K most frequent elements
        int[] result = new int[k];
        int index = 0;

        for (int i = buckets.length - 1; i >= 1; i--) {

            if (buckets[i] != null) {

                for (int num : buckets[i]) {

                    result[index] = num;
                    index++;

                    if (index == k) {
                        return result;
                    }
                }
            }
        }

        return result;
    }
}
