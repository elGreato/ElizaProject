package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ElizaModel {
	ElizaView view;
	Socket s;
	DataInputStream din;
	DataOutputStream dout;
	public ElizaModel(ElizaView view){
		this.view=view;
			

	try {
		
		s = new Socket("127.0.0.1",1342);
	din= new DataInputStream(s.getInputStream());
	dout = new DataOutputStream(s.getOutputStream());

	
	}
	catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	
	}}
	public void sendToServer() {

		String userinputString = view.txtInput.getText();
		
		view.txtArea.appendText("> You: " + userinputString+"\n");
		
		try {
			dout.writeUTF(userinputString);
			view.txtArea.appendText(din.readUTF());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}