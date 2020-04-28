package registertest;

import java.awt.EventQueue;

import UserDao.daoRealise;
import javax.swing.JOptionPane;


import java.awt.Image;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import javax.swing.JPanel;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


class JTextFieldDName extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldDName() {
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

class JTextFieldDColumn extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldDColumn() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/column.png");
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

class JTextFieldDInner extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldDInner() {
        //获取当前路径下的图片
    	java.net.URL imgURL = insertview.class.getResource("/image/d_inner.png");
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









public class Deleteview {

	private JFrame frame;
	private JTextField textField_name;
	private JTextField textField_column;
	private JTextField textField_inner;
	private JLabel labbak;
	private ImageIcon icon;
	private ImageIcon icon_title;
	private JPanel JPanel;
	private String tempname,tempcolumn,tempinformation;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleteview window = new Deleteview();
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
	public Deleteview() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		frame.setFont(new Font("幼圆", Font.PLAIN, 12));
		frame.setForeground(new Color(255, 0, 0));
		frame.setBounds(449, 200, 209, 221);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		java.net.URL imgURL = insertview.class.getResource("/image/timg.jpg");
		icon=new ImageIcon(imgURL);
		JLabel labback=new JLabel(icon);
		labback.setBounds(0,0,frame.getWidth(),frame.getHeight());
		JPanel panel1=(JPanel)frame.getContentPane();
		panel1.setOpaque(false);
		frame.getLayeredPane().add(labback,new Integer(Integer.MIN_VALUE));
		imgURL = insertview.class.getResource("/image/tree.png");
		icon_title=new ImageIcon(imgURL);
		frame.setIconImage(icon_title.getImage());
		
		textField_name = new JTextFieldDName();
		textField_name.setText("\u540D\u5B57");
		textField_name.setForeground(new Color(192, 192, 192));
		textField_name.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_name.setBounds(10, 10, 174, 31);
		frame.getContentPane().add(textField_name);
		textField_name.setColumns(10);
		
		textField_column = new JTextFieldDColumn();
		textField_column.setText("\u66F4\u65B0\u5217");
		textField_column.setForeground(new Color(192, 192, 192));
		textField_column.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_column.setColumns(10);
		textField_column.setBounds(10, 51, 174, 31);
		frame.getContentPane().add(textField_column);
		
		JButton button = new JButton("\u66F4\u65B0");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				daoRealise temp= new daoRealise();
				tempname=textField_name.getText();
				tempcolumn=textField_column.getText();
				tempinformation=textField_inner.getText();
				if(tempname.equals("")||tempcolumn.equals("")||tempinformation.equals(""))
				{
					JOptionPane.showMessageDialog(null, "请填写完整");
					return;
				}
				temp.update(tempname, tempcolumn, tempinformation);
			}
		});
		button.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		button.setFont(new Font("幼圆", Font.BOLD, 16));
		button.setForeground(new Color(255, 0, 0));
		button.setBounds(10, 134, 174, 38);
		frame.getContentPane().add(button);
		
		textField_inner = new JTextFieldDInner();
		textField_inner.setText("\u5185\u5BB9");
		textField_inner.setForeground(Color.LIGHT_GRAY);
		textField_inner.setFont(new Font("幼圆", Font.PLAIN, 12));
		textField_inner.setColumns(10);
		textField_inner.setBounds(10, 92, 174, 31);
		frame.getContentPane().add(textField_inner);
		
		frame.setTitle("更新");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
	}
}
