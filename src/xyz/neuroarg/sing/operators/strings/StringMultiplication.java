package xyz.neuroarg.sing.operators.strings;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

/**
 * concat to an empty string the current string  "number" times
 */
public class StringMultiplication extends LyricOperators {
    
    long number;
    public StringMultiplication(long number){
        this.number = number;
    }
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < number; i++) {
            stb.append(oldresult.asString());
        }
        adder.add(stb.toString());
    }
    
    
}
