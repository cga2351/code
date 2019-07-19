package cga2351.example.com.testpurejava;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by XiangNing on 2017/6/23.
 */

public class Logger {

    private static String prefix;

    private static final int MSG_WRITE = 0;
    private static final int MSG_DELETE_OLD_LOG_FILES = 1;
    private static WriterThread writerThread = null;
    private static WriterHandler handler = null;
    private static String logFileName = "";
    private static Calendar logFileCreateDate;

    private static final String LEVEL_DEBUG = "D";
    private static final String LEVEL_ERROR = "E";
    private static final String LEVEL_INFO = "I";

    private static final long LOG_FILE_KEEP_PERIOD = 5 * 24 * 60 * 60 * 1000;   // 5 days
    private static final long LOG_FILE_KEEP_PERIOD_EMULATOR = 2 * 24 * 60 * 60 * 1000;   // 2 days
    private static final long LOG_FILE_CHECK_INTERVAL = 10 * 60 * 1000;   // 10 minutes
    private static final long LOG_FILE_MAX_SIZE = 1024 * 1024 * 500;   // 500MB

//    //test
//    private static final long LOG_FILE_CHECK_INTERVAL = 1000 * 10;
//    private static final long LOG_FILE_MAX_SIZE = 1024 * 10;

    static {
        Logger.prefix = "[MQMS-AGENT]";
    }

//    public static void init() {
////        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
////        com.orhanobut.logger.Logger.addLogAdapter(new DiskLogAdapter());
//
//        logFileName = DateUtil.getFormatDate(DateUtil.DATA_FORMAT_yyyy_MM_dd_hh_mm_ss_UNDERLINE, SysUtil.currentTimeMillis());
//        logFileName += Constant.MQMS_AGENT_LOG_FILE_SUFFIX;
//        logFileCreateDate = Calendar.getInstance();
//
//        writerThread = new WriterThread();
//        writerThread.start();
//
//        // timer to check if write log to new log file
//        startCheckTimer();
//
//    }
//
//    private static void startCheckTimer() {
//        new Timer().schedule(new Logger.LogFileCheckTimerTask(),
//                new Date(SysUtil.currentTimeMillis() + LOG_FILE_CHECK_INTERVAL),
//                LOG_FILE_CHECK_INTERVAL);
//
//        Logger.debug("-mqmsdebug", "next check new log file time is:" + DateUtil.getFormatDate(DateUtil.DATA_FORMAT_yyyy_MM_dd_hh_mm_ss_HYPHEN, SysUtil.currentTimeMillis() + LOG_FILE_CHECK_INTERVAL));
//    }

//    private static void checkOldLogFiles() {
//        Logger.debug("-mqmsdebug", "checkOldLogFiles(), check new log file, cur time:" + DateUtil.getFormatDate(DateUtil.DATA_FORMAT_yyyy_MM_dd_hh_mm_ss_UNDERLINE, SysUtil.currentTimeMillis()));
//
//        Calendar currentTime = Calendar.getInstance();
//        if (logFileCreateDate.get(Calendar.DAY_OF_MONTH) != currentTime.get(Calendar.DAY_OF_MONTH)) {
//            // time goes to the second day, save log to new file
//            String newLogFileName = DateUtil.getFormatDate(DateUtil.DATA_FORMAT_yyyy_MM_dd_hh_mm_ss_UNDERLINE, currentTime.getTimeInMillis());
//            newLogFileName += Constant.MQMS_AGENT_LOG_FILE_SUFFIX;
//            logFileName = newLogFileName;
//            logFileCreateDate = currentTime;
//            Logger.debug("-mqmsdebug", "checkOldLogFiles(), time goes to the second day, save log to new file, logFileName=" + logFileName);
//        }
//
//        //delete old files
//        CommonUtil.deleteOldFiles();
//    }

//    public static void deleteOldLogFile() {
//        // delete log file 5 days ago
//        File logDir = new File(Constant.SD_PATH_MQMS_LOG);
//        File[] logFiles = logDir.listFiles();
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.HOUR_OF_DAY, 0);
//        calendar.set(Calendar.MINUTE, 0);
//        calendar.set(Calendar.SECOND, 0);
//        calendar.set(Calendar.MILLISECOND, 0);
//        long curTimeStamp = calendar.getTimeInMillis();
//        long timeToDelete = 0;
//        if (SysUtil.isEmulator()) {
//            timeToDelete = curTimeStamp - LOG_FILE_KEEP_PERIOD_EMULATOR; // last update time is 5 days ago. to delete
//        } else {
//            timeToDelete = curTimeStamp - LOG_FILE_KEEP_PERIOD; // last update time is 5 days ago. to delete
//        }
//        FileInputStream logFileInputStream;
//        long modifyTime = 0;
//
//        for (File logFile : logFiles) {
//            try {
//                modifyTime = logFile.lastModified();
//                logFileInputStream = new FileInputStream(logFile);
//
//                if ((logFile.getName().endsWith(Constant.MQMS_AGENT_LOG_FILE_SUFFIX) ||
//                        logFile.getName().endsWith(Constant.NATIVE_AGENT_LOG_FILE_SUFFIX) ||
//                        logFile.getName().endsWith(Constant.DAEMON_AGENT_LOG_FILE_SUFFIX) ||
//                        logFile.getName().endsWith(Constant.AUTO_AGENT_LOG_FILE_SUFFIX) ||
//                        logFile.getName().endsWith(Constant.JAVA_HOOK_LOG_FILE_SUFFIX) ||
//                        logFile.getName().endsWith(Constant.NATIVE_HOOK_LOG_FILE_SUFFIX)) &&
//                        (modifyTime < timeToDelete || logFileInputStream.available() > LOG_FILE_MAX_SIZE)) {
//                    logFile.delete();
//                }
//
//                logFileInputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

    public static void debug(final String des) {
        Log.d(Logger.prefix, des);
//        System.out.println(Logger.prefix + " [debug] " + des);
//        com.orhanobut.logger.Logger.d(des);
//        writeToFile(des, LEVEL_DEBUG, Logger.prefix);
    }

    public static void debug(final String subTag, String des) {
        Log.d(Logger.prefix, String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [debug] " + des);
//        com.orhanobut.logger.Logger.d(String.format("  %s : %s", subTag, des));
//        writeToFile(Logger.prefix + String.format("  %s : %s", subTag, des));
//        writeToFile(String.format("  %s : %s", subTag, des), LEVEL_DEBUG, Logger.prefix);
    }

    public static void error(final String des) {
        Log.e(Logger.prefix, des);
//        System.out.println(Logger.prefix + " [error] " + des);
//        com.orhanobut.logger.Logger.e(des);
//        writeToFile(Logger.prefix + des);
//        NeloLog.error(LEVEL_ERROR, des, Logger.prefix);
//        writeToFile(des, LEVEL_ERROR, Logger.prefix);
    }

    public static void error(final String subTag, final String des) {
        Log.e(Logger.prefix, String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [error] " + String.format("  %s : %s", subTag, des));
//        com.orhanobut.logger.Logger.e(String.format("  %s : %s", subTag, des));
//        writeToFile(Logger.prefix + String.format("  %s : %s", subTag, des));
//        NeloLog.error(LEVEL_ERROR, String.format("  %s : %s", subTag, des), Logger.prefix);
//        writeToFile(String.format("  %s : %s", subTag, des), LEVEL_ERROR, Logger.prefix);
    }

    public static void error(final String des, final Throwable ex) {
        Log.e(Logger.prefix, des, ex);
//        System.out.println(Logger.prefix + " [error] " + des);
//        System.out.println(Logger.prefix + " [error] " + ex.toString());
//        com.orhanobut.logger.Logger.e(ex, des);
//        NeloLog.error(ex, des + ex.getMessage(), Logger.prefix);
//        writeToFile(des + ex.getMessage(), LEVEL_ERROR, Logger.prefix);
    }

    public static void error(final String subTag, final String des, final Throwable ex) {
        Log.e(Logger.prefix, String.format("  %s : %s", subTag, des), ex);
//        System.out.println(Logger.prefix + " [error] " + String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [error] " + ex.toString());
//        com.orhanobut.logger.Logger.e(ex, String.format("  %s : %s", subTag, des));
//        writeToFile(Logger.prefix + String.format("  %s : %s", subTag, des) + ex.getMessage());
//        NeloLog.error(ex, String.format("  %s : %s", subTag, des) + ex.getMessage(), Logger.prefix);
//        writeToFile(String.format("  %s : %s", subTag, des) + ex.getMessage(), LEVEL_ERROR, Logger.prefix);
    }

    public static void info(final String des) {
        Log.i(Logger.prefix, des);
//        System.out.println(Logger.prefix + " [info] " + des);
//        com.orhanobut.logger.Logger.i(des);
//        writeToFile(Logger.prefix + des);
//        writeToFile(des, LEVEL_INFO, Logger.prefix);
    }

    public static void info(final String subTag, final String des) {
        Log.i(Logger.prefix, String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [info] " + String.format("  %s : %s", subTag, des));
//        com.orhanobut.logger.Logger.i(String.format("  %s : %s", subTag, des));
//        writeToFile(String.format("  %s : %s", subTag, des), LEVEL_INFO, Logger.prefix);
    }


//    private static void writeToFile(String content, String level, String moduleName) {
////        08-29 18:38:59.694 18962-19148/com.navercorp.ncp.mqms.mqmsagent D/[MQMS-AGENT]:
//        if (null != handler) {
//            String prefix = DateUtil.getFormatDate(DateUtil.DATA_FORMAT_yyyy_MM_dd_hh_mm_ss_HYPHEN, SysUtil.currentTimeMillis());
//            prefix += " " + Process.myPid() + "-" + Thread.currentThread().getId();
//            prefix += " " + MQMSApplication.getApplication().getPackageName();
//            prefix += " " + level + "/" + moduleName;
//            content = prefix + " " + content;
//
//            Message msg = Message.obtain();
//            msg.what = MSG_WRITE;
//            msg.obj = content;
//            handler.sendMessage(msg);
//        }
//    }

//    private static void writeFile(Message msg) {
//        String content = (String) msg.obj;
//        FileWriter fileWriter = null;
//        try {
//            String logFilePath = Constant.SD_PATH_MQMS_LOG + logFileName;
//            if (!new File(logFilePath).exists()) {
//                new File(Constant.SD_PATH_MQMS_LOG).mkdirs();
//                new File(logFilePath).createNewFile();
//            }
//            fileWriter = new FileWriter(logFilePath, true);
//            fileWriter.append(content);
//            fileWriter.append("\r\n");
//            fileWriter.flush();
//            fileWriter.close();
//        } catch (IOException e) {
//            if (fileWriter != null) {
//                try {
//                    fileWriter.flush();
//                    fileWriter.close();
//                } catch (IOException ex) {
//                    ex.printStackTrace();
//                }
//            }
//        }
//    }

    public static class LogFileCheckTimerTask extends TimerTask {
        @Override
        public void run() {
            Message msg = Message.obtain();
            msg.what = MSG_DELETE_OLD_LOG_FILES;
            handler.sendMessage(msg);
        }
    }

    public static class WriterHandler extends Handler {
        WriterHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_WRITE:
//                    writeFile(msg);
                    break;
                case MSG_DELETE_OLD_LOG_FILES:
//                    checkOldLogFiles();
                    break;
                default:
                    break;
            }
        }
    }

    public static class WriterThread extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            handler = new WriterHandler(Looper.myLooper());

            Logger.debug("-mqmsdebug", "log WriterThread thread start loop, thread id:" + currentThread().getId());
            Looper.loop();
            Logger.debug("-mqmsdebug", "log WriterThread thread exit, thread id:" + currentThread().getId());
        }
    }

}
