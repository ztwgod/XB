package cn.com.xb.domain.base;


public class UserSession {

	private String userAccount;// 账号
	private String chName;// 用户中文名称
	private String userId;
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	private String role;// 用户角色
	
	//private List<String> menus; // 菜单

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getChName() {
		return chName;
	}

	public void setChName(String chName) {
		this.chName = chName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	/*public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}*/
	
	public void setUserSession(User user){
		this.userAccount = user.getUserAccount();
		this.chName = user.getUserName();
		this.userId = user.getUserId();
	}
}
