
    private boolean isBST(node root,int l,int h){
        if(root == null)
            return true;

        if(root.element > h || root.element < l)
            return false;
            
        return ( isBST(root.left, l,root.element-1) && isBST(root.right, root.element+1, h) ); 

    }   

    public boolean isBST(){
        return isBST(base,Integer.INT_MIN,Intger.INT_MAX);
    }
