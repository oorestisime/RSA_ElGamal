/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author oorestisime
 */
public class RSA_PublicKey {
 
    private BigInteger N;
    private BigInteger e;
    public RSA_PublicKey(BigInteger N,BigInteger e){
        this.N=N;
        this.e=e;
    }

    /**
     * @return the N
     */
    public BigInteger getN() {
        return N;
    }

    /**
     * @return the e
     */
    public BigInteger getE() {
        return e;
    }
    
}
