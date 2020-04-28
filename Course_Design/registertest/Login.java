package registertest;

import java.awt.EventQueue;


import java.awt.Image;
import java.awt.Insets;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;
import java.nio.file.WatchEvent.Kind;

import registertest.MainView;
import UserDao.daoRealise;
import javax.swing.JOptionPane;


class JTextFieldPassword extends JPasswordField {
    private ImageIcon icon;
 
    public JTextFieldPassword() {
//        获取当前路径下的图片
    	java.net.URL imgURL = Login.class.getResource("/image/psw.png");
        icon = new ImageIcon(imgURL);
        Insets insets = new Insets(0, 20, 0, 0);
        //设置文本输入距左边20
        this.setMargin(insets);
    }
    public void paintComponent(Graphics g) 
    {
        Insets insets = getInsets();
        super.paintComponent(g);
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        int Height = this.getHeight();
        //在文本框中画上之前图片
        icon.paintIcon(this, g, (insets.left - iconWidth)/2, (Height - iconHeight) / 2);
    }
}

class JTextFieldUser extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldUser() {
        //获取当前路径下的图片
    	java.net.URL imgURL = Login.class.getResource("/image/loginuser.png");
        icon = new ImageIcon(imgURL);
        Insets insets = new Insets(0, 20, 0, 0);
        //设置文本输入距左边20
        this.setMargin(insets);
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        Insets insets = getInsets();
        super.paintComponent(g);
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        int Height = this.getHeight();
        //在文本框中画上之前图片
        icon.paintIcon(this, g, (insets.left - iconWidth)/2, (Height - iconHeight) / 2);
    }
}


public class Login implements ActionListener{

	private JFrame frame;
	private JLabel lableregister;
	private JTextField textField_login;
	private JPasswordField passwordField;
	private JButton button;
	private ImageIcon icon;
	private ImageIcon icon_title;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Login();
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setFont(new Font("华文彩云", Font.PLAIN, 12));
		frame.setTitle("\u7535\u8BDD\u7C3F");
		frame.setBounds(549, 310, 233, 233);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		
		java.net.URL imgURL = Login.class.getResource("/image/timg.jpg");
		icon=new ImageIcon(imgURL);
		JLabel labback=new JLabel(icon);
		labback.setBounds(0,0,frame.getWidth(),frame.getHeight());
		JPanel panel1=(JPanel)frame.getContentPane();
		panel1.setOpaque(false);
		frame.getLayeredPane().add(labback,new Integer(Integer.MIN_VALUE));
		imgURL= Login.class.getResource("/image/title.png");
		icon_title=new ImageIcon(imgURL);
		frame.setIconImage(icon_title.getImage());
		
		lableregister = new JLabel("\u6CE8\u518C");
		lableregister.setForeground(new Color(0, 191, 255));
		lableregister.setFont(new Font("幼圆", Font.PLAIN, 12));
		lableregister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lableregister.setEnabled(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lableregister.setEnabled(false);
			}
		});
		lableregister.setEnabled(false);
		lableregister.setHorizontalAlignment(SwingConstants.CENTER);
		lableregister.setLabelFor(frame.getContentPane());
		lableregister.setBounds(0, 169, 54, 15);
		frame.getContentPane().add(lableregister);
		
		textField_login = new JTextFieldUser();
		textField_login.setBounds(37, 23, 147, 27);
		frame.getContentPane().add(textField_login);
		textField_login.setColumns(10);
		
		button = new JButton("\u767B\u5F55");
		button.setForeground(new Color(30, 144, 255));
		button.setFont(new Font("幼圆", Font.BOLD, 13));
		button.setBounds(37, 123, 147, 36);
		ImageIcon login_btn=new ImageIcon("src/login");
		login_btn.setImage(login_btn.getImage().getScaledInstance(200, 25, Image.SCALE_DEFAULT));
		button.setIcon(login_btn);
		button.setBorderPainted(false);
		button.setBorder(null);
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		frame.getContentPane().add(button);
		
		passwordField = new JTextFieldPassword();
		passwordField.setBounds(37, 70, 147, 27);
		frame.getContentPane().add(passwordField);
		button.addActionListener(this);
		
		frame.setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
	
		if (e.getSource()==button)
		{
			String user=textField_login.getText();
			String psw=passwordField.getText();
			if (user.equals("")||psw.equals("")) {
				JOptionPane.showMessageDialog(frame, "请填写完整");
			}
			daoRealise temp=new daoRealise();
			int i=temp.loginVerify(user, psw);
			if (i==1) {
				frame.dispose();
				new MainView();
			}
		}
		
	}
	
	
}
