import java.io.*;
import java.util.*;

class Main{
    
    int N;
    
    public boolean isvalid(int[][] Board , int row, int col){
        
        for(int i = col;i>=0;i--)
            if(Board[row][i] == 'Q')
                return false;
        
        
        for(int i = row,j = col;i>=0 && j>=0 ;i--,j--)
            if(Board[i][j] == 'Q')
                return false;
                
         for(int i = row,j = col;i<N && j>=0 ;i++,j--)
            if(Board[i][j] == 'Q')
                return false;
        
        return true;
    } 
    
    public boolean NQueensUtil(int[][] Board , int col){
        
        if(col == N)
            return true;
        
        for(int i = 0;i<N;i++)
        {
            if(isvalid(Board,i,col) ){
            Board[i][col] = 'Q';
            
            if(NQueensUtil(Board,col + 1) == true)
                return true;
                
            Board[i][col] = '-';    
            }
        }
        
        return false;
    }
    
    public boolean NQueens(int n){
        
        N = n;
        
        int[][] Board = new int[n][n];
        
        for(int i = 0; i<n;i++)
        for(int j = 0 ; j<n;j++)
            Board[i][j]  = '-' ;
        
        if( NQueensUtil(Board,0) == true )
            {
                for(int i = 0;i<n;i++){
                    for(int j =0;j<n;j++){
                        System.out.print(((char)Board[i][j]) + " ");
                    }
                    
                    System.out.println("");
                }
                
                return true;
            }
            
        return false;
        
    }
    
    public static void main(String[] args ) throws Exception{
        
        Main Q = new Main();
        
        Q.NQueens(8);
        
        return ;
    }
}
