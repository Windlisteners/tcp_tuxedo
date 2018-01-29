package com.xt.message.vo;

/**
 * 
 * Copyright: Copyright (c) 2011 Company: xiongtao
 * 
 * @author 作者 tao.xiong  E-mail:yiwang3_26@163.com
 * @date 2018年1月29日上午11:45:21
 * @version 1.0
 * @description 功能描述: 参数
 */
public class ParamVO {

	private String ip;
	private Integer port;
	private String svrName;
	private String outTime;
	private String charSet;
	private String reqMsg;
	
	@Override
	public String toString() {
		String str = "ip:" + ip + ",port:" + port + ",svrName:" + svrName + ",outTime:" + outTime + ",charSet:" + charSet + ",reqMsg:" + reqMsg;
		return str;
	}
	
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getSvrName() {
		return svrName;
	}
	public void setSvrName(String svrName) {
		this.svrName = svrName;
	}
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getCharSet() {
		return charSet;
	}
	public void setCharSet(String charSet) {
		this.charSet = charSet;
	}
	public String getReqMsg() {
		return reqMsg;
	}
	public void setReqMsg(String reqMsg) {
		this.reqMsg = reqMsg;
	}
	
}
