package io.github.ettoolset.algorithms.math;

public class Fraction {
    private int numerator;
    private int dominator;

    public Fraction(){}
    public Fraction(int dominator,int numerator){
        this.dominator=dominator;
        this.numerator=numerator;
        if(dominator<0){
            this.dominator*=-1;
            this.numerator*=-1;
        }
        int a=Prime.greatestCommonDivisorOf(Math.abs(dominator),Math.abs(numerator));
        this.numerator/=a;
        this.dominator/=a;
    }
    public int getNumerator(){
        return numerator;
    }
    public int getDominator(){
        return dominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }
    public void setDominator(int dominator){
        this.dominator=dominator;
    }
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Fraction)){
            return false;
        }else if(((Fraction) obj).getDominator()==this.dominator&&((Fraction) obj).getNumerator()==this.numerator){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        if(this.dominator!=1) {
            return this.numerator + "/" + this.dominator;
        }else{
            return String.valueOf(this.numerator);
        }
    }

    public Fraction add(int a){
        return new Fraction(this.dominator,this.numerator+a*this.dominator);
    }
}
