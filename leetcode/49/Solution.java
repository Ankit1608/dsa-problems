//https://leetcode.com/problems/group-anagrams/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> dict = new HashMap<>();

        for(String s: strs){
            int[] key = new int [26];
            int itr=0;
            while(itr<s.length()){
                key[s.charAt(itr)-'a']++;
                itr++;
            }
            dict.putIfAbsent(Arrays.toString(key),new ArrayList<>());
            dict.get(Arrays.toString(key)).add(s);
        }
        // **converting map values to array list**
        return new ArrayList<>(dict.values());

    }

    
}


//Explanation
// loop through each string
// create a key for each set of anagram
// add it in map