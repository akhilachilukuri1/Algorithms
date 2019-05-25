import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

 class Solution21 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        long T = in.nextLong();
        for(int t = 0; t < T; t++) {
            int N = in.nextInt();
            long M = in.nextLong();
            long[] array = new long[N];
            for (int i = 0; i < N; i++) {
                array[i] = in.nextLong();
            }
            solve(M,array);
        }
    }

    static void solve(long M, long[] array){
        TreeSet<Long> sumSet = new TreeSet<Long>();
        long best = 0;
        long sum = 0;

        for(int i = 0; i < array.length; i++){

            sum = (sum + array[i]) % M;
            Long up = sumSet.higher(sum);
            if(up == null){
                best = Math.max(best,sum);
            } else {
                best = Math.max(best, M - up + sum);
            }
            sumSet.add(sum);
        }

        System.out.println(best);
    }

}