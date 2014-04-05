/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rsa;
import chiffrement.CipherScheme;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;
/**
 *
 * @author oorestisime
 */
public class RSA implements CipherScheme {
    private RSA_Parameters params;
    private int nbits;
    private RSA_KeySet keys;
    
    public RSA(int nb_bits){
        this.nbits=nb_bits;
        keys= new RSA_KeySet(this.nbits);
        params=keys.getParams();
    }
    public RSA(RSA_KeySet keyset){
        keys= keyset;
        params=keyset.getParams();
    }
    
    public RSA_Parameters getParameters(){
        return this.params;
    }
    public static BigInteger getPrime(int nb_bits, Random rng){
       return BigInteger.probablePrime(nb_bits,rng);
    }
    public RSA_Ciphertext encrypt(RSA_PlainText pt){
       RSA_Ciphertext cipherT;
       BigInteger[] cipher=new BigInteger[pt.getText().length];
       for(int i=0;i<pt.getText().length;i++){
            //System.out.println("in encrypt "+pt.getText()[i].bitLength()+" number for pk "+getKeys().getPk().getN().bitLength());
            if(pt.getText()[i].compareTo(getKeys().getPk().getN())==1){
                System.out.println("Plain text superieure a N");
                System.exit(1);
            }
            cipher[i]=pt.getText()[i].modPow(getKeys().getPk().getE(), getKeys().getPk().getN());
       }
        cipherT=new RSA_Ciphertext(cipher);
        return cipherT;
    }
    public RSA_Ciphertext encrypt(String s){
        RSA_Ciphertext cipherT;
        byte bytes[]=s.getBytes();
        byte[][] chuncked =divideArray(bytes, 127);
        //System.out.println("remainder is "+ s.length()%127);
        //last byte[]. we have to delete zeros in the end!
        byte lastchunck[]=new byte[s.length()%127];
        int j=0;
        for(int i=0;i<chuncked[0].length;i++){
            if(chuncked[chuncked.length-1][i]!=(byte)0){
               lastchunck[j]=(byte)(chuncked[chuncked.length-1][i]);
               j++;
             }
        }
        // convert to biginteger!
        BigInteger[] chuncks=new BigInteger[chuncked.length];
        for(int w=0;w<chuncks.length-1;w++){
            chuncks[w]=new BigInteger(chuncked[w]);
        }
        //convert last chunk
        chuncks[chuncks.length-1]=new BigInteger(lastchunck);
        //encrypt
        cipherT=encrypt(new RSA_PlainText(chuncks));
        return cipherT;
    }
    public RSA_PlainText decrypt(RSA_Ciphertext ct){
        RSA_PlainText plainT;
        BigInteger plain[]=new BigInteger[ct.getCiphers().length];
        //decrypt all blocs
        for(int i=0;i<plain.length;i++){
            plain[i]=ct.getCiphers()[i].modPow(getKeys().getSk().getD(), getKeys().getPk().getN());
        }
        plainT=new RSA_PlainText(plain);
        return plainT;
    }
    public static byte[][] divideArray(byte[] source, int chunksize) {
        byte[][] ret = new byte[(int)Math.ceil(source.length / (double)chunksize)][chunksize];
        int start = 0;
        for(int i = 0; i < ret.length; i++) {
            ret[i] = Arrays.copyOfRange(source,start, start + chunksize);
            start += chunksize ;
        }
        return ret;
    }
    
    public String RSA_PtToString(RSA_PlainText pt){
        String res="";
        for(int i=0;i<pt.getText().length;i++){
            res+=new String(pt.getText()[i].toByteArray());
        }
        return res;
    }
    /**
     * @return the keys
     */
    public RSA_KeySet getKeys() {
        return keys;
    }
}
