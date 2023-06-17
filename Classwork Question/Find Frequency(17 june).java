import java.io.*;
import java.util.*;

public class Solution {
    public static int countGivenDigit(int n, int d){
        int count =0;
        while(n>0){
            int rem = n%10;
            if(rem == d){
                count++;
            }
            n = n/10;
        }
        
        return count;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        
        // int ans = countGivenDigit(n,d);
        // System.out.println(ans);
        
        System.out.println(countGivenDigit(n,d));
    }
}
