#include <stdio.h>
#include <stdlib.h>
#include "my_quicksort.h"
#include "other_quicksort.h"
#include "sort_common.h"

int list0[N];
int list1[N];
int list2[N];
int list3[N];
int list4[N];
int list5[N];

int main()
{


    random_fill(0,N,6,list0,list1,list2,list3,list4,list5);

    test_sort(list0,0,N-1,"my quick_sort_0",quick_sort_0);

    test_sort(list1,0,N-1,"my quick_sort_1",quick_sort_1);

    test_sort(list2,0,N-1,"other_quick_sort_0",other_quick_sort_0);

    test_sort(list3,0,N-1,"clib_quick_sort",clib_quick_sort);

    test_sort1(list4,0,N-1,"other bq_sort",bq_sort);

    test_sort1(list5,0,N-1,"my quick_sort_2",quick_sort_2);





    return 0;


}


