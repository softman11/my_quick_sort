#ifndef OTHER_QUICKSORT_H_INCLUDED
#define OTHER_QUICKSORT_H_INCLUDED

/**
来自维基百科速度最快的快速排序算法
**/
void other_quick_sort_0(int *ar,int l,int r);

/**
c语言库实现的快速排序算法
**/
void clib_quick_sort(int *ar,int l,int r);

/**
安徽工业大学计算机学院 周建钦 提出的超快速排序算法 结合了快速排序和基数排序的优点
**/
void bq_sort(int *ar,int l,int r,int k);

#endif // OTHER_QUICKSORT_H_INCLUDED
