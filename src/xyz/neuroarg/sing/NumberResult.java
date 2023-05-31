package xyz.neuroarg.sing;

import java.math.BigInteger;
import java.util.Objects;

public class NumberResult {
    
    private static final String DEFAULT_CODE = "Start";
    
    BigInteger numberDec;
    String numberStr;
    String code;
    public NumberResult(String number){
        this.numberStr = number;
        try{
            this.numberDec = new BigInteger(this.numberStr);
        }catch (Exception ignored){}
        this.code = DEFAULT_CODE;
    }
    public NumberResult(BigInteger number){
        this.numberDec = number;
        this.numberStr = number.toString();
        this.code = DEFAULT_CODE;
    }
    
    public String asString(){
        return this.numberStr;
    }
    
    public BigInteger asBigInt(){
        return this.numberDec;
        
    }
    
    //we want 32 bytes no bits
    private static final BigInteger AES_LIMIT = BigInteger.valueOf(256).pow(32);
    

    //used only for writing to file
    boolean isnumber = false;
    public boolean validate(){
        //AES key should be less or equal of 32 bytes (bc key is 16, 24 or 32 bytes)
        BigInteger value = asBigInt();
        if(value == null)
            return asString().length() <= 32;
        isnumber = true;
        return value.compareTo(AES_LIMIT) < 0;
    }
    
    public boolean isNumber() {
        return isnumber;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getCode() {
        return code;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NumberResult that)) return false;
        return Objects.equals(numberStr, that.numberStr);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(numberStr);
    }
}
