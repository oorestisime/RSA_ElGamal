/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;

import java.math.BigInteger;

/**
 *
 * @author oorestisime
 */
public class RSA_SecretKey {
    private BigInteger d;
    private BigInteger p;
    private BigInteger q;
    public RSA_SecretKey(BigInteger d,BigInteger p,BigInteger q){
        this.d=d;
        this.p=p;
        this.q=q;
    }

    /**
     * @return the d
     */
    public BigInteger getD() {
        return d;
    }

    /**
     * @return the p
     */
    public BigInteger getP() {
        return p;
    }

    /**
     * @return the q
     */
    public BigInteger getQ() {
        return q;
    }
    
}
