package com.adam.rpc.demo.framework.myFramework;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.Socket;

import org.omg.CORBA.SystemException;
import org.omg.CORBA.portable.InputStream;
import org.omg.CORBA.portable.InvokeHandler;
import org.omg.CORBA.portable.OutputStream;
import org.omg.CORBA.portable.ResponseHandler;

/**
 * user dynamic proxy to invoke service method
 * @author Copsec
 *
 */
public class ConsumerProxy {

	@SuppressWarnings("unchecked")
	public static <T> T consumer(final Class<T> interfaceClass,final String host,final int port) throws Exception{
		
		return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class<?>[]{interfaceClass}, new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				
				Socket socket = new Socket(host, port);
				try {
					ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
					
						try {
							
							output.writeUTF(method.getName());
	    					output.writeObject(args);
	    					ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
	    					
	    					try {
								
	    						Object result = input.readObject();
	    						if(result instanceof Throwable){
	    							
	    							throw (Throwable) result;
	    						}
	    						return result;
							} catch (Exception e) {
								e.printStackTrace();
							}finally{
								
								input.close();
							}
						} catch (Exception e) {
							
							e.printStackTrace();
						}finally{
							
							output.close();
						}
				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					
					socket.close();
				}
				return null;
			}
		});
	}
}
