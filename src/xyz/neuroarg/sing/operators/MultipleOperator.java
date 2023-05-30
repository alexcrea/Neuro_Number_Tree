package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NeuroSama;
import xyz.neuroarg.sing.NumberResult;

import java.util.List;

public class MultipleOperator extends LyricOperators {
    
    LyricOperators[] operators;
    public MultipleOperator(LyricOperators... operators){
        this.operators = operators;
    }
    
    @Override//not used
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {}
    
    @Override
    public void interpretLyrics(NeuroSama neuroSama, List<NumberResult> oldresults) {
        for (LyricOperators operator : operators) {
            operator.interpretLyrics(neuroSama,oldresults);
        }
    }
    
}
