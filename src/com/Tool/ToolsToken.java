package com.Tool;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by vd on 2017/7/30.
 */
public class ToolsToken
{
    public static String loginToken(String identify)
    {
        String token = new String();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("md5");
            String mdString = System.currentTimeMillis() + identify;
            messageDigest.update(mdString.getBytes());
            StringBuffer sb = new StringBuffer();
            byte[] bytes = messageDigest.digest();
            for (int i = 0; i < bytes.length; i++) {
                int b = bytes[i] & 0xFF;
                if (b < 0x10) {
                    sb.append('0');
                }
                sb.append(Integer.toHexString(b));
            }
            token = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return token;
    }

}
