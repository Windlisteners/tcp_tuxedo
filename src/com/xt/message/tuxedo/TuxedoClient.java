package com.xt.message.tuxedo;

import com.xt.message.vo.ParamVO;

import bea.jolt.JoltRemoteService;
import bea.jolt.JoltSession;
import bea.jolt.JoltSessionAttributes;

/**
 * 
 * Copyright: Copyright (c) 2011 Company: xiongtao
 * 
 * @author ���� tao.xiong  E-mail:yiwang3_26@163.com
 * @date 2018��1��29������11:45:17
 * @version 1.0
 * @description ��������: tuxedoͨѶ
 */
public class TuxedoClient {
	
	private JoltSession session = null;
	private JoltRemoteService jrservice = null;
	private JoltSessionAttributes jsattr = null;

	public String callClient(ParamVO param) {
		try {
			jsattr = new JoltSessionAttributes();
			jsattr.setString(JoltSessionAttributes.APPADDRESS, param.getIp());
			jsattr.setInt(JoltSessionAttributes.IDLETIMEOUT, Integer.parseInt(param.getOutTime()));
			jsattr.setInt(JoltSessionAttributes.RECVTIMEOUT, 2);
			
			// �ַ�������
			System.setProperty("bea.jolt.encoding", "GBK");
			// ���ӷ���
			session = new JoltSession(jsattr, null, null, null, null);
			// ���÷�����
			jrservice = new JoltRemoteService(param.getSvrName(), session);
			jrservice.setString("STRING", param.getReqMsg());
			jrservice.call(null);
			
			return jrservice.getStringDef("STRING", null).toString();
		} catch (Exception e) {
			e.printStackTrace();
			return e.toString();
		} finally {
			close();
		}
	}
	
	private void close() {
		if(null != session) {
			session.endSession();
		}
		session = null;
		jrservice = null;
		jsattr = null;
	}
	
}
