package com.adam.timeServer;

import java.util.List;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

/**
 * 
 * 
 * @author Copsec
 *	ByteToMessageDecoder is an implementation of ChannelInboundHandler
 */
public class TimeDecoder extends ByteToMessageDecoder{

	/**
	 * 
	 * calls the decode() method with an internally 
	 * maintained cumulative buffer whenever
	 *  new data is received
	 */
	@Override
	protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
		// TODO Auto-generated method stub
		
		if(in.readableBytes() < 4){
			return;
		}
		/**
		 * If decode() adds an object to out, 
		 * it means the decoder decoded a message successfully
		 */
		out.add(in.readBytes(4));
	}
}
