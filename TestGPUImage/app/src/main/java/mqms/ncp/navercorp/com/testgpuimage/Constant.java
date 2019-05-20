package mqms.ncp.navercorp.com.testgpuimage;

import android.graphics.Color;
import android.os.Build;

import java.nio.charset.Charset;

/**
 * author : yuliang
 * mail : yuliang@navercorp.com
 * date : 2017/6/20
 * description :
 */

public class Constant {

    public static final int previewWidth = 1280;
    public static final int previewHeight = 720;

    public static final String LD_LIBRARY_PATH = (Build.VERSION.SDK_INT < 20) ? "export LD_LIBRARY_PATH=/vendor/lib:/system/lib \n" :
            (Build.BRAND.equals("samsung") && Build.VERSION.SDK_INT == 21) ? "sh \n" :"\n";

    // ------------------------------- app package -------------------------------
    public static final String PACKAGE_NAME_LINE = "jp.naver.line.android";
    public static final String PACKAGE_NAME_KAKAO_TALK = "com.kakao.talk";
    public static final String PACKAGE_NAME_WHATSAPP = "com.whatsapp";
    public static final String PACKAGE_NAME_VIBER = "com.viber.voip";
    public static final String PACKAGE_NAME_SKYPE = "com.skype.raider";
    public static final String PACKAGE_NAME_WECHAT = "com.tencent.mm";
    public static final String PACKAGE_NAME_QQ = "com.tencent.mobileqq";
    public static final String PACKAGE_NAME_QQ_VIDEO = "com.tencent.mobileqq:video";
    public static final String PACKAGE_NAME_TEST = "mqms.ncp.navercorp.com.testsurfaceview";

    // ------------------------------- Socket -------------------------------
//    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT = 65400;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_LINE = 65401;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_KAKAO = 65402;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_WHTSAPP = 65403;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_VIBER = 65404;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_SKYPE = 65405;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_WECHAT = 65406;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_QQ = 65407;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_QQ_VIDEO = 65408;
    public static final int MQMS_JAVA_HOOK_AGENT_LISTEN_PORT_TEST = 65409;


    public static final byte[] MAGIC_NUM = "MQMS".getBytes(Charset.defaultCharset());

    // ------------------------------- Communication Command -------------------------------
    public static final int MQMS_CMD_HEADER_SIZE = 8;
    public static final int MQMS_CMD_BODY_DEFAULT_SIZE = 0;

    // ------------------------------- Path -------------------------------
    public static final String MQMS_AGENT_LOG_FILE_SUFFIX = "_agent_log.txt";
    public static final String AUTO_AGENT_LOG_FILE_SUFFIX = "_auto_log.txt";
    public static final String NATIVE_AGENT_LOG_FILE_SUFFIX = "_native_log.txt";
    public static final String DAEMON_AGENT_LOG_FILE_SUFFIX = "_daemon_log.txt";
    public static final String JAVA_HOOK_AGENT_LOG_FILE_SUFFIX = "_jhook_log.txt";
    public static final String SD_PATH_ROOT = "/sdcard/";
    public static final String SD_PATH_MQMS_LOG = "/sdcard/mqms/log/";
    public static final String SD_PATH_MQMS_TMP = "/sdcard/mqms/tmp/";
    public static final String SD_PATH_MQMS_SCENARIO_SCRIPT = "/sdcard/mqms/ScenarioScript/";
    public static final String SD_PATH_MQMS_SCENARIO_RESULT = "/sdcard/mqms/ScenarioResult/";
    public static final String SD_PATH_MQMS_DEBUG_SCRIPT= "/sdcard/mqms/DebugScript/";
    public static final String SD_PATH_MQMS_DEBUG_RESULT = "/sdcard/mqms/DebugResult/";
    public static final String SD_PATH_MQMS_NATIVE_HOOK_LIB_PATH_ARMEABI_V7A = "/sdcard/mqms/nativeHook/lib/armeabi-v7a/";
    public static final String SD_PATH_MQMS_NATIVE_HOOK_LIB_PATH_ARM64_V8A= "/sdcard/mqms/nativeHook/lib/arm64-v8a/";
    public static final String NATIVE_HOOK_LIB = "libnative_hook.so";

//    public static String scenarioResult = "/sdcard/mqms/ScenarioResult/";
//    public static String scenarioScript = "/sdcard/mqms/ScenarioScript/";
    public static final String SD_PATH_MQMS_SCENARIO_SCRIPT_FILE_NAME = "script.json";
    public static final String SD_PATH_MQMS_SCENARIO_RESULT_FILE_NAME = "result.json";
    public static final String SD_PATH_MQMS_SCENARIO_RESULT_SCREEN_CAP_DIR = "ScreenCap/";
    public static final String SD_PATH_MQMS_SCENARIO_RESULT_NET_CAP_FILE = "netCapture.pcap";
    public static final String SD_PATH_MQMS_SCENARIO_RESULT_PERFORMANCE_FILE = "performance.json";
    public static final String SD_PATH_MQMS_APP_LAUNCH_INFO_FILE = "/sdcard/mqms/appLaunchInfo.dat";
    public static final String SD_PATH_MQMS_VERIFY_ELEMENT_SCREENSHOT_FILE = "/sdcard/mqms/tmp/findElementsScreenShot.jpg";

    // ------------------------------- Time Out -------------------------------
    public static final int INITIAL_WAIT_CONNECTOR_TIMEOUT = 20 * 1000;
    public static final int AUTOMATION_CMD_WAIT_TIMEOUT = 5 * 1000;    // if wait time too long, will cause some issues. do not wait too long, exceed 5s, treat as exception, restart uiautomator
    public static final int AUTOMATION_CMD_SET_TEXT_WAIT_TIMEOUT = 20 * 1000;
    public static final int AUTOMATION_CMD_RE_SEND_TIMEOUT = 10 * 1000;
    public static final int AUTOMATION_CMD_RE_SEND_INTERVAL = 2000;
    public static final int AUTOMATION_AGENT_CONNECT_RE_TRY_INTERVAL = 500;
    public static final int AUTOMATION_AGENT_CONNECT_TIME_OUT = 3000;
    public static final int DAEMON_AGENT_CONNECT_RE_TRY_INTERVAL = 1000;
    public static final int DAEMON_AGENT_CMD_WAIT_TIMEOUT  = 10 * 1000;
    public static final int DAEMON_AGENT_HEART_BEAT_INTERVAL  = 10 * 1000;
    public static final int SYNC_SCREEN_SHOT_WAIT_TIMEOUT = 5 * 1000;

    public static final int SCRIPT_STEP_RE_EXECUTE_INTERVAL = 500;
    public static final int SCRIPT_STEP_RE_EXECUTE_DEFAULT_TIMEOUT = 6000;

    public static final int MQMS_HOOK_START_UP_WAIT_TIME = 1000 * 2;
    public static final int MQMS_HOOK_GET_INSTALL_APP_WAIT_TIME = 1000 * 3;

    public static final int TIME_SYNC_TIME_OUT = 500;     //sync time with ntp server time out
    public static final int TIME_SYNC_RETRY_TIME_OUT = 10 * 1000;     //sync time with ntp server re-try time out
    public static final String NTP_SERVER_ADDRESS = "pool.ntp.org";    //ntp server, refer to old GQMS
    public static final int NTPD_SYNC_TIME_TIME_OUT = 5 * 1000;     // ntpd command wait time out
//    public static final String NTP_SERVER_ADDRESS = "cn.ntp.org.cn";    //ntp server, refer to old GQMS
//    public static final int TIME_SYNC_PERIOD = 12 * 60 * 60 * 1000;   //sync time period, half day
    public static final int TIME_SYNC_PERIOD = 60 * 60 * 1000;   //sync time period, one hour

    // voip_test_type params value
    public static final byte MED_TEST = 0;
    public static final byte POLQA_TEST = 1;

    // other params
    public static final String PCK_NAME = "package_name";   // LAUNCH_APP params
    public static final String REPLACE_AUDIO_PATH = "replace_audio_path";   // START_REPLACE_AUDIO/STOP_REPLACE_AUDIO params
    public static final String RECEIVE_AUDIO_PATH = "receive_audio_path";   // START_RECEIVE_AUDIO/STOP_RECEIVE_AUDIO params
    public static final String REPLACE_VIDEO_PATH = "replace_audio_path";   // START_REPLACE_VIDEO/STOP_REPLACE_VIDEO params
    public static final String RECEIVE_VIDEO_PATH = "receive_audio_path";   // START_RECEIVE_VIDEO/STOP_RECEIVE_VIDEO params
    public static final String WATER_MARK_DURATION = "water_mark_duration"; // ADD_WATER_MARK params
    public static final String WATER_MARK_TIMESTAMP = "water_mark_timestamp";    // ADD_WATER_MARK params

    public static final int SWITCH_STOP   = 0;
    public static final int SWITCH_START  = 1;

    public static final String RECORD_AUDIO_FILE_NAME = "recordAudioFile";
    public static final String PLAY_AUDIO_FILE_NAME = "playAudioFile";
    public static final String SENDER_RECORD_VIDEO_FILE_NAME = "senderRecord";
    public static final String RECEIVER_RECORD_VIDEO_FILE_NAME = "receiverRecord";
    public static final String AUDIO_FMT_WAV = ".wav";
    public static final String VIDEO_FMT_MP4 = ".mp4";

    // ------------------------------- System -------------------------------
    public static final String SEPARATOR = "/";     //instead of the File.separator

    // ------------------------------- tcp dump -------------------------------
    public static final String TCP_DUMP     = "/data/local/tmp/tcpdump";
    public static final String BUSY_BOX     = "/data/local/tmp/busybox";
    public static final String EMULATOR_TCP_DUMP     = "tcpdump";

    //
    public static final int VERIFY_ELEMENT_TARGET_COLOR = Color.RED;
//    public static final int VERIFY_ELEMENT_NORMAL_COLOR = Color.rgb((int)(0.6 * 255), (int)(0.4 * 255), (int)(0.2 * 255));  //0.6, 0.4, 0.2
    public static final int VERIFY_ELEMENT_NORMAL_COLOR = (0xff000000 | ((int)(0.6 * 255) << 16) | ((int)(0.4 * 255) << 8) | (int)(0.2 * 255));  //0.6, 0.4, 0.2

    // ------------------------------- uiautomator -------------------------------
    public static final int UIAUTOMATOR_GOT_NULL_ROOT_NODE_ERROR_CODE = 255;
    public static final String UIAUTOMATOR_GOT_NULL_ROOT_NODE_ERROR_INFO = "uiautomator got null root node";

    public static final String RES_SUCCESS = "success";
    public static final String RES_FAILED = "fail";

    // ------------------------------- video record -------------------------------
    public static final int RECORD_VIDEO_WIDTH = 1280;
    public static final int RECORD_VIDEO_HEIGHT = 720;
}
