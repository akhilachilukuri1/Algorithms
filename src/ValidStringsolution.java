import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution11 {

public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String watson = scan.nextLine();
        Map<Character, Integer> countChar = new HashMap<Character, Integer>();
        Map<Integer, Integer> countCount = new HashMap<Integer, Integer>();
        int length = watson.length();
        int i;
        for (i = 0; i < length; i++) {
            char c = watson.charAt(i);
            if (countChar.containsKey(c)) {
                countChar.put(c, countChar.get(c) + 1);
            } else {
                countChar.put(c, 1);
            }
        }
        
        for(Map.Entry<Character, Integer> entry : countChar.entrySet()){
            if(countCount.containsKey(entry.getValue())){
                countCount.put(entry.getValue(), countCount.get(entry.getValue())+1);
            }
            else{
                countCount.put(entry.getValue(), 1);
            }
            
        }
        if(countCount.size() == 1){
            System.out.println("YES");
        }
        else if(countCount.size() == 2){
            if(countCount.containsValue(1)){
                Set<Integer> Allkey=countCount.keySet();
                int arr[]=new int[2];
                int j=0;
                for(int key:Allkey)
                {
                    arr[j]=key;
                    j++;
                }
                if(Math.abs(arr[1]-arr[0])==1)
                System.out.println("YES");
                else
                System.out.println("NO");
                    
            }
            else{
                System.out.println("NO");
            }
        }
        else{
            System.out.println("NO");
        }
    }

}