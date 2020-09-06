package dev.luisalberto.util.passwordencoding;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import dev.luisalberto.util.passwordencoding.runner.PasswordEncoderRunner;

@SpringBootTest
class PasswordencodingApplicationTests {

    @Autowired
    private PasswordEncoderRunner passwordEncoderRunner;
    
	@Test
	public void contextLoads() {
	    assertNotNull(passwordEncoderRunner);
	}
}
