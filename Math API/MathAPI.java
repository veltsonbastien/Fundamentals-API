/**
 * Bundle of APIs made by Your's Truly
 * 
 * @author Veltson Bastien 
 * @Whole thing started June 2nd, 2018
 */

import java.io.*; 
import java.util.*;
import java.text.*;
import java.lang.*;
import java.lang.Math.*;
import static java.lang.Math.pow;
import java.util.ArrayList;

public class MathAPI
{
  public static void main(String args[])
   {
       //Multiplying Example
        System.out.println(multiply(2,2));   
        //Dividing Example
        System.out.println(divide(8,3));
        //Factoring Example
        System.out.println(factorialOf(4));       
        //Exponent Example
        System.out.println(power(11,2));      
        //Module Example
        System.out.println(modulo(100,12));    
   }
   
       public static int add(int x, int y)
        {
         int result = 0;
         result = x+y;
         return result;
        }
    
        public static int subtract(int x, int y)
        {
         int result = 0;
         result = y-x;        
         return result;            
        }
    
        public static int multiply(int x, int y)
        {
            int result = 0;
            int counter = y;   
            
                 while(counter>0)
                 {
                   for(int i = 0; i<x; i++)
                    {
                     result+=1;  
                        for(int j = x; j<x; j++)
                        {
                         result+=1;
                        }      
                    }              
                 counter--;                     
                } //end of while 
                  
          return result;   
        } //end of multiply
        
    public static String divide(int x, int y)
    {
      int result = 0;
      int remainder = 0;  
      int counter = 0;
      int secondCounter = 0;
      
      for(int i = 0; i<x; i++)
      {    
        counter++;       
        if(counter>=y)
         {
          counter = 0;
          secondCounter++;
         }        
      }
        
      result = secondCounter; 
      remainder = counter;
     
      return "Quotient: "+result+"\n" 
             +"Remainder: "+remainder;
    }
    
    public static int modulo(int x, int y)
    {
      int result = 0;
      int remainder = 0;
      int counter = 0;
      int secondCounter = 0;
      
      for(int i = 0; i<x; i++)
      {    
        counter++;     
        if(counter>=y)
         {
          counter = 0;
          secondCounter++;
         }   
      }       
      result = secondCounter; 
      remainder = counter; 
      
      return remainder;       
    }
      
    public static int factorialOf(int x)
    {
        int result = 0; 
        if(x == 0 || x==1)
        {
            return x; 
        }

        result = x*factorialOf(x-1);
        
        return result;
    } //end of factorialOf
    
    
    public static int power(int x, int y)
    {      
     int finalResult = 0;
     if( y == 0 ) { return 1; }
     else if( y == 1) { return x; }   
     finalResult =  x * power(x, y-1);  
     
     return finalResult;
    } //end power 
    
    
    public static double log2(double d) {
      return java.lang.Math.log(d)/java.lang.Math.log(2.0);
    }
    
}

