import java.util.*;
class Solution{
    public String frequencySort (String s){
        HashMap<Character,Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch , 0) + 1);
        }
        List<Character> list = new ArrayList<>(map.keySet());

        list.sort((a,b) -> map.get(b) - map.get(a));

        StringBuilder result = new StringBuilder();
        for (char ch : list ){
            int freq = map.get(ch);
            for(int i=0; i<freq; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}