package com.adam.serializer.xmlDemoImpl;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.adam.serializer.interfaceDemo.ISerializer;

/**
 * 
 * @author Copsec
 *	using xmlencoder and xmldecoder to formate object
 */
public class Xml2Serializer implements ISerializer{

	
	public <T> byte[] serializer(T obj) {
		// TODO Auto-generated method stub
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		XMLEncoder encoder = new XMLEncoder(output,"utf-8",true,0);
		encoder.writeObject(obj);
		encoder.close();
		return output.toByteArray();
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize(byte[] data, Class<T> clazz) {
		// TODO Auto-generated method stub
		ByteArrayInputStream input = new ByteArrayInputStream(data);
		XMLDecoder decoder = new XMLDecoder(input);
		Object object = decoder.readObject();
		decoder.close();
		return (T)object;
	}
}
