#include "stopwatch.h"
long start_time=0;
long end_time=0;
void start_stopwatch()
{
    struct timeval tv;
    struct timezone tz;
    gettimeofday (&tv , &tz);
    start_time=tv.tv_sec*1000*1000+tv.tv_usec;
}

void end_stopwatch()
{
    struct timeval tv;
    struct timezone tz;
    gettimeofday (&tv , &tz);
    end_time=tv.tv_sec*1000*1000+tv.tv_usec;
}

double get_stopwatch_ms()
{
    double ms=(double)(end_time-start_time)/(double)1000.0;
    return ms;
}

