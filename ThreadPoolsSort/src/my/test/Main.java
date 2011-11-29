package my.test;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=1000*10000;
		int max=Integer.MAX_VALUE;
		int[] arr=new int[size];
		int[] temp=new int[size];
		Tools.randFillArray(arr, 0, max);
		StopWatch sw=new StopWatch();
		SortPools sp=new SortPools(arr, temp,2, 0);
		//Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		
		long sort,merge;
		int[] arr2=new int[size];
		System.arraycopy(arr, 0, arr2, 0, size);
		//================
		//quick sort
		sw.start();
		QuickSort.quicksort(arr2, 0, size-1);
		sw.stop();
		if(Tools.isSorted(arr2))System.out.println("sort is ok");
		else System.out.println("sort failed");
		System.out.println("quick sort cost:"+sw.getElapsedTime());
		
		//======================
		//muti_threads sort
		sw.start();
		sp.startSort();
		sw.stop();
		sort=sw.getElapsedTime();
		sw.start();
		sp.startMerge();
		sw.stop();
		merge=sw.getElapsedTime();
		
		System.out.println("==============================================");
		if(Tools.isSorted(arr))System.out.println("sort is ok");
		else System.out.println("sort failed");
		System.out.println("sort cost:"+sort+" ms");
		System.out.println("merge cost:"+merge+" ms");
		System.out.println("total cost:"+(sort+merge)+" ms");
		

	}

}
