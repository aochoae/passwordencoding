# Password Encoding

Password Encoding is a tool that helps to encrypt a password using
Spring Security.

Algorithms:

* bcrypt
* Argon2
* PBKDF2 _(Default)_
* scrypt

## Use

    java -jar passwordencoding.jar --password="qwerty" --algorithm=bcrypt

Output 

    qwerty
    $2a$10$ArnXbqsROFDghv4dPicPb.PoVuR4Kb0Bdf989DElKYKWOuBIVx.nW

## Build

    ./mvnw clean package -Dmaven.test.skip=true

## License

Copyright 2020-2021 Luis A. Ochoa

Password Encoding is licensed under the Apache 2.0 license.
See [LICENSE](LICENSE) for the full lecense text.
