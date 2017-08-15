import java.util.*;
import java.io.*;

class Trie{
    Trie[] alphabet;
    boolean isEnd;

    public Trie(){
        isEnd = false;
        alphabet = new Trie[26];
    }

    private static int getIndex(char a){
        return a-97;
    }

    public static void insert(Trie root,String str){
        for(int i = 0;i<str.length();i++){
            int index = getIndex(str.charAt(i));

            if( root.alphabet[index]   ==    null)  {
                root.alphabet[index] = new Trie();
            }

            root = root.alphabet[index];
        }

        root.isEnd = true;
    }

    public static void display(Trie root){
        
        if(root == null)
            return ;
            
        for(int i  =0; i<26;i++)
            if(root.alphabet[i] !=null ){
                if(root.alphabet[i].isEnd == true){
                    System.out.println((char)(i + 97));
                }
                else{  
                     System.out.print((char)(i + 97));
                }
                display(root.alphabet[i]);

            }

            return ;
    }

    public static void delete(Trie root,String str){

        if(root == null || str.isEmpty())
            return ;

        delete(root.alphabet[getIndex(str.charAt(0))],str.substring(1));

        boolean deleteFlag = true;
        for(int i = 0;i<26;i++){
            if(root.alphabet[i] != null && i!= getIndex(str.charAt(0)) ){
                deleteFlag = false;
            }
        }
        if(str.length() == 1)
             root.alphabet[getIndex(str.charAt(0))].isEnd = false;
        if(deleteFlag == true)
            root.alphabet[getIndex(str.charAt(0))] = null;

        return ;
    }
}

class Main{
    public static void main(String[] args) throws Exception{
        Trie root = new Trie();

        Trie.insert(root,"christen");
        Trie.insert(root,"legend");
        Trie.insert(root,"amdisthebest");
        Trie.insert(root,"amd");



        Trie.display(root);
        
        System.out.println("");

        Trie.delete(root,"amd");

        Trie.display(root);
    }
}
