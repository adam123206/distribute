package com.adam.rpc.demo.framework.myFramework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.reflect.MethodUtils;

public class ProviderReflect {

	private static final ExecutorService EXECUTOR_SERVICE = Executors.newCachedThreadPool();
	
	public static void provider(final Object service,int port) throws Exception{
		
		ServerSocket serverSocket = new ServerSocket(port);
		
		while (true) {
			
			final Socket socket = serverSocket.accept();
			EXECUTOR_SERVICE.execute(new Runnable() {
				
				public void run() {
					
					try {
						
					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
						try {
							
							//获取方法名
							String methodName = input.readUTF();
							//方法参数
							Object[] arguments = (Object[])input.readObject();
							
							ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
							try {
								
								Object result = MethodUtils.invokeExactMethod(service, methodName, arguments);
								
								output.writeObject(result);
							} catch (Throwable e) {
								
								output.writeObject(e);
							}finally{
								
								output.close();
							}
						} catch (Exception e) {
							
							e.printStackTrace();
							
						}finally{
							
							input.close();
						}
					} catch (Exception e) {
						
						e.printStackTrace();
					}finally{
						
						try {
							socket.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
		}
	}
}
