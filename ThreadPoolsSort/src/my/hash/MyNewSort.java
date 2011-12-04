package my.hash;

import my.test.StopWatch;
import my.test.Tools;
//这是我突然想到到排序方法，后来查一下，居然就是桶排序
//速度确实比快速排序快，可惜需要付出一倍的额外空间，而且空间和被排序数据到跨度直接相等。
//最大应该是Integer.MaxValue
public class MyNewSort {
	public static void Sort(int[] arr,int max)
	{
	
		int[] temp=new int[max];
		int[] count=new int[max];
		for(int i=0;i<arr.length;i++){temp[arr[i]]=arr[i];count[arr[i]]++;}
		int pos=0;
		for(int i=0;i<temp.length;i++)
		 for(int ii=0;ii<count[i];ii++)arr[pos++]=temp[i];
		
	}
	public static void main(String[] args) {
	
		int N=1000*10000;
		int max=N;
		int[] ar=new int[N];
		Tools.randFillArray(ar, 0, N);
		StopWatch sw=new StopWatch();
		sw.start();
		Sort(ar,max);
		sw.stop();
		System.out.println("cost time:"+sw.getElapsedTime());
		if(Tools.isSorted(ar))System.out.println("sort ok");
	}

}
