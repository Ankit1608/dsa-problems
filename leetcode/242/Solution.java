// // https://leetcode.com/problems/valid-anagram/description/

import java.util.HashMap;
import java.util.Map;

// Map Solution
public class Solution {
    public boolean isAnagram(String s, String t) { 
        if(s.length()!= t.length()){
            return false;
        }

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            sMap.putIfAbsent(s.charAt(i), 0);
            sMap.put(s.charAt(i), sMap.get(s.charAt(i))+1);
        }
        for(int i=0; i<t.length(); i++){
            tMap.putIfAbsent(t.charAt(i), 0);
            tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
        }

        return sMap.equals(tMap);
    }




// Xor Solution

    public boolean isAnagramm(String s, String t){
        //Edge Case
        if(s.length()!= t.length()){
            return false;
        }


        // Xor Sum for each character in string since 'a'^'a' xor is 0;             

        int xorSum=0, i=0;
        int[] frequencyCounter= new int[26];

        while(i<s.length()){
            //since it is an anagram we also have to store result in xorSum and xor it again and hence '^='
            xorSum^=s.charAt(i)^t.charAt(i);

            //also need to include frequency counter as the xor logic would fail for inputs 'aa' and 'bb'
            frequencyCounter[s.charAt(i)-'a']++;
            frequencyCounter[t.charAt(i)-'a']--;

            i++;
        }
        
        if (xorSum != 0) return false;
        
        for(int itr: frequencyCounter){
            if(itr!=0) return false;
        }

        return true;
    }
}