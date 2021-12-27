package edu.spring.ex06.domain;

public class MemberVO {
	private String userid;
	private String password;
	private String username;
	private String nickname;
	private String email;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberVO(String userid, String password, String username, String nickname, String email) {
		super();
		this.userid = userid;
		this.password = password;
		this.username = username;
		this.nickname = nickname;
		this.email = email;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "MemberVO [userid=" + userid + ", password=" + password + ", username=" + username + ", nickname="
				+ nickname + ", email=" + email + "]";
	}
	
	
}
