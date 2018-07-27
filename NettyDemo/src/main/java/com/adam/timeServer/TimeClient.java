package com.adam.timeServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TimeClient {

	public static void main(String[] args) throws Exception{

		int port = 8080;
		EventLoopGroup worker = new NioEventLoopGroup();
		try {
			//it's for non-server channels such as a client-side or connectionless channel
			Bootstrap b = new Bootstrap();
			/**
			 * specify only one EventLoopGroup, 
			 * it will be used both as a boss group 
			 * and as a worker group. 
			 * The boss worker is not used for the 
			 * client side though
			 */
			b.group(worker);
			//NioSocketChannel is being used to create a client-side Channel
			b.channel(NioSocketChannel.class);
			//the client-side SocketChannel does not have a parent
			b.option(ChannelOption.SO_KEEPALIVE, true);
			b.handler(new ChannelInitializer<Channel>() {

				@Override
				protected void initChannel(Channel arg0) throws Exception {
					// TODO Auto-generated method stub
					arg0.pipeline().addLast(new TimeDecoder(),new TimeServerHandler());
				}
			});
			//call the connect() method instead of the bind() method.
			ChannelFuture f = b.connect("localhost", port);
			
			f.channel().closeFuture().sync();
		
		} catch (Exception e) {
			worker.shutdownGracefully();
		}
	}
}
