package com.adam.DiscardServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 * 
 * @author Copsec 忽略所有传入数据
 * 
 * ChannelInboundHanlderAdapter 继承自ChannelInboundHandler接口
 */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("channel is inactive");
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("channel is Inaction");
		super.channelInactive(ctx);
	}
	/**
	 * This method is called with the received message, 
	 * 	whenever new data is received from a client.
	 */
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		super.channelRead(ctx, msg);
		/*try {
			ByteBuf buf = (ByteBuf)msg;
			while (buf.isReadable()) {
				
				System.out.println(buf.toString(io.netty.util.CharsetUtil.US_ASCII));
				System.out.println((char)buf.readByte());
				System.out.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			*//**
			 * ByteBuf is a reference-counted object which 
			 * has to be released explicitly via the release() method.
			 *//*
			ReferenceCountUtil.release(msg);
		}*/
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("channel read complete");
		super.channelReadComplete(ctx);
	}

	@Override
	public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("channel registered");
		super.channelRegistered(ctx);
	}

	@Override
	public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("channel unregistered");
		super.channelUnregistered(ctx);
	}

	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		super.channelWritabilityChanged(ctx);
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("user event triggered");
		super.userEventTriggered(ctx, evt);
	}

	
}
