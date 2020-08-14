package dev.luisalberto.util.passwordencoding.crypto;

import java.util.Optional;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import dev.luisalberto.util.passwordencoding.exception.PasswordEncodingException;

public abstract class AbstractPasswordEncoding {

    protected String rawPassword = "";

    protected String algorithm = "";

    public AbstractPasswordEncoding(ApplicationArguments args) {
        setRequest(args);
    }

    protected PasswordEncoder getPasswordEncoderInstance() {

        PasswordEncoder passwordEncoder = null;

        switch (algorithm) {
        case "argon2":
            passwordEncoder = new Argon2PasswordEncoder();
            break;
        case "bcrypt":
            passwordEncoder = new BCryptPasswordEncoder();
            break;
        case "pbkdf2":
            passwordEncoder = new Pbkdf2PasswordEncoder();
            break;
        case "scrypt":
            passwordEncoder = new SCryptPasswordEncoder();
            break;
        default:
            throw new PasswordEncodingException("Invalid encryption algorithm.");
        }

        return passwordEncoder;
    }

    private void setRequest(ApplicationArguments args) {

        Set<String> options = args.getOptionNames();

        if (options.contains("password")) {

            if (args.getOptionValues("password").isEmpty()) {
                throw new PasswordEncodingException("You must enter a password.");
            }

            Optional<String> container = Optional.of(args.getOptionValues("password").get(0)).filter(rawPassword -> {
                return !rawPassword.isBlank();
            });

            rawPassword = container.orElseThrow(() -> {
                throw new PasswordEncodingException("You must enter a password.");
            });
        } else {
            throw new PasswordEncodingException("You must enter a password.");
        }

        if (options.contains("algorithm")) {

            if (args.getOptionValues("algorithm").isEmpty()) {
                algorithm = "bcrypt";
            }

            Optional<String> container2 = Optional.of(args.getOptionValues("algorithm").get(0)).filter(algorithm -> {
                return !algorithm.isBlank();
            });

            algorithm = container2.orElse("bcrypt");
        } else {
            algorithm = "bcrypt";
        }
    }

}