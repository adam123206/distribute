package com.adam.serializer.Marshalling;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import javax.swing.text.MaskFormatter;

import org.jboss.marshalling.Marshaller;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;
import org.jboss.marshalling.Unmarshaller;

import com.adam.serializer.interfaceDemo.ISerializer;
import com.thoughtworks.xstream.converters.MarshallingContext;

public class MarshallingSerializer implements ISerializer{

	final static MarshallingConfiguration configuration = new MarshallingConfiguration();
	final static MarshallerFactory marshallingFactory = Marshalling.getMarshallerFactory("serial");
	
	static{
		
		configuration.setVersion(5);
	}
	
	
	public <T> byte[] serializer(T obj) {
		
		final ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
			final Marshaller marshaller= marshallingFactory.createMarshaller(configuration);
			marshaller.start(Marshalling.createByteOutput(output));
			marshaller.writeObject(obj);
			marshaller.finish();
			return output.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T deserialize(byte[] data, Class<T> clazz) {
		
		try {
			ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
			final Unmarshaller unmarshaller = marshallingFactory.createUnmarshaller(configuration);
			unmarshaller.start(Marshalling.createByteInput(inputStream));
			Object objt = unmarshaller.readObject();
			unmarshaller.finish();
			return (T)objt;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
