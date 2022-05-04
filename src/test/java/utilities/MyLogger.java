package utilities;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger {
	// get a logger instance
		public static Logger logger = Logger.getLogger("hudl");
		
		public MyLogger() {
			PropertyConfigurator.configure("log4j.properties");
		}

		public void debug(String message) {
			logger.debug(message);
		}

		public void info(String message) {
			logger.info(message);
		}

		public void warn(String message) {
			logger.warn(message);
		}

		public void error(String message) {
			logger.error(message);
		}

}
