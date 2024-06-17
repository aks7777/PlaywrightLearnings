import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogs {
	
	
	public static Logger log = LogManager.getLogger(TestLogs.class.getName());

	public static void main(String[] args) {
		
		System.setProperty("log4j.configurationFile", "./main/resources/properties/log4j2.properties");
		// log.error("Test Error");
		log.info("Test INFO");
		log.debug("Test DEBUG");

	}

}
