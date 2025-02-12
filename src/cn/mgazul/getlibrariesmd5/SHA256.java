package cn.mgazul.getlibrariesmd5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Mgazul
 * @date 2020/4/11 0:53
 */
public class SHA256 {

    /**
     * Get the SHA-256 value of this input stream
     *
     * @param is
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getSHA256(InputStream is) throws NoSuchAlgorithmException, IOException {
        StringBuffer sha256 = new StringBuffer();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = is.read(dataBytes)) != -1) {
            md.update(dataBytes, 0, nread);
        }
        byte[] mdbytes = md.digest();

        // convert the byte to hex format
        for (int i = 0; i < mdbytes.length; i++) {
            sha256.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sha256.toString();
    }

    /**
     * Get the SHA-256 value of the file
     *
     * @param file
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getSHA256(File file) throws NoSuchAlgorithmException, IOException {
        FileInputStream fis = new FileInputStream(file);
        return getSHA256(fis);
    }

    /**
     * Get the SHA-256 value of the specified path file
     *
     * @param path
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static String getSHA256(String path) throws NoSuchAlgorithmException, IOException {
        FileInputStream fis = new FileInputStream(path);
        return getSHA256(fis);
    }

    /**
     * Check the SHA-256 value of this input stream
     *
     * @param is
     * @param toBeCheckSum
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static boolean sha256CheckSum(InputStream is, String toBeCheckSum) throws NoSuchAlgorithmException, IOException {
        return getSHA256(is).equals(toBeCheckSum);
    }

    /**
     * Check the SHA-256 value of the file
     *
     * @param file
     * @param toBeCheckSum
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static boolean sha256CheckSum(File file, String toBeCheckSum) throws NoSuchAlgorithmException, IOException {
        return getSHA256(file).equals(toBeCheckSum);
    }

    /**
     * Check the SHA-256 value of the specified path file
     *
     * @param path
     * @param toBeCheckSum
     * @return
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static boolean sha256CheckSum(String path, String toBeCheckSum) throws NoSuchAlgorithmException, IOException {
        return getSHA256(path).equals(toBeCheckSum);
    }
}
