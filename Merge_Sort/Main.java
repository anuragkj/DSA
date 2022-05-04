import java.util.*;1
import java.lang.Math;
import java.io.*;
public class Main
{
    private static void mergeSort(int[] array, int low, int high) 
    {
        if (high <= low) 
            return;
        int mid = (low + high) / 2;
        mergeSort(array, low, mid);
        mergeSort(array, mid + 1, high);
        merge(array, low, mid, high);
    }
    
    private static void merge(int[] array, int low, int mid, int high) 
    {
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = low; i < high + 1; i++)
        {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) 
            {
                if (leftArray[leftIndex] >= rightArray[rightIndex]) 
                {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else
                {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
            else if (leftIndex < leftArray.length) 
            {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            } 
            else if (rightIndex < rightArray.length) 
            {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
    
    public static void main (String args[]) throws FileNotFoundException{
        PrintWriter writeToMyFile = new PrintWriter(new File("mergeout.txt"));
        int max = 2147483647;
        int min = 1;
        int[] arr = new int[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * (max - min + 1) + min);
        }
        long startTime = System.nanoTime();
		mergeSort(arr, 0, arr.length - 1);
		long endTime = System.nanoTime() - startTime;
		System.out.println("Execution Time(nano seconds): "+endTime);
		for (int i = 0; i < arr.length; i++) {
            writeToMyFile.format("%d%n", arr[i]); 
        }
    writeToMyFile.close();
    }
}
