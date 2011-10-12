#include "my_quicksort.h"
#include "sort_common.h"
#include <stdio.h>
int temp_list[N];

/*

*
*/

void quick_sort_0(int *ar,int left,int right)
{

    int i=left,k=right;
    int el,er,key;
    el=er=(left+right)/2;
    key=ar[el];
    recursion_count++;
	
	

    while(1)
    {
        while(i<=el-1)
        {
            if(ar[i]>key)break;
            if(ar[i]==key)
            {
                swap(&ar[i],&ar[el-1]);
                el--;

                continue;
            }
            else
            {
                i++;
            }
        }
        while(k>=er+1)
        {
            if(ar[k]<key)break;
            if(ar[k]==key)
            {
                swap(&ar[k],&ar[er+1]);


                er++;

                continue;
            }
            else
            {
                k--;
            }
        }

        if(i==el)
            if(k==er)break;
            else
            {
                swap(&ar[i],&ar[k]);
                el++;
                i++;
                continue;
            }
        else if(k==er)
        {
            swap(&ar[i],&ar[k]);
            er--;
            k--;
            continue;
        }
        else
        {
            swap(&ar[i],&ar[k]);
            i++;
            k--;

        }

    }
    if(el-1==left+1)if(ar[left]>ar[el-1])swap(&ar[left],&ar[el-1]);
    if(el-1>left+1)quick_sort_0(ar,left,el-1);
    if(er+2==right)if(ar[er+1]>ar[right])swap(&ar[er+1],&ar[right]);
    if(right>er+2)quick_sort_0(ar,er+1,right);

}

void quick_sort_1(int *ar,int left,int right)
{

    int i=left;
    //int key=ar[left+rand()%(right-left)];
    int key=ar[(left+right)/2];
    int t_max=right+1,t_min=left-1,t_equ=0;
    recursion_count++;
    //if(left>=right)return;

    for(; i<=right; i++)
    {
        if(ar[i]>key)
        {

            temp_list[--t_max]=ar[i];


        }
        else if(ar[i]<key)
        {

            temp_list[++t_min]=ar[i];

        }
        else
        {

            t_equ++;
        }
    }

    for(i=left; i<=t_min; i++)ar[i]=temp_list[i];
    for(i=t_min+1; i<t_min+1+t_equ; i++)ar[i]=key;
    for(i=t_max; i<=right; i++)ar[i]=temp_list[i];
    if(t_min>left)quick_sort_1(ar,left,t_min);
    if(t_max<right)quick_sort_1(ar,t_max,right);

}

void quick_sort_2(int*ar,int l,int r,int k)
{


	int i = l;
	int j = r;	
	recursion_count++;
	while(i < j)
	{
		for(;(i < r)&&!(ar[i]&k);i++);
		for(;(j > l)&&(ar[j]&k);j--);
		if (i <= j)
		{
			if ( i != j)
			{
				swap(&ar[i],&ar[j]);
			}
			i++;
			j--;
		}
	}
	if(k>0)
	{
		if (i < r)
			quick_sort_2(ar,i,r,k/2);
		if (j > l)
			quick_sort_2(ar,l,j,k/2);
	}

}









