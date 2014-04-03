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
        RSA rsa=new RSA(1024);
        RSA_PlainText plain=new RSA_PlainText(new BigInteger("0123"));
        RSA_Ciphertext cipher=rsa.encrypt(plain);
        System.out.println("0123 = "+rsa.decrypt(cipher).getText());
    }
    
}
