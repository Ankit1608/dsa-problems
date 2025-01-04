//https://neetcode.io/problems/string-encode-and-decode
package neetcode.stringEncodeAndDecode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public String encode(List<String> input){
        StringBuilder res = new StringBuilder();
        for(String s: input){
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();     
    }

    public List<String> decode (String input){
        List<String> res = new ArrayList<>();
        int j, length;   
        
        for(int i=0; i<input.length(); i++){
            j=i;
            while(input.charAt(i)!='#'){
              j+=1;
            }
            length=Integer.parseInt(input.substring(i,j));
            res.add(input.substring(j, j+length+1));
            i=j+length+1;
        }

        return res;
    }
}

// Explanation
/* 
 * 
 * We can use a non ascii in input as a delimiter instead of space
 * the short fall is if the string itself has that non ascii value
 * 
 * but if pair it with the length of the string and non ascii. 
 * for example: input="Demo textt"   output="4#Demo5#textt" 
 * 
 * 
 */