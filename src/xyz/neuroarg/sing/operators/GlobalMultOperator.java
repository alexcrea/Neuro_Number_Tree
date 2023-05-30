package xyz.neuroarg.sing.operators;

import xyz.neuroarg.sing.operators.numericals.NumericalMultiplication;
import xyz.neuroarg.sing.operators.strings.StringMultiplication;
import xyz.neuroarg.sing.operators.strings.XMultiplication;

/**
 * used to do every mult operator know
 */
public class GlobalMultOperator extends MultipleOperator {
    
    public GlobalMultOperator(int number) {
        super(  new NumericalMultiplication(number),
                new StringMultiplication(number),
                new XMultiplication(String.valueOf(number)));
        
    }
}
