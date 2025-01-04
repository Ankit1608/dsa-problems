class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res= new int[2];
        int i=0, j=numbers.length-1; 

        while(i<j){
            if(numbers[i]+numbers[j]>target){
                j--;
            }else if(numbers[i]+numbers[j]<target){
                i++;
            }else{
                res[0]=++i;
                res[1]=++j;
                return res;
            }
        }
        return res;
    }
}