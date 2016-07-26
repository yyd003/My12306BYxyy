package com.neuedu.my12306.usermgr.domain;

public class CertType {

	private Integer ID;
	private String content;

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "CerType [ID=" + ID + ", content=" + content + "]";
	}

}
