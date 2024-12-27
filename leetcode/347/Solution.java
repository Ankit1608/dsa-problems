//https://leetcode.com/problems/top-k-frequent-elements/
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    //solution 1
    public int[] topKFrequent(int[] nums, int k) {
        Map <Integer, Integer> numsCounter = new HashMap<>();
        for(int num: nums){
            numsCounter.put(num, numsCounter.getOrDefault(num,0)+1);
        }

        List<int[]>midList= new ArrayList<>();
        for(Map.Entry<Integer, Integer> itr: numsCounter.entrySet()){
            midList.add(new int[]{itr.getKey(), itr.getValue()});
        }
        //sort in descending order
        midList.sort((a,b)->b[1]-a[1]);
        
        int[] res = new int[k];
        for(int i=0; i<k; i++ ){
            res[i]=midList.get(i)[0];
        }
        return res;
    }


    //solution 2
    public int[] topKFrequentt(int[] nums, int k) {

        Map <Integer, Integer> numsCounter = new HashMap<>();
        for(int num: nums){
            numsCounter.put(num, numsCounter.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]>queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        for(Map.Entry<Integer,Integer>itr: numsCounter.entrySet()){
            queue.offer(new int[]{itr.getKey(), itr.getValue()});
            if(queue.size()>k){
                queue.poll();
            }
        }

        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i]= queue.poll()[0];
        }
        return res;
    }
}

//Explanation

// add in map
//sort according to values
//print first 2

// add in map
// inject in a priority queue & sort according to frequency
//pop first two elements
