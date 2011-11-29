package my.test;

import java.util.Queue;

public class SortRunner implements Runnable {

	int[] arr;
	int l,r;
	//Queue<Partion> mlist;
	public SortRunner(int[] arr,int l,int r)
	{
		this.arr=arr;
		this.l=l;
		this.r=r;
		//this.mlist=mlist;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		QuickSort.quicksort(arr, l, r);
		//synchronized(mlist){mlist.add(new Partion(l,r));mlist.notifyAll();}

	}

}
