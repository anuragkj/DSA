import java.util.*;
import java.io.*;
class Main {
 
    private String[] Heap;
    private int size;
    private int maxsize;
    private static final int FRONT = 1;
    public Main(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
 
        Heap = new String[this.maxsize + 1];
        Heap[0] ="";
    }
    private int parent(int pos) { return pos / 2; }
    private int leftChild(int pos) { return (2 * pos); }
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
    private boolean isLeaf(int pos)
    {
 
        if (pos > (size / 2) && pos <= size) {
            return true;
        }
 
        return false;
    }
    private void swap(int fpos, int spos)
    {
 
        String tmp;
        tmp = Heap[fpos];
 
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }
    private void minHeapify(int pos)
    {
        if (!isLeaf(pos)) {
            if (Heap[pos].compareTo(Heap[leftChild(pos)]) > 0
                || Heap[pos].compareTo(Heap[rightChild(pos)]) > 0) 
                {
                    if (Heap[leftChild(pos)].compareTo(Heap[rightChild(pos)]) < 0) {
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }
                else {
                    swap(pos, rightChild(pos));
                    minHeapify(rightChild(pos));
                }
            }
        }
    }
    public void insert(String element)
    {
 
        if (size >= maxsize) {
            return;
        }
 
        Heap[++size] = element;
        int current = size;
 
        while (Heap[current].compareTo(Heap[parent(current)]) < 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }
    public void printHeap()
    {
        for (int i = 1; i <= size; ++i)
            System.out.print(Heap[i] + " ");
 
        System.out.println();
    }
    public String giveTop()
    {
        return Heap[FRONT];
    }
    public String remove()
    {
 
        String popped = Heap[FRONT];
        Heap[FRONT] = Heap[size--];
        minHeapify(FRONT);
 
        return popped;
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println("Step by step formation of min heap:");
        Main minHeap = new Main(100);
        Scanner readMyFile = new Scanner(new File("heapin.txt"));
        String data = readMyFile.nextLine();
        String[] nodes = data.split(", ");
        for (String s: nodes) {           
            minHeap.insert(s);
            minHeap.printHeap();
        }
        
        System.out.println("Heap sort implementation:");
        for(int i = 0; i < nodes.length - 1 ; i++)
        {
            System.out.print(minHeap.remove() +" ");
        }
        System.out.println(minHeap.giveTop());
                           
    }
}
