#include <stdio.h>
#include <stdlib.h>
#include "my_quicksort.h"
#include "stopwatch.h"
#include "other_quicksort.h"
#include "sort_common.h"

int list0[N];
int list1[N];
int list2[N];
int list3[N];

int main()
{


    random_fill(0,N,4,list0,list1,list2,list3);

    start_stopwatch();
    quick_sort_0(list0,0,N-1);
    end_stopwatch();
    double ms=get_stopwatch_ms();
    print_result(list0,ms,get_recursion_count0(),"my quick_sort_0");

    start_stopwatch();
    other_quick_sort_0(list1,0,N-1);
    end_stopwatch();
    ms=get_stopwatch_ms();
    print_result(list1,ms,get_other_recursion_count0(),"other quick_sort_0");

    start_stopwatch();
    quick_sort_1(list2,0,N-1);
    end_stopwatch();
    ms=get_stopwatch_ms();
    print_result(list2,ms,get_recursion_count1(),"my quick_sort_1");

    start_stopwatch();
    clib_quick_sort(list3,0,N-1);
    end_stopwatch();
    ms=get_stopwatch_ms();
    print_result(list3,ms,0,"other clib qsort");

    return 0;


}


