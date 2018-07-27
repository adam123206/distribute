package com.adam.timeServer;

import java.util.Date;

import sun.applet.resources.MsgAppletViewer;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class TimeServerHandler extends ChannelInboundHandlerAdapter{

	@Override
	public void channelActive(final ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		//super.channelActive(ctx);
		final ByteBuf timeBuf = ctx.alloc().buffer(4);
		try {
		timeBuf.writeInt((int)(System.currentTimeMillis() /1000L + 2208988800L));
		/**
		 * it has two pointers; one for read operations and the other for write operations
		 * 
		 * The writer index increases when you write something to a ByteBuf while the reader 
		 * index does not change. 
		 * The reader index and the writer index represents 
		 * where the message starts and ends respectively
		 */
		//A ChannelFuture represents an I/O operation which has not yet occurred
		//any requested operation might not have been performed yet 
		//because all operations are asynchronous in Netty
		final ChannelFuture future = ctx.writeAndFlush(timeBuf);
		future.addListener(new ChannelFutureListener() {
			
			public void operationComplete(ChannelFuture arg0) throws Exception {
				// TODO Auto-generated method stub
				/**
				 * to call the close() method after the ChannelFuture is complete
				 * 
				 * close() also might not close the connection immediately, and it returns a ChannelFuture
				 */
				assert arg0 == future;
				ctx.close();
			}
		});
		}finally{
			
			timeBuf.release();
		}
	}
	
	/**
	 *
	 * 出现数组越界的原因：
	 * 	基于流的协议，会把接收到的数据放入一个接收缓存当中socket receive buffer；
	 * 	但是不是数据包的队列而是字符队列
	 * 
	 * The simplistic solution is to create an internal cumulative buffer 
	 * and wait until all 4 bytes are received into the internal buffer. 
	 */

	private ByteBuf buf;
	/**
	 * 
	 */
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		buf = ctx.alloc().buffer(4);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		buf.release();
		buf = null;
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		//super.exceptionCaught(ctx, cause);
		cause.printStackTrace();
		ctx.close();
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		ByteBuf m = (ByteBuf)msg;
		buf.writeBytes(m);
		m.release();
		if (buf.readerIndex() >= 4) {
			
			long currentTimeMillis = (buf.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
		}
	}
	
}
