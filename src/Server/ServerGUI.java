package Server;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class ServerGUI extends JFrame{

	public int aUsers = 0;
	public int cUsers = 0;
	public int rUsers = 0;

	private final int WIDTH = 500;
	private final int HEIGHT = 500;

	Server server = new Server();

	JFrame frame;

	Timer T;
    JButton logOut;
	JLabel activeUsers;
	JLabel connectedUsers;
	JLabel registeredUsers;
	JScrollPane loggedUserList;
	JTextArea output;
	JScrollPane lockoutList;
	JTextArea lockOutput;


    public ServerGUI()
	{
		// -- construct the base JFrame first
		super();

		frame = this;
		
		// -- set the application title
		this.setTitle("PerfectNumberGui");

		// -- initial size of the frame: width, height
		this.setSize(WIDTH, HEIGHT);

		// -- center the frame on the screen
		this.setLocationRelativeTo(null);

		// -- shut down the entire application when the frame is closed
		//    if you don't include this the application will continue to
		//    run in the background and you'll have to kill it by pressing
		//    the red square in eclipse
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// -- set the layout manager and add items
		//    5, 5 is the border around the edges of the areas
		//setLayout(new BorderLayout());


		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(new EmptyBorder(28, 28, 28, 28));


        

		//add the components to the pannel and set their location
		//-------------------------------------------------------
		logOut = new JButton("log out");
		logOut.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(logOut);

		registeredUsers = new JLabel("Registered users: " + rUsers);
		registeredUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(registeredUsers);

		activeUsers = new JLabel("Logged in users: " + aUsers);
		activeUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(activeUsers);

		connectedUsers = new JLabel("connected users: " + cUsers);
		connectedUsers.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(connectedUsers);

		int width = 10, height = 1;
		output = new JTextArea("",5,5);
		loggedUserList = new JScrollPane(output);
		loggedUserList.setSize(new Dimension(width,height));
		panel.add(loggedUserList);

		lockOutput=new JTextArea("",5,5);
		lockoutList = new JScrollPane(lockOutput);
		lockoutList.setSize(new Dimension(width,height));
		panel.add(lockoutList);

		//---------------------------------------------------------

		JPanel space = new JPanel();
		panel.add(space);


		this.getContentPane().add(panel);

		// -- can make it so the user cannot resize the frame
		this.setResizable(false);
        
		// -- show the frame on the screen
		this.setVisible(true);		

		server.start();
		T = new Timer(500,new RefreshContent());
		T.start();
	}

	class RefreshContent implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
			aUsers = server.getNumOfLoggedInUsers();
			cUsers = server.getNumOfConnectedClients();
			rUsers = server.getNumOfRegisteredUsers();
			activeUsers.setText("Logged in users: " + aUsers);
			connectedUsers.setText("connected users: " + cUsers);
			registeredUsers.setText("Registered users: " + rUsers);
			activeUsers.repaint();
			connectedUsers.repaint();
			frame.repaint();

			loggedUserList.removeAll();
			String [] usernames = server.getUsernamesOfConnectedUsers();
			String str = "";
			for(int i = 0; i < usernames.length; i++)
			{
				str += usernames[i] + "\n";
				
			}
			output.setText(str);
			loggedUserList.add(output);
			loggedUserList.repaint();
			frame.repaint();
            
			lockoutList.removeAll();
			String [] lockout = server.getLockedOutUsers();
			String st = "";
			for(int i = 0; i < lockout.length; i++)
			{
				st += lockout[i] + "\n";
				
			}
			lockOutput.setText(st);
			lockoutList.add(lockOutput);
			lockoutList.repaint();
			frame.repaint();




        }
        
    }
    

    public static void main(String [] args)
    {
        new ServerGUI();
    }
    
}
