package my.test;

import java.util.Random;

public class Tools {
	public static  boolean isSorted(int[] ar)
	{
		
		for(int i=1;i<ar.length;i++)
		{
			if(ar[i-1]>ar[i])return false;
		}
		return true;
	}
	
	public static void randFillArray(int[] ar,int min,int max)
	{
		Random rd=new Random();
		for(int i=0;i<ar.length;i++)
			ar[i]=rd.nextInt(max)+min;
	}

}
