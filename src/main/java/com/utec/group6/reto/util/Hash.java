package com.utec.group6.reto.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hash {

    static Logger logger = LoggerFactory.getLogger(Hash.class);

    public static String getHash(String txt, String hashType) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
            logger.error("error al desencriptar, mensaje", e);
        }
        return null;
    }

}
