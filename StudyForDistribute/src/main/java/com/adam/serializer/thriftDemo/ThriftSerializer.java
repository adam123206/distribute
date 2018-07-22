package com.adam.serializer.thriftDemo;

import org.apache.thrift.TBase;
import org.apache.thrift.TDeserializer;
import org.apache.thrift.TSerializer;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;

import com.adam.serializer.interfaceDemo.ISerializer;

/**
 * 
 * @author Copsec
 *	using org.apache.thrift.TSerializer and org.apache.thrift.TDeserializer to serialize and deserialize 
 * object which must extends from org.apache.thrift.TBase
 */
public class ThriftSerializer implements ISerializer{

	public <T> byte[] serializer(T obj) {
		// TODO Auto-generated method stub
		try {
			if(!( obj instanceof TBase))
				throw new UnsupportedOperationException();
			
			TSerializer serializer = new TSerializer(new TBinaryProtocol.Factory());
			return serializer.serialize((TBase)obj);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public <T> T deserialize(byte[] data, Class<T> clazz) {
		try {
			if(!TBase.class.isAssignableFrom(clazz))
				throw new RuntimeException();
			TBase o = (TBase)clazz.newInstance();
			//point to fixed protocol
			TDeserializer deserializer = new TDeserializer(new TBinaryProtocol.Factory());
			deserializer.deserialize(o, data);
			return (T)o;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	
}
