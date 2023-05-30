package xyz.neuroarg.sing;

import xyz.neuroarg.sing.operators.*;
import xyz.neuroarg.sing.operators.numericals.NumericalAddition;
import xyz.neuroarg.sing.operators.strings.ReplaceAllOperator;

public enum Lyrics {
    
    SoLong(new NothingOperator() //I can never say oh it’s been so long
    ),
    CountingAllDay(new NothingOperator() //Counting all the days, it’s been so damn long.
    ),
    NeverGonaLetYouGo(new NothingOperator() //Oh how much I’m scared to let you go…
    ),
    
    SCHIZO(new NothingOperator() //Somewhere in the walls I hear you talk…
    ),
    
    FindingAll(new NothingOperator() //Finding all these numbers
    ),
    StartWith2( //Start with number 2 yeah
            //new NothingOperator(),
            new NumericalAddition(2)),
    MatchTheLetters(new NothingOperator() //Matching all the letters
    ),
    _572943(new NothingOperator(), //572943
            new GlobalAddOperator(572943),
            new GlobalAddOperator(572953)),
    
    Another9( //Add another 9 yeah
            //new NothingOperator(),
            new GlobalAddOperator(9)),
    AnotherLine( //Add another line yeah
            new NothingOperator(),
            new GlobalAddOperator(10)),//\n = 10
    MultBy5(//new NothingOperator(),  //Multiply by 5 yeah
            new GlobalMultOperator(5)),
    HowLong(new NothingOperator() //How long will I keep this up?
    ),
    
    SeeYouGo(new NothingOperator() //Oh how much it hurts to see you go…
    ),
    GeneratingIsPain(new NothingOperator() //Generating lyrics is a pain
    ),
    Another6( //Add another 6 yeah
            //new NothingOperator(),
            new GlobalAddOperator(6)),
    FlipBackwards( //Flip the numbers backwards
            //new NothingOperator(),
            new FlipOperator()),
    Make2_3(//new NothingOperator(), //Make the 2 a 3 yeah
            new ReplaceAllOperator("2","3")),
    abcdefg(new NothingOperator() //ABCDEFG
    ),
    
    MultBy9(//new NothingOperator(), //Multiply by 9 yeah
            new GlobalMultOperator(9)),
    Add2_4( new NothingOperator(), //Add the numbers 2 4
            new SimultaneousMultipleOperation(new GlobalMultOperator(2),new GlobalMultOperator(4)),
            new GlobalAddOperator(24)),
    _17Fist(new NothingOperator(), //17 is first yeah
            new GlobalAddOperator(17)),
    abcdefg2(new NothingOperator() //ABCDEFG
    )
    
    ;
    
    final LyricOperators[] operators;
    Lyrics(LyricOperators... operators){
        this.operators = operators;
    }
    
    public LyricOperators[] getOperators() {
        return operators;
    }
}
