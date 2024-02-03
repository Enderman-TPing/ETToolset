package io.github.ettoolset.algorithms.math;

public class Prime {
    public static boolean isPrime(int k){
        for (int i=2;i*i<=k;i++){
            if(k%i==0){
                return false;
            }
        }
        return true;
    }

    public static int greatestCommonDivisorOf(int a,int b) {
        int m=a,n=b;
        while(n!=0){
            int temp=m%n;
            m=n;
            n=temp;
        }
        return m;
    }

    public static int leastCommonMultipleOf(int a,int b){
        return a*b/greatestCommonDivisorOf(a,b);
    }
}
