package helper;

import org.testng.log4testng.Logger;

public class Helper_Log {

	
    private static Logger Log = Logger.getLogger(String.class);         //getLogger("info");

    public static void add_debug(String message) {
        Log.debug(message);
    }

    public static void add_info(String message) {
        Log.info(message);
    }

    public static void add_warn(String message) {
        Log.warn(message);
    }

    public static void add_error(String message) {
        Log.error(message);
    }

    public static void add_fatal(String message) {
        Log.fatal(message);
    }

}
