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
public class Elgamal_PublicKey {
    private BigInteger p;
    private BigInteger h;
    private BigInteger g;
    
    public Elgamal_PublicKey(BigInteger p,BigInteger h,BigInteger g){
     this.p=p;
     this.h=h;
     this.g=g;
   }

    /**
     * @return the p
     */
    public BigInteger getP() {
        return p;
    }

    /**
     * @return the h
     */
    public BigInteger getH() {
        return h;
    }

    /**
     * @return the g
     */
    public BigInteger getG() {
        return g;
    }
    
}
