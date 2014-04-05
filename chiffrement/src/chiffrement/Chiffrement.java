/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrement;

import java.math.BigInteger;
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
        RSA rsa=new RSA(1024);
        RSA_PlainText plain=new RSA_PlainText(new BigInteger("123"));
        RSA_Ciphertext cipher=rsa.encrypt(plain);
        System.out.println("0123 = "+rsa.decrypt(cipher).getText());
        // Encryption using existing keys
        RSA_KeySet keys=new RSA_KeySet(1024);
        RSA rsa_2=new RSA(keys);
        
        String s="Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
        // fragmentation for long text.
        byte bytes[]=s.getBytes();
        System.out.println("bytes length "+bytes.length*8);
        byte bytes_2[]=new byte[bytes.length/2];
        
        for(int i=0;i<bytes_2.length;i++){
            bytes_2[i]=bytes[i];
        }
        byte bytes_3[]=new byte[bytes.length-bytes_2.length];
        int j=0;
        for(int i=bytes_2.length;i<bytes.length;i++){
            bytes_3[j]=bytes[i];
            j++;
        }
        BigInteger testing_3=new BigInteger(bytes_3);
        BigInteger testing_2=new BigInteger(bytes_2);
        RSA_Ciphertext cipher3=rsa_2.encrypt(new RSA_PlainText(testing_2));
        RSA_Ciphertext cipher4=rsa_2.encrypt(new RSA_PlainText(testing_3));
        String s1=new String(rsa_2.decrypt(cipher3).getText().toByteArray());
        String s2=new String(rsa_2.decrypt(cipher4).getText().toByteArray());
        System.out.println("s1+s2 = "+s1+s2);
        
        
        // encryption(String s)
       RSA_Ciphertext cipher5=rsa_2.encrypt("Orestis Ioannou");
       String deciphered=new String(rsa_2.decrypt(cipher5).getText().toByteArray());
       System.out.println("Orestis Ioannou = "+deciphered);
       
    }
    
}
