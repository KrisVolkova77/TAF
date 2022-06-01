package tests;

import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

    @Test
    public void logLevelsTest() {
        logger.trace("Trace MSG: Начало теста...");
        logger.debug("Debug MSG: ...");
        logger.info("Info MSG: ...");
        logger.warn("Warn MSG: ...");
        logger.error("Error MSG: ...");
        logger.fatal("Fatal MSG: ...");
    }
}

