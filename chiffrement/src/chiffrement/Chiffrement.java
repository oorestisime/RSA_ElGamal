/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrement;

import elgamal.Elgamal;
import elgamal.Elgamal_CipherText;
import elgamal.Elgamal_PlainText;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import rsa.*;

/**
 *
 * @author oorestisime
 */
public class Chiffrement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // New keyset encryption.
        
        // Encryption using existing keys
        Elgamal eg=new Elgamal(256);
        String s="Lorem ipsum dolor sit amet, consectetur adipisicing elit"+
                ", sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit,\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        System.out.println(s+"\nELGAMAL");
        System.out.println(eg.Elgamal_PtToString(eg.decrypt(eg.encrypt(s))));
        /*ArrayList<BigInteger> list;
        BigInteger p=new BigInteger("23");
        list=eg.ordre(new BigInteger("23"));
        for(int i=0;i<list.size();i++){
            System.out.println(i+" -> "+list.get(i));
        }
        System.out.println();*/
        RSA_KeySet keys=new RSA_KeySet(1024);
        RSA rsa_2=new RSA(keys);
                try {
            // fragmentation for long text.
            byte bytes[]=s.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Chiffrement.class.getName()).log(Level.SEVERE, null, ex);
        }
        RSA_CipherText cipher1=rsa_2.encrypt(s);
        System.out.println("RSA");
        System.out.println(rsa_2.RSA_PtToString(rsa_2.decrypt(cipher1)));
    }
    
}
