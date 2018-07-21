package com.adam.rpc.demo.framework.invoke;

import com.adam.rpc.demo.framework.myFramework.ProviderReflect;
import com.adam.rpc.demo.framework.service.MyService;
import com.adam.rpc.demo.framework.service.MyServiceImpl;

public class RpcProviderMain {

	public static void main(String[] args) throws Exception{
		
		MyService service = new MyServiceImpl();
		ProviderReflect.provider(service,8083);
	}
}
