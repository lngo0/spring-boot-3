package com.sample.sb3;

import com.sample.sb3.config.CustomJasyptEncryptorConfig;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;

public class JasyptTest {

    @Test
    void contextLoads() {

    }
    @Test
    public void testEncryptionKey() {
        CustomJasyptEncryptorConfig config = new CustomJasyptEncryptorConfig();
        StringEncryptor stringEncryptor = config.stringEncryptor();
        String userName = "root";
        String userPassword = "Root@123";
        String encryptedUN = stringEncryptor.encrypt(userName);
        String encryptedPW = stringEncryptor.encrypt(userPassword);

        System.out.println("Encrypted user name: " + encryptedUN);
        System.out.println("Encrypted password: " + encryptedPW);
    }
}
