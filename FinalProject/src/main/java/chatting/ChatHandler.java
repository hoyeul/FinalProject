package chatting;

 
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException; 
import java.net.Socket;



public class ChatHandler  extends Thread{

	Socket s;
	ChatServer cs;
	DataInputStream in;
	DataOutputStream out;
	
	
	public ChatHandler(ChatServer cs, Socket s) throws IOException {
		this.s = s;
		this.cs =cs;
		in= new DataInputStream(s.getInputStream());
		out = new DataOutputStream(s.getOutputStream());
	}
	
	public void run() {
		String name="";
		try {
			name=in.readUTF();
			cs.register(this);   //생성된 객체를(chatHadler 객체)서버의 배열(벡터)에 담기
			cs.broadcast(name + "님이 방문하셨습니다" ,this );
			
			while(true) {
				String msg =in.readUTF();
				cs.broadcast(name + "님의 말:" + msg ,this);
			}			
			
		}catch(Exception e) {			 
			System.out.println("나감");
		}
		
		cs.unregister(this); //생성된 객체를(chatHadler 객체)서버의 배열(벡터)에서 제거하기
		cs.broadcast(name + "님이 나가셨습니다",this  );
		
		//쓰레드 종료전에 모든 스트림 종료
		try {
			in.close();
			out.close();
			s.close();
		}catch(IOException e) {
			//e.printStackTrace();
		}		
		
	}
	
	public void disp(String message) throws IOException {
		out.writeUTF(message);
	}
}
