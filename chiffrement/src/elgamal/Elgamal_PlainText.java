/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package elgamal;

import java.math.BigInteger;

/**
 *
 * @author oorestisime
 */
public class Elgamal_PlainText {
    private BigInteger pt[];
    
    public Elgamal_PlainText(BigInteger p[]){
        pt=p;
    }

    /**
     * @return the pt
     */
    public BigInteger[] getPt() {
        return pt;
    }

    
}
