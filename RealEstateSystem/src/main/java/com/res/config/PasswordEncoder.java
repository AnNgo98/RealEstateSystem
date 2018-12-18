package com.res.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoder {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public String hashPassword(String passwordInput)
    {
        return encoder.encode(passwordInput + "~XT&|KT;");
    }

    public boolean checkPassword(String passwordInput, String passwordDB)
    {
        return encoder.matches(passwordInput + "~XT&|KT;", passwordDB);
    }
}
