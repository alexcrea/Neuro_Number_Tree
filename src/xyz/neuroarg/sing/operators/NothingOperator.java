package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

/**
 * let the NumberResult unchanged
 */
public class NothingOperator extends LyricOperators {
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        adder.add(oldresult);
    }
    
}
