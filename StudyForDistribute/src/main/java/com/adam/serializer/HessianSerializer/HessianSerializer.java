package com.adam.serializer.HessianSerializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.adam.serializer.interfaceDemo.ISerializer;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;

/**
 * 
 * @author Copsec
 *	hessian supports transform serialized object between different languages ;
 *	core objects are :
 *	AbstractSerializerFactory ,AbstracHessianOutput,abstractSerializer,abstractHessianInput
 *	AbstractDeserializer
 */
public class HessianSerializer implements ISerializer{

	public <T> byte[] serializer(T obj) {
		if(null == obj)
			throw new NullPointerException();
		try {
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			HessianOutput hOutput = new HessianOutput(output);
			hOutput.writeObject(obj);
			return output.toByteArray();
		} catch (Exception e) {
			
			throw new RuntimeException();
		}
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize(byte[] data, Class<T> clazz) {
		
		if(null == data)
			throw new NullPointerException();
		
		try {
			ByteArrayInputStream input = new ByteArrayInputStream(data);
			HessianInput hInput = new HessianInput(input);
			return (T)hInput.readObject();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
