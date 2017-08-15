import java.util.*;
import java.io.*;

class minHeap{
    private int[] heap;
    private int maxSize;
    private int size;

    private int leftChild(int root){
        return 2*root + 1;
    }

    private int rightChild(int root){
        return 2*root + 2;
    }

    private int parentNode(int child){
        return (child-1)/2;
    }

    public minHeap(int s){
        maxSize = s;
        heap = new int[maxSize];
    }

    public boolean insert(int element){
        if(size == maxSize)
            return false;

        int i = size;
        size++;
        heap[i] = element;

        while(i!=0 && heap[i] < heap[parentNode(i)] )
            {
                int t = heap[i];
                heap[i] = heap[parentNode(i)];
                heap[parentNode(i)] = t;

                i = parentNode(i);
            }

        return true;
    }

    public void minHeapify(int i){
        int left = leftChild(i);
        int right = rightChild(i);
        int smallest = i;

        if(left<size && heap[smallest] > heap[left])
            smallest = left;

        if(right<size && heap[smallest] > heap[right])
            smallest = right;
            
        if(smallest != i){

            int t = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = t;

            minHeapify(smallest);
        }    

    }

    public int minElement()
    {
        return heap[0];
    }

    public int extractMin(){
        int min = heap[0];

        heap[0]= heap[size-1];
        size--;

        minHeapify(0);

        return min;

    } 

    public void display(){

        while(size != 0)
        {
            System.out.print(extractMin()+" ");
        }
    }

}

class Main{
    public static void main(String[] args) throws Exception{
        minHeap m = new minHeap(10);

        m.insert(5);
        m.insert(1);
        m.insert(7);
        m.insert(9);
        m.insert(2);
        m.insert(8);

        m.display();
    }
}
