import java.util.*;
import java.io.*;

class node{
    public int element;
    public int hd;
    public node left , right;

    public node(){
        element = 0;
        left = null;
        right = null;
    }
    public node(int x){
        element = x;
        left = null;
        right = null;
    }

    public node insert(node root, int x){
        if(root == null){
            return new node(x);
        }

        if(root.element > x){
            root.left = insert(root.left,x);
        }
        else if(root.element < x){
            root.right = insert(root.right,x);
        }
        
        else return root;

        return root;
    }

    public void inorder(node root){
        if(root == null){
                System.out.println("");
                return;
            }

        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
        return ;
    }

    public void level(node root,int level){
        if(root == null )
            return ;

        if(level == 0 ){
            System.out.print(root.element+" ");
            return ;
        }

        level(root.left,level-1);
        level(root.right,level-1);

        return ;
    }

    public void BottomView(node root,Map<Integer,Integer> m){
        if(root == null)
            return ;

        Queue<node> Q = new LinkedList<>();
        int hd = 0;
        
        root.hd = hd;
        Q.add(root);

        while(Q.peek() != null ){
            node top = Q.poll();
            hd = top.hd;
            m.put(top.hd,top.element);
            
            if(top.left != null){
                top.left.hd = hd - 1;
                Q.add(top.left);
            }

            if(top.right != null){
                top.right.hd = hd + 1;
                Q.add(top.right);
            }
        }
    }
}

class bottomview{
    public static void main(String[] args) throws Exception{

        node tree = new node();
        node root = null;
        
        root = new node(20);
        root.left = new node(8);
        root.right  = new node(22);
        root.left.left = new node(5);
        root.left.right  = new node(3);
        root.left.right.left  = new node(10);
        root.left.right.right  = new node(14);
        root.right.right  = new node(25);

        tree.inorder(root);

        Map<Integer,Integer> m = new HashMap<Integer,Integer>();

        tree.BottomView(root, m);

        Set<Integer> kset = m.keySet();

        Iterator<Integer> i = kset.iterator();

        while(i.hasNext()){
            
            int key = i.next();
            int value = m.get(key);

            System.out.println(key + " : "+value);
        }
    }
}
