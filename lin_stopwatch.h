#ifndef LIN_STOPWATCH_H_INCLUDED
#define LIN_STOPWATCH_H_INCLUDED
#include <sys/time.h>
#include <unistd.h>
void start_stopwatch();
void end_stopwatch();
double get_stopwatch_ms();

#endif // LIN_STOPWATCH_H_INCLUDED
