package registertest;

import sqltable.*;

import java.awt.EventQueue;








import javax.swing.JScrollPane;








import java.awt.Button;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.ScrollPane;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.Font;
import java.awt.Color;
import java.sql.SQLException;

import javax.swing.UIManager;

import registertest.insertview;
import registertest.Deleteview;
import UserDao.daoRealise;



class JTextFieldcolumns extends JTextField {
    private ImageIcon icon;
 
    public JTextFieldcolumns() {
        //获取当前路径下的图片
    	java.net.URL imgURL = Login.class.getResource("/image/column.png");
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


class JTextFieldInner extends JTextField {
    private ImageIcon icon;
    
 
    public JTextFieldInner() {
        //获取当前路径下的图片
    	java.net.URL imgURL = MainView.class.getResource("/image/inner.png");
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

public class MainView implements ActionListener{

	private JFrame frame;
	private JTextField textField_infromation;
	private JPanel tablePanel;
	private ImageIcon icon;
	private JLabel labbak;
	private ImageIcon icon_title;
	private JTable jatJTable;
	private JTextField textField_column;
	private JButton queryButton;
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==queryButton) {
			jatJTable.getModel().addTableModelListener(new TableModelListener()
			{
				public void tableChanged(TableModelEvent e)
				{
					int row=e.getFirstRow();
					int col=e.getColumn();
					TableModel model=(TableModel)e.getSource();
					String valuetest=model.getValueAt(row, col).toString();
					String value=jatJTable.getValueAt(row, col).toString();
					System.out.println(valuetest);
					System.out.println(value);

				}
			});
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
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
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(449, 200, 520, 374);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 515, 35);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		tablePanel = new JPanel();
		tablePanel.setBounds(0, 45, 515, 300);
		frame.getContentPane().add(tablePanel);
		tablePanel.setLayout(null);
		tablePanel.setOpaque(false);
		
		
		
		java.net.URL imgURL = MainView.class.getResource("/image/timg.jpg");
		icon=new ImageIcon(imgURL);
		JLabel labback=new JLabel(icon);
		labback.setBounds(0,0,frame.getWidth(),frame.getHeight());
		JPanel panel1=(JPanel)frame.getContentPane();
		panel1.setOpaque(false);
		frame.getLayeredPane().add(labback,new Integer(Integer.MIN_VALUE));
		imgURL = MainView.class.getResource("/image/magnet.png");
		icon_title=new ImageIcon(imgURL);
		frame.setIconImage(icon_title.getImage());
		
		
		
		
		panel.setOpaque(false);
		
		textField_infromation = new JTextFieldInner();
		textField_infromation.setBounds(0, 0, 146, 36);
		panel.add(textField_infromation);
		textField_infromation.setColumns(10);
		
		queryButton = new JButton("\u67E5\u8BE2");
		queryButton.setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
		queryButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		queryButton.setToolTipText("\u8BF7\u8F93\u5165\u8054\u7CFB\u4EBA\u540D\u79F0\u6216\u5355\u4F4D\u540D\u79F0\u6216\u5206\u7EC4\u4FE1\u606F");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String column=textField_column.getText();
				String information=textField_infromation.getText();
				if (column.equals("")||information.equals("")) {
					JOptionPane.showMessageDialog(frame, "请填写完整");
				}
				
				try 
				{
					jatJTable=Sqltable.queryunitname(column,information);
					JScrollPane jScrollPane=new JScrollPane(jatJTable);
					jScrollPane.setBounds(0, 0, 515, 290);
					tablePanel.add(jScrollPane);
					
					
					
				} catch (Exception e2) 
				{
					// TODO: handle exception
					e2.printStackTrace();
				}
			
			}
		});
		queryButton.setBounds(279, 0, 65, 37);
		panel.add(queryButton);
		
		JButton updateButton = new JButton("\u66F4\u65B0");
		updateButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				new Deleteview();
				
			}
		});
		updateButton.setBounds(333, 0, 65, 37);
		panel.add(updateButton);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String inner=textField_infromation.getText();
				daoRealise temp = new daoRealise();
				temp.delete(inner);
			}
		});
		deleteButton.setToolTipText("\u8BF7\u8F93\u5165\u8054\u7CFB\u4EBA\u79FB\u52A8\u7535\u8BDD");
		deleteButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		deleteButton.setBounds(388, 0, 65, 37);
		panel.add(deleteButton);
		
		JButton insertButton = new JButton("\u6DFB\u52A0");
		insertButton.setFont(new Font("幼圆", Font.PLAIN, 12));
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//frame.dispose();
				new insertview();
			}
		});
		insertButton.setBounds(450, 0, 65, 37);
		panel.add(insertButton);
		
		textField_column = new JTextFieldcolumns();
		textField_column.setBounds(147, 0, 132, 36);
		panel.add(textField_column);
		textField_column.setColumns(10);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(0, 45, 515, -10);
		frame.getContentPane().add(horizontalStrut);
		

		//tablePanel.setBackground(null);
		//tablePanel.setOpaque(false);
		
		frame.setTitle("主窗口");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		
		jatJTable=null;
		/*jatJTable.getModel().addTableModelListener(new TableModelListener()
		{
			public void tableChanged(TableModelEvent e)
			{
				int row=e.getFirstRow();
				int col=e.getColumn();
				TableModel model=(TableModel)e.getSource();
				String valuetest=model.getValueAt(row, col).toString();
				String value=jatJTable.getValueAt(row, col).toString();
				System.out.println(valuetest);
				System.out.println(value);

			}
		});*/
	}
	
	/*public  void tableprint(String column,String information)
	{
			
		try 
		{
			jatJTable=Sqltable. queryunitname(column,information);
			JScrollPane jScrollPane=new JScrollPane(jatJTable);
			jScrollPane.setBounds(0, 0, 515, 290);
			tablePanel.add(jScrollPane);
			
			
			
		} catch (Exception e2) 
		{
			// TODO: handle exception
			e2.printStackTrace();
		}
	 }*/
	
}
