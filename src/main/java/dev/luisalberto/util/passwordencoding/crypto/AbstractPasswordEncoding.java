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

package dev.luisalberto.util.passwordencoding.crypto;

import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import dev.luisalberto.util.passwordencoding.exception.PasswordEncodingException;

public abstract class AbstractPasswordEncoding {

    protected String rawPassword = "";

    protected String algorithm = "";

    public AbstractPasswordEncoding(String rawPassword, String algorithm) {
        this.rawPassword =  rawPassword;
        this.algorithm = algorithm;
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
}
