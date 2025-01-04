//https://leetcode.com/problems/product-of-array-except-self/description/

public class Solution {
    public int[] productExceptSelf(int[] nums) {

		int[] prefixSum = new int[nums.length];
		prefixSum[0]= nums[0];
        for(int i=0; i<nums.length; i++){
			prefixSum[i]= prefixSum[i-1]*nums[i];
        }

		int[] suffixSum = new int[nums.length];
		suffixSum[nums.length-1]= nums[nums.length-1];
		for(int i=nums.length-2; i>=0; i--){
			suffixSum[i]= suffixSum[i+1]*nums[i];
		}

		int[] res = new int[nums.length];
		res[0]=suffixSum[1];
		res[nums.length-1]=prefixSum[nums.length-2];
		for(int i=1; i<nums.length-1; i++){
			res[i]= prefixSum[i-1]*suffixSum[i+1];
        }
		return res;
       
    }
}

// Explanatino
// calculate prefix sum
// calculate suffix sum

// input a=[1,2,3,4]  res=[24,12,8,6]
// prefix=[1,2,6,24] suffix=[24,24,12,4]