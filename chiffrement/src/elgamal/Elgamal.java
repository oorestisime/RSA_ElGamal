/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elgamal;

import chiffrement.CipherScheme;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author oorestisime
 */
public class Elgamal implements CipherScheme {

    private int nbits;
    private Elgamal_KeySet kset;
    public Elgamal(int nb_bits){
        this.nbits=nb_bits;
        Elgamal_Parameters params=new Elgamal_Parameters(this.nbits,new SecureRandom());
        this.kset=new Elgamal_KeySet(params);
    }
    
    public static BigInteger getPrime(int nb_bits, Random rng){
       BigInteger fois=new BigInteger("2");
       BigInteger p_prime,p;
       do{
         p_prime=BigInteger.probablePrime(nb_bits,rng);
         p=p_prime.multiply(fois).add(BigInteger.ONE);
       }while(!p.isProbablePrime(100));
       return p;
    }
    
    public static BigInteger getPrime_cert(int nb_bits, Random rng,int cert){
       BigInteger fois=new BigInteger("2");
       BigInteger p_prime,p;
       do{
         p_prime=BigInteger.probablePrime(nb_bits-1,rng);
         p=p_prime.multiply(fois).add(BigInteger.ONE);
       }while(!p.isProbablePrime(cert));
       
       return p;
    }
    public Elgamal_CipherText encrypt(BigInteger p){
        Elgamal_PlainText pt=new Elgamal_PlainText(p);
        BigInteger modulo=kset.getPk().getP();
        Elgamal_CipherText ct;
        BigInteger r;
        do{
        r = new BigInteger(this.kset.getPk().getP().bitCount()-1, new SecureRandom());
        }while(kset.getPk().getP().compareTo(r)==-1);
        BigInteger mhr=(pt.getPt().multiply(kset.getPk().getH().modPow(r, modulo))).mod(modulo);
        BigInteger gr=kset.getPk().getG().modPow(r,modulo);
        ct=new Elgamal_CipherText(mhr,gr);
        return ct;
    }
    public Elgamal_PlainText decrypt(Elgamal_CipherText ct){
        Elgamal_PlainText pt;
        //System.out.println(ct.getGr());
        BigInteger s=ct.getGr().modPow(kset.getSk().getX(), kset.getPk().getP());
        BigInteger decrypt=ct.getCt().multiply(s.modInverse(kset.getPk().getP())).mod(kset.getPk().getP());
        pt=new Elgamal_PlainText(decrypt);
        return pt;
        
    }
    public static ArrayList<BigInteger> ordre(BigInteger p){
        BigInteger factor1=new BigInteger("2");
        ArrayList<BigInteger> list = new ArrayList<BigInteger>();
        BigInteger factor2=(p.subtract(BigInteger.ONE)).divide(factor1);
        list.add(null);
        System.out.println("here  "+factor1+"  "+factor2);
        BigInteger i=BigInteger.ONE;
        BigInteger ordre;
        boolean found=false;
        while(i.compareTo(p)==-1){
            if(i.mod(factor1)==BigInteger.ZERO ||i.mod(factor2)==BigInteger.ZERO){
                list.add(null);
            }else{
                ordre=BigInteger.ONE;
                found=false;
                while(!found){
                    if(i.modPow(ordre,p).compareTo(BigInteger.ONE)==0){
                        found=true;
                        list.add(ordre);
                    }else{
                        ordre=ordre.add(BigInteger.ONE);
                    }
                }
            }     
            i=i.add(BigInteger.ONE);
        }
        return list;
    }
    
}
