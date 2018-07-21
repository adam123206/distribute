package hello.thrift.service;

import hello.thrift.entity.User;

public class HelloServiceImpl implements HelloService {

	public String sayHello(User user) {
		// TODO Auto-generated method stub
		return "this call invoked by thrift";
	}
}
