package chatting;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
	Vector<ChatHandler> v;		

	public ChatServer( ) {
		try {
			ServerSocket ss = new ServerSocket(6150);
			v= new Vector<>();
			System.out.println("서버 준비 완료");
			while(true) {
				Socket s = ss.accept();
				ChatHandler c= new ChatHandler(this, s);
				System.out.println("클라이언트");
				c.start();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void register(ChatHandler c) {	 
		v.add(c);
	}

	public void unregister(ChatHandler c) {		
		v.remove(c);
	}
	
	 
	public synchronized  void broadcast(String message,ChatHandler chathandler) {	  
			for(int i=0; i<  v.size(); i++) {				 
				ChatHandler c = v.get(i);
				try {
					 if(chathandler!=c) {
				  	    c.disp(message);
					 }
				}catch(Exception e) {
					e.printStackTrace();
				}
			}	 	
		
	}
	
	
	

	public static void main(String[] args) {
	 
		new ChatServer( );

	}


		// TODO Auto-generated method stub
		
	}


