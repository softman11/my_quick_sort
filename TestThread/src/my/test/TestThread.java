package my.test;

import java.util.concurrent.ArrayBlockingQueue;

public class TestThread {

	static boolean addFlag=true;
	static ArrayBlockingQueue<Task> tasklist=null;
	static int key=0;
	
	static  void AddTask(int[]arr,int l,int r)
	{
		 if(tasklist!=null)
				try {
					{tasklist.put(new Task(arr,l,r));};
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			 // System.out.println(Thread.currentThread().getId()+" add:"+l+"-"+r);
	}
	static class DoTask implements Runnable
	{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(addFlag)
			{
			  
			try {
				Task task = tasklist.take();
				 if(task!=null)
				 {
					 quicksort(task.arr,task.l,task.r);
					// System.out.println(Thread.currentThread().getId()+" do key:"+task.l+"-"+task.r);
				 }
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			 
			}	
		}
		public void swap(int[] ar,int i,int j)
		{
			int t=ar[i];
			ar[i]=ar[j];
			ar[j]=t;
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
		           //quicksort(arr,i,r);
		     {
		    	 if(tasklist!=null)
						AddTask(arr,i,r);
						
		     }
		     if (j > l)
		           //quicksort(arr,l,j);
		     {
		    	 if(tasklist!=null)
						AddTask(arr,l,j);
		     }
		}
		
	}
	/**
	 * @param args
	 */
	static boolean isEnd(Thread t1,Thread t2)
	{
		System.out.println(tasklist.isEmpty());
		System.out.println(t1.getState());
		System.out.println(t2.getState());
		return tasklist.size()==0&&t1.getState()==Thread.State.WAITING&&t2.getState()==Thread.State.WAITING;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		tasklist=new ArrayBlockingQueue<Task>(10,true);
		int size=50;
		int max=size;
		int[] arr=new int[size];
		new qsort().randFill(arr, 0, max);
		
		//Thread t11=new Thread(new AddTask(null,1,10));
		Thread t2=new Thread(new DoTask());
		Thread t22=new Thread(new DoTask());
		StopWatch sw=new StopWatch();
		sw.start();
		AddTask(arr,0,size-1);
		t2.start();
		//t11.start();
		t22.start();
		
		
		while(!isEnd(t2,t22));
		sw.stop();
		System.out.println("cost time:"+sw.getElapsedTime());
		t2.interrupt();
		t22.interrupt();			
			if(new qsort().isRight(arr))System.out.println("sort ok");
			System.out.println("exit");
		
		
		
		

	}
	

}
