#ifndef STOPWATCH_H_INCLUDED
#define STOPWATCH_H_INCLUDED
#include <sys/time.h>
#include <unistd.h>
void start_stopwatch();
void end_stopwatch();
double get_stopwatch_ms();

#endif // STOPWATCH_H_INCLUDED
