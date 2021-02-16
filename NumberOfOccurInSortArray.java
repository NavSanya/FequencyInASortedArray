import java.io.IOException;
import java.util.*;
//like strings have firstIndexOf and lastIndexOf
//total occur = lastOcc-firstOcc+1 (since its a sorted array)
public class NumberOfOccurInSortArray {
    int arr[];
    //set array
    protected void setValues(int a[])
    {
        arr = a;
    }
    //the first occurance through the binary search.
    // Keep going to the left subarray till you don't have
    // anything to the left of it.
    public int firstOcc(int low, int high, int key)
    {
        if(low>high)
            return -999; //flag value when it doesn't exist
        int mid = (low+high)/2;

        if((key<arr[mid]||key == arr[mid-1])&& high<arr.length&&low<arr.length)
           return firstOcc(low,mid-1,key);
        else if(key>arr[mid]&& high<arr.length&&low<arr.length)
           return firstOcc(mid+1,high,key);
        else
            return mid;
    }

    public int lastOcc(int low, int high, int key)
    {
        if(low>high)
            return -999; //flag value when it doesn't exist
        int mid = (low+high)/2;

        if(key<arr[mid]&& high<arr.length&&low<arr.length)
            return lastOcc(low,mid-1,key);
        else if((key>arr[mid]||key == arr[mid+1])&& high<arr.length&&low<arr.length)
            return lastOcc(mid+1,high,key);
        else
            return mid;
    }

    public static void main(String args[])throws IOException
    {
        int arr[] = {1,2,2,2,3,4,4,4,4,4,4,5,6,6,7,8,8,8};
        NumberOfOccurInSortArray obj = new NumberOfOccurInSortArray();
        obj.setValues(arr);
        int first = obj.firstOcc(0,arr.length-1,5);
        int last = obj.lastOcc(0,arr.length-1,5);
        if(first!=-999&&last!=-999)
            System.out.println("5 comes "+(last-first+1)+" times!");
        else
            System.out.println("Error");
    }
}
