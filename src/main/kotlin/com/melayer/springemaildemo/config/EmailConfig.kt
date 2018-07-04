package com.melayer.springemaildemo.config

import org.springframework.context.annotation.Configuration
import org.springframework.mail.SimpleMailMessage
import org.springframework.context.annotation.Bean
import org.springframework.mail.javamail.JavaMailSenderImpl
import org.springframework.mail.MailSender
import java.util.*

@Configuration
class EmailConfig {

    private fun getProperty(): Properties {

        val props = Properties()
        props["mail.smtp.auth"] = "true"
        props["mail.smtp.starttls.enable"] = "true"
        props["mail.smtp.host"] = "smtp.gmail.com"
        props["mail.smtp.port"] = "587"

        return props
    }

    @Bean
    fun mailSender(): MailSender {

        val mailSender = JavaMailSenderImpl()

        val properties = getProperty()

        mailSender.javaMailProperties = properties
        mailSender.username = "melayer.poojabhor@gmail.com"
        mailSender.password = "pooja@123"

        return mailSender
    }

    @Bean
    fun message(): SimpleMailMessage {

        val message = SimpleMailMessage()
        message.setFrom("melayer.poojabhor@gmail.com")

        return message
    }
}