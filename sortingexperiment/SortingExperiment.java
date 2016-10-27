/*
 * Jefferson Zhumi
 * test experiment for sorting methods
 * summer 2015 
 */
package sortingexperiment;

/**
 *
 * @author Jefferson
 */
public class SortingExperiment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int k = 1; k <= 100; k++) {
            int size = 200000;     // change this number to change the size of the random array
            int[] a = new int[size];
            int[] temp = new int[a.length];  // empty temporary array, the same size and type as a[]

            // fill the array with random integers
            for (int i = 0; i < a.length; i++) {
                a[i] = (int) (Math.random() * 100000 + 1);
            }

            // get the start time in nanoseconds
            long startTime = System.nanoTime();

            /**
             * *UNCOMMENT A SORT METHOD TO EXPERIMENT**
             */
            //mergeSort(a, temp, 0, (a.length - 1)); //merge Sort
            //quickSort(a, 0, a.length - 1);    //quick sort
            //selSort(a, (a.length));   //selection sort
            //inSort(a, (a.length));    //insertion sort
            /**
             * *READ ABOVE**
             */
            
            // get the end time in nanoseconds
            long endTime = System.nanoTime();

            // calculate elapsed time in nanoseconds
            long duration = endTime - startTime;

            // print the elapsed time in seconds   (nanaoseconds/ 1 billion)
            System.out.printf("%12.8f %n", (double) duration / 100000000);

            //uncomment to print the set of arrays
            //printtArray(a);
            // write the sorted array to a data file 
            // WARNING the file will be 5.7 MB for 1 million items
            //writeLines(a, "after.txt");
        }
    }// end main()
    //*******************************************************************

    public static void mergeSort(int[] a, int[] temp, int low, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted

        int mid;  // the middle of the array – last item in low half

        // if high > low then there is more than one item in the list to be sorted
        if (high > low) {

            // split into two halves and mergeSort each part
            // find middle (last element in low half)   
            mid = (low + high) / 2;
            mergeSort(a, temp, low, mid);
            mergeSort(a, temp, mid + 1, high);

            // merge the two halves back together, sorting while merging
            merge(a, temp, low, mid, high);
        } // end if 

        return;
    }// end mergerSort()
    //********************************************************************
    /* This method merges the two halves of the set being sorted back together.
     * the low half goes from a[low] to a[mid]
     * the high half goes from a[mid+1] to a[high]
     * (High and low only refer to index numbers, not the values in the array.)
     * 
     * The work of sorting occurs as the two halves are merged back into one 
     * sorted set.
     * 
     * This version of mergesort copies the set to be sorted into the same 
     * locations in a temporary array, then sorts them as it puts them back.
     * Some versions of mergesort sort into the temporary array then copy it back.
     */

    public static void merge(int[] a, int[] temp, int low, int mid, int high) {
        //  low is the low index of the part of the array to be sorted
        //  high is the high index of the part of the array to be sorted
        //  mid is the middle of the array – last item in low half

        // copy the two sets from a[] to the same locations in the temporary array
        for (int i = low; i <= high; i++) {
            temp[i] = a[i];
        }

        //set up necessary pointers 
        int lowP = low;         // pointer to current item in low half
        int highP = mid + 1;    // pointer to current item in high half
        int aP = low;           // pointer to where each item will be put back in a[]

        // while the pointers have not yet reached the end of either half)
        while ((lowP <= mid) && (highP <= high)) {

            // if current item in low half <= current item in high half 
            if (temp[lowP] <= temp[highP]) {
                // move item at lowP back to array a and increment low pointer
                a[aP] = temp[lowP];
                lowP++;
            } else {
                // move item at highP back to array a and increment high pointer
                a[aP] = temp[highP];
                highP++;
            } // end if..else

            // increment pointer for location in original array
            aP++;
        } // end while

        /* When the while loop is done, either the low half or the high half is done 
         * We now simply move back everything in the half not yet done.
         * Remember, each half is already in order itself.
         */
        // if lowP has reached end of low half, then low half is done, move rest of high half
        if (lowP > mid) {
            for (int i = highP; i <= high; i++) {
                a[aP] = temp[i];
                aP++;
            } // end for
        } else // high half is done, move rest of low half
        {
            for (int i = lowP; i <= mid; i++) {
                a[aP] = temp[i];
                aP++;
            }// end for
        }
        return;
    } // end merge()
    // *************************************************************

    // the recursive quicksort method, which calls the partition method
    public static void quickSort(int[] a, int startIndex, int endIndex) {
        int pivotIndex; // the index of pivot returned by the quicksort partition
        // if the set has more than one element, then partition
        if (startIndex < endIndex) {
            // partition and return the pivotIndex
            pivotIndex = partition(a, startIndex, endIndex);
            // quicksort the low set
            quickSort(a, startIndex, pivotIndex - 1);
            // quiclsort the high set
            quickSort(a, pivotIndex + 1, endIndex);
        } // end if
    } // end quickSort()
    
/* This method sorts an array of Strings line by line 
     * using an insertion sort. 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */

    public static void inSort(int[] a, int count) {
        int value; //variable from the unsorted list to be inserted into the sorted list

        int j;//j is a pointer to an item in the sorted list

        //iterate the entire list       
        for (int i = 1; i < count; i++) {
            value = a[i]; //next item from the original list, will be added to newlist
            j = i - 1; //set the pointer to the beginning of the unsorted list
            //checks if the items of j are >= than 0
            while (j >= 0) {
                if (value > a[j]) { //compares the string lexicographally 
                    break;//leaves the loop
                }
                a[j + 1] = a[j];//moves the current item to the right
                j--;//moves left to the next item in the array
            }
            //insert the correct value in the spot
            a[j + 1] = value;
        }

    }
    /* This method sorts an array of Strings line by line 
     * using a selection sort. 
     * The first parameter refers to the array in the main method.  
     * The second parameter is the number of elements in the array that 
     * actually contain data
     */

    public static void selSort(int[] a, int count) {
        int min; //location of the minimum value in the remainder of the list

        //the for loop is a pass through the array to the second to last element
        for (int spot = 0; spot < count; spot++) { //the outer loop
            min = spot; //initialize the minimum to be rhe first value in the remainder of the list

            //i iterates from spot to the end of list-one pass
            for (int i = spot + 1; i < count; i++) {

                //compares a.array to min location
                if (a[i] < a[min]) {
                    min = i; //
                }//end if
            }//end for

            //swap the value in spot with the pass minimum 
            int temp = a[min];
            a[min] = a[spot];
            a[spot] = temp;

        }//end spot
    }// end selSort()
    
    // This method performs quicksort partitioning on a set of elements in an array.

    public static int partition(int[] a, int startIndex, int endIndex) {

        int pivotIndex;             // the index of the chosen pivot element
        int pivot;                  // the value of the chosen pivot
        int midIndex = startIndex;  // boundary element between high and low sets

        // select the center element in the set as the pivot by integer averaging
        pivotIndex = startIndex + (int) (Math.random() * ((endIndex - startIndex) + 1));
        pivot = a[pivotIndex];

        // put the pivot at the end of the set so it is out of the way
        swap(a, pivotIndex, endIndex);

        // iterate the set, up to but not including last element
        for (int i = startIndex; i < endIndex; i++) {
            // if a[i] is less than the pivot
            if (a[i] < pivot) {

                // put a[i] in the low half and increment current Index
                swap(a, i, midIndex);
                midIndex = midIndex + 1;
            } // end if
        } // end for 

        // partitioning complete -- move pivot from end to middle
        swap(a, midIndex, endIndex);

        // return index of pivot
        return midIndex;

    }

    // This method swaps two elements in an integer array
    public static void swap(int[] a, int first, int second) {

        int c;  // a catalyst variable used for the swap

        c = a[first];
        a[first] = a[second];
        a[second] = c;

    }

    //This method prints the array(a)
    public static void printtArray(int[] a) {
        // iterate and print the array on one line
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    /* This method writes an int array to a text data file.  
     * The first parameter is the array. The second parameter
     * is the file name.
     */
    public static void writeLines(int[] a, String fileName) throws Exception {
        // create a File class object with the given file name
        java.io.File out = new java.io.File(fileName);
        // Create a PrintWriter output stream and link it to the File object
        java.io.PrintWriter outfile = new java.io.PrintWriter(out);

        // write the elements of an int array, separated by spaces
        for (int i = 0; i < a.length; i++) {
            outfile.print(a[i] + " ");
        }

        // print a newline at the end of the list of integers
        outfile.println();

        outfile.close();

    } // end writeTextArray()

} // end class MergeSortDemo
