package dev.luisalberto.util.passwordencoding.crypto;

import org.springframework.boot.ApplicationArguments;

public class PasswordEncoding extends AbstractPasswordEncoding {

    public PasswordEncoding(ApplicationArguments args) {
        super(args);
    }

    public String getRawPassword() {
        return rawPassword;
    }

    public String getEncodedPassword() {
        return getPasswordEncoderInstance().encode(rawPassword);
    }
}
