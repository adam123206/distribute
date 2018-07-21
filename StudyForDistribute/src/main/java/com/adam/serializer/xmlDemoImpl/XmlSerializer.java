package com.adam.serializer.xmlDemoImpl;

import com.adam.serializer.interfaceDemo.ISerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlSerializer implements ISerializer {

	private static final XStream xstream  = new XStream(new DomDriver());
	
	public <T> byte[] serializer(T obj) {
		// TODO Auto-generated method stub
		
		return xstream.toXML(obj).getBytes();
	}

	@SuppressWarnings("unchecked")
	public <T> T deserialize(byte[] data, Class<T> clazz) {
		// TODO Auto-generated method stub
		String xml = new String(data);
		
		return (T)xstream.fromXML(xml);
	}
}
