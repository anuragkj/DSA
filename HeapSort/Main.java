import java.util.*;
import java.io.*;
public class Main {
    public void sort(String arr[])
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i > 0; i--) {
            String temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }
    void heapify(String arr[], int n, int i)
    {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;
 
        if (r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;
 
        if (largest != i) {
            String swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            printArray(arr);
            heapify(arr, n, largest);
        }
    }
 
    static void printArray(String arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner readMyFile = new Scanner(new File("hsortin.txt"));
        String data = readMyFile.nextLine();
        String[] arr = data.split(", ");
        int n = arr.length;
 
        Main ob = new Main();
        System.out.println("Array before sorting:");
        printArray(arr);
        System.out.println("Steps of sorting:");
        ob.sort(arr);
 
        System.out.println("Array after sorting:");
        printArray(arr);
    }
}
    
    