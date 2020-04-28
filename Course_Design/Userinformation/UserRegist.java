package Userinformation;

public class UserRegist {
		/*
		 *  µÃÂ¿‡
		 * */	
		private String id;
		private String psw;
		private String tel;
		
		public UserRegist() {
		}
		public UserRegist(String id, String psw, String tel) {
			super();
			this.id = id;
			this.psw = psw;
			this.tel = tel;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPsw() {
			return psw;
		}
		public void setPsw(String psw) {
			this.psw = psw;
		}
		public String getTel() {
			return tel;
		}
		public void setPassword(String tel) {
			this.tel = tel;
		}
	}


