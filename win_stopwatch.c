#include <windows.h>   
#include "win_stopwatch.h"   
LARGE_INTEGER beginticks;  
LARGE_INTEGER endticks ;  
LARGE_INTEGER  frequency;
int init_flag=0;
void init_win_stopwatch()  
{  
    
  beginticks.QuadPart=0;  
  endticks.QuadPart=0;  
  frequency.QuadPart=0;  
  QueryPerformanceFrequency(&frequency);  
}  
void start_stopwatch()  
{  
      
	if(!init_flag){init_win_stopwatch();init_flag=1;}
	QueryPerformanceCounter(&beginticks);  
}
  
void end_stopwatch()  
{  
     
   QueryPerformanceCounter(&endticks);  
}  

double get_stopwatch_ms()  
{  
    unsigned long long cost=(unsigned long long)(endticks.QuadPart-beginticks.QuadPart);  
    double millsecond=(double)cost*1000.0/(double)frequency.QuadPart;  
    return millsecond;  
} 