package com.he.server;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.keepalive.KeepAliveMessageFactory;

public class MyKeepAliveMessageFactory implements  KeepAliveMessageFactory{
	
	private final Logger LOG = Logger.getLogger(MyKeepAliveMessageFactory.class);
	
    /** 心跳包内容 */  
    private static final String HEARTBEATREQUEST = "1111";  
    private static final String HEARTBEATRESPONSE = "1112"; 

	public Object getRequest(IoSession session) {
		LOG.warn("请求预设信息: " + HEARTBEATREQUEST);  
         /** 返回预设语句 */  
         return HEARTBEATREQUEST;
	}

	public Object getResponse(IoSession session, Object request) {
		LOG.warn("响应预设信息: " + HEARTBEATRESPONSE);  
        /** 返回预设语句 */  
        return HEARTBEATRESPONSE;  
//      return null;  
	}

	public boolean isRequest(IoSession session, Object message) {
		 LOG.warn("请求心跳包信息: " + message);  
         if (message.equals(HEARTBEATREQUEST))  
             return true;  
         return false;  
	}

	public boolean isResponse(IoSession session, Object message) {
      LOG.warn("响应心跳包信息: " + message);  
      if(message.equals(HEARTBEATRESPONSE))  
          return true;
		return false;
	}

}
