package com.jm.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.UnknownHostException;

import org.java_websocket.WebSocketImpl;

public class SocketThread  extends Thread{
	
private ChatServer chatServer=null;
private BufferedReader sysin;
	public SocketThread() {
		WebSocketImpl.DEBUG = true;
		if (chatServer==null) {
			int port = 8886; // 843 flash policy port
			try {
				chatServer= new ChatServer( port );
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		chatServer.start();
		System.out.println( "ChatServer started on port: " + chatServer.getPort() );
	    sysin = new BufferedReader( new InputStreamReader( System.in ) );
	}
   
   @Override
	public void run() {
	   try {
		// TODO Auto-generated method stub
	   while(!this.isInterrupted()) {
			String in = sysin.readLine();
			chatServer.broadcast( in );
			if( in.equals( "exit" ) ) {
			 chatServer.stop(1000);
				break;
			}
	      } 
	   }
	   catch (Exception e) {
			e.printStackTrace();
		}
   }

  
}
