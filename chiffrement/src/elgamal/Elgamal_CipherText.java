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
    private BigInteger mhr[];
    private BigInteger gr;
    public Elgamal_CipherText(BigInteger p[],BigInteger gr){
        mhr=p;
        this.gr=gr;
    }

    /**
     * @return the mhr
     */
    public BigInteger[] getCt() {
        return mhr;
    }

    /**
     * @return the gr
     */
    public BigInteger getGr() {
        return gr;
    }
    
    
}
