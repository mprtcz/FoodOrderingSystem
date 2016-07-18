package com.mprtcz.foodordering.logger;

import java.io.IOException;
import java.util.logging.*;

/**
 * Created by Azet on 2016-07-18.
 */
public class AppLogger {
    private final static Logger logger = Logger.getLogger(AppLogger.class.getName());
    private static Handler handler = null;

    public static void initializeLogger() {
        try {
            handler = new FileHandler("logFile.log", false);
        } catch (IOException e) {
            logger.log(Level.WARNING, "Could not create file");
            e.printStackTrace();
        }
        Logger newLogger = Logger.getLogger("");
        handler.setFormatter(new SimpleFormatter());
        newLogger.addHandler(handler);
        newLogger.setLevel(Level.CONFIG);
    }
}
