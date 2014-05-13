/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;

import java.math.BigInteger;
import java.util.Random;
import chiffrement.*;
/**
 *
 * @author oorestisime
 */
public class RSA_KeySet implements KeySet {
    private RSA_PublicKey pk;
    private RSA_SecretKey sk;
    private RSA_Parameters params;
    private int nb_bits;
    
    public RSA_KeySet(RSA_PublicKey pubk, RSA_SecretKey seck){
      this.pk=pubk;
      this.sk=seck;
    }
    
    public RSA_KeySet(int nbits){
       nb_bits=nbits;
       params=new RSA_Parameters(this.nb_bits);
       BigInteger p=RSA.getPrime((params.getNb_bits()/2),params.getPrg());  
       BigInteger q=RSA.getPrime((params.getNb_bits()/2),params.getPrg()); 
       BigInteger n=p.multiply(q);
       BigInteger e=new BigInteger("65537");
       BigInteger totient=p.subtract(BigInteger.ONE).multiply((q.subtract(BigInteger.ONE)));
       BigInteger d=e.modInverse(totient);    
       //System.out.println("d * e mod N: "+d.multiply(e).mod(totient));
       pk=new RSA_PublicKey(n,e);
       sk=new RSA_SecretKey(d,p,q);
    }
    /**
     * @return the pk
     */
    @Override
    public RSA_PublicKey getPk() {
        return pk;
    }

    /**
     * @return the sk
     */
    @Override
    public RSA_SecretKey getSk() {
        return sk;
    }

    /**
     * @return the params
     */
    @Override
    public RSA_Parameters getParams() {
        return params;
    }
    
}
