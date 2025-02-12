// PasswordHashingUtil.java
package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordHashingUtil {
    
    /**
     * 솔트 생성
     * @return Base64로 인코딩된 솔트
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt); // 솔트를 Base64로 인코딩하여 반환
    }
    
    /**
     * 비밀번호 해싱
     * @param password 비밀번호
     * @param salt 솔트
     * @return 해싱된 비밀번호
     */
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256"); // SHA-256 해시 알고리즘 사용
            // salt를 btye 배열로 변환 후 MessageDigest에 추가함
            md.update(salt.getBytes());
            
            // 비밀번호도 동일하게 바이트 변환하여 salt와 함께 바이트 배열에 추가
            byte[] hashedPassword = md.digest(password.getBytes());
            
            // 바이트 배열을 16진수 문자열로 변환
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("해시 알고리즘이 존재하지 않습니다.", e);
        }
    }
}
