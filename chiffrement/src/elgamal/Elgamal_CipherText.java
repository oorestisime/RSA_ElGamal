/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elgamal;

import java.math.BigInteger;

/**
 *
 * @author oorestisime
 */
public class Elgamal_CipherText {
    private BigInteger ct;
    private BigInteger gr;
    public Elgamal_CipherText(BigInteger p,BigInteger gr){
        ct=p;
        this.gr=gr;
    }

    /**
     * @return the ct
     */
    public BigInteger getCt() {
        return ct;
    }

    /**
     * @return the gr
     */
    public BigInteger getGr() {
        return gr;
    }
    
    
}
