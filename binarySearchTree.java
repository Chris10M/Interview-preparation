import java.util.*;
import java.io.*;


class node{
    public int element;
    public node left,right;
    public int count;
    public int height;

    public node(){
        left = null;
        right = null;
        count = 0;
        height  = 1;
    }

    public node(int x){
        element = x;
        left = null;
        right = null;
        count = 0;
        height  = 1;
    }

}

class BST{
    private node base;

    public BST(){
        base = null;
    }
    private node insert(int x,node root){
        if(root == null){
        }

        if(root.element>x)
            root.left = insert(x,root.left);

        else if(root.element<x)
            root.right = insert(x,root.right);
    
        return root;
    }

    private void inorder(node root){
        if(root == null)
            return ;

        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);    

    }

    private node Maxnode(node root){
        if(root == null)
            return null;

        while(root.right != null)
        root = root.right;

        return root;
    }

    private node delete(node root , int x){
        if(root == null)
            return root;
        
        if(root.element>x)
            root.left = delete(root.left,x);
        else if(root.element<x)
            root.right = delete(root.right,x); 
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.right;

            node temp = Maxnode(root.left);
            root.element = temp.element;
            root.left = delete(root.left,temp.element);

        }

        return root;   
    }

    public boolean insert(int x){
        base = insert(x,base);

        if(base == null)
            return false;

        return true; 
    }

    public boolean delete(int x){
        base = delete(base,x);

        if(base == null)
            return false;

        return true;
    }

    public void inorder(){
        inorder(base);
    }
}

class binarySearchTree{
    public static void main(String[] args) throws Exception{

        BST Tree = new BST();
        Tree.insert(1);
        Tree.insert(2);
        Tree.insert(3);
        Tree.insert(4);
        Tree.insert(5);
        Tree.insert(6);
        
        Tree.delete(3);

        Tree.inorder();
        
    }
}
