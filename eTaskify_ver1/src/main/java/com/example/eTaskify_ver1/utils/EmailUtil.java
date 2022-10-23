package com.example.eTaskify_ver1.utils;

import com.example.eTaskify_ver1.dao.entity.UserEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailUtil {
    private JavaMailSender javaMailSender;
    private final String FROM = "noreply@abb-bank.az";

    public void notifyEmployeesByEmail(long taskId, List<UserEntity> userEntities){
        SimpleMailMessage msg;
        msg = new SimpleMailMessage();
        msg.setFrom(FROM);
        for(UserEntity user : userEntities){
            msg.setTo(user.getEmail());
        }
        msg.setSubject("New Task #" + taskId);
        msg.setText("Task #" + taskId + " Has Been Assigned To You");

        javaMailSender.send(msg);
    }
}
