package com.hndfsj.springbootwebsocket.service;

import com.hndfsj.springbootwebsocket.bean.WiselyResponse;
import com.hndfsj.springbootwebsocket.constant.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <pre>
 * TODO：service
 * </pre>
 *
 * @author zhangjunchao
 * @date 2019/7/2
 */
@Service
public class WebSocketService {
    @Autowired
    private SimpMessagingTemplate template;

    /**
     * 广播
     * 发给所有在线用户
     *
     * @param msg
     */
    public void sendMsg(WiselyResponse msg) {
        template.convertAndSend(Constant.PRODUCERPATH, msg);
    }

    /**
     * 发送给指定用户
     * @param users
     * @param msg
     */
    public void send2Users(List<String> users, String msg) {
        for (String user : users) {
            template.convertAndSendToUser(user, Constant.P2PPUSHPATH, msg);
            System.out.println(user);
            System.out.println(msg);

        }
    }
   //jdk1.8
   /* public void send2Users(List<String> users, WiselyResponse msg) {
        users.forEach(userName -> {
            template.convertAndSendToUser(userName, Constant.P2PPUSHPATH, msg);
        });
    }*/



}
