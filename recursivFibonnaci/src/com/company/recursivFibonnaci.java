package com.company;

/**
 * a simple java program
 * using a recursive method
 * to calculate the Fibonnaci sequence
 * @author Gregory Lauture
 * @version 1.0
 * since 8/30/2022
 */
public class recursivFibonnaci {
    /**
     * Simple recursive method
     * using an input number
     * return the Fibonnaci
     * @param n
     * @return
     */
    public static long recursivFib(long n){
        if ((n == 0) || (n==1))
            return n;
        else
            return recursivFib(n-1) + recursivFib(n-2);
    }

    /**
     * the demo main class
     * @param args
     */
    public static void main(String[] args) {
	// write your code here
        long y =10;
        System.out.println("The " +y+"th term of the Fibonacci sequence is :" + recursivFib(y));

    }
}
