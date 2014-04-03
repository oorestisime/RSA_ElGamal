/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;
import chiffrement.CipherScheme;
import java.math.BigInteger;
import java.util.Random;
/**
 *
 * @author oorestisime
 */
public class RSA implements CipherScheme {
    private RSA_Parameters params;
    int nbits;
    private RSA_KeySet keys;
    public RSA(int nb_bits){
        this.nbits=nb_bits;
        this.params=new RSA_Parameters(this.nbits);
        keys=KeyGen();
    }
    
    public RSA_KeySet KeyGen(){
       RSA_KeySet key;
       BigInteger p=getPrime((params.getNbBits()/2),params.getRand());  
       BigInteger q=getPrime((params.getNbBits()/2),params.getRand()); 
       BigInteger n=p.multiply(q);
       BigInteger e=new BigInteger("65537");
       BigInteger totient=p.subtract(BigInteger.ONE).multiply((q.subtract(BigInteger.ONE)));
       BigInteger d=e.modInverse(totient);    
       System.out.println("d * e mod N: "+d.multiply(e).mod(totient));
       RSA_PublicKey pk=new RSA_PublicKey(n,e);
       RSA_SecretKey sk=new RSA_SecretKey(d,p,q);
       return new RSA_KeySet(pk,sk);
    }
    public RSA_Parameters getParameters(){
        return this.params;
    }
    public BigInteger getPrime(int nb_bits, Random rng){
       return BigInteger.probablePrime(nb_bits,rng);
    }
    public RSA_Ciphertext encrypt(RSA_PlainText pt){
        RSA_Ciphertext cipherT;
        if(pt.getText().compareTo(keys.getPk().getN())==1){
            System.out.println("Plain text superieure a N");
            System.exit(1);
        }
        BigInteger cipher=pt.getText().modPow(keys.getPk().getE(), keys.getPk().getN());
        cipherT=new RSA_Ciphertext(cipher);
        return cipherT;
    }
    public RSA_PlainText decrypt(RSA_Ciphertext ct){
        RSA_PlainText plainT;
        BigInteger plain=ct.getCipher().modPow(keys.getSk().getD(), keys.getPk().getN());
        plainT=new RSA_PlainText(plain);
        return plainT;
    }
}
