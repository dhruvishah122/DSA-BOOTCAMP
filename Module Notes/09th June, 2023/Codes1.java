import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int n=24;
        boolean flag = true;
        for(int i = 1 ;i <= n;i++){
            if(n%i == 0){
                System.out.print(i + " ");
            }
        }
        
    }
}
