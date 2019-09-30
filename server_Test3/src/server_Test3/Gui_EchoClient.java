package server_Test3;

import java.awt.event.*;
import java.io.*;
import java.net.*;
import javax.swing.*;

class ClientFrame extends JFrame implements ActionListener { 
	// Client UI
	JButton but_input =new JButton("�Է�");
	private JTextArea textArea=new JTextArea();
	private JTextField nameField=new JTextField();
	private JTextField textField = new JTextField();
	
	// out , in ���� 
	static PrintWriter writer = null; 
	static BufferedReader reader = null; 
	
	public ClientFrame() { 
		setSize(740, 440); 
		setTitle("�� â"); 
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
		if (arg0.getSource() == but_input) { 
			String s = nameField.getText()+" : " + textField.getText(); 	// �г��� : ä��
			textArea.append(s+"\n"); 	// ä��â�� ���
			writer.println(s); 			// ����(output)
			textField.setText(""); 		// �Է�â �ʱ�ȭ
		} 
	} 
	
	public void client() throws IOException { 
		Socket socket = null; 
		try { 
			socket = new Socket("192.168.0.40", 5555); 	// ���� ������ PC IP �Է�, ���� ���⤤
			writer = new PrintWriter(socket.getOutputStream(), true); 	// ����
			reader = new BufferedReader(new InputStreamReader( socket.getInputStream()));	// �б� 
			} catch (UnknownHostException e) { 
				System.err.println("localhost�� ������ �� �����ϴ�."); 
				System.exit(1); 	// UI����
			} catch (IOException eg) { 
					System.err.println("����� ����"); 
					System.exit(1);  // UI����
			} 
		
		String fromServer; 
		
		while ((fromServer = reader.readLine()) != null) { 		// �� �پ� �б�
			String s =fromServer+"\n"; 
			System.out.println(s); 
			textArea.append(s); 
			System.out.println(fromServer); 
			if (fromServer.equals("quit")) 
				break; 
			} 
		writer.close(); 	// ����
		reader.close(); 	// ����
		socket.close(); 	// ����
		} 
	}

	public class Gui_EchoClient {
		public static void main(String[] args) throws IOException{
			ClientFrame f = new ClientFrame(); 
			f.client();
	}
}
