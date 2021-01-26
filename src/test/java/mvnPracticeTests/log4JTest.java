package mvnPracticeTests;

import org.apache.log4j.LogManager;

import org.apache.log4j.Logger;

public class log4JTest {

    static final Logger logger = Logger.getLogger(log4JTest.class);

    public static void main (String[] args){
        logger.error("object not found");
        logger.debug("debugger line");
        logger.fatal("fatal line");
    }
}
