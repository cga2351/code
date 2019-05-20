package mqms.ncp.navercorp.com.testgpuimage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
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

    static {
        Logger.prefix = "[test_gpu_image]";
    }

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
    private static final long LOG_FILE_CHECK_INTERVAL = 60 * 60 * 1000;   // 1 hour
    private static final long LOG_FILE_MAX_SIZE = 1024 * 1024 * 500;   // 500MB

//    //test
//    private static final long LOG_FILE_CHECK_INTERVAL = 1000 * 10;
//    private static final long LOG_FILE_MAX_SIZE = 1024 * 10;

    public static void init() {
//        com.orhanobut.logger.Logger.addLogAdapter(new AndroidLogAdapter());
//        com.orhanobut.logger.Logger.addLogAdapter(new DiskLogAdapter());

        Calendar curDay = Calendar.getInstance();
        curDay.set(Calendar.HOUR_OF_DAY, 0);
        curDay.set(Calendar.MINUTE, 0);
        curDay.set(Calendar.SECOND, 0);
        curDay.set(Calendar.MILLISECOND, 0);

        logFileName = "";
        logFileName += "";
        logFileCreateDate = Calendar.getInstance();

        writerThread = new WriterThread();
        writerThread.start();

        // timer to check if write log to new log file
//        startCheckTimer();

    }

    public static void debug(final String des) {
        Log.d(Logger.prefix, des);
//        System.out.println(Logger.prefix + " [debug] " + des);
//        com.orhanobut.logger.Logger.d(des);
        writeToFile(des, LEVEL_DEBUG, Logger.prefix);
    }

    public static void debug(final String subTag, String des) {
        Log.d(Logger.prefix, String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [debug] " + des);
//        com.orhanobut.logger.Logger.d(String.format("  %s : %s", subTag, des));
//        writeToFile(Logger.prefix + String.format("  %s : %s", subTag, des));
        writeToFile(String.format("  %s : %s", subTag, des), LEVEL_DEBUG, Logger.prefix);
    }

    public static void error(final String des) {
        Log.e(Logger.prefix, des);
//        System.out.println(Logger.prefix + " [error] " + des);
//        com.orhanobut.logger.Logger.e(des);
//        writeToFile(Logger.prefix + des);
//        NeloLog.error(LEVEL_ERROR, des, Logger.prefix);
        writeToFile(des, LEVEL_ERROR, Logger.prefix);
    }

    public static void error(final String subTag, final String des) {
        Log.e(Logger.prefix, String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [error] " + String.format("  %s : %s", subTag, des));
//        com.orhanobut.logger.Logger.e(String.format("  %s : %s", subTag, des));
//        writeToFile(Logger.prefix + String.format("  %s : %s", subTag, des));
//        NeloLog.error(LEVEL_ERROR, String.format("  %s : %s", subTag, des), Logger.prefix);
        writeToFile(String.format("  %s : %s", subTag, des), LEVEL_ERROR, Logger.prefix);
    }

    public static void error(final String des, final Throwable ex) {
        Log.e(Logger.prefix, des, ex);
//        System.out.println(Logger.prefix + " [error] " + des);
//        System.out.println(Logger.prefix + " [error] " + ex.toString());
//        com.orhanobut.logger.Logger.e(ex, des);
//        NeloLog.error(ex, des + ex.getMessage(), Logger.prefix);
        writeToFile(des + ex.getMessage(), LEVEL_ERROR, Logger.prefix);
    }

    public static void error(final String subTag, final String des, final Throwable ex) {
        Log.e(Logger.prefix, String.format("  %s : %s", subTag, des), ex);
//        System.out.println(Logger.prefix + " [error] " + String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [error] " + ex.toString());
//        com.orhanobut.logger.Logger.e(ex, String.format("  %s : %s", subTag, des));
//        writeToFile(Logger.prefix + String.format("  %s : %s", subTag, des) + ex.getMessage());
//        NeloLog.error(ex, String.format("  %s : %s", subTag, des) + ex.getMessage(), Logger.prefix);
        writeToFile(String.format("  %s : %s", subTag, des) + ex.getMessage(), LEVEL_ERROR, Logger.prefix);
    }

    public static void info(final String des) {
        Log.i(Logger.prefix, des);
//        System.out.println(Logger.prefix + " [info] " + des);
//        com.orhanobut.logger.Logger.i(des);
//        writeToFile(Logger.prefix + des);
        writeToFile(des, LEVEL_INFO, Logger.prefix);
    }

    public static void info(final String subTag, final String des) {
        Log.i(Logger.prefix, String.format("  %s : %s", subTag, des));
//        System.out.println(Logger.prefix + " [info] " + String.format("  %s : %s", subTag, des));
//        com.orhanobut.logger.Logger.i(String.format("  %s : %s", subTag, des));
        writeToFile(String.format("  %s : %s", subTag, des), LEVEL_INFO, Logger.prefix);
    }


    private static void writeToFile(String content, String level, String moduleName) {
//        08-29 18:38:59.694 18962-19148/com.navercorp.ncp.mqms.mqmsagent D/[MQMS-AGENT]:
//        if (null != handler) {
//            String prefix = DateUtil.getFormatDate(DateUtil.DATA_FORMAT_yyyy_MM_dd_hh_mm_ss_HYPHEN, System.currentTimeMillis());
//            prefix += " " + Process.myPid() + "-" + Thread.currentThread().getId();
//            prefix += " " + HookModule.getInstance().getPackageName();
//            prefix += " ";
//
//            prefix += " " + level + "/" + moduleName;
//            content = prefix + " " + content;
//
//            Message msg = Message.obtain();
//            msg.what = MSG_WRITE;
//            msg.obj = content;
//            handler.sendMessage(msg);
//        }
    }

    private static void writeFile(Message msg) {
        String content = (String) msg.obj;
        if (!TextUtils.isEmpty(content)) {
            writeLogToFile(content);
        }
    }

    private static void writeLogToFile(String content) {
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
    }

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
                    writeFile(msg);
                    break;
//                case MSG_DELETE_OLD_LOG_FILES:
//                    checkOldLogFiles();
//                    break;
                default:
                    break;
            }
        }
    }

    public static class WriterThread extends Thread {
        @Override
        public void run() {
            Looper.prepare();
            writeLogToFile("\nstart write a new log--------------------------------------------------------");
            handler = new WriterHandler(Looper.myLooper());

            Logger.debug("-mqmsdebug", "log WriterThread thread start loop, thread id:" + currentThread().getId());
            Looper.loop();
            Logger.debug("-mqmsdebug", "log WriterThread thread exit, thread id:" + currentThread().getId());
        }
    }

}
