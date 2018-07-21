package hello.thrift.service;

import hello.log.LogDemo;
import hello.thrift.entity.User;

public class HelloServiceImpl implements HelloService {

	@Override
	public String sayHello(User user) {
		// TODO Auto-generated method stub
		LogDemo.log(user, this.getClass());
		return "this call invoked by thrift";
	}
}
