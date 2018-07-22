package com.adam.serializer.avroDemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;

import com.adam.serializer.interfaceDemo.ISerializer;

public class AvroSerializer implements ISerializer{

	public <T> byte[] serializer(T obj) {
		try {
			
			if(!(obj instanceof SpecificRecordBase))
				throw new UnsupportedOperationException();
			
			DatumWriter userDatuWrite = new SpecificDatumWriter(obj.getClass());
			ByteArrayOutputStream output = new ByteArrayOutputStream();
			BinaryEncoder binaryEncoder = EncoderFactory.get().directBinaryEncoder(output, null);
			userDatuWrite.write(obj, binaryEncoder);
			return output.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

	public <T> T deserialize(byte[] data, Class<T> clazz) {
		
		try {
			if(!SpecificRecordBase.class.isAssignableFrom(clazz))
				throw new UnsupportedOperationException();
			
			DatumReader userDatumReader = new SpecificDatumReader<T>(clazz);
			BinaryDecoder binaryDecoder = DecoderFactory.get().directBinaryDecoder(new ByteArrayInputStream(data), null);
			return (T)userDatumReader.read(clazz.newInstance(), binaryDecoder);
		} catch (Exception e) {
			
			throw new RuntimeException();
		}
	}

	
}
