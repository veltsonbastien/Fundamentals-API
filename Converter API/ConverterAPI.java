import java.io.*; 
import java.util.*;
import java.text.*;
import java.lang.*;
import java.lang.Math.*;
import static java.lang.Math.pow;
import java.util.ArrayList;

public class ConverterAPI
{
    public static void main (String args[])
    {
        System.out.println("Enter a hex to be converted to binary");
        Scanner sc = new Scanner (System.in);

        String x = sc.nextLine();
        System.out.println(hexToBinary(x)); 
        System.out.println(binaryToDecimal( hexToBinary(x) ) + " in Decimal" );

        int y = sc.nextInt(); 
        System.out.println( decimalToBinary(y) + " in Binary"  );
        System.out.println( binaryToHex( decimalToBinary(y) ) + "in Hexadecimal "  ); 
    }
    
    public static double log2(double d) {
      return java.lang.Math.log(d)/java.lang.Math.log(2.0);
    }

    public static ArrayList decimalToBinary(int x)
    {

        int insertedNumber = x; 
        double power = 0.0;
        int number = 0; 

        ArrayList<Integer> binaryNumber = new ArrayList(); 

        if(insertedNumber == 0) { 
            binaryNumber = new ArrayList<Integer>(); 
            binaryNumber.add(0,0);
            return binaryNumber;   
        }

        while(number <= insertedNumber)
        {
            power++; 
            number = (int)(java.lang.Math.pow(2.0,power));
        }

        int checkFrom = (int)java.lang.Math.pow(2.0, power-1.0);
        int binarySize = ((int)(log2( (double)checkFrom ) ))+1 ;

        for(int i=0; i<binarySize; i++)
        {
            binaryNumber.add(0); 
        }

        ////////////////////////////////////////////////////////
        /////// BUILD THE BINARY NUMBER ////////////////////////

        binaryNumber.set(0, 1);
        int counter = ((int)power) - 1;  
        int upCounter = 0;

        while( counter >= 0 )
        {
            checkFrom = (int) (java.lang.Math.pow(2.0, (double)counter));
            if(insertedNumber >= checkFrom) 
            {
                binaryNumber.set(upCounter, 1); 
                insertedNumber = insertedNumber - checkFrom;     
            }
            else 
            {
                binaryNumber.set(upCounter, 0);
            }
            upCounter++; 
            counter--; 
        }

        int sizeCounter = 0;  
        
        for(int i = binarySize; i>0; i-=4)
        {
            sizeCounter++; 
        }

        int addSize = 0; 

        if(binarySize%4!=0)
        {
            if(binarySize<4) { addSize = 4-binarySize; }
            else
            {
                addSize = (4*sizeCounter)-binarySize; 
            }
        }

        for(int i = 0; i<addSize; i++)
        {
            binaryNumber.add(0, 0);
        }
   
        return binaryNumber;

    } //end of decimal to binary

    public static ArrayList binaryToHex (ArrayList arr)
    {
        ArrayList<Integer> binaryNumber = new ArrayList();
        binaryNumber = arr; 
        ArrayList<String> hexNumber = new ArrayList();
        String binary = "";

        for(int i: binaryNumber)
        {
            binary+= i;     
        }

        ArrayList<String> binaryString = new ArrayList();
        int iterationCount = 0;

        for(int i=0; i<binary.length(); i+=4)
        {
            binaryString.add(iterationCount, binary.substring(i,i+4) ); 
            iterationCount++;
        }

        for(String s: binaryString)
        {
            String hexValue = "";

            switch(s)
            {
                case "0001": hexValue = "1"; break;
                case "0010": hexValue = "2"; break;
                case "0011": hexValue = "3"; break;
                case "0100": hexValue = "4"; break;
                case "0101": hexValue = "5"; break;
                case "0110": hexValue = "6"; break;
                case "0111": hexValue = "7"; break;
                case "1000": hexValue = "8"; break;
                case "1001": hexValue = "9"; break;
                case "1010": hexValue = "A"; break;
                case "1011": hexValue = "B"; break;
                case "1100": hexValue = "C"; break;
                case "1101": hexValue = "D"; break;
                case "1110": hexValue = "E"; break;
                case "1111": hexValue = "F"; break;
                default:
                hexValue = "0";
            } //end of switch statement
            hexNumber.add(hexValue);
        }
        
        System.out.println(binaryString);
        
        return hexNumber; 

    }

    public static ArrayList hexToBinary(String s)
    {
        String result = "";       

        ArrayList<String> individualHex = new ArrayList(); 
        ArrayList<String> binaryNumber = new ArrayList();
        ArrayList<Integer> binaryNumberFinal = new ArrayList();

        for(int i=0; i<s.length(); i++)
        {
            individualHex.add(s.substring(i,i+1));   
        }

        for(String value: individualHex)
        {
            switch(value)
            {
                case "1": binaryNumber.add("0001"); break; 
                case "2": binaryNumber.add("0010"); break; 
                case "3": binaryNumber.add("0011"); break; 
                case "4": binaryNumber.add("0100"); break; 
                case "5": binaryNumber.add("0101"); break; 
                case "6": binaryNumber.add("0110"); break; 
                case "7": binaryNumber.add("0111"); break; 
                case "8": binaryNumber.add("1000"); break; 
                case "9": binaryNumber.add("1001"); break; 
                case "A": binaryNumber.add("1010"); break; 
                case "B": binaryNumber.add("1011"); break; 
                case "C": binaryNumber.add("1100"); break; 
                case "D": binaryNumber.add("1101"); break; 
                case "E": binaryNumber.add("1110"); break; 
                case "F": binaryNumber.add("1111"); break; 
                default:
                binaryNumber.add("0000"); 
            } //end of switch

        }// end of enchanced 
     
        for(String d: binaryNumber)
        {
            for(int i=0; i<d.length(); i++)
            {
                binaryNumberFinal.add( Integer.parseInt(d.substring(i,i+1)) );   
            }  
        }
        
        return binaryNumberFinal; 
    }//end of hex to binary

    public static int binaryToDecimal(ArrayList arr)
    {
        int decimalValue = 0; 
        int placeValues = (arr.size())-1; 
        int counter = 1;   
        int upCounter = 0;

        while(upCounter<arr.size())
        {
            counter = (int) (java.lang.Math.pow(2.0, (double)placeValues) ); 
            decimalValue +=  (int)(arr.get(upCounter)) *counter; 
            placeValues--; 
            upCounter++; 
        }
        return decimalValue;             
    } //end of binary to decimal
}

