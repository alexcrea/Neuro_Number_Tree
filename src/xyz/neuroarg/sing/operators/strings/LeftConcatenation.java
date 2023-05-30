package xyz.neuroarg.sing.operators.strings;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

public class LeftConcatenation extends LyricOperators {
    
    String toConcate;
    public LeftConcatenation(String toConcate){
        this.toConcate = toConcate;
    }
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        adder.add(toConcate+oldresult.asString());
    }
    
}
