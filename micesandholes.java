import java.io.*;
import java.util.*;

class micesandholes{
    
    public static int miceToHoles(int[] mices , int[] holes){
        Arrays.sort(mices);
        Arrays.sort(holes);
        
        for(int i:mices)
        System.out.print(i+" ");
        
        System.out.println("");
        
        for (int i:holes )
        System.out.print(i+" ");
        
        System.out.println("");
        
        int n = mices.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<n;i++){
            max = Math.max(max,Math.abs(mices[i]-holes[i]));
        }
        
        return Math.abs(max);
    }
    
    
    public static void main(String[] args) throws Exception{
        
        int[] mices = { -10, -79, -79, 67, 93, -85, -28, -94};
        int[] holes = {  -2, 9, 69, 25, -31, 23, 50, 78};
        
        System.out.print(miceToHoles(mices,holes));
        
    }
}
