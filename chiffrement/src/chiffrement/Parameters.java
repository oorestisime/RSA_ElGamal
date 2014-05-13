/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chiffrement;

import java.util.Random;

/**
 *
 * @author oorestisime
 */
public interface Parameters {
    public int getNb_bits();
    public Random getPrg();
}
