package com.example.ilaydaaozensimplebookservice;

import com.example.ilaydaaozensimplebookservice.security.PasswordService;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

class PasswordEncoderTest
{
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    private final PasswordService passwordService = new PasswordService(encoder);

    @Test
    void shouldHashPassword()
    {
        String password = "password123";
        String hashed = passwordService.hashPassword(password);

        assertNotEquals(password, hashed);
    }

    @Test
    void shouldVerifyPassword()
    {
        String password = "password123";
        String hashed = passwordService.hashPassword(password);

        assertTrue(passwordService.verifyPassword(hashed, password));
    }

    @Test
    void shouldReturnTrueIfPasswordIsValid() {
        String password = "password123";
        String hashed = passwordService.hashPassword(password);

        assertFalse(passwordService.verifyPassword(hashed, password));
    }
}