package my.test;

public class MergeSort {
	public static void merge(int[] array,int[] temp,int low,int mid,int high)
	{
		int  k;       
        int begin1 = low;
        int end1 = mid;
        int begin2 = mid + 1;
        int end2 = high;
 
        for (k = low; begin1 <= end1 && begin2 <= end2; ++k)  //比较两个指针所指向的元素，
//选择相对小的元素放入到合并空间，并移动指针到下一位置
        { 
            if(array[begin1]<=array[begin2])
             {
              temp[k] = array[begin1++];
             }
            else
            {   
             temp[k] = array[begin2++];
            }
        }
        if(begin1 <= end1) //若第一个序列有剩余，直接拷贝出来粘到合并序列尾
        {
          //memcpy(temp+k, array+begin1, (end1-begin1+1)*sizeof(int));
        	System.arraycopy(array, begin1, temp, k, end1-begin1+1);
        }
        if(begin2 <= end2) //若第二个序列有剩余，直接拷贝出来粘到合并序列尾
        {
          //memcpy(temp+k, array+begin2, (end2-begin2+1)*sizeof(int));
        	System.arraycopy(array, begin2, temp, k, end2-begin2+1);
        }
        //memcpy(array+low, temp, (high-low+1)*sizeof(int));//将排序好的序列拷贝回数组中
        System.arraycopy(temp, low, array, low, high-low+1);
	}

}
