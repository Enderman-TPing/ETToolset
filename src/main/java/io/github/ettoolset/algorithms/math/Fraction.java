package io.github.ettoolset.algorithms.math;

public class Fraction {
    private int numerator;
    private int dominator;

    public Fraction(){}
    public Fraction(int dominator,int numerator){
        this.dominator=dominator;
        this.numerator=numerator;
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
        return this.numerator+"/"+this.dominator;
    }

//    public Fraction add(){}
}
