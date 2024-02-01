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
}
