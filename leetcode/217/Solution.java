// https://leetcode.com/problems/contains-duplicate/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int num: nums){
            if(res.contains(num)){
                return true;
            }
            res.add(num);

        }
        return false;
        
    }
}
