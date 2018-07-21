package client;

import java.util.concurrent.TimeUnit;

import grpc.example.HelloRequest;
import grpc.example.HelloResponse;
import grpc.example.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

	//远程连接管理，管理连接的生命周期
	private final ManagedChannel channel;
	//远程服务
	private final HelloServiceGrpc.HelloServiceBlockingStub blockingStub;
	
	public GrpcClient(String host,int port){
		
		//初始化连接
		channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext(true).build();
		//初始化远程服务
		blockingStub = HelloServiceGrpc.newBlockingStub(channel);
	}
	
	private void shutdown() throws InterruptedException{
		
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}
	
	public String sayHello(String name){
		
		//构造请求
		HelloRequest request = HelloRequest.newBuilder().setName(name).build();
		
		//调用远程服务
		HelloResponse response = blockingStub.sayHello(request);
		
		return response.getMessage();
	}
	
	public static void main(String[] args) throws InterruptedException{
		
		GrpcClient client = new GrpcClient("localhost", 50051);
		
		String content = client.sayHello("ceshi");
		
		System.out.println(content);
		
		client.shutdown();
	}
}
