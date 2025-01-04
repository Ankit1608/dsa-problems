//https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num: nums){
            numSet.add(num);
        }

        int temp, streak=0, res=0;
        for(Integer itr: numSet){
            if(!numSet.contains(itr.intValue()-1)){
                temp= itr.intValue();
                while(numSet.contains(temp++)){
                    streak+=1;
                    res = Math.max(streak, res);
                }
            }
            streak=0;
        }
        return res;
    }
}

// Explanation
// add all the nums in set
// to make sure that you are on start of the sequence. if yes then start counting.
// for example start counting when you are at 2 in 2,3,4
// then return the biggest sequence