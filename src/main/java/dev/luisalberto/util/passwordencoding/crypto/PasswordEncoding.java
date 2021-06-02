/*
 * Copyright 2020-2021 Luis A. Ochoa
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

package dev.luisalberto.util.passwordencoding.crypto;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import dev.luisalberto.util.passwordencoding.exception.AlgorithmArgumentException;

/**
 * @author Luis A. Ochoa
 */
public class PasswordEncoding {

    private final String rawPassword;

    private final String algorithm;

    /**
     * Creates a new instance.
     *
     * @param rawPassword The raw password to encode
     * @param algorithm Id for password encoder
     */
    public PasswordEncoding(String rawPassword, String algorithm) {
        this.rawPassword =  rawPassword;
        this.algorithm = algorithm;
    }

    /**
     * Retrieves the password in plain text.
     *
     * @return The raw password.
     */
    public String getRawPassword() {
        return rawPassword;
    }

    /**
     * Retrieves the encrypted password.
     *
     * @return The encrypted password.
     */
    public String getEncodedPassword() {
        return getPasswordEncoderInstance().encode(rawPassword);
    }

    /**
     * Retrieve the implementation selected by passing the --algorithm param.
     *
     * @return PasswordEncoder implementation.
     */
    private PasswordEncoder getPasswordEncoderInstance() {

        PasswordEncoder passwordEncoder;

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
            throw new AlgorithmArgumentException();
        }

        return passwordEncoder;
    }
}
