package xyz.neuroarg.sing.operators.strings;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

public class ReplaceAllOperator extends LyricOperators {
    
    String from;
    String to;
    public ReplaceAllOperator(String from, String to){
        this.from = from;
        this.to = to;
    }
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        adder.add(oldresult.asString().replaceAll(from,to));
    }
}
