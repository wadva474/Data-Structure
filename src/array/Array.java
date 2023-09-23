package array;

import java.util.*;

public class Array {

    public static void main(String[] args) {
        int[] arr = {1, 7, -2, -5, 10, -1};
        
    }

    //Remove Even Element from an array O(n)
    public static int[] removeEven(int[] arr) {
        int oddElement = 0;
        for (int k : arr) {
            if (k % 2 == 1) {
                oddElement++;
            }
        }
        int[] result = new int[oddElement];
        int resultCount = 0;
        for (int j : arr) {
            if (j % 2 == 1) {
                result[resultCount++] = j;
            }
        }
        return result;
    }

    // merge arr1 and arr2 into a new result array that is sorted O(N+M)
    public static int[] mergeArrays(int[] arr1, int[] arr2) {
        int s1 = arr1.length;
        int s2 = arr2.length;
        int[] arrayResult = new int[s1 + s2];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < s1 && j < s2) {
            if (arr1[i] < arr2[j]) {
                arrayResult[k++] = arr1[i++];
            } else {
                arrayResult[k++] = arr2[j++];
            }
        }

        while (i < s1) {
            arrayResult[k++] = arr1[i++];
        }

        while (j < s2) {
            arrayResult[k++] = arr2[j++];
        }
        return arrayResult;
    }


    //Find two elements in an array that adds up to a number(n)
    public static int[] findSumOptimal(int[] arr, int n) {
        int[] result = new int[2];
        int frontPointer = 0;
        int backPointer = arr.length - 1;
        int sum;

        Arrays.sort(arr);
        while (frontPointer != backPointer) {
            sum = arr[frontPointer] + arr[backPointer];
            if (sum < n) {
                frontPointer++;
            } else if (sum > n) {
                backPointer--;
            } else {
                result[0] = arr[frontPointer];
                result[1] = arr[backPointer];
                return result;
            }
        }
        return arr;
    }

    //Product of all item in the array excluding current position
    public static int[] findProduct(int[] arr) {
        int i;
        int product = 1;
        int length = arr.length;
        int[] result = new int[length];

        for (i = 0; i < length; i++) {
            result[i] = product;
            product *= arr[i];
        }

        product = 1;

        for (i = arr.length - 1; i >= 0; i--) {
            result[i] *= product;
            product *= arr[i];
        }

        return result;
    }

    public static int findMinimum(int[] arr) {
        int minimum = arr[0];
        for (int i =1; i<arr.length; i++){
            if (arr[i] < minimum){
                minimum = arr[i];
            }
        }
        return minimum;
    }

    public static int findFirstUnique(int[] arr) {
        HashMap<Integer, Integer> valueMap = new HashMap<>();
        for (int j : arr) {
            valueMap.put(j, 0);
        }
        for (int j : arr) {
            valueMap.put(j, valueMap.get(j) + 1);
        }
        for (int j : arr) {
            if (valueMap.get(j) == 1) {
                return j;
            }
        }
        return -1;
    }


    public int findSecondMaximum(int[] arr)
    {
        int indexOfLargest = 0;
        int largest = arr[0];
        //Gets the First Largest number
        for (int i =0; i < arr.length; i ++){
            if(arr[i] > largest){
                largest = arr[i];
                indexOfLargest = i;
            }
        }
        //Change the Largest to zero so it becomes the smallest
        arr[indexOfLargest] = 0;
        largest = arr[0];
        //Get the new Largest
        for (int j : arr) {
            if (j > largest) {
                largest = j;
            }
        }
        return largest;
    }

    //Right rotate an array
    public static int[] rotateArray(int[] arr) {
        int lastIndex = arr.length - 1;
        int lastElement = arr[lastIndex];
        for (int i = lastIndex; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = lastElement;
        return arr;
    }

    public static void reArrange(int[] arr) {
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {   // if negative number found
                if (i != j) {
                    int temp = arr[i];
                    arr[i] = arr[j]; // swapping with leftmost positive
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    public static void maxMin(int[] arr) {
        int arraySize = arr.length;
        int midPoint = arraySize/2;
        int begining = 0 ;
        int end = arraySize - 1 ;
        int currentPosition = 0;
        int [] outPutArray= new int [arr.length];
        for (int i = 0; i< midPoint; i++){
            outPutArray[currentPosition] = arr[end];
            outPutArray[currentPosition+1]= arr[begining];
            currentPosition+= 2;
            end --;
            begining++;
        }
        if(arraySize % 2 == 1){
            outPutArray[currentPosition] = arr[midPoint];
        }
        System.arraycopy(outPutArray, 0, arr, 0, arraySize);
    }


    //KADANE'S ALGORITHM
    //DYNAMIC PROGRAMMING
    //local_maximum at index i is the maximum of A[i] and the sum of A[i] and local_maximum at index i-1.
    public static int findMaxSumSubArray(int[] arr) {
        if (arr.length < 1) {
            return 0;
        }
        int localMaximum = 0;
        int maximum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            localMaximum= Math.max(arr[i], arr[i]+localMaximum);
            if (localMaximum > maximum){
                maximum = localMaximum;
            }
        }
        return maximum;
    }


}
