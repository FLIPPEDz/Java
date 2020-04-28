package sqldriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public final class JdbcUtil{
    private static final String url = "jdbc:sqlserver://localhost:1433;DataBaseName=telproject";//连接字符串
    private static final String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";//驱动程序
    private static final String user = "sa";//用户名
    private static final String password = "123456";//密码  

    private JdbcUtil(){     }
    static{
          try{
	    Class.forName(driverName);
	  }catch(Exception e){
	    e.printStackTrace();
	  }
	}
    
    public static Connection getConnection(){		
	Connection con = null;
	try {
	        con = DriverManager.getConnection(url, user,password);
        } catch (Exception e) {
			e.printStackTrace();
		}
	return con;
	}
 
    public static void close(ResultSet rs, Statement pstmt ,Connection con){
	   try{
		 if(rs!=null) rs.close();
	   }catch(Exception e){
	     e.printStackTrace();
	   }
	   try{
		 if(pstmt!=null) pstmt.close();
	   }catch(Exception e){
	     e.printStackTrace();
	   }
	   try{
		 if(con!=null) con.close();
	   }catch(Exception e){
	     e.printStackTrace();
	   }
	}
     public static void close(Object o){
	   try{
	     if(o instanceof ResultSet){
		   ((ResultSet)o).close();
		 }else if(o instanceof PreparedStatement){
		   ((PreparedStatement)o).close();
		 }else if(o instanceof Connection){
		   ((Connection)o).close();
		 } 
	   }catch(Exception e){
	     e.printStackTrace();
	   }
	}
}
