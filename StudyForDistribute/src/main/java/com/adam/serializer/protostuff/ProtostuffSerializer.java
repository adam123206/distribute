package com.adam.serializer.protostuff;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import com.adam.serializer.interfaceDemo.ISerializer;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.ProtostuffOutput;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

public class ProtostuffSerializer implements ISerializer{

	private static Map<Class<?>, Schema<?>> cachedSchema = new ConcurrentHashMap<Class<?>, Schema<?>>();
	
	private static Objenesis objenesis = new ObjenesisStd(true);
	
	@SuppressWarnings("unchecked")
	private static <T> Schema<T> getSchema(Class<T> cls){
		
		Schema<T> schema = (Schema<T>)cachedSchema.get(cls);
		if(schema == null){
			
			schema = RuntimeSchema.createFrom(cls);
			cachedSchema.put(cls, schema);
		}
		return schema;
	}
	
	@SuppressWarnings("unchecked")
	public <T> byte[] serializer(T obj) {
		
		Class<T> cls = (Class<T>)obj.getClass();
		LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
		try {
			Schema<T> schema = getSchema(cls);
			
			return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
			buffer.clear();
		}
		return null;
	}

	public <T> T deserialize(byte[] data, Class<T> clazz) {
		try {
			
			T message = (T)objenesis.newInstance(clazz);
			Schema<T> schema = getSchema(clazz);
			ProtostuffIOUtil.mergeFrom(data, message, schema);
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
	}

	
}
