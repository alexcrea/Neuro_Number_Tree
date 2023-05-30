package xyz.neuroarg.sing.operators.strings;

import xyz.neuroarg.sing.LyricOperators;
import xyz.neuroarg.sing.NumberResult;

public class MoveExistingToLeft extends LyricOperators {
    
    String tosearch;
    public MoveExistingToLeft(String tosearch){
        this.tosearch = tosearch;
    }
    
    @Override
    public void interpretLyric(ResultAdder adder, NumberResult oldresult) {
        StringBuilder stb = new StringBuilder(oldresult.asString());
        int indexof17 = stb.indexOf(this.tosearch);
        if(indexof17 >= 0){
            stb.replace(indexof17,indexof17+2,"");
            stb.insert(0,this.tosearch);
            adder.add(stb.toString());
        }
        
    }
}
