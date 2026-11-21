
package com.example.ilaydaaozensimplebookservice;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordHashGenerator {

    public static void main(String[] args) {

        PasswordEncoder encoder = new BCryptPasswordEncoder();

        String correctPassword = "password123";
        String incorrectPassword = "password456";

        String hashedPassword = encoder.encode(correctPassword);

        System.out.println("Generated BCrypt Hash:");
        System.out.println(hashedPassword);

        System.out.println("Correct password matches:");
        System.out.println(
                encoder.matches(correctPassword, hashedPassword)
        );

        System.out.println("Incorrect password matches:");
        System.out.println(
                encoder.matches(incorrectPassword, hashedPassword)
        );
    }
}
