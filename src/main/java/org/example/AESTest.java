package org.example;

import org.openjdk.jol.info.ClassLayout;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.lang.instrument.Instrumentation;
import java.security.InvalidKeyException;

import java.security.NoSuchAlgorithmException;

public class AESTest extends  Test {

    @Override
    public void test()  {
        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
        String AlgorithmString="AES/ECB/PKCS5Padding";
        algorithmSynchronousTest(secretKeySpec,AlgorithmString);

        System.out.println(info());
    }




}
