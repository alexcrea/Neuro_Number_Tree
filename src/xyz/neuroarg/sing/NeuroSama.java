package xyz.neuroarg.sing;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * the name of this class is only used as a joke on the Main (Sing.java)
 */
public class NeuroSama {
    
    ArrayList<NumberResult> results;
    
    NeuroSama(){
        this.results = new ArrayList<>();
        addDefaultNumbers();
    }
    
    private void addDefaultNumbers() {
        results.add(new NumberResult(BigInteger.valueOf(0)));
        
    }
    
    public ArrayList<NumberResult> getResults() {
        return results;
    }
    
    public void sing(Lyrics lyric){
        System.out.println(lyric.name());
        ArrayList<NumberResult> oldresult = this.results;
        this.results = new ArrayList<>();
        for (LyricOperators operator : lyric.getOperators()) {
            operator.interpretLyrics(this,oldresult);
        }
    }
    
    //default by false
    private final static boolean SHOULD_REGISTER_CODE = false;
    private final static boolean ONLY_GOOD_KEY_SIZE = false;
    
    public void endOfSong() {
        
        //write to a file ?
        
        try {
            File folder = new File("./result/");
            folder.mkdirs();
            
            File validascii = new File(folder,"validASCII.txt");
            if (!validascii.exists())
                validascii.createNewFile();
            
            //write utf result
            FileWriter fw = new FileWriter(validascii.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            
            for (NumberResult result : results) {
                String resultstr = result.asString();
                if(ONLY_GOOD_KEY_SIZE && resultstr.length() != 32 && resultstr.length() != 24 && resultstr.length() != 16){//check ascii key size
                    continue;
                }
                bw.write(resultstr);
                bw.newLine();
            }
            
            bw.close();
            
            //write numbers as hex
            File validint = new File(folder,"validInt.txt");
            if (!validint.exists())
                validint.createNewFile();
            fw = new FileWriter(validint.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            
            for (NumberResult result : results) {
                if(result.isNumber()){//check is valid number
                    bw.write(result.asBigInt().toString(16));//write as hex
                    bw.newLine();
                }
            }
            
            bw.close();
            
            
            //write codes
            if(SHOULD_REGISTER_CODE){
                File asciiOp = new File(folder,"validASCII-opperations.txt");
                if (!asciiOp.exists())
                    asciiOp.createNewFile();
                fw = new FileWriter(asciiOp.getAbsoluteFile());
                bw = new BufferedWriter(fw);
                
                for (NumberResult result : results) {
                    int keylen = result.asString().length();
                    if(ONLY_GOOD_KEY_SIZE && keylen != 32 && keylen != 24 && keylen != 16){//check ascii key size
                        continue;
                    }
                    bw.write(result.getCode());
                    bw.newLine();
                }
                
                File intOp = new File(folder,"validInt-opperations.txt");
                if (!intOp.exists())
                    intOp.createNewFile();
                fw = new FileWriter(intOp.getAbsoluteFile());
                bw = new BufferedWriter(fw);
                
                for (NumberResult result : results) {
                    if(result.isNumber()){//check is valid numbere
                        bw.write(result.getCode());
                        bw.newLine();
                    }
                }
            }
            
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
    
    }
}
