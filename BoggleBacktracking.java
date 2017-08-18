import java.io.*;
import java.util.*;

class Main{
    
    int N;
    
    public boolean isPresent(String t, String[] dict){
        
        for(String x:dict){
            if(x.equals(t) == true)
                return true;
        }
        
        return false;
    }
    
    public boolean isValid( int x , int y ,boolean[][] isVisited){
        
        if(x<0 || x>=N)
            return false;
            
        if(y<0 || y>=N)
            return false;
            
        if(isVisited[x][y] == true)
            return false;
        
        return true;
    }
    
    public boolean BoggleUtil(char[][] a, String[] dict, String t,boolean[][] isVisited,int x,int y ){
        
        if(isPresent(t,dict) == true)
        {
            System.out.println(t);    
            
            return true;
        }
    
        int[] dx = {-1,-1,-1,0,0,1,1,1};
        int[] dy = {-1,0,1,-1,1,-1,0,1};
        
        for(int k =0;k<8;k++)
        {
            int i = dx[k] + x;
            int j = dy[k] + y;
            
            if(isValid(i,j,isVisited) == true ){

                 isVisited[x][y] = true;

                if( BoggleUtil(a,dict,t + a[i][j],isVisited,i,j) == true )
                    return true;
                
                 isVisited[x][y] = false;    
                
            }
        }
    
        return false;
    }
    
    public void Boggle(){
        String[] dict = {"legend","look","luke","Sykwaker"};
        
        char[][] a= {
                    {'l','o','r'},
                    {'o','e','s'},
                    {'k','e','g'},
            
        };
        
        N = a.length;

        boolean [][]isVisited = new boolean[N][N];
        String t = new String();
        
        for(int i =0;i<N;i++){
            for(int j = 0;j<N;j++){
                    if(BoggleUtil(a,dict,t,isVisited,i,j) == true )
                        return ;
                }    
            }
        }
        
    
    
    public static void main(String[] args) throws Exception{
        
        Main m = new Main();
        
        m.Boggle();
        
    }
}
