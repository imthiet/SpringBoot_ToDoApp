package com.thietAppp.springboot.todoApp.Login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode("1234");
        System.out.println(encodedPassword);  // Lưu giá trị này vào cơ sở dữ liệu
    }
}
