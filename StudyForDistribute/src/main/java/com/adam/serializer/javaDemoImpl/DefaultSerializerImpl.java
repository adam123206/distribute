package com.adam.serializer.javaDemoImpl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.adam.serializer.interfaceDemo.ISerializer;

/**
 * 
 * @author Copsec
 *	jdk provides the default serialized method,using 
 *	ObjectInputStream and ObjectOutputStream,also the serialized object must be implements
 *	java.io.serializable interface；
 *
 *	weakness ：only for java language;may happen OOM if references too deep
 */
public class DefaultSerializerImpl implements ISerializer{

	public <T> byte[] serializer(T obj) {
		// TODO Auto-generated method stub
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		try {
			ObjectOutputStream output = new ObjectOutputStream(outputStream);
			output.writeObject(obj);
			
			output.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}
		return outputStream.toByteArray();
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize(byte[] data, Class<T> clazz) {
		// TODO Auto-generated method stub
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(input);
			return (T)objectInputStream.readObject();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException();
		}finally{
			
			try {
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				throw new RuntimeException();
			}
		}
	}

	
}
