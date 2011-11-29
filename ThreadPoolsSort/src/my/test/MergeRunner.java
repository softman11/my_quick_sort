package my.test;

import java.util.Queue;

public class MergeRunner implements Runnable {

	public boolean isBusy=false;
	int[] arr,temp;
	int low,mid,high;
	//Queue<Partion> mlist;
	public MergeRunner(int[] arr,int[] temp,int low,int mid,int high)
	{
		this.arr=arr;
		this.temp=temp;
		this.low=low;
		this.mid=mid;
		this.high=high;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		MergeSort.merge(arr, temp, low, mid, high);

	}

}
