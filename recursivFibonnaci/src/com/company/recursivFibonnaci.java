package com.company;

public class recursivFibonnaci {
    public static long recursivFib(long n){
        if ((n == 0) || (n==1))
            return n;
        else
            return recursivFib(n-1) + recursivFib(n-2);
    }

    public static void main(String[] args) {
	// write your code here
        long y =10;
        System.out.println("The " +y+"th term of the Fibonacci sequence is :" + recursivFib(y));

    }
}
