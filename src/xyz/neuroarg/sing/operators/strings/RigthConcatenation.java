package xyz.neuroarg.sing.operators.strings;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

public class RigthConcatenation extends LyricOperators {
    
    
    String toConcate;
    public RigthConcatenation(String toConcate){
        this.toConcate = toConcate;
    }
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        adder.add(oldresult.asString()+toConcate);
    }
    
}
