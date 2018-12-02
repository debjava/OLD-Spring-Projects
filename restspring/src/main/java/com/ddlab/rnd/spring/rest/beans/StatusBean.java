package com.ddlab.rnd.spring.rest.beans;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Status")
public class StatusBean {
	
	private String status = "Failed";
	private String errCode = "";
	private String errMsg = "";
	
	@XmlElement(defaultValue="Status")
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@XmlElement(defaultValue="ErrorCode")
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	@XmlElement(defaultValue="ErrorMessage")
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
}
