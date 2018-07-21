package com.adam.serializer.protobuf.protobufDemo;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang3.reflect.MethodUtils;

import com.adam.serializer.interfaceDemo.ISerializer;
import com.google.protobuf.GeneratedMessageV3;

public class ProtobufSerializer implements ISerializer{

	public <T> byte[] serializer(T obj) {
		if(!(obj instanceof GeneratedMessageV3))
			throw new UnsupportedOperationException();
		try {
			return (byte[])MethodUtils.invokeMethod(obj, "toByteArray");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize(byte[] data, Class<T> clazz) {
		
		if(!GeneratedMessageV3.class.isAssignableFrom(clazz)){
			
			throw new UnsupportedOperationException();
		}
		try {
			Object object = MethodUtils.invokeMethod(clazz, "getDefaultInstance");
			
			return (T)MethodUtils.invokeMethod(object, "parseFrom", data);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
