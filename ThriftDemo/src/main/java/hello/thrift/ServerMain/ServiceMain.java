package hello.thrift.ServerMain;

import hello.thrift.service.HelloServiceImpl;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.facebook.nifty.core.NettyServerConfig;
import com.facebook.nifty.core.ThriftServerDef;
import com.facebook.swift.codec.ThriftCodecManager;
import com.facebook.swift.service.ThriftEventHandler;
import com.facebook.swift.service.ThriftServer;
import com.facebook.swift.service.ThriftServiceProcessor;

public class ServiceMain {

	public static void main(String[] args) {

		ThriftServiceProcessor processor = new ThriftServiceProcessor(new ThriftCodecManager(), new ArrayList<ThriftEventHandler>(), new HelloServiceImpl());
		// 创建固定大小的线程池
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		//构建thrift server 
		ThriftServerDef serverDef = ThriftServerDef.newBuilder()
				.listen(8899).withProcessor(processor).using(executorService).build();
		
		ExecutorService bossService = Executors.newCachedThreadPool();
		
		ExecutorService workerService = Executors.newCachedThreadPool();
		
		NettyServerConfig serverConfig = NettyServerConfig.newBuilder()
			.setBossThreadExecutor(bossService).setWorkerThreadExecutor(workerService).build();
		
		ThriftServer server = new ThriftServer(serverConfig,serverDef);
		server.start();
	}
}
