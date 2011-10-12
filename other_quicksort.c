
#include "sort_common.h"
#include <stdlib.h>

void other_quick_sort_0(int *arr,int l,int r)
{
     int i = l;
     int j = r;
     int key = arr[(i+j)/2];
     recursion_count++;
     while(i < j)
        {
            for(;(i < r)&&(arr[i] < key);i++);
            for(;(j > l)&&(arr[j] > key);j--);
            if (i <= j)
               {
                 if ( i != j)
                    {
                       swap(&arr[i],&arr[j]);
                    }
                 i++;
                 j--;
                }
        }
     if (i < r)
           other_quick_sort_0(arr,i,r);
     if (j > l)
           other_quick_sort_0(arr,l,j);
}

int int_compare(const void *a,const void *b)
{
    int *ai=(int *)a;
    int *bi=(int *)b;
    return (*ai)-(*bi);
}

void clib_quick_sort(int *ar,int l,int r)
{
    qsort(ar+l,r-l+1,sizeof(int),int_compare);
}


void bq_sort(int *ar,int l,int r,int k)
{
	
	int i,j;
	i=l;
	j=r;
	recursion_count++;
	
	while(i<j)
	{
		while((ar[j]&k)&&(i<j))j--;
		while(((ar[i]&k)==0)&&(i<j))i++;
		if(i<j)swap(&ar[i],&ar[j]);
		else
		{
			if(ar[j]&k)i--;
			else j++;
			break;
		}
	}
	if(k>1)
	{
		if(l<i)bq_sort(ar,l,i,k/2);
		if(j<r)bq_sort(ar,j,r,k/2);

	}
}
