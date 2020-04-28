package UserDao;


import java.security.PublicKey;

import org.omg.CORBA.PUBLIC_MEMBER;

import Userinformation.*;

public interface UserDao {
	 
	public int loginVerify(String user,String psw);
	public void insert(UserTel u);
	public void delete(String name);
	public void update(String name,String column,String information);
}
