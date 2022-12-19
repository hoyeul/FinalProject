package chatting;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

 

public class Client{
	   private Socket clientSocket;
	   private DataInputStream dataInputStream;
	   private DataOutputStream dataOutputStream;

	   

	   
	  public void dataRecv() {
		  Thread th = new Thread( new Runnable () {		  
		  @Override public void run() { 
			while(true) { 
				try {
			        System.out.println(dataInputStream.readUTF());		   
				} catch (IOException e) {			 
						e.printStackTrace(); 
				} 				
			  }
			}  //run		   
		  });
		   
		  th.start();
		}
		    
		 
		  public void dataSend() {  new Thread(  new Runnable() {	
			  Scanner in = new Scanner(System.in);
			  @Override public void run() {					 
			      while(true) {
			    	  try{ String sendData = in.nextLine();
			               dataOutputStream.writeUTF(sendData);
			         }catch(Exception e){
			               e.printStackTrace(); 
			         } 			    	  
			      } 
			       
			    } //run			  
		      }).start() ;		   
		  }
		 

		public Client(){
		 try {
		     clientSocket= new Socket("localhost", 6150);
	         System.out.println("서버접속요청");
	 	     dataInputStream = new DataInputStream(clientSocket.getInputStream());
		     dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		   
		    dataSend();
		    dataRecv();		    
		   
		}

		 
	public static void main(String[] args) {		
		new Client();

	}

}

