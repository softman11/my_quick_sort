#ifndef SORT_COMMON_H_INCLUDED
#define SORT_COMMON_H_INCLUDED

#define N 10000000
void swap(int*,int*);
void random_fill(int low,int up,int ar_count,...);
int correct(int*,int n);
void print_result(int* ar,double ms,int rcount,char*);
void test_sort(int *ar,int l,int r,char * title,void (*f)(int*,int,int),int(*gr)());

#endif // SORT_COMMON_H_INCLUDED
