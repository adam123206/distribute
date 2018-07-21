package com.adam.serializer.protobuf.protobufDemo;

import java.util.Arrays;

import com.adam.serializer.protobuf.model.AddressBookProtos;
import com.adam.serializer.protobuf.model.AddressBookProtos.AddressBook;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;

public class ProtobufDemo {

	/**
	 * 
	 * @param args
	 *            using generated class to invoke serializer and deserializer
	 *            methods
	 */
	public static void main(String[] args) throws Exception{

		// 构建person对象
		AddressBookProtos.Person person = AddressBookProtos.Person.
			newBuilder().setEmail("test@123.com").setId(123).setName("huyaozhongTest").
			addPhone(AddressBookProtos.Person.PhoneNumber.newBuilder().
				setNumber("1234562").setType(AddressBookProtos.Person.PhoneType.HOME).build()).build();
	
		//序列化
		ByteString serialized = person.toByteString();
		System.err.println(serialized);
		System.err.println(Arrays.toString(person.toByteArray()));
		
		//反序列化
		AddressBookProtos.Person newPerson = AddressBookProtos.Person.parseFrom(serialized);
		
		System.out.println(newPerson);
		newPerson = AddressBookProtos.Person.parseFrom(person.toByteArray());
		System.out.println(newPerson);
		
		System.out.println("--------------------------------------------------");
		ProtobufSerializer serializer = new ProtobufSerializer();
		byte[] data = serializer.serializer(person);
		
		AddressBookProtos.Person copyPerson = serializer.deserialize(data, AddressBookProtos.Person.class);
		System.out.println(copyPerson);
	}
}
