# minaSpring

spring整合mina框架，包含心跳检测部分。

原始博文在http://blog.csdn.net/smile326/article/details/51912141
对工程的大部分说明都在文中，也是应评论的要求，发到github上面。

提一下目录结构，因为是测试的工程，比较乱~多多包涵。
client包里面的minaclient是按照mina结构写的客户端，SocketTest和SocketTestTwo是没用mina结构，用普通的socket写的客户端，都是好用的~
server包里面自然就是服务端了
websocket包是应对websocket的时候需要的编码和解码器，从git上一个开源项目拷贝的，亲测好用~，当然，如果不用websocket可以忽略。
mainTest自然就是服务端的启动文件，下面分别是编码器，处理器和心跳工厂。
sendToAll写了一个群发的，服务端启动，客户端连接之后，群发功能也是有效果的~
 
 
关于本工程还是感谢众多的国产博客，参考了很多博客的内容，百分之八十的篇幅都是参考而来的吧，但是心跳部分和spring结合还真是网上没找到然后自己琢磨出来的。


后续想讨论一下关于Handler类中的setIdleTime语句。设置空闲时间，比如两秒（注意读空闲、写空闲、读写空闲区别），那么每两秒都会触发一个sessionIdle事件。
但是在KeepAliveFilter和Myhandler中都有对应的sessionIdle事件。
心跳检测会触发KeepAliveFilter中的sessionIdle事件，并不会触发Handler中的sessionIdle事件，如果希望同时触发Handler中的sessionIdle事件，需要在spring中对心跳滤波器加上：
<property name="forwardEvent" value="true" />
即可以让相同的事件往下一个滤波器传递。

