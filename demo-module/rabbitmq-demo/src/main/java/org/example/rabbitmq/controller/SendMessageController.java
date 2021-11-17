package org.example.rabbitmq.controller;

import cn.hutool.core.util.StrUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/*
 *@ClassName SendMessageController
 *@Description TODO
 *@Author 武万章
 *@Date 2021/11/17 17:11
 */
@RestController
@RequestMapping("/sendMessage")
public class SendMessageController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/direct")
    public String sendDirectMessage() {
        String messageId = StrUtil.uuid();
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        //将消息携带绑定键值：TestDirectRouting 发送到交换机TestDirectExchange
        rabbitTemplate.convertAndSend("TestDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

}
