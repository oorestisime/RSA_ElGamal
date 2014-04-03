/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elgamal;

import chiffrement.Parameters;
import java.security.SecureRandom;
import java.util.Random;

/**
 *
 * @author oorestisime
 */
public class Elgamal_Parameters implements Parameters {
    
   private int nb_bits;
   private Random prg;

   public Elgamal_Parameters(int nb_bits,Random prg){
       this.nb_bits=nb_bits;
       this.prg=prg;
   }
   public Elgamal_Parameters(int nb_bits){
       this.nb_bits=nb_bits;
       this.prg=new SecureRandom();
   }
 
       
   }
   
