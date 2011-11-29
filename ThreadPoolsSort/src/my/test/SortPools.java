package my.test;

import java.util.ArrayList;

public class SortPools {
	
	int[] arr, temp;
	int nsort;
	int nmerge;
	int[] begins,ends;
	Thread[] sortThreads,mergeThreads;
	public ArrayList<Partion> partionList;
	public ArrayList<MergeItem> mergeList;
	public SortPools(int[] arr,int[] temp,int nsort,int nmerge)
	{
		this.arr=arr;
		this.temp=temp;
		this.nsort=nsort;
		this.nmerge=nmerge;
		partionList=new ArrayList<Partion>();
		mergeList=new ArrayList<MergeItem>();
		makePartion();
		productThreads();
	}
	public void startSort()
	{
		for(int i=0;i<nsort;i++)
			sortThreads[i].start();
		for(int i=0;i<nsort;i++)
			try {
				sortThreads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void startMerge()
	{
		this.makeMergeTask();
		while(mergeList.size()>0)
		{
			Thread[] threads=new Thread[mergeList.size()];
			for(int i=0;i<mergeList.size();i++)
			{
				MergeItem mi=mergeList.get(i);
				threads[i]=new Thread(new MergeRunner(arr,temp, mi.low,mi.mid,mi.high));
				//threads[i].setPriority(Thread.MAX_PRIORITY);
				threads[i].start();
			}
			for(int i=0;i<mergeList.size();i++)
			{
				try {
					threads[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.makeMergeTask();
		}
		
		
	}
	
	public void makePartion()
	{
		int step=arr.length/nsort;
		begins=new int[nsort];
		ends=new int[nsort];
		
		for(int i=0;i<nsort;i++)
		{
			begins[i]=i*step;
			if(i==nsort-1)
				ends[i]=arr.length-1;
			else ends[i]=begins[i]+step-1;
			this.partionList.add(new Partion(begins[i],ends[i]));
			
		}
	}
	
	void productThreads()
	{
		sortThreads=new Thread[nsort];
		for(int i=0;i<nsort;i++)
			{
			sortThreads[i]=new Thread(new SortRunner(arr,begins[i],ends[i]));
			//sortThreads[i].setPriority(Thread.MAX_PRIORITY);
			}
	}
	
	public void makeMergeTask()
	{
		
		int mcount=partionList.size()/2;
		mergeList.clear();
		ArrayList<Partion> temp=new ArrayList<Partion>();
		for(int i=0;i<mcount;i++)			
			{
			   int low=partionList.get(i*2).begin;
			   int mid=partionList.get(i*2).end;
			   int high=partionList.get(i*2+1).end;
			   mergeList.add(new MergeItem(low,mid,high));
			   partionList.get(i*2).end=partionList.get(i*2+1).end;
			   //partionList.set(i*2, new Partion(low,high));
			   temp.add(partionList.get(i*2+1));
			}		
		partionList.removeAll(temp);		
		
	}

}
