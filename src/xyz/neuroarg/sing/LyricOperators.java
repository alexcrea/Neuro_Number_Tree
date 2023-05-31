package xyz.neuroarg.sing;

import java.math.BigInteger;
import java.util.Set;

public abstract class LyricOperators {
    
    public abstract void interpretLyric(ResultAdder adder, NumberResult oldresult);
    
    public void interpretLyrics(NeuroSama neuroSama, Set<NumberResult> oldresults){
        ResultAdder adder = new ResultAdder(neuroSama.getResults(),this);
        for (NumberResult result : oldresults) {
            adder.setOldresult(result);
            interpretLyric(adder,result);
        }
    }
    
    public static class ResultAdder{
        
        protected Object parent;
        Set<NumberResult> result;
        protected NumberResult oldresult;
        public ResultAdder(Set<NumberResult> result, Object parent){
            this.result = result;
            this.parent = parent;
        }
        
        public void setResult(Set<NumberResult> result) {
            this.result = result;
        }
        public Set<NumberResult> getResult() {
            return result;
        }
        
        public void setOldresult(NumberResult oldresult) {
            this.oldresult = oldresult;
        }
        
        public void setParent(Object parent) {
            this.parent = parent;
        }
        
        public void add(NumberResult newresult){
            if(!newresult.validate())
                return;
            result.add(newresult);
            newresult.setCode(this.oldresult.getCode()+","+this.parent.getClass().getSimpleName());
        }
        public void add(String resultstr){
            add(new NumberResult(resultstr));
        }
        public void add(BigInteger resultlong){
            add(new NumberResult(resultlong));
        }
        
        
    }
    
    
}
