package com.he.client.minaclient;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 *@function：基于mina框架的客户端，结构和mina服务端一直
 *@date：2016-9-27 下午03:45:30
 *@author:He.
 *@notice：
 */
public class ClientTest {
	public static void main(String[] args) throws InterruptedException {
		//创建客户端连接器. 
		NioSocketConnector connector = new NioSocketConnector();
		connector.getFilterChain().addLast("logger", new LoggingFilter());
		connector.getFilterChain().addLast("codec",
				new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("utf-8")))); //设置编码过滤器 
		connector.setHandler(new ClientHandler());//设置事件处理器 
		ConnectFuture cf = connector.connect(new InetSocketAddress("127.0.0.1", 8888));//建立连接 
		cf.awaitUninterruptibly();//等待连接创建完成 
		cf.getSession().write("hello,测试！");//发送消息 
//		cf.getSession().closeOnFlush();
//		cf.getSession().getCloseFuture().awaitUninterruptibly();//等待连接断开 
//		connector.dispose();

	}
}
