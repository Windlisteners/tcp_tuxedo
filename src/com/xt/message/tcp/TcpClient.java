package com.xt.message.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

import com.xt.message.vo.ParamVO;

/**
 * 
 * Copyright: Copyright (c) 2011 Company: xiongtao
 * 
 * @author 作者 tao.xiong  E-mail:yiwang3_26@163.com
 * @date 2018年1月29日上午11:45:04
 * @version 1.0
 * @description 功能描述: tcp通讯
 */
public class TcpClient {

	public String callClient(ParamVO param) {
		
		Socket socket = null;
		OutputStream out = null;
		InputStream in = null;
		BufferedReader br = null;
		StringBuffer rspBuff = null;
		
		try {
			
			socket = new Socket(param.getIp(), param.getPort());
			socket.setSoTimeout(Integer.parseInt(param.getOutTime()));
			out = socket.getOutputStream();
			in = socket.getInputStream();
			
			out.write(param.getReqMsg().getBytes(param.getCharSet()));
			out.flush();

			br = new BufferedReader(new InputStreamReader(in, param.getCharSet()));
			String line;
			rspBuff = new StringBuffer();
			while((line = br.readLine()) != null) {
				rspBuff.append(line);
			}
			return rspBuff.toString();
		} catch (Exception e) {
			return e.toString();
		} finally {
			try {
				if(null != out) {
					out.close();
				}
				if(null != socket && !socket.isClosed()) {
					socket.close();
				}
				if(null != br) {
					br.close();
				}
			} catch (IOException e) {
				return e.toString();
			}
		}
	}
	
}
