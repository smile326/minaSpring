package com.he.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *@function：java的简单的套接字连接，短连接，满足一次性的收发；注释部分可以通过控制台接受输入字符
 *@parameter:
 *@return：
 *@date：2016-6-22 下午03:41:07
 *@author:he
 *@notice:
 */
public class ScoketTest {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8888);
			PrintWriter os = new PrintWriter(socket.getOutputStream());
			os.println("测试消息");
			os.flush();

			BufferedReader is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg = is.readLine();
			System.out.println("客户端收到：" + msg);

			os.close();
			socket.close(); 

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("+++++客户端发生异常+++++");
		}
	}
	// public static void main(String[] args) {
	// try {
	// Socket socket = new Socket("127.0.0.1", 8888);
	//
	// //由系统标准输入设备构造BufferedReader对象
	// BufferedReader sin = new BufferedReader(new
	// InputStreamReader(System.in));
	//
	// //由Socket对象得到输出流，并构造PrintWriter对象　　　　　　　　
	// PrintWriter os = new PrintWriter(socket.getOutputStream());
	//
	// //由Socket对象得到输入流，并构造相应的BufferedReader对象
	// BufferedReader is = new BufferedReader(new
	// InputStreamReader(socket.getInputStream()));
	//
	// String readline;
	//
	// readline = sin.readLine();
	// //从系统标准输入读入一字符串
	//
	// while (!readline.equals("bye")) {
	// //若从标准输入读入的字符串为 "bye"则停止循环
	//				
	// os.println(readline);
	// //将从系统标准输入读入的字符串输出到Server
	//				
	// os.flush();
	// //刷新输出流，使Server马上收到该字符串
	//
	// System.out.println("Client:" + readline);
	// //在系统标准输出上打印读入的字符串
	//
	// System.out.println("Server:" + is.readLine());
	// //从Server读入一字符串，并打印到标准输出上
	//
	// readline = sin.readLine();
	// //从系统标准输入读入一字符串
	// }
	// //继续循环
	//
	// os.close(); //关闭Socket输出流
	//
	// is.close(); //关闭Socket输入流
	//
	// socket.close(); //关闭Socket
	//
	// } catch (Exception e) {
	// // TODO: handle exception
	// System.out.println("+++++客户端发生异常+++++");
	// }
	// }
}
