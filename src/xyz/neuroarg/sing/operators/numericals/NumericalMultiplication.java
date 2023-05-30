package xyz.neuroarg.sing.operators.numericals;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

import java.math.BigInteger;

public class NumericalMultiplication extends LyricOperators {
    
    BigInteger number;
    public NumericalMultiplication(int number){
        this.number = BigInteger.valueOf(number);
    }
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        BigInteger old = oldresult.asBigInt();
        if(old != null)
            adder.add(old.multiply(this.number));
    }
}
