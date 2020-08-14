package dev.luisalberto.util.passwordencoding.runner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import dev.luisalberto.util.passwordencoding.crypto.PasswordEncoding;
import dev.luisalberto.util.passwordencoding.exception.PasswordEncodingException;

@Component
public class PasswordEncoderRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (args.containsOption("help")) {
            help();
        }

        passwordEncoding(args);
    }

    private void passwordEncoding(ApplicationArguments args) {

        try {

            PasswordEncoding passwordEncoding = new PasswordEncoding(args);

            System.out.println(passwordEncoding.getRawPassword());
            System.out.println(passwordEncoding.getEncodedPassword());

        } catch (PasswordEncodingException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private void help() {

        InputStream inputStream = getClass().getClassLoader()
                .getResourceAsStream("help");

        String help = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(help);

        System.exit(0);
    }
}
