public class Search1
{
    public static int linearSearch(int[] arr, int key){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == key){    
                return i;    
            }    
        }    
        return -1;    
    } 
    
	public static int binarySearch(int arr[], int l, int r, int x)
    {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }
    
	public static void main(String[] args) {
		int[] arr = new int[10000];
		for(int i = 0; i<10000;i++){
		    arr[i] = i;
		}
		System.out.println("Carrying out linear search");
		System.out.println("\nInput: 5000");
		long startTime = System.nanoTime();
		int x = linearSearch(arr, 5000);
		long endTime = System.nanoTime() - startTime;
		if(x == -1){
		    System.out.println("Not Found");
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		else{
		    System.out.println("Found at position: "+x);
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		
		System.out.println("\nInput: 9997");
		startTime = System.nanoTime();
		 x = linearSearch(arr, 9997);
		endTime = System.nanoTime() - startTime;
		if(x == -1){
		    System.out.println("Not Found");
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		else{
		    System.out.println("Found at position: "+x);
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		
		System.out.println("\nInput: 50000");
		startTime = System.nanoTime();
		x = linearSearch(arr, 50000);
		endTime = System.nanoTime() - startTime;
		if(x == -1){
		    System.out.println("Not Found");
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		else{
		    System.out.println("Found at position: "+x);
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		System.out.println("\n\nCarrying out binary search");
		startTime = System.nanoTime();
		x = binarySearch(arr, 0, 9999, 5000);
		endTime = System.nanoTime() - startTime;
		if(x == -1){
		    System.out.println("Not Found");
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		else{
		    System.out.println("Found at position: "+x);
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		
		System.out.println("\nInput: 9997");
		startTime = System.nanoTime();
		x = binarySearch(arr, 0, 9999, 9997);
		endTime = System.nanoTime() - startTime;
		if(x == -1){
		    System.out.println("Not Found");
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		else{
		    System.out.println("Found at position: "+x);
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		
		System.out.println("\nInput: 50000");
		startTime = System.nanoTime();
		x = binarySearch(arr, 0, 9999, 50000);
		endTime = System.nanoTime() - startTime;
		if(x == -1){
		    System.out.println("Not Found");
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
		else{
		    System.out.println("Found at position: "+x);
		    System.out.println("Execution Time(nano seconds): "+endTime);
		}
	}
}
