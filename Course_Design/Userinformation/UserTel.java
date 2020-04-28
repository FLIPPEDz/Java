package Userinformation;

public class UserTel {
	/*
	 *  µÃÂ¿‡
	 * */	
	private String name;
	private String unitname;
	private String tel;
	private String gangway;
	private String unittel;
	private int group;
	
	public UserTel() {
	}
	public UserTel(String name, String unitname, String tel, String gangway,String unittel,int group) {
		super();
		this.name = name;
		this.unitname = unitname;
		this.tel = tel;
		this.gangway = gangway;
		this.unittel = unittel;
		this.group=group;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUnitname() {
		return unitname;
	}
	public void setUnitname(String unitname) {
		this.unitname = unitname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getGangway() {
		return gangway;
	}
	public void setGangway(String gangway) {
		this.gangway = gangway;
	}
	public String getUnittel() {
		return unittel;
	}
	public void setUnittel(String unittel) {
		this.unittel = unittel;
	}
	
	public int getGroup() {
		return group;
	}
	
	public void setGroup(int group) {
		this.group=group;
	}

}
