/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;
import chiffrement.*;
import elgamal.*;
import java.security.SecureRandom;
import java.util.Random;
/**
 *
 * @author oorestisime
 */
public class RSA_Parameters implements Parameters {

    private int nb_bits;
   private Random prg;

   public RSA_Parameters(int nb_bits,Random prg){
       this.nb_bits=nb_bits;
       this.prg=prg;
   }
   public RSA_Parameters(int nb_bits){
       this.nb_bits=nb_bits;
       this.prg=new SecureRandom();
   }
   public int getNbBits(){
       return this.nb_bits;
   }
   public Random getRand(){
       return this.prg;
   }
   
}
