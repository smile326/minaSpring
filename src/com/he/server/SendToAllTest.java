package com.he.server;

import java.util.Iterator;

import org.apache.mina.common.IoSession;

/**
 *@function：模拟群发，在服务端和客户端都启动之后，可以运行此方法群发消息
 *@date：2016-9-27 下午03:42:42
 *@author:He.
 *@notice：
 */
public class SendToAllTest {
	public static void main(String[] args) {
		System.out.println(MyHandler.sessions.size());
		for (Iterator iterator = MyHandler.sessions.iterator(); iterator.hasNext();) {
			IoSession session = (IoSession) iterator.next();
			session.write("发送系统消息");
		}
	}
}
