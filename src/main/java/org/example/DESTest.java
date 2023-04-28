package org.example;

import javax.crypto.spec.SecretKeySpec;
import java.security.Security;

public class DESTest extends Test {
    @Override
    public void test()  {
        key="12345678";
        KeyLen=key.length();


        byte[] keyBytes = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "DES");
        String AlgorithmString="DES/ECB/PKCS5Padding";
        algorithmSynchronousTest(secretKeySpec,AlgorithmString);

        System.out.println(info());
    }
}
