#ifndef SORT_COMMON_H_INCLUDED
#define SORT_COMMON_H_INCLUDED

#include "os_version.h"

#if defined WIN32_OS
#include "win_stopwatch.h"
#endif
#if defined LINUX_OS
#include "lin_stopwatch.h"
#endif

#define N 10000000
long recursion_count;
void swap(int*,int*);
void random_fill(int low,int up,int ar_count,...);
int correct(int*,int n);
void print_result(int* ar,double ms,long rcount,char*);
void test_sort(int *ar,int l,int r,char * title,void (*f)(int*,int,int));
void test_sort1(int *ar,int l,int r,char * title,void (*f)(int*,int,int,int));

#endif // SORT_COMMON_H_INCLUDED
