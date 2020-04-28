package sqltable;

import sqldriver.*;

import java.awt.ScrollPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.management.Query;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.sql.*;


public class Sqltable {

	static String sql;
	/*JTable jtable;
	private Connection coon;
	public Sqltable(String tables)throws SQLException
	{
		super("学生信息");
		this.setBounds(300,240,700,320);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		coon=JdbcUtil.getConnection();
		jtable = query(tables);
		this.getContentPane().add(new JScrollPane(jtable));
		this.setVisible(true);
	}*/
	
	
	public static JTable queryunitname(String column,String information)throws SQLException
	{
		DefaultTableModel dtm=new DefaultTableModel();
		if (column.equals("group")) {
			sql="select * from tel where["+ column+"]="+Integer.parseInt(information);
		}
		else
		{
			sql="select * from tel where "+column+" = '"+information+"'";
		}
		Connection coon=JdbcUtil.getConnection();
		Statement st=coon.createStatement();
		ResultSet rset=st.executeQuery(sql); 
		ResultSetMetaData rsmd = rset.getMetaData(); 
		int columnCount = rsmd.getColumnCount();
        for (int j=1; j<=columnCount; j++) 
            dtm.addColumn(rsmd.getColumnLabel(j));
        Object[]coulms=new Object[columnCount];
        while (rset.next()) {
			for(int j=1;j<=columnCount;j++)
				coulms[j-1]=rset.getString(j);
			dtm.addRow(coulms);
		}
        rset.close();
        st.close();
        return new JTable(dtm);
	}
	
	
	public static JTable queryname(String name)throws SQLException
	{
		DefaultTableModel dtm=new DefaultTableModel();
		sql="select * from tel where name='"+name+"'";
		Connection coon=JdbcUtil.getConnection();
		Statement st=coon.createStatement();
		ResultSet rset=st.executeQuery(sql); 
		ResultSetMetaData rsmd = rset.getMetaData(); 
		int columnCount = rsmd.getColumnCount();
        for (int j=1; j<=columnCount; j++) 
            dtm.addColumn(rsmd.getColumnLabel(j));
        Object[]coulms=new Object[columnCount];
        while (rset.next()) {
			for(int j=1;j<=columnCount;j++)
				coulms[j-1]=rset.getString(j);
			dtm.addRow(coulms);
		}
        rset.close();
        st.close();
        return new JTable(dtm);
	}
	
	public static JTable querytable()throws SQLException
	{
		DefaultTableModel dtm=new DefaultTableModel();
		sql="select * from tel";
		Connection coon=JdbcUtil.getConnection();
		Statement st=coon.createStatement();
		ResultSet rset=st.executeQuery(sql); 
		ResultSetMetaData rsmd = rset.getMetaData(); 
		int columnCount = rsmd.getColumnCount();
        for (int j=1; j<=columnCount; j++) 
            dtm.addColumn(rsmd.getColumnLabel(j));
        Object[]coulms=new Object[columnCount];
        while (rset.next()) {
			for(int j=1;j<=columnCount;j++)
				coulms[j-1]=rset.getString(j);
			dtm.addRow(coulms);
		}
        rset.close();
        st.close();
        return new JTable(dtm);
	}
	
    /*public void finalize() throws SQLException             //析构方法，关闭数据库连接
    {
        coon.close();
    }*/
	
    /*public static void main(String args[]) throws ClassNotFoundException, SQLException
    {
        new Sqltable("tel"); 
    }*/
	
	
}