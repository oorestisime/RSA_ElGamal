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
public interface PublicKey {
    public BigInteger getN();
    public BigInteger getE();
}
