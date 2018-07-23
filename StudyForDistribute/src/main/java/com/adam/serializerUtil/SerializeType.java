package com.adam.serializerUtil;
import org.apache.commons.lang.StringUtils;

public enum SerializeType {

	DefaultJavaSerializer("DefaultJavaSerializer"),
	HessianSerializer("HessianSerializer"),
	JSONSerializer("JSONSerializer"),
	ProtoStuffSerializer("ProtoStuffSerializer"),
	XmlSerializer("XmlSerializer"),
	MarshallingSerializer("MarshallingSerializer"),
	
	AvroSerializer("AvroSerializer"),
	ProtpcolBufferSerializer("ProtocolBufferSerializer"),
	ThriftSerializer("ThriftSerializer");
	
	private String serializeType;
	
	private SerializeType(String serializeType){
		
		this.serializeType= serializeType;
	}
	
	public static SerializeType queryByType(String serializerType){
		
		if(StringUtils.isBlank(serializerType)){
			
			return null;
		}
		
		for(SerializeType type:SerializeType.values()){
			
			if(StringUtils.equals(serializerType,type.getSerializerType())){
				
				return type;
			}
		}
		return null;
	}
	
	public String getSerializerType(){
		
		return serializeType;
	}
}
