/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrement;

import java.math.BigInteger;
import java.util.Arrays;
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
        RSA_KeySet keys=new RSA_KeySet(1024);
        RSA rsa_2=new RSA(keys);
        
        String s="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit,sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipisicing elit,\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.\nsed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        // fragmentation for long text.        
        byte bytes[]=s.getBytes();
        RSA_Ciphertext cipher1=rsa_2.encrypt(s);
        System.out.println(rsa_2.RSA_PtToString(rsa_2.decrypt(cipher1)));
    }
    
}
