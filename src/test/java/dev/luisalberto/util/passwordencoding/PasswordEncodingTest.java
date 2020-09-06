package dev.luisalberto.util.passwordencoding;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import dev.luisalberto.util.passwordencoding.crypto.PasswordEncoding;

public class PasswordEncodingTest {

    private static final String PASSWORD = "qwerty";

    @Test
    public void argon2() {

        PasswordEncoding passwordEncoding = new PasswordEncoding(PASSWORD, "argon2");

        PasswordEncoder encoder = new Argon2PasswordEncoder();

        assertTrue(encoder.matches(PASSWORD, passwordEncoding.getEncodedPassword()));
    }

    @Test
    public void bcrypt() {

        PasswordEncoding passwordEncoding = new PasswordEncoding(PASSWORD, "bcrypt");

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        assertTrue(encoder.matches(PASSWORD, passwordEncoding.getEncodedPassword()));
    }

    @Test
    public void pbkdf2() {

        PasswordEncoding passwordEncoding = new PasswordEncoding(PASSWORD, "pbkdf2");

        PasswordEncoder encoder = new Pbkdf2PasswordEncoder();

        assertTrue(encoder.matches(PASSWORD, passwordEncoding.getEncodedPassword()));
    }

    @Test
    public void scrypt() {

        PasswordEncoding passwordEncoding = new PasswordEncoding(PASSWORD, "scrypt");

        PasswordEncoder encoder = new SCryptPasswordEncoder();

        assertTrue(encoder.matches(PASSWORD, passwordEncoding.getEncodedPassword()));
    }
}
