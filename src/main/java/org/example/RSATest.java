package org.example;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class RSATest extends Test {
    @Override
    public void test() {
        KeyPairGenerator keyPairGenerator = null;
        try {
            keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        keyPairGenerator.initialize(2048);
        KeyPair keyRsa = keyPairGenerator.generateKeyPair();

        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new RuntimeException(e);
        }
        try {
            cipher.init(Cipher.ENCRYPT_MODE, keyRsa.getPublic());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }



        long start = System.nanoTime();
        byte[] encryptedBytes;
        try {
            encryptedBytes = cipher.doFinal(text.getBytes());
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        timeEncrypt = System.nanoTime() - start;
        memoryEncrypt = encryptedBytes.length;

        try {
            cipher.init(Cipher.DECRYPT_MODE, keyRsa.getPrivate());
        } catch (InvalidKeyException e) {
            throw new RuntimeException(e);
        }

        start= System.nanoTime();
        byte[] decryptedBytes = new byte[0];
        try {
            decryptedBytes = cipher.doFinal(encryptedBytes);
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        } catch (BadPaddingException e) {
            throw new RuntimeException(e);
        }
        timeDecrypt = System.nanoTime() -start;
        memoryDecrypt=decryptedBytes.length;

        key =""+keyRsa.getPublic()+"\n"+ keyRsa.getPrivate();
        System.out.println(info());
    }
}
