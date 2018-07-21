
package hello.thrift.ServerMain;

import hello.thrift.entity.User;
import hello.thrift.service.HelloService;
import hello.thrift.service.HelloServiceImpl;

import java.net.InetSocketAddress;

import com.facebook.nifty.client.FramedClientConnector;
import com.facebook.swift.service.ThriftClientManager;

public class ClientMain {

	public static void main(String[] args) throws Exception{
		
		ThriftClientManager clientManager = new ThriftClientManager();
		FramedClientConnector connector = new FramedClientConnector(new InetSocketAddress("localhost",8899));
		
		User user =new User();
		user.setEmail("email");
		user.setName("adam");
		
		HelloService clientService = clientManager.createClient(connector, HelloService.class).get();
		
		System.out.println(clientService.sayHello(user));
	}
}
