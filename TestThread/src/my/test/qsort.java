package my.test;

import java.util.Random;

public class qsort {
	
	public void randFill(int[] ar,int min,int max)
	{
		Random rd=new Random();
		for(int i=0;i<ar.length;i++)
			ar[i]=rd.nextInt(max)+min;
	}
	public void swap(int[] ar,int i,int j)
	{
		int t=ar[i];
		ar[i]=ar[j];
		ar[j]=t;
	}
	
	public boolean isRight(int[] ar)
	{
		
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i-1]>ar[i])return false;
		}
		return true;
	}
	
	public void quicksort(int[] arr,int l,int r)
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
