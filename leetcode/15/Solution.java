//https://leetcode.com/problems/3sum/

import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            if(i!=0 && nums[i-1]==nums[i])
                continue;
            
            int l =i+1, r= nums.length-1;
            while(l<r){
                if(nums[l]+nums[r]+nums[i]>0)
                    r--;
                else if(nums[l]+nums[r]+nums[i]<0)
                    l++;
                else{
                    res.add(Arrays.asList(nums[l], nums[r], nums[i]));
                    r--;
                    l++;

                    while(l<r && nums[l] == nums[l-1]){
                        l++;
                    }
                }
            }
        }

        return res;
    }
}

// Explanation
// we sort the array so the duplicates are collectively next to each other
// for ( a+b+c=0 ) we select a
// and for b and c we use 2pointer2sum approach
// edge case: we need to make sure not to use same number twice at 'a' position nor 'b, c' position. so we get distinct pairs

