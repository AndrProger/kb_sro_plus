package org.example;

public class Main {
    public static void main(String[] args) {
        Test aes =new AESTest();
        aes.test();
        Test blowfish=new BlowfishTest();
        blowfish.test();
        Test des=new DESTest();
        des.test();
        Test rsa=new RSATest();
        rsa.test();

    }
}