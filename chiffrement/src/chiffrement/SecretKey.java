/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrement;

import java.math.BigInteger;

/**
 *
 * @author oorestisime
 */
public interface SecretKey {
    
    public BigInteger getD(); 
    public BigInteger getP(); 
    public BigInteger getQ(); 
    
}
