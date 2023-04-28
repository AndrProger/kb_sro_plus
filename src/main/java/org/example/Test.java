package org.example;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public abstract class Test {
    public  String key="thisisaverysecretkey123412313243";
    public int KeyLen=key.length();
    public final String text="Lorem Ipsum is simply dummy text of the printing and " +
            " with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
            ;
    public long timeEncrypt = 0;
    public long timeDecrypt = 0;
    public String textEncrypt="";
    public String textDecrypt="";

    public int memoryEncrypt ;
    public int memoryDecrypt ;
    public String  algorithmName = "";

    public abstract void test() ;
    public  void algorithmSynchronousTest(SecretKeySpec secretKeySpec, String cipherText) {
        try {

            algorithmSynchronous(secretKeySpec,cipherText);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
    }
    private void  algorithmSynchronous(SecretKeySpec secretKeySpec, String cipherText) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        Cipher cipher = Cipher.getInstance(cipherText);
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
        Cipher decipher = Cipher.getInstance(cipherText);
        decipher.init(Cipher.DECRYPT_MODE, secretKeySpec);

        long start= System.nanoTime();
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        timeEncrypt = System.nanoTime() -start;
        memoryEncrypt=encryptedBytes.length;

        start= System.nanoTime();
        byte[] decryptedBytes = decipher.doFinal(encryptedBytes);
        timeDecrypt = System.nanoTime() -start;
        memoryDecrypt=decryptedBytes.length;
    }

    public  String info() {
        return "================================================================\n"+
                "algorithm:"+this.getClass().getName()+"\n"+
                "================================================================\n"+
                "Time encrypted: "+
                timeEncrypt+" nano sec"+
                "\nTime decrypted: "+
                timeDecrypt+" nano sec\n"+
                "----------------------------------------------------------------\n"+
                "Total time: "+(timeEncrypt+timeDecrypt)+"nano sec\n"+
                "----------------------------------------------------------------\n"+
                "Encrypt size: "+ memoryEncrypt+" bytes\n"+
                "Decrypt size: "+ memoryDecrypt+" bytes\n"+
                "----------------------------------------------------------------\n"+
                "Total memory: "+(memoryEncrypt+memoryDecrypt)+" bytes\n"+
                "----------------------------------------------------------------\n"+
                "Key length : "+ KeyLen+"\n"+
                "Key:" + key+"\n"+
                "================================================================\n";
    }
}
