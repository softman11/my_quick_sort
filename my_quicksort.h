#ifndef MY_QUICKSORT_H_INCLUDED
#define MY_QUICKSORT_H_INCLUDED


/**
我的快速排序算法，主要解决了重复元素太多而导致的效率问题
**/
void quick_sort_0(int *,int ,int);

/**
我的快速排序算法，主要牺牲了一倍的数组存储空间来换得效率的提升
**/
void quick_sort_1(int*,int,int);

/**
我的快速排序算法，结合了最快的快速排序算法和二进制基数排序算法
相当于超快速的排序算法的我的实现
**/
void quick_sort_2(int*ar,int ,int,int);




#endif // MY_QUICKSORT_H_INCLUDED

