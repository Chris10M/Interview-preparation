import java.util.*;
import java.io.*;

class node{
    public int element;
    public node link;  

    public node(int x){
        element = x;
        link = null;
    }
}

class List{
    node head;

    public List(){
        head = null;
    }

    public void insert(int x){
        node temp = new node(x);

        temp.link = head;
        head = temp;

        return ;
    }

    public void display()
    {  
        if(head == null)
            return ;

        node temp = head;

        while(temp!=null){
            System.out.print(temp.element+" ");
            temp = temp.link;
        }
        
        System.out.println("");
    }

    public int AddSamelength(node one,node two,List result,int carry){
        
        if(one == null || two  == null)
            return 0;

        int carryadd = AddSamelength(one.link, two.link,result,carry);

        int sum = one.element + two.element + carryadd;
        carry = sum/10;
        sum%=10;

        result.insert(sum);

        return carry;
    }


    public int length(List one){
        if(one.head == null)
            return 0;

        int count = 0;
        
        node temp = one.head;

        while(temp!=null){
            count++;
            temp = temp.link;
        }

        return count;
    }

    public int addRemaining(node head,node upto,List result,int carry)
    {
        if(head == null)
            return 0;
            
        if(head == upto)
            return carry;   

        int curcarry = addRemaining(head.link,upto,result, carry);
    
        int sum = head.element + curcarry;
        carry = sum/10;
        sum = sum%10;

        result.insert(sum);

        return carry;

    }
public void Addnumbers(List one , List two , List result){
    if(one.head == null) {
            result = two;
            return ;
        }

    if(two.head == null){
        result = one;
        return;
    }

    int l1 = length(one);
    int l2 = length(two);

    if(l1 == l2)
    {
        result.insert(result.AddSamelength(one.head, two.head, result,0));
        return ;
    }

    else{
        if(l1<l2)
        {
            List temp = one;
            one = two;
            two = temp;

            node upto = one.head;

            int k = Math.abs(l1-l2);
            int i = 0;

            while(i<k){
                upto = upto.link;
                i++;
            }

            int carry = result.AddSamelength(upto, two.head, result,0);
            carry = result.addRemaining(one.head,upto,result,carry);
            
            if(carry != 0) 
                result.insert(carry); 
        }
    }

    return ;
} 

}  



class LinkedList{
    public static void main(String[] args) throws Exception{
        List n1 = new List();

        n1.insert(5);
        n1.insert(4);
        n1.insert(5);
        
        n1.display();

        
        List n2 = new List();
        
        n2.insert(1);
        n2.insert(3);
        n2.insert(7);
        n2.insert(8);

        n2.display();
        
        List result = new List();
        
        result.Addnumbers(n1,n2,result);
        
        result.display();
    }
}
