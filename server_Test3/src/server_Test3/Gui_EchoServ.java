package server_Test3;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class SFrame extends JFrame implements ActionListener{
	// Server UI
	JButton but_input= new JButton("�Է�");	
	private JTextArea textArea=new JTextArea();
	private JTextField nameField=new JTextField("������");
	private JTextField textField = new JTextField(); 
	
	static ServerSocket serverSocket = null; 
	static Socket clientSocket =null; 
	static PrintWriter writer; 		// output
	static BufferedReader reader; 	// input
	static String inputLine, outputLine; 
	
	public SFrame(){ 
		setSize(740, 440); 
		setTitle("POS â"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		textArea.setBounds(10, 10, 700, 300);
		add(textArea);
		nameField.setBounds(10, 320, 200, 30);
		add(nameField);
		textField.setBounds(10, 360, 600, 30);
		add(textField);
		but_input.setBounds(630, 360, 70, 30);
		add(but_input);
		but_input.addActionListener(this);  
	} 
	
	@Override public void actionPerformed(ActionEvent arg0) { 	// �Է� ��ư ���
		String s; 
		s=nameField.getText()+" : "+textField.getText(); 	// �г��� : ä��
		if(arg0.getSource()==but_input){ 
			textArea.append(s+"\n"); 	// ä��â�� ���
			writer.println(s); 			// ����(output)
			textField.setText(""); 		// �Է�â �ʱ�ȭ
			} 
//		if(arg0.getSource()==button){ 
//		} 
	} 
	
	public void serverStart() throws IOException{ 
		System.out.println("���� ����!"); 
		
		try{ 
			serverSocket = new ServerSocket(5555); 	// 5555��Ʈ�� �� ���� ����
		}catch(IOException e){ 
			System.out.println("������ ��Ʈ ��ȣ�� ������ �� �����ϴ� : 5555"); 
			System.exit(1); 	// UI����
		} 
		
		clientSocket = null; // ����
		
		try{ 
			clientSocket = serverSocket.accept(); 	// �������� ���
		}catch(IOException e){ 
			System.err.println("accept() ���� "); 
			System.exit(1); 	// ����
		} 
		
		writer = new PrintWriter(clientSocket.getOutputStream(),true); 	// ����
		reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));	// �б� 
		
		// ���� ����� ��µǴ� ����
		outputLine = "ī�� : ������ ���͵帱���?"; 	
		writer.println(outputLine); 
		textArea.append("���� �޽��� : ������ �����û.\n"); 		
		
		while((inputLine = reader.readLine())!=null){ 	// �� �پ� �б�
			String s =inputLine+"\n"; 	// s ��Ʈ�������� ����
			System.out.println(s); 		
			textArea.append(s); 		// ä��â�� ���
			//outputLine = inputLine; 
			//out.println(outputLine); 
			if(outputLine.equals("quit")) 
				break; 
		} 
	}
}

public class Gui_EchoServ {
	public static void main(String[] args) throws IOException{
		SFrame f = new SFrame(); 
		f.serverStart(); 
	}
}
