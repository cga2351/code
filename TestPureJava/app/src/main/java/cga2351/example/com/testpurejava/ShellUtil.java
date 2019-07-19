package cga2351.example.com.testpurejava;

import android.text.TextUtils;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import cga2351.example.com.testpurejava.Logger;

/**
 * Created by xiangning on 2017/7/14.
 */

public class ShellUtil {

    public static String command(boolean needRoot, String cmd) {
        return commandRun(needRoot, cmd);
    }

    public static String command(boolean needRoot, String cmd, String... args) {
//        return command(cmd, true, args);
        StringBuilder sb = new StringBuilder();
        sb.append(cmd).append(" ");
        for (String arg : args) {
            sb.append(arg).append(" ");
        }
        return commandRun(needRoot, sb.toString());
    }

    private static String commandRun(boolean needRoot, String cmd) {
//        return commandRun(cmd, true);

        String tmp = "";
        String error = "";
        String result = "";

        try {
            Process proc = Runtime.getRuntime().exec(getShell(needRoot));
            DataOutputStream dos = new DataOutputStream(proc.getOutputStream());
            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(proc.getErrorStream(), "UTF-8"));

//            dos.writeBytes(Constant.LD_LIBRARY_PATH);
            dos.writeBytes(cmd);
            dos.flush();
            dos.close();

            try {
                try {
                    proc.getOutputStream().close();
                } catch (IOException e) {
                }

                proc.waitFor();
            } catch (InterruptedException e) {
                proc.destroy();
            }

            tmp = errorBufferedReader.readLine();
            while (!TextUtils.isEmpty(tmp)) {
                error += tmp + "\n";
                tmp = errorBufferedReader.readLine();
            }
            Logger.debug("-mqmsdebug", "cmd:" + cmd + ", error=" + error);

            tmp = inputBufferedReader.readLine();
            while (!TextUtils.isEmpty(tmp)) {
                result += tmp + "\n";
                tmp = inputBufferedReader.readLine();
            }
            Logger.debug("-mqmsdebug", "cmd:" + cmd + ", result=" + result);

            inputBufferedReader.close();
            errorBufferedReader.close();
            proc.getInputStream().close();
            proc.getErrorStream().close();
        } catch (Exception e) {
            e.printStackTrace();
            Logger.error(" # commandRun(IOException): " + e.getMessage());
        }

        return result;
    }

    public static void chmodFb() {
		ShellUtil.command(true, "chmod", "666", "/dev/graphics/fb0");
    }

//    public static String getShell() {
//        return "sh";
////        if (new File("/system/xbin/su").exists() || new File("/system/bin/su").exists()) {
////            return "su";
////        } else {
////            return "sh";
////        }
//    }

    public static String getShell(boolean needRoot){
//        return "sh";
        if(needRoot &&
                (new File("/system/xbin/su").exists() ||
                        new File("/system/bin/su").exists() ||
                        new File("/su").exists() ||
                        new File("/sbin/su").exists() )) {
            return "su";
        } else {
            return "sh";
        }
    }
}
