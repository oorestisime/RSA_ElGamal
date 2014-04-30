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
public class Elgamal_SecretKey {
   private BigInteger p;
   private BigInteger x;
   
   public Elgamal_SecretKey(BigInteger p,BigInteger x){
     this.p=p;
     this.x=x;
   }

    /**
     * @return the p
     */
    public BigInteger getP() {
        return p;
    }

    /**
     * @return the x
     */
    public BigInteger getX() {
        return x;
    }
   
}
