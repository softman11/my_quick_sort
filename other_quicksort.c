#include "sort_common.h"
#include <stdlib.h>
#include <assert.h>
void other_quick_sort_0(int *arr,int l,int r)
{
    int i = l;
    int j = r;
    int key = arr[(i+j)/2];
    //int key=arr[l]/2+arr[r]/2;
    recursion_count++;
    while(i < j)
    {
        for(; (i < r)&&(arr[i] < key); i++);
        for(; (j > l)&&(arr[j] > key); j--);
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

int f_avg(int *ay,int l,int r,long int *avg)
{
    int i;
    //double average=0.0;
    if(r<l)return 0;
    else
    {
        //average=0.0;
        for(i=l; i<=r; i++)avg+=ay[i]/(r-l+1);
        //*avg=(int)average;
        return 1;
    }
}

void eq_sort(int *arr,int l ,int r)//这个算法目前还没通过测试
{
    int i = l;
    int j = r;
    long key ;

    //int key=arr[l]/2+arr[r]/2;
    recursion_count++;
     if(!f_avg(arr,l,r,&key))return;
    while(i < j)
    {
        for(; (i < r)&&(arr[i] < key); i++);
        for(; (j > l)&&(arr[j] > key); j--);
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
//    int i,j,mid;
//    if(l>=r)return;
//    if(!f_avg(ar,l,r,&mid))return;
//
//
//
//    i=l;
//    j=r;
//    recursion_count++;
//    while(i<j)
//    {
//
//        while(ar[i]<=mid&&i<j)i++;
//        while(ar[j]>=mid&&i<j)j--;
//        if(i<j)swap(&ar[i],&ar[j]);
//        else
//        {
//
//
//
//            break;
//
//        }
//    }
// assert(ar[i]>=mid);
// if(i>l&&i<r)
//   {
//      if(i-1>l)eq_sort(ar,l,i-1);
//      if(i<r)eq_sort(ar,i,r);
//   }





}


