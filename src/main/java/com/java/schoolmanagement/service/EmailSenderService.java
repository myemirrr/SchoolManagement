package com.java.schoolmanagement.service;

import java.io.File;

public interface EmailSenderService {
    void sendEmail(String to, String subject, String message);
}
