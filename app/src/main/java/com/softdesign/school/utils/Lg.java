package com.softdesign.school.utils;

import android.util.Log;


public class Lg {
    private static final String PREFIX = "HTC ";
    public static final int LOGCAT_BUFFER_SIZE = 3000;

    /**
     * Checks the logging is enabled
     */
    private static boolean shouldLog() {
//        return BuildConfig.IS_LOGCAT_LOGGER_ENABLED;
        return true;
    }

    /**
     * Send a ASSERT log message
     */
    public static void a(String tag, String text) {
        logOn(Log.ASSERT, tag, text);
    }

    /**
     * Send a DEBUG log message
     */
    public static void d(String tag, String text) {
        logOn(Log.DEBUG, tag, text);
    }

    /**
     * Send a ERROR log message
     */

    public static void e(String tag, String text) {
        logOn(Log.ERROR, tag, text);
    }

    /**
     * Send a INFO log message
     */

    public static void i(String tag, String text) {
        logOn(Log.INFO, tag, text);
    }

    /**
     * Send a VERBOSE log message
     */

    public static void v(String tag, String text) {
        logOn(Log.VERBOSE, tag, text);
    }

    /**
     * Send a WARN log message
     */

    public static void w(String tag, String text) {
        logOn(Log.WARN, tag, text);
    }

    /**
     * Formats the log message -
     * - complies the message length {@link #LOGCAT_BUFFER_SIZE};
     * - @param level used to ;
     * - @param tag used to identify the source of a log message;
     * - @param text - the message you would like logged;
     */
    private static void logOn(int level, String tag, String text) {
            if (shouldLog()) {
            String str = text;
            while (str.length() > LOGCAT_BUFFER_SIZE) {
                String str1 = str.substring(0, LOGCAT_BUFFER_SIZE);
                str = str1.substring(LOGCAT_BUFFER_SIZE);
                Log.println(level, PREFIX + tag, str1);
            }
            Log.println(level, PREFIX + tag, str);
        }
    }

}