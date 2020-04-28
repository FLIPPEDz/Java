package registertest;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.Component;

import javax.swing.Box;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.SystemColor;

import javax.swing.JPanel;

import UserDao.daoRealise;
import Userinformation.UserTel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;




class JTextFieldName extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldName() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/name.png");
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


class JTextFieldUnit extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldUnit() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/unit.png");
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

class JTextFieldTel extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldTel() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/tel.png");
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

class JTextFieldGangway extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldGangway() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/gangway.png");
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

class JTextFieldSectortel extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldSectortel() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/sectortel.png");
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

class JTextFieldGroup extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldGroup() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/group.png");
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








public class insertview {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private ImageIcon icon;
	private JLabel labbak;
	private ImageIcon icon_title;
	private JPanel JPanel;
	private UserTel tempUser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					insertview window = new insertview();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public insertview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(449, 200, 213, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		java.net.URL imgURL = insertview.class.getResource("/image/timg.jpg");
		icon=new ImageIcon(imgURL);
		JLabel labback=new JLabel(icon);
		labback.setBounds(0,0,frame.getWidth(),frame.getHeight());
		JPanel panel1=(JPanel)frame.getContentPane();
		panel1.setOpaque(false);
		frame.getLayeredPane().add(labback,new Integer(Integer.MIN_VALUE));
		
		imgURL = insertview.class.getResource("/image/mew.png");
		icon_title=new ImageIcon(imgURL);
		frame.setIconImage(icon_title.getImage());
		
		textField = new JTextFieldName();
		textField.setForeground(new Color(192, 192, 192));
		textField.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField.setText("\u59D3\u540D");
		textField.setColumns(10);
		textField.setBounds(10, 10, 177, 21);
		frame.getContentPane().add(textField);
		
		textField_1 = new JTextFieldUnit();
		textField_1.setText("\u5355\u4F4D\u540D\u79F0");
		textField_1.setForeground(new Color(192, 192, 192));
		textField_1.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_1.setColumns(10);
		textField_1.setBounds(10, 41, 177, 21);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextFieldTel();
		textField_2.setText("\u79FB\u52A8\u7535\u8BDD");
		textField_2.setForeground(new Color(192, 192, 192));
		textField_2.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_2.setColumns(10);
		textField_2.setBounds(10, 72, 177, 21);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextFieldGangway();
		textField_3.setText("\u56FA\u5B9A\u7535\u8BDD");
		textField_3.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_3.setForeground(new Color(192, 192, 192));
		textField_3.setColumns(10);
		textField_3.setBounds(10, 103, 177, 21);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextFieldSectortel();
		textField_4.setText("\u529E\u516C\u7535\u8BDD");
		textField_4.setForeground(new Color(192, 192, 192));
		textField_4.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_4.setColumns(10);
		textField_4.setBounds(10, 134, 177, 21);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextFieldGroup();
		textField_5.setText("\u5206\u7EC4");
		textField_5.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_5.setForeground(new Color(192, 192, 192));
		textField_5.setColumns(10);
		textField_5.setBounds(10, 165, 177, 21);
		frame.getContentPane().add(textField_5);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserTel temp=new UserTel();
				temp.setName(textField.getText());
				temp.setUnitname(textField_1.getText());
				temp.setTel(textField_2.getText());
				temp.setGangway(textField_3.getText());
				temp.setUnittel(textField_4.getText());
				temp.setGroup(Integer.parseInt(textField_5.getText()));
				
				if(temp.getName().equals("")||temp.getName().equals("")||temp.getName().equals("")||temp.getName().equals("")||temp.getName().equals(""))
				{
					JOptionPane.showMessageDialog(null, "请填写完整");
					return;
				}
				daoRealise daotemp=new daoRealise();
				daotemp.insert(temp);
				
			}
		});
		button.setBackground(SystemColor.activeCaption);
		button.setForeground(new Color(255, 0, 0));
		button.setFont(new Font("幼圆", Font.PLAIN, 12));
		button.setBounds(10, 196, 177, 40);
		frame.getContentPane().add(button);
		
		frame.setTitle("添加");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
