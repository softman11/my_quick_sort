#include "sort_common.h"
#include "win_stopwatch.h"
#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <time.h>
void random_fill(int low,int up,int ar_count,...)
{
    int i=0,key,j,*p_ar;
    va_list ap;
    srand((unsigned int)time(NULL));
    for(; i<N; i++)
    {
        key=low+rand()%(up-low);
        va_start(ap,ar_count);
        for(j=0;j<ar_count;j++)
        {
            p_ar=va_arg(ap,int *);
            p_ar[i]=key;
        }
    }
    va_end(ap);
}

int correct(int *ar,int n)
{
    int i=0;
    for(; i<n-1; i++)if(ar[i]>ar[i+1])return 0;
    return 1;
}

void swap(int *a,int *b)
{
    int t=*a;
    *a=*b;
    *b=t;
}

void print_result(int* ar,double ms,int rcount,char *str)
{
    if(correct(ar,N))printf("test ok!");
    else printf("test fail!");
    printf(" %s cost ms:%f recursion_count:%d\n",str,ms,rcount);
}

void test_sort(int *ar,int l,int r,char * title,void (*f)(int*,int,int))
{
	recursion_count=0;
	start_win_stopwatch();
    f(ar,l,r);
    end_win_stopwatch();
    print_result(ar,get_win_stopwatch_ms(),recursion_count,title);
}
