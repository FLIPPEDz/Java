package UserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


import sqldriver.*;
import Userinformation.UserTel;

public class daoRealise implements UserDao {
	
	public int loginVerify(String user,String psw)
	{
		Connection coon=JdbcUtil.getConnection();
		       try {  
			            PreparedStatement ps=coon.prepareStatement("select * from teluser where id=? and psw=? ");  
			            ps.setString(1, user);  
			            ps.setString(2, psw);   
			           ResultSet rs = ps.executeQuery();  
			              
			            if(rs.next())  
				            {  
				                JOptionPane.showMessageDialog(null, "登录成功！！！", "提示消息", JOptionPane.WARNING_MESSAGE);  
				                rs.close();
				                ps.close();
				                return 1;
				            }
			            else  
			            	{  
			                	JOptionPane.showMessageDialog(null, "用户名或者密码错误，请重新输入！", "提示消息", JOptionPane.ERROR_MESSAGE);  
			                	rs.close();
			                	ps.close();
			                	return 0;
				            }  
				              
				        } catch (SQLException e) {  
				              
				            e.printStackTrace();  
				        } 
		       finally
		       {
		    	   try {
		    		   coon.close();
					
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
		       }
		       return 0;

	}
	
	public void insert(UserTel u)
	{
		Connection coon=JdbcUtil.getConnection();
		try {
			
            PreparedStatement ps=coon.prepareStatement("insert into tel values(?,?,?,?,?,?)");  
            ps.setString(1, u.getName());  
            ps.setString(2, u.getUnitname());
            ps.setString(3,	u.getTel());
            ps.setString(4,	u.getGangway());
            ps.setString(5,	u.getUnittel());
            ps.setInt(6, u.getGroup());
            
            int i=ps.executeUpdate();
            if (i>0) {
            	
            	JOptionPane.showMessageDialog(null, "插入成功！", "提示消息", JOptionPane.WARNING_MESSAGE); 
				
			} else {
				JOptionPane.showMessageDialog(null, "插入失败！", "提示消息", JOptionPane.ERROR_MESSAGE);  
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void delete(String name)
	{
		
		Connection coon=JdbcUtil.getConnection();
		try {
			
            PreparedStatement ps=coon.prepareStatement("DELETE FROM tel WHERE name=?");  
            ps.setString(1, name);  
   
            
            int i=ps.executeUpdate();
            if (i>0) {
            	
            	JOptionPane.showMessageDialog(null, "删除成功！", "提示消息", JOptionPane.WARNING_MESSAGE); 
				
			} else {
				JOptionPane.showMessageDialog(null, "删除失败！", "提示消息", JOptionPane.ERROR_MESSAGE);  
			}
            
            coon.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public void update(String name,String column,String information)
	{
		Connection coon=JdbcUtil.getConnection();
		PreparedStatement ps=null;
		try {
			if (column.equals("group")) {
				String sql="UPDATE tel SET["+column+"]="+Integer.parseInt(information)+"WHERE name='"+name+"'";
				ps=coon.prepareStatement(sql);
			}
			
			else {
				String sql="UPDATE tel SET "+column+"='"+information+"'WHERE name='"+name+"'";
				ps=coon.prepareStatement(sql);
			}
         
            
   
            
            int i=ps.executeUpdate();
            if (i>0) {
            	
            	JOptionPane.showMessageDialog(null, "更新成功！", "提示消息", JOptionPane.WARNING_MESSAGE); 
				
			} else {
				JOptionPane.showMessageDialog(null, "更新失败！", "提示消息", JOptionPane.ERROR_MESSAGE);  
			}
            
            coon.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
