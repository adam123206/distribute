package com.adam.DiscardServer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.ServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {

	private int port;
	public DiscardServer(int port){
		
		this.port = port;
	}
	
	public void run() throws Exception{
		
		//The first one, often called 'boss', accepts an incoming connection
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		
		//The second one, often called 'worker', 
		//handles the traffic of the accepted connection once 
		//the boss accepts the connection and registers the accepted connection 
		//to the worker
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		
		try {
			/**
			 * set up a server 
			 */
			ServerBootstrap b = new ServerBootstrap();
			/**
			 * specify to use the NioServerSocketChannel class which is used to instantiate
			 * 	 a new Channel to accept incoming connections.
			
			 *	ChannelInitializer is a special handler that is purposed to help a user configure a new Channel.
			 */
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {

				/**
				 * to configure the ChannelPipeline of the new Channel by 
				 * 	adding some handlers such as DiscardServerHandler 
				 * to implement your network application
				 */
				@Override
				protected void initChannel(SocketChannel arg0) throws Exception {
					// TODO Auto-generated method stub
					arg0.pipeline().addLast(new DiscardServerHandler());
					
					arg0.pipeline().addLast(new EchoServerHandler());
				}
				
			})
			/**
			 * 	option() is for the NioServerSocketChannel that accepts incoming connections
			 */
			.option(ChannelOption.SO_BACKLOG, 128)
			/**
			 * childOption() is for the Channels accepted by the parent ServerChannel, 
			 * which is NioServerSocketChannel in this case
			 */
			.childOption(ChannelOption.SO_KEEPALIVE, true);
			
			//bind and start to accept coming connections
			ChannelFuture future = b.bind(this.port).sync();
			System.out.println("server running");
			//wait until the server socket to close 
			future.channel().closeFuture().sync();
		}finally{
			
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) throws Exception{
		
		new DiscardServer(8080).run();
	}
}
