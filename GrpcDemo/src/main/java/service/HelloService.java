package service;

import java.io.IOException;

import grpc.example.HelloRequest;
import grpc.example.HelloResponse;
import grpc.example.HelloServiceGrpc;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


public class HelloService {

	private int port = 50051;
	private Server server ;
	
	//初始化注冊服务
	private void start() throws IOException{
		
		server = ServerBuilder.forPort(port).addService(new HelloServiceImpl()).build().start();
	
		//注册钩子，jvm退出时停止服务
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
			public void run(){
				
				HelloService.this.stop();
			}
		});
	}
	
	private void stop(){
		
		if(server != null){
			
			server.shutdown();
		}
	}
	
	//阻塞一直到程序退出
	private void blockUntilShutdown() throws InterruptedException{
		
		if(server != null){
			
			server.awaitTermination();
		}
	}
	
	private class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase{
		
		public void sayHello(HelloRequest req,StreamObserver<HelloResponse> responseObservers){
			
			//构建返回结果
			HelloResponse response = HelloResponse.newBuilder().setMessage("hello "+req.getName()).build();
			//将结果传入stream ，返回给调用方
			responseObservers.onNext(response);
			//通知stream结束
			responseObservers.onCompleted();
		}
	}
	
	public static void main(String[] args) throws IOException,InterruptedException{
		
		final HelloService server = new HelloService();
		server.start();
		server.blockUntilShutdown();
	}
}
