package com.example.test;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/ws")
public class TestWebSocket {
	
	
	public TestWebSocket() {
	}
		
	
	@OnMessage
    public void onMessage(Session session, String message) {
	    System.out.println("### Testing onMessage");
        test(session);
    }
	
	
	@OnOpen
    public void onOpen (Session session) {
	    System.out.println("### Testing onOpen");
	    test(session);
    }

    @OnClose
    public void onClose (Session session) {
    }
    
    private void test(Session session) {
        TestClass testClass = new TestClass();
        try {
            session.getBasicRemote().sendText("Files Found: " + testClass.getValue());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}