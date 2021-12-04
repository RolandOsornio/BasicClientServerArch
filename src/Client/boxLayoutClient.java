package Client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class boxLayoutClient extends JFrame {
    //login
    //sign up

    private final int WIDTH = 500;
    private final int HEIGHT = 500;

    //add elements here
    JTextArea password;
    JTextArea username;
    JLabel p;
    JLabel u;
    JButton submit;
    JButton signUp;
    JScrollPane pass;
    JScrollPane user;
    JTextArea confirm;
    JTextArea email;
    JLabel c;
    JLabel e;
    JScrollPane con;
    JScrollPane male;

    JFrame frame;

    // make panels
    JPanel LogInUser = logIn();
    JPanel SignUpUser = signUp();

    //logic for which panel is visible
    public int visible = 0;

    public boxLayoutClient()
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

		// -- can make it so the user cannot resize the frame
		this.setResizable(false);
        
		// -- show the frame on the screen
		this.setVisible(true);

        this.add(LogInUser);
	}

    public void CreateComponents()
    {}

    public JPanel logIn()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(new EmptyBorder(28, 28, 28, 28));

		//add the components to the pannel and set their location
		//-------------------------------------------------------
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        u = new JLabel("username");
		u.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(u);


        username = new JTextArea("",1, 500);
        user = new JScrollPane(username);
        user.setAutoscrolls(true);
        user.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		user.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(user);

        p = new JLabel("password");
		p.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(p);

        password = new JTextArea("",1, 500);
        pass = new JScrollPane(password);
        pass.setAutoscrolls(true);
        pass.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pass.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(pass);

        submit = new JButton("submit");
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(submit);

        signUp = new JButton("sign up");
		signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUp.addActionListener(new signUpListener());
        panel.add(signUp);

		//---------------------------------------------------------

        return panel;
    }

    public JPanel signUp()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBorder(new EmptyBorder(28, 28, 28, 28));

		//add the components to the pannel and set their location
		//-------------------------------------------------------
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        u = new JLabel("username");
		u.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(u);


        username = new JTextArea("",1, 500);
        user = new JScrollPane(username);
        user.setAutoscrolls(true);
        user.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		user.setAlignmentX(Component.CENTER_ALIGNMENT);

        p = new JLabel("password");
		p.setAlignmentX(Component.CENTER_ALIGNMENT);

        password = new JTextArea("",1, 500);
        pass = new JScrollPane(password);
        pass.setAutoscrolls(true);
        pass.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		pass.setAlignmentX(Component.CENTER_ALIGNMENT);

        submit = new JButton("submit");
		submit.setAlignmentX(Component.CENTER_ALIGNMENT);

        e = new JLabel("email");
        email = new JTextArea("",1, 5);
        male = new JScrollPane(email);
        male.setAutoscrolls(true);
        male.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        e.setAlignmentX(Component.CENTER_ALIGNMENT);
        male.setAlignmentX(Component.CENTER_ALIGNMENT);

        /*
        c = new JLabel("confirm password");
        confirm = new JTextArea("",1, 5);
        con = new JScrollPane(confirm);
        c.setAlignmentX(Component.CENTER_ALIGNMENT);
        con.setAutoscrolls(true);
        con.setAlignmentX(Component.CENTER_ALIGNMENT);
        con.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        */

        signUp = new JButton("sign up");
		signUp.setAlignmentX(Component.CENTER_ALIGNMENT);
        signUp.addActionListener(new signUpListener());

		//---------------------------------------------------------

        panel.add(u);
        panel.add(user);
        panel.add(e);
        panel.add(male);
        panel.add(p);
        panel.add(pass);
        //panel.add(c);
        //panel.add(con);
        panel.add(submit);


        return panel;
    }

    class signUpListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            frame.add(SignUpUser);
            SignUpUser.setVisible(true);
            LogInUser.setVisible(false);
            LogInUser.repaint();
            SignUpUser.repaint();         
            frame.repaint();

        }
        
    }

    class NewUserSubmit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            
        }
        
    }

	
    public static void main(String [] args)
    {
        new boxLayoutClient();
    }
}