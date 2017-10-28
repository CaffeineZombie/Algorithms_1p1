package com.example.Algorithms_1p1;

import java.util.Random;

public class Section1 {
    /**
     * This file holds the written examples from Algorithms 4th Edition, Sedgewick and Wayne. All content based on
     * examples by authors. This is simply an exercise in creating and understanding basic examples through usage.
     */
    public static void main(String[] args) {
        //Define arbitrary array length to create set of values to run tests on.
        int arrayLength = 1000000;
        double arbitraryArray[] = createTestArray(arrayLength);

        //for (int i = 0; i < arbitraryArray.length; i++) {
        //    System.out.print(arbitraryArray[i] + "\n");
        //}
        //Testing the getMax method
        double maximum = getMax(arbitraryArray);
        System.out.print("\nMaximum: " + maximum);

        //Testing the getAverage method
        double average = getAverage(arbitraryArray);
        System.out.print("\nAverage: " + average);
    }

    //Array Functions

    /**
     * getMax method used to find the maximum number within an array of size arrayLength
     *
     * @param arrayOfValues is the set array of doubles on which the getMax computation will be run
     * @return the maximum value stored in the array.
     */
    private static double getMax(double[] arrayOfValues) {
        double max = arrayOfValues[0];
        for (int i = 1; i < arrayOfValues.length; i++) {
            if (arrayOfValues[i] > max) {
                max = arrayOfValues[i];
            }
        }
        return max;
    }

    /**
     * getAverage method is used to find the average value of array contents
     *
     * @param arrayOfValues is the set array of doubles on which the getAverage computation will be run
     * @return average value of doubles within the given array
     */
    private static double getAverage(double[] arrayOfValues) {
        double sum = 0.0;
        for (double i : arrayOfValues) {
            //since the for each loop uses the i as the actual value, no need to access the array again directly.
            sum += i;
        }
        return (sum / arrayOfValues.length);
    }

    /**
     * This simpled method is used to create an exact copy of an array to a new array object to avoid changing contents
     * of the original data set. This will return a warning in IntelliJ 'Manual array copy.' assuming a Java language
     * method is already in existence.
     *
     * @param arrayOfValues is the array to be copied from into the new array
     * @return an exact copy of the desired array to a new variable for calculation and manipulation.
     */
    public static double[] duplicateArray(double[] arrayOfValues) {
        //Initialized a new array to populated
        double[] copiedArray = new double[arrayOfValues.length];
        //Copy values from existing array to new array
        for (int i = 0; i < arrayOfValues.length; i++) {
            copiedArray[i] = arrayOfValues[i];
        }
        return copiedArray;
    }

    /**
     * This method is used to reverse the order of elements in an array by swapping position index
     * a[i] with a[a.length - 1 - i]
     *
     * @param arrayOfValues if the passed in array to apply the reversal to
     * @return the array of reversed values;
     */
    public static double[] reverseArrayValues(double[] arrayOfValues) {
        for (int i = 0; i < (arrayOfValues.length / 2); i++) {
            //Copy the double at position i in the original array
            double valueAtPositionI = arrayOfValues[i];
            //Swap out the double stored in the iterative index from the end of the array to the position of the iterator
            arrayOfValues[i] = arrayOfValues[arrayOfValues.length - 1 - i];
            //Replace the value at the end array iterator position with the value saved from position i
            arrayOfValues[arrayOfValues.length - 1 - i] = valueAtPositionI;
        }
        return arrayOfValues;
    }
    /** TODO: Try making the reversal method using an iterator instead of the above method to improve performance**/

    /**
     * This method is used for matrix multiplication
     *
     * @param arrayOfValues1 is the first array to be multiplied
     * @param arrayOfValues2 is the second array to be multipled
     * @return result is the end product of the matrix multiplication.
     */
    public static double[][] multiplyMatricies(double[][] arrayOfValues1, double[][] arrayOfValues2) {
        //create an arry to hold the values of the products
        double[][] result = new double[arrayOfValues1.length][arrayOfValues2.length];
        //iterate through the rows of the first array
        for (int i = 0; i < arrayOfValues1.length; i++) {
            //iterate through the columns of the array
            for (int j = 0; j < arrayOfValues2.length; j++) {
                //compute the matrix math for dot product result[i][j] = aA + bB + cC...
                for (int k = 0; k < arrayOfValues1.length; k++) {
                    result[i][j] += arrayOfValues1[i][k] * arrayOfValues2[k][j];
                }
            }
        }
        return result;
    }


    //Utility Functions

    /**
     * createTestArray is used to create an array of length arrayLength of random number on which to run tests.
     *
     * @param arrayLength is used to set the size of the array to run tests on
     * @return an array of length arrayLength populated with random numbers. No scaling or seed set, double values between 0 and 1.
     */
    private static double[] createTestArray(int arrayLength) {
        double arbitraryArray[] = new double[arrayLength];
        for (int i = 0; i < arrayLength; i++) {
            arbitraryArray[i] = getRandomNumber();
        }
        return arbitraryArray;
    }

    /**
     * Simple random number generator of doubles between 0 and 1
     *
     * @return a random double value between 0 and 1. No seed set.
     */
    private static double getRandomNumber() {
        Random rand = new Random();
        return rand.nextDouble();
    }
}
