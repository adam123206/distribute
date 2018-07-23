package com.adam.serializerUtil;

import java.util.Map;

import javax.management.RuntimeErrorException;

import avro.shaded.com.google.common.collect.Maps;

import com.adam.serializer.HessianSerializer.HessianSerializer;
import com.adam.serializer.Marshalling.MarshallingSerializer;
import com.adam.serializer.avroDemo.AvroSerializer;
import com.adam.serializer.interfaceDemo.ISerializer;
import com.adam.serializer.javaDemoImpl.DefaultSerializerImpl;
import com.adam.serializer.protostuff.ProtostuffSerializer;
import com.adam.serializer.thriftDemo.ThriftSerializer;
import com.adam.serializer.xmlDemoImpl.XmlSerializer;

public class SerializerEngine {

	public final static Map<SerializeType, ISerializer> SERIALIZERMAP_MAP = Maps.newConcurrentMap();
	
	static{
		
		SERIALIZERMAP_MAP.put(SerializeType.DefaultJavaSerializer,new DefaultSerializerImpl());
		SERIALIZERMAP_MAP.put(SerializeType.HessianSerializer,new HessianSerializer());
		SERIALIZERMAP_MAP.put(SerializeType.XmlSerializer,new XmlSerializer());
		SERIALIZERMAP_MAP.put(SerializeType.ProtoStuffSerializer,new ProtostuffSerializer());
		SERIALIZERMAP_MAP.put(SerializeType.MarshallingSerializer,new MarshallingSerializer());
	
		SERIALIZERMAP_MAP.put(SerializeType.AvroSerializer,new AvroSerializer());
		SERIALIZERMAP_MAP.put(SerializeType.ThriftSerializer,new ThriftSerializer());
		SERIALIZERMAP_MAP.put(SerializeType.ProtpcolBufferSerializer,new ProtostuffSerializer());
	}
	
	public static <T> byte[] SerializeType(T obj,String type){
		
		SerializeType serializeType = SerializeType.queryByType(type);
		if(serializeType ==null){
			
			throw new RuntimeException();
		}
		ISerializer serializer = SERIALIZERMAP_MAP.get(serializeType);
		if(serializer ==null){
			
			throw new RuntimeException();
		}
		try {
			return serializer.serializer(obj);
		} catch (Exception e) {
			
			throw new RuntimeException();
		}
	}
}
