package com.adam.rpc.demo.framework.invoke;

import com.adam.rpc.demo.framework.myFramework.ConsumerProxy;
import com.adam.rpc.demo.framework.service.MyService;

public class RpcConsumerMain {

	
	public static void main(String[] args) throws Exception{
		
		MyService service = ConsumerProxy.consumer(MyService.class, "localhost", 8083);
		
		for (int i = 0; i < 10; i++) {
			System.err.println(service.sayHello()+"_huyaozhong"+i);
			
			Thread.sleep(1000);
		}
	}
}
