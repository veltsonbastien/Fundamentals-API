import java.io.*; 
import java.util.*;
import java.text.*;
import java.lang.*;
import java.lang.Math.*;
import static java.lang.Math.pow;
import java.util.ArrayList;

public class DateAPI
{
    public static void main (String args[])
    {
        System.out.println("Date Duration Calculator");
        Dates d1 = new Dates(6, 14, 2018);
        Dates d2 = new Dates(9,23,2018);

        System.out.println( d1.durationBetween(d1, d2) + " days" );
        System.out.println( d1.durationInWeeks( d1.durationBetween(d1, d2) ) );
    }
}

class Dates
{   
    int month = 0;
    int day = 0;
    int year = 0;

    public Dates()
    {
        month = 8;
        day = 23;
        year = 2017;
    } //end of default constructor

    public Dates(int m, int d, int y)
    {
        month = m;
        day = d;
        year = y;
    } //end of constructor

    public void setMonth(int m) { month = m; }

    public void setDay(int d) { day = d; }

    public void setYear(int y) { year = y; }

    public int getMonth() { return this.month; }

    public int getDay() { return this.day; }

    public int getYear() { return this.year; }

    public int dayOfTheYear(Dates d1)
    {

        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31,0};

        int checkMonth = 1;
        int checkDay = 1;
        int checkYear = 2000;

        int inputMonth = 0;
        int inputDay = 0;
        int inputYear = 0;

        int dayOfYear = 0;
        int dayOfYearFinal = 0;    

        inputMonth = this.getMonth();
        inputDay = this.getDay();
        inputYear = this.getYear();

        int saveThisNumber = daysInMonth[inputMonth] - inputDay ;

        int yearDifference = inputYear - checkYear; 

        int yearChecker = checkYear; 

        if(yearDifference > 0)
        {      
            int normalDays = 0;

            for(int a = checkMonth ; a<=inputMonth; a++)
            {

                for(int b = 1; b<=daysInMonth[a]; b++)
                {
                    normalDays++; 
                }
            } //end of month looper

            int normalDistance = 365- normalDays;
            int saveThisAlso = normalDistance * (yearDifference) ;  
            dayOfYear += saveThisAlso; 

            for(int k = 0; k <= yearDifference; k++)
            {

                if(yearChecker%4 == 0)
                {
                    daysInMonth[1] = 29; 
                }
                else
                {
                    daysInMonth[1] = 28;
                }

                for(int i = checkMonth ; i<=inputMonth; i++)
                {

                    for(int j = 1; j<=daysInMonth[i]; j++)
                    {
                        dayOfYear++; 

                    } //end of day looper

                } //end of month looper

                yearChecker++;

            } //end of year looper
        }
        else if(yearDifference==0)
        {

            for(int i = checkMonth ; i<=inputMonth; i++)
            {

                for(int j = 1; j<=daysInMonth[i]; j++)
                {
                    dayOfYear++; 
                }

            } //end of month looper

        }

        dayOfYearFinal = dayOfYear - saveThisNumber;

        return dayOfYearFinal;     
    } //end of dayOfTheYEar
    
    public int durationBetween(Dates d1, Dates d2)
    {
        /**
         * Methods: durationBetween() and durationInWeeks(), calculations done in the dayOfTheYear() method
         * Syntax: Date object "d1" and Date object "d2" --> d.durationBetween(d1, d2) (assuming d1 is the Start Date and d2 is the End Date) 
         * Use: Calculates Duration Between Both Dates
         * Limitations: Only functional for dates after January 1st, 2000
         * Other Notes: also uses the durationInWeeks() function, Date object "d1" and Date object "d2" --> d1.durationInWeeks( d.durationBetween(d1,d2) )  
         * Duration Between adds an extra day, to account for the end date which was not previously accounted for
         * Created: 06/02/2018 Revised: 06/03/2018 
         * Version 1.0, 06/02/2018
         * - Features the dayOfTheYear() function as well as durationBetween()
         * Version 1.1, 06/03/2018
         * - Features improvements in the dayOfTheYear() function as well as durationBetween(), new addition of durationInWeeks() function
         */
        
        int totalDays = 0; 
        totalDays = d2.dayOfTheYear(d2) - d1.dayOfTheYear(d1);
        totalDays+=1;
        
        return totalDays;
        
    }
      
    public String durationInWeeks(int d)
     {

        String result = "";

        int weeks = 0;
        int leftOverDays = 0;

        weeks = d/7; 
        leftOverDays = d%7; 

        result = weeks+" weeks and "+leftOverDays+" days"; 

        return result;

     }
      
    } //end of dates class
