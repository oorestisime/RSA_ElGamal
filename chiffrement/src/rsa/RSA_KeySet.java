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
public class RSA_KeySet {
    private RSA_PublicKey pk;
    private RSA_SecretKey sk;
    
    public RSA_KeySet(RSA_PublicKey pubk, RSA_SecretKey seck){
      this.pk=pubk;
      this.sk=seck;
    }

    /**
     * @return the pk
     */
    public RSA_PublicKey getPk() {
        return pk;
    }

    /**
     * @return the sk
     */
    public RSA_SecretKey getSk() {
        return sk;
    }
    
}
