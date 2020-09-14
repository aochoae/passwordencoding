/*
 * Copyright 2020 Luis A. Ochoa
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.luisalberto.util.passwordencoding.runner;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import java.util.Set;
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

        if (args.containsOption("help") || args.getOptionNames().isEmpty()) {
            help();
        } else {
            passwordEncoding(args);
        }
    }

    private void passwordEncoding(ApplicationArguments args) {

        try {

            PasswordEncoding passwordEncoding = new PasswordEncoding(getPassword(args), getAlgorithm(args));

            System.out.println(passwordEncoding.getRawPassword());
            System.out.println(passwordEncoding.getEncodedPassword());

        } catch (PasswordEncodingException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private String getPassword(ApplicationArguments args) {

        Set<String> options = args.getOptionNames();

        if (options.contains("password")) {

            if (args.getOptionValues("password").isEmpty()) {
                throw new PasswordEncodingException("You must enter a password.");
            }

            Optional<String> container = Optional.of(args.getOptionValues("password").get(0))
                .map(String::trim)
                .filter(arg -> !arg.isEmpty());

            return container.orElseThrow(() -> {
                throw new PasswordEncodingException("You must enter a password.");
            });
        }

        throw new PasswordEncodingException("You must enter a password.");
    }

    private String getAlgorithm(ApplicationArguments args) {

        Set<String> options = args.getOptionNames();

        if (options.contains("algorithm")) {

            if (args.getOptionValues("algorithm").isEmpty()) {
                return "bcrypt";
            }

            Optional<String> container = Optional.of(args.getOptionValues("algorithm").get(0))
            	.map(String::trim)
                .filter(arg -> !arg.isEmpty());

            return container.orElse("bcrypt");
        }

        return "bcrypt";
    }

    private void help() {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("help");

        String help = new BufferedReader(new InputStreamReader(inputStream))
                .lines()
                .collect(Collectors.joining(System.lineSeparator()));

        System.out.println(help);
    }
}
