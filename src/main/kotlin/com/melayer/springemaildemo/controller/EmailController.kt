package com.melayer.springemaildemo.controller

import com.melayer.springemaildemo.domain.EmailData
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/email")
class EmailController(
        private val simpleMailMessage: SimpleMailMessage,
        private val mailSender: MailSender
) {
    private val logger = LoggerFactory.getLogger(EmailController::class.java)
    private val map = HashMap<String, Any>()

    @PostMapping("/sendEmail")
    fun sendMail(@RequestBody emailData: EmailData): ResponseEntity<*> {
        map.clear()
        simpleMailMessage.setTo(emailData.to)
        simpleMailMessage.setText(emailData.data!!)
        simpleMailMessage.setSubject(emailData.subject!!)
        mailSender.send(simpleMailMessage)
        map["status"] = "success"
        map["message"] = "Mail Send Successfully"
        logger.info("message send successfully")
        return ResponseEntity.ok(map)
    }
}