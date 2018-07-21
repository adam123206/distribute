package com.adam.serializer.interfaceDemo;

public interface ISerializer {

	public <T> byte[] serializer(T obj);
	
	public <T> T deserialize(byte[] data,Class<T> clazz);
}
