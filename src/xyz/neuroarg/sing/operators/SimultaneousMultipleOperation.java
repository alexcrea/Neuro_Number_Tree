package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NeuroSama;
import xyz.neuroarg.sing.NumberResult;

import java.util.ArrayList;
import java.util.List;

public class SimultaneousMultipleOperation extends MultipleOperator{
    
    public SimultaneousMultipleOperation(LyricOperators... operators){
        super(operators);
        
    }
    
    @Override
    public void interpretLyrics(NeuroSama neuroSama, List<NumberResult> results) {
        ResultAdder adder = new ResultAdder(null,this);
        for (LyricOperators operator : operators) {
            adder.setResult(new ArrayList<>());
            adder.setParent(operator);
            for (NumberResult result : results) {
                operator.interpretLyric(adder,result);
            }
            results = adder.getResult();
        }
        //add code and add all
        neuroSama.getResults().addAll(results);
        
    }
    
    /*public static class FakeAdder extends ResultAdder{
        
        ArrayList<NumberResult> results;
        public void reset(){
            this.results = new ArrayList<>();
        }
        
        
        public ArrayList<NumberResult> getResults() {
            return results;
        }
        
        @Override
        public void add(NumberResult result) {
            results.add(result);
            result.setCode(this.oldresult.getCode()+","+this.parent.getClass().getSimpleName());
        }
    }*/
    
}
