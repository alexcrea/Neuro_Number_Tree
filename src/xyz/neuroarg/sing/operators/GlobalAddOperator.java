package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.operators.numericals.NumericalAddition;
import xyz.neuroarg.sing.operators.strings.LeftConcatenation;
import xyz.neuroarg.sing.operators.strings.RigthConcatenation;

/**
 * used to do every add operator know
 */
public class GlobalAddOperator extends MultipleOperator {
    
    public GlobalAddOperator(int number){
        super(  new NumericalAddition(number),
                new LeftConcatenation(String.valueOf(number)),
                new RigthConcatenation(String.valueOf(number)));
    }
    
}
