package hello.log;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;

public class LogDemo {

	private static LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
	
	private LogDemo(){}
	
	public static void log(Object object,Class clazz){
		
		Logger logger = loggerContext.getLogger(clazz);
		if (logger.isDebugEnabled()) {
			
			logger.debug("message is {} ",object );
		
		}else if(logger.isErrorEnabled()){
			
			logger.error("error message is {}",object);
		}else if(logger.isInfoEnabled()){
			
			logger.info("info message is {}",object);
		}else if(logger.isTraceEnabled()){
			
			logger.trace("trace messsage is {}",object);
		}
	}
}
