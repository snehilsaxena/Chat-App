/* Snehil Saxena And Vipray Jain */

import java.net.*;
import java.sql.Time;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.sun.glass.ui.Timer;


public class Server extends JFrame implements Runnable{

	/** Creates a new instance of myFrame */
    private JTextArea ChatBox=new JTextArea(10,45);
    private JScrollPane myChatHistory=new JScrollPane(ChatBox,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
            JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private JTextArea UserText = new JTextArea(5,40);
    private JScrollPane myUserHistory=new JScrollPane(UserText,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    private JButton Send = new JButton("Send");
    /* by vip */
      private JLabel lblByjainvipray= new JLabel("                                                                                                By-JainVipRay & SnehilSaxena");
      private JLabel S_his;
      private JLabel box;
      /* by vip */



	ServerSocket ss;
	Socket s;
	DataInputStream dis;
	DataOutputStream dos;

	public Server(){

		setTitle("Server by Snehil Saxena And Vipray Jain");
        setSize(560,400);
        Container cp=getContentPane();
        cp.setBackground(Color.decode("#6E58A3"));
        cp.setLayout(new FlowLayout());
        /* by vip */
        S_his=new JLabel("Server History");
        S_his.setForeground(Color.decode("#FFFFFF"));
        lblByjainvipray.setForeground(Color.decode("#FFFFFF"));
        box=new JLabel("Chat Box : ");
        box.setForeground(Color.decode("#FFFFFF"));
        /* by vip */
        cp.add(S_his);
        cp.add(myChatHistory);
        cp.add(box);
        cp.add(myUserHistory);
        cp.add(Send);
        /* by vip */
        cp.add(lblByjainvipray);
        /* by vip */





        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);






		try{
			ChatBox.append("Server Running"+"\n");
			ss = new ServerSocket(10);
			s = ss.accept();

			ChatBox.append(s.toString()+"\n");
			ChatBox.append("Client Connected"+"\n");
			System.out.println("Client Connected"+"\n");
			dis = new DataInputStream(s.getInputStream());
			dos = new DataOutputStream(s.getOutputStream());
			serverChat();
		}
		catch(Exception e){
			System.out.println(e);
		}

		 Send.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                //ChatServer.SendMassage(ServerAddress.getHostName()+" < Server > "+UserText.getText());
	            	//ChatBox.append("<Server> Started. \n");
	            	String msg=UserText.getText();
	            	try {
	            		System.out.println("doing");
	            		ChatBox.append("Server Message: " + msg +"\n");
						dos.writeUTF(msg);
						dos.flush();
						//ChatBox.append("Client Message: "+dis.readUTF()+"\n");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

	            }
	        });

	}

	public void serverChat() throws Exception{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str=null,s;


	try{
		System.out.println("djkj");
		if(dis.available()>0)
		ChatBox.append("Client Message: "+dis.readUTF()+"\n");

		//Thread.sleep(1000);

	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}






	}

	public static void main(String args[]){
		Server s=new Server();
		Thread t= new Thread(s);
		t.start();


	}

	public void run() {
		while(true){
			try {
				serverChat();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}



}

/* Snehil Saxena And Vipray Jain */