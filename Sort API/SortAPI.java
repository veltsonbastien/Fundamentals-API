import java.io.*; 
import java.util.*;
import java.text.*;
import java.lang.*;
import java.lang.Math.*;
import static java.lang.Math.pow;
import java.util.ArrayList;

public class SortAPI
{
    public static void main (String args[])
    {
        int[] sortThis0 = {23,65,1,23,7,3,9,43,27,9,82,46,12,77,32,15,44,22,11}; 
        int[] sortThis1 = {23,65,1,23,7,3,9,43,27,9,82,46,12,77,32,15,44,22,11}; 
        int[] sortThis2 = {23,65,1,23,7,3,9,43,27,9,82,46,12,77,32,15,44,22,11};  
        int[] sortThis3 = {23,65,1,23,7,3,9,43,27,9,82,46,12,77,32,15,44,22,11};  

        System.out.println(printArray(bubbleSort(sortThis1))); 
        System.out.println(selectionSort(sortThis2) );
        System.out.println(insertionSort(sortThis0) );
        System.out.println(printArrayList(mergeSort(sortThis3)) );

    }

    public static String printArray(int[] arr)
    {
        String result = "";

        for(int i=0; i<arr.length; i++)
        {
            result+= arr[i] + ", ";   
        }

        return result; 
    }

    public static String printArrayList(ArrayList arr)
    {
        String result = "["; 
        ArrayList<int[]> temp = arr;

        for(int[] a: temp)
        {
            result+= Arrays.toString(a);
        }

        return result;

    }

    public static boolean isIncreasing(int[] arr)
    {
        int[] temp = arr; 
        boolean result = true;

        for(int i=0; i<temp.length-1; i++)
        {
            if( !(temp[i+1] >= temp[i]) ) { return false;}
        }

        return result; 
    }

    public static boolean isIncreasingArrayList(ArrayList arr)
    {
        ArrayList<Integer> temp = arr;
        boolean result = true;

        if(temp.size() > 1)
        {
            for(int i=0; i<temp.size()-1; i++)
            {
                if( !(temp.get(i+1) >= temp.get(i)) ) { return false;}
            }
        }

        return result;

    }
    public static int[] bubbleSort(int[] arr)
    {
        int[] result = arr; 
        int upCounter = 0;

        if(arr.length > 1)
        {

            while( !(isIncreasing(result)) )  //while not increasing
            {
                for(int i=0; i<result.length-1; i++)
                {
                    int j = result[i]; 
                    int k = result[i+1]; 

                    if( k < j )
                    {
                        result[i] = k; 
                        result[i+1] = j; 
                    }  
                    upCounter++;   
                } //end of for loop
            } //end of while loop

        }
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Sorted with Bubble Sort after "+upCounter+" iterations"); 

        return arr;

    } //end of bubble sort

    public static ArrayList selectionSort( int[] arr )
    {
        ArrayList<Integer> temp = new ArrayList(); 

        for(int i = 0; i<arr.length; i++)
        {
            temp.add(arr[i]);     
        } //make arraylist of inserted data values

        int startFrom = 0; 
        int iterationCount = 0;   

        while( !(isIncreasingArrayList(temp) ) )
        {
            int minValue = temp.get(startFrom); 
            int minValueIteration = startFrom; 

            for(int a = startFrom; a < temp.size()-1; a++)
            {
                if( temp.get(a+1) <= minValue) 
                {
                    minValue = temp.get(a+1); 
                    minValueIteration = a+1; 

                }

            } //end of for loop

            temp.remove(minValueIteration); 
            temp.add(startFrom, minValue); 

            // System.out.println("Iteration Count: "+iterationCount + "\n" +
            //                    "Array: "+temp); 

            iterationCount++;

            startFrom++;

           
        } //end of while loop
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Sorted with Selection Sort after "+iterationCount+" iterations"); 

        return temp;
    } //end of selection sort 

    public static ArrayList insertionSort(int[] arr)
    {
        ArrayList<Integer> temp = new ArrayList(); 
        int iterationCount = 0;

        for(int a = 0; a<arr.length; a++)
        {
            temp.add(arr[a]);     
        } //make arraylist of inserted data values

        for(int i=1; i<temp.size(); i++)
        {

            int previous = temp.get(i-1);
            int current = temp.get(i); 
            int currentIteration = i; 

            while(currentIteration > 0 && current<previous)
            {
                temp.set(currentIteration, previous);
                temp.set(currentIteration-1, current);
                currentIteration--; 
                current = temp.get(currentIteration); 
                if(currentIteration>0) { previous = temp.get(currentIteration-1); } 

                //  System.out.println("Iteration Count: "+iterationCount + "\n" +
                //                      "Array: "+temp); 

                iterationCount++;                    

            } // end of while loop

        }//end of for loop
        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Sorted with Insertion Sort after "+iterationCount+" iterations");
        return temp;

    }//end of insertion sort

    public static ArrayList mergeSort(int[] arr)
    {
        ArrayList<int[]> temp = new ArrayList(); 
        ArrayList<int[]> temps = new ArrayList();
        ArrayList<int[]> temps2 = new ArrayList();

        int[] firstArray = arr; 
        final int originalSize = firstArray.length;

        temp.add(firstArray); 

        temps= mergeSortDivide(temp, originalSize); 

        return temps; 

    } //end of merge sort

    public static ArrayList mergeSortDivide(ArrayList arr, int size)
    {
        ArrayList<int[]> basic = new ArrayList();
        ArrayList<int[]> temp = arr; 
        ArrayList<int[]> newArrayList = new ArrayList();
        final int originalSize = size; 
        int divisionCounter = 0; 

        ArrayList<Integer> arrayList1 = new ArrayList();
        ArrayList<Integer> arrayList2 = new ArrayList(); 

        int[] basicArray = new int [0];
        basic.add(basicArray);

        
        for(int[] a: temp)
        {

            int leftIndex = 0;
            int rightIndex = a.length-1; 
            arrayList1.clear();
            arrayList2.clear();

            if(leftIndex < rightIndex)
            {
                int halfIndex = (rightIndex/2)+1; 

                for(int i = 0; i<halfIndex; i++)
                {

                    arrayList1.add( a[i] ) ;     
                }

                for(int j = halfIndex; j<a.length; j++)
                {   

                    arrayList2.add( a[j] ) ;    
                }

                int arrayList1Size = arrayList1.size();
                int arrayList2Size = arrayList2.size();

                int[] array1 = new int [arrayList1Size]; 
                int[] array2 = new int [arrayList2Size]; 

                for(int k = 0; k<arrayList1Size; k++)
                {
                    array1[k] = arrayList1.get(k);
                }

                for(int l = 0; l<arrayList2Size; l++)
                {
                    array2[l] = arrayList2.get(l);
                }

                newArrayList.add(array1);
                newArrayList.add(array2); 

            } //end of if left index is less than right index
            else
            {
                newArrayList.add(a); 
                divisionCounter++;    
            }

           
        }//end of for loop
        
        System.out.println("Dividing with MergeSort: " + printArrayList(newArrayList));

        if(divisionCounter >= originalSize){mergeSortConquer(newArrayList, originalSize, 1); return newArrayList; }

        else {  mergeSortDivide(newArrayList, originalSize); }


        return basic;   
    } //end of merge sort DIVIDE

    public static ArrayList mergeSortConquer(ArrayList arr, int size, int iterat)
    {

        ArrayList<int[]> temp = arr; 
        final int originalSize = size;    
        ArrayList<String> basic = new ArrayList();
        ArrayList<int[]> newArrayList = new ArrayList();

        basic.add("///////////////////////////////////////////////////////////////////////////////////////////");

        ArrayList<Integer> aArray = new ArrayList();  
        ArrayList<Integer> bArray = new ArrayList(); 

        aArray.clear(); 
        bArray.clear(); 

        if(temp.size() == 1) { return newArrayList; }

        int iterations = iterat;

        int counter = (int)java.lang.Math.pow(2.0, (double)iterations );

        for(int q = 0; q<temp.size(); q+=2)
        {

            int[] a = temp.get(q);

            aArray.clear(); 
            bArray.clear(); 

            if(  !(q>=temp.size()-1 )   ) //check if it has a partner to be compared to
            {
                //if so? compare them with the for loops

                int[] b = temp.get(q+1);

                for(int x = 0; x<a.length; x++)
                {
                    aArray.add(a[x]);   
                } 
                for(int y = 0; y<b.length; y++)
                {
                    bArray.add(b[y]);   
                }                

                int totalLength = a.length+b.length; 
                int[] groupedArray = new int [totalLength];

                for(int i = 0; i<totalLength; i+=1)
                {

                    if(aArray.size() > 0 && bArray.size() > 0 ) //do the arraylists have values in them?
                    {

                        int aValue = aArray.get(0); 
                        int bValue = bArray.get(0); 

                        if(aValue<=bValue) { 
                            groupedArray[i] = aValue;
                            aArray.remove(0);
                            if(totalLength == 2)
                            {
                                groupedArray[i+1] = bValue;
                                bArray.remove(0);
                            }

                        }
                        else {
                            groupedArray[i] = bValue; 
                            bArray.remove(0); 
                            if(totalLength==2)
                            {
                                groupedArray[i+1] = aValue;
                                aArray.remove(0);
                            }

                        }
                    } //end of if both are greater

                    else //they both are empty
                    {

                        ArrayList<Integer> cArray = new ArrayList(); 
                        cArray.clear(); //clear anything that was still in it 

                        int newSize = 0; 
                        int minimum = 0;
                        int minimumIndex = 0; 
                        int whileLooper = 0; 

                        if(aArray.size()>0 || bArray.size()>0)
                        {

                            if(aArray.size() == 0) { cArray = bArray; newSize = bArray.size(); minimum = bArray.get(0);} 
                            else if(bArray.size() == 0) { cArray = aArray; newSize = aArray.size(); minimum = aArray.get(0);} 

                            while(newSize > 1)
                            {
                                minimumIndex = 0; 
                                minimum = cArray.get(0);

                                for(int z = 1; z<newSize; z++)
                                {
                                    if(cArray.get(z) <= minimum) { minimum = cArray.get(z); minimumIndex = z; } 
                                }
                                groupedArray[i+whileLooper] = minimum; 
                                cArray.remove(minimumIndex);
                                newSize = cArray.size(); //changing after this
                                whileLooper++;
                            } //end of while

                            groupedArray[totalLength-1] = cArray.get(minimumIndex);  
                            cArray.remove(minimumIndex); 

                        } //only do this while loop if there are left overs

                    }// END OF ELSE //they aren't both greater than zero (aka one is empty)
                }//end of first for loop 
                newArrayList.add(groupedArray); //this is only done if it had a partner 
            } //end of if checking if it had a partner
            else 
            {
                newArrayList.add(a); 
            }

        } //end of for loop

        System.out.println("Merging With MergeSort: " + printArrayList(newArrayList));

        iterations++;
        mergeSortConquer(newArrayList, originalSize,iterations);

          
        //   System.out.println("Sorted With MergeSort After "+(iterations+(iterations-1))+" iterations"+"\n" + printArrayList(newArrayList));

        return basic; 
    } //end of mergeSortConquer

}