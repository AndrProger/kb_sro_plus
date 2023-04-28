package org.example;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;

public class BlowfishTest extends Test {
    @Override
    public void test() {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "Blowfish");
        String AlgorithmString="Blowfish";
        algorithmSynchronousTest(secretKeySpec,AlgorithmString);

        System.out.println(info());

    }


}
