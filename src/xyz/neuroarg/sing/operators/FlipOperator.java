package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

public class FlipOperator extends LyricOperators {
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        adder.add(new StringBuilder(oldresult.asString()).reverse().toString());
    }
}
