package lamt.javawip;

import java.math.BigInteger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class PasswordDecrypt {

    public static void main(String[] args) {
        System.out.println(decode("b5b74269c11434b"));
    }

    public static String decode(String secret) {
        String retString = "";
        try {
            byte[] kbytes = "jaas is the way".getBytes();
            SecretKeySpec key = new SecretKeySpec(kbytes, "Blowfish");

            BigInteger n = new BigInteger(secret, 16);
            byte[] encoding = n.toByteArray();

            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decode = cipher.doFinal(encoding);
            retString = new String(decode);
        } catch (Exception ignore) {
            ignore.printStackTrace();
        }

        return retString;
    }

}
