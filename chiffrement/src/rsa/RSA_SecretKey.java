/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;

import chiffrement.*;
import java.math.BigInteger;

/**
 *
 * @author oorestisime
 */
public class RSA_SecretKey implements SecretKey {
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
    @Override
    public BigInteger getD() {
        return d;
    }

    /**
     * @return the p
     */
    @Override
    public BigInteger getP() {
        return p;
    }

    /**
     * @return the q
     */
    @Override
    public BigInteger getQ() {
        return q;
    }
    
}
