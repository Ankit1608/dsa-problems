//https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // Brute Force
    public int[] twoSum(int[] nums, int target) {
        for(int i=0; i<nums.length; i++){
            // System.out.println(nums[i]);
            for(int j=i+1; j<nums.length; j++){
                // System.out.println(nums[j]);
                if(nums[i]+nums[j]== target){
                    return new int [] {i, j};
                }
            }
        }
        return new int[0];
    }

    //Hash Map
    public int[] twoSumm(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(numsMap.containsKey(target-nums[i])){
                return new int[] {i, numsMap.get(target-nums[i])};
            }
            numsMap.put(nums[i], i);
        }
        return new int[0];
    }
}