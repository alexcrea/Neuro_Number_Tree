package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NeuroSama;
import xyz.neuroarg.sing.NumberResult;

import java.util.List;

/**
 * let the NumberResult unchanged
 */
public class NothingOperator extends LyricOperators {
    
    @Override
    @Deprecated
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        adder.add(oldresult);
    }
    
    @Override
    public void interpretLyrics(NeuroSama neuroSama, List<NumberResult> oldresults) {
        neuroSama.getResults().addAll(oldresults);//it do not update the code but let ignore that for perfomance issus
    }
}
