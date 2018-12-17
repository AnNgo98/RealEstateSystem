package com.res.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {

    @Autowired
    private BCryptPasswordEncoder encoder;

    public String hashPassword(String passwordInput)
    {
        return encoder.encode(passwordInput + "~XT&|KT;");
    }

    public boolean checkPassword(String passwordInput, String passwordDB)
    {
        return encoder.matches(passwordInput + "~XT&|KT;", passwordDB);
    }
}
