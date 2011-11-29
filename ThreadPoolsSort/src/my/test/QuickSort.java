package my.test;

import java.util.Random;

public class QuickSort {
	
	
	public static void swap(int[] ar,int i,int j)
	{
		int t=ar[i];
		ar[i]=ar[j];
		ar[j]=t;
	}
	
	
	
	public static void quicksort(int[] arr,int l,int r)
	{
		int i = l;
	     int j = r;
	     int key = arr[(i+j)/2];
	     while(i < j)
	        {
	            for(;(i < r)&&(arr[i] < key);i++);
	            for(;(j > l)&&(arr[j] > key);j--);
	            if (i <= j)
	               {
	                 if ( i != j)
	                    { 
	                       swap(arr,i,j);
	                    }
	                 i++;
	                 j--;
	                }
	        }
	     if (i < r)
	           quicksort(arr,i,r);
	     if (j > l)
	           quicksort(arr,l,j);
	}

}
