# Password Encoding

Password Encoding is a tool that helps to encrypt a password using
Spring Security.

Algorithms:

* bcrypt
* Argon2
* PBKDF2
* scrypt

## Use

    java -jar passwordencoding.jar --password="qwerty"
    java -jar passwordencoding.jar --password="qwerty" --algorithm=bcrypt

## Build

    ./mvnw clean package -Dmaven.test.skip=true

## License

Copyright 2020 Luis A. Ochoa

Password Encoding is licensed under the Apache 2.0 license.
See [LICENSE](LICENSE) for the full lecense text.
