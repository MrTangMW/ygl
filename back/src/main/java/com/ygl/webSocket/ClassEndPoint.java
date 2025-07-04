package com.ygl.webSocket;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: ClassEndPoint
 * @Description:
 * @Author:tangmw
 * @Date 2025-07-04
 * @Version 1.0
 */
@Component
@ServerEndpoint("/webSocket")
@CrossOrigin(origins = "*") // 允许所有来源的跨域请求
public class ClassEndPoint {

    private static Set<Session> sessions = Collections.synchronizedSet(new HashSet<>());

    @OnOpen
    public void onOpen(Session session) {
        sessions.add(session);
        System.out.println("新客户端连接：" + session.getId());
    }


    @OnMessage
    public void processGreeting(String message, Session session) {
        System.out.println("客户端发来消息：" + message);
        for (Session s : sessions) {
            if (s.isOpen()) {
                s.getAsyncRemote().sendText(message);
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable e) {
        e.printStackTrace();
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) {
        sessions.remove(session);
        System.out.println("关闭状态码：" + reason.getCloseCode().getCode());
    }
}
