package xyz.neuroarg.sing.operators.strings;

import xyz.neuroarg.sing.operators.MultipleOperator;

/**
 * if multiply mean add "x" and the number (or *)
 */
public class XMultiplication extends MultipleOperator {
    
    public XMultiplication(String toConcate) {
        super(
                new RigthConcatenation("x"+toConcate),
                new RigthConcatenation("*"+toConcate)
        );
    }
    
}
