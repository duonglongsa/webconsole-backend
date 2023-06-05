package com.webconsole.miniappmanager.utils;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SignatureException;
import java.security.spec.ECGenParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Base64;

public class Signature {
    private static final String SPEC = "secp256r1";
    private static final String ALGO = "SHA256withECDSA";

    public static String signatureFile(String filePath, String privateKeyStr) throws NoSuchAlgorithmException, InvalidKeySpecException, SignatureException, InvalidKeyException, IOException {
        byte[] bytesValidate = Files.readAllBytes(Paths.get(filePath));// path file zip
        byte[] keyBytes = Base64.getDecoder().decode(privateKeyStr);
        PKCS8EncodedKeySpec spec =
                new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("EC");
        PrivateKey privateKey =  kf.generatePrivate(spec);

        java.security.Signature ecdsaSign = java.security.Signature.getInstance(ALGO);
        ecdsaSign.initSign(privateKey);
        byte[] bytes = bytesValidate;
        ecdsaSign.update(bytes, 0, bytes.length);
        byte[] signature = ecdsaSign.sign();
        // Generate publickey and signature
        if (signature != null) {
            return Base64.getEncoder().encodeToString(signature);
        }
        return "";
    }

    public void renderKey() throws InvalidAlgorithmParameterException, NoSuchAlgorithmException, InvalidKeyException {
        ECGenParameterSpec ecSpec = new ECGenParameterSpec(SPEC);
        KeyPairGenerator g = KeyPairGenerator.getInstance("EC");
        g.initialize(ecSpec);
        KeyPair keypair = g.generateKeyPair();
        PublicKey publicKey = keypair.getPublic();
        PrivateKey privateKey = keypair.getPrivate();

        java.security.Signature ecdsaSign = java.security.Signature.getInstance(ALGO);
        ecdsaSign.initSign(privateKey);
        String pub = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        System.out.println(pub);

        String pri = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        System.out.println(pri);
    }
}
