import java.util.*;
import java.io.*;

class node{
    public node left,right;
    public int element;
    public node nextRight;
    public int level;

    node(int x){
        element = x;
        left = null;
        right = null;
        nextRight = null;
    }
    node(){
        left = null;
        right = null;
        nextRight = null;
    }
}

class connetnodes{
    
    private node insert(node root,int x){
        
        if(root == null)
            return new node(x);

         if(root.element>x)
            root.left = insert(root.left, x);
        
        else if(root.element<x)   
            root.right = insert(root.right, x);

        else    
            return root;
        
        return root;
    }


    private node minnode(node root){

        while(root.left != null)
            root = root.left;

        return root;
    }

    private node delete(node root,int x){

        if(root == null)
            return null;

        if(root.element>x)
            root.left = delete(root.left, x);
    
        else if(root.element<x)   
            root.right = delete(root.right, x);

        else    
            {
                if(root.left == null)
                    return root.right;
                
                else if(root.right == null)
                    return root.left;
            
                node temp = minnode(root.left);
                root.element = temp.element;
                root.left = delete(root.left, temp.element);
                
            }
    
        return root;
    }

    private void inorder(node root){
        if(root == null)
            return ;

        inorder(root.left);
        System.out.print(root.element+" ");
        inorder(root.right);
    }

    private void levelOrder(node root){
        if(root == null)
            return ;

        Queue<node> Q = new LinkedList<>();
        
        root.level = 0;
        Q.add(root);
        node prev = null;
        node curr = root;

        while(true){
            node temp = Q.poll();
            int level = temp.level;
            prev = temp;

            if(temp.left!=null){
                temp.left.level = level+1;
                Q.add(temp.left);
            }

            if(temp.right!=null){
                temp.right.level = level+1;
                Q.add(temp.right);
            }

            if(Q.peek() == null)
                break;
            
            curr = Q.peek();

            if(curr.level == prev.level){
                prev.nextRight = curr;
            }

            
        }
    }

    public static void main(String[] args) throws Exception{

        connetnodes T = new connetnodes();

        node tree = new node(1);
        tree.left =  new node(2);
        tree.right =  new node(3);
        tree.left.left =  new node(4);
        tree.left.right =  new node(5);
    
        T.levelOrder(tree);
        
        System.out.println(tree.nextRight);
        System.out.println(tree.left.nextRight);
        System.out.println(tree.right);
        System.out.println(tree.right.nextRight);
        
        System.out.println(tree.left.left.nextRight);
        System.out.println(tree.left.right);
        System.out.println(tree.left.right.nextRight);




        T.inorder(tree);        

    }
    
}
