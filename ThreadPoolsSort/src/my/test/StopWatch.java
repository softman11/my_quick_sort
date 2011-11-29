//filename:StopWatch.java  
package my.test;  
public class StopWatch   
{  
    private long startTime = 0;    
    private long stopTime = 0;    
       
    
        
    public void start() {    
        this.startTime = System.currentTimeMillis();    
           
    }    
    
        
    public void stop() {    
        this.stopTime = System.currentTimeMillis();    
          
    }    
    
        
    //elaspsed time in milliseconds    
    public long getElapsedTime() {    
        long elapsed;    
         
        elapsed = (stopTime - startTime);    
           
        return elapsed;    
    }    
        
        
      
} 
