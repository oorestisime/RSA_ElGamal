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
public class RSA_Ciphertext implements CipherText {
    private BigInteger cit;
    public RSA_Ciphertext(BigInteger ct){
        this.cit=ct;
    }
    public BigInteger getCipher(){
        return cit;

    }
}
