/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;
import chiffrement.CipherScheme;
import chiffrement.CipherText;
import chiffrement.PlainText;
import java.math.BigInteger;
import java.util.Random;
/**
 *
 * @author oorestisime
 */
public class RSA implements CipherScheme {
    private RSA_Parameters params;
    private int nbits;
    private RSA_KeySet keys;
    
    public RSA(int nb_bits){
        this.nbits=nb_bits;
        keys= new RSA_KeySet(this.nbits);
        params=keys.getParams();
    }
    public RSA(RSA_KeySet keyset){
        keys= keyset;
        params=keyset.getParams();
    }
    
    public RSA_Parameters getParameters(){
        return this.params;
    }
    public static BigInteger getPrime(int nb_bits, Random rng){
       return BigInteger.probablePrime(nb_bits,rng);
    }
    public RSA_Ciphertext encrypt(RSA_PlainText pt){
        RSA_Ciphertext cipherT;
       System.out.println("in encrypt "+pt.getText().bitLength()+" number for pk "+getKeys().getPk().getN().bitLength() );
        if(pt.getText().compareTo(getKeys().getPk().getN())==1){
            System.out.println("Plain text superieure a N");
            System.exit(1);
        }
        BigInteger cipher=pt.getText().modPow(getKeys().getPk().getE(), getKeys().getPk().getN());
        cipherT=new RSA_Ciphertext(cipher);
        return cipherT;
    }
    public RSA_Ciphertext encrypt(String s){
        RSA_Ciphertext cipherT;
        byte bytes[]=s.getBytes();
        BigInteger res=new BigInteger(bytes);
        cipherT=encrypt(new RSA_PlainText(res));
        return cipherT;
    }
    public RSA_PlainText decrypt(RSA_Ciphertext ct){
        RSA_PlainText plainT;
        BigInteger plain=ct.getCipher().modPow(getKeys().getSk().getD(), getKeys().getPk().getN());
        plainT=new RSA_PlainText(plain);
        return plainT;
    }

    /**
     * @return the keys
     */
    public RSA_KeySet getKeys() {
        return keys;
    }
}
