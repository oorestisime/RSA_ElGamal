/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;

import java.math.BigInteger;
import chiffrement.*;
/**
 *
 * @author oorestisime
 */
public class RSA_CipherText implements CipherText {
    private BigInteger[]ciphers; 
    
    public RSA_CipherText(BigInteger[]ct){
        this.ciphers=ct;
    }
    /**
     * @return the ciphers
     */
    public BigInteger[] getCiphers() {
        return ciphers;
    }
    
}
