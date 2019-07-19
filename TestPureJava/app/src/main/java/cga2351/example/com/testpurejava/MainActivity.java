package cga2351.example.com.testpurejava;

import android.Manifest;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.net.ConnectivityManager;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cga2351.testapp.IRemoteInterface;
import com.navercorp.ncp.mqms.testxposedsubstrate.IHookInterface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    IRemoteInterface remoteInterface;
    int count = 0;
    TestServiceConnection testServiceConnection = new TestServiceConnection();
    TextView tvInfo;
    SurfaceView sv_1;
    Button btnTest1;
    Button btnTest2;
    IHookInterface hookInterface;
    SurfaceHolder surfaceHolder;
    int previewWidth = 1280;
    int previewHeight = 720;
    long lastFrameTime = 0;
    boolean preview = false;

    byte[] previewDataBuf = new byte[previewWidth * previewHeight * ImageFormat.getBitsPerPixel(ImageFormat.NV21) / 8];
    Camera camera;
    boolean testFlag = false;

    ServiceConnection hookInterfaceServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d("-yuliang", "HookInterfaceService connected!" );
            try {
                hookInterface = IHookInterface.Stub.asInterface(service);
                hookInterface.getTargetAppLibAbsPath();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d("-yuliang", "HookInterfaceService disconnected!" );
            hookInterface = null;
            initHookInterface();
        }
    };

    private static String videoMediaFormatType = MediaFormat.MIMETYPE_VIDEO_MPEG4;

    public static final String TAG = "test_pure_java";

    public void startTcpdump(String _saveFilePath) {

        String tcpDumpPath = "";
            tcpDumpPath = "/data/local/tmp/tcpdump";

        try {
            try {
                String option = "";
                StringBuilder sb = new StringBuilder();

//                sb.append(" -i any");
                int networkType = ConnectivityManager.TYPE_WIFI;
                if (networkType == ConnectivityManager.TYPE_WIFI) {
                    sb.append(" -i wlan0");
                } else if (networkType == ConnectivityManager.TYPE_MOBILE){
                    sb.append(" -i rmnet1");
                } else if (networkType == ConnectivityManager.TYPE_ETHERNET) {
                    // emulator net type is TYPE_ETHERNET
                    sb.append(" -i eth0");
                } else {
                }

                sb.append(" -s 0 -w ");
                sb.append(_saveFilePath);
                if(option != null && option.length() > 0) {
                    sb.append(" ").append(option);
                }

                Process proc = Runtime.getRuntime().exec(ShellUtil.getShell(true));
                DataOutputStream dos = new DataOutputStream(proc.getOutputStream());
                dos.writeBytes(tcpDumpPath + sb.toString());
                dos.flush();
                dos.close();

                String userTcpdumpMsg = null;
                BufferedReader reader = null;
                try {
                    reader = new BufferedReader(new InputStreamReader(proc.getErrorStream(), "UTF-8"));
                    userTcpdumpMsg = reader.readLine();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }
                reader.close();
            }
            catch (Exception e) {
            }
        } catch (Exception e) {
        }
    }

    private void killTcpdump() {
        String tcpDumpName = "";
        tcpDumpName = "tcpdump";

        try {
            Process proc = Runtime.getRuntime().exec(ShellUtil.getShell(true));
            DataOutputStream dos = new DataOutputStream(proc.getOutputStream());
            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));

            String psCmd = "ps ";
            if (Build.VERSION.SDK_INT >= 26) {
                psCmd += "-e ";
            }
            dos.writeBytes(psCmd + "| grep " + tcpDumpName);
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

            String line = inputBufferedReader.readLine();
            DataOutputStream tmpdos;
            Process procForKill;
            while (!TextUtils.isEmpty(line)) {
                procForKill = Runtime.getRuntime().exec(ShellUtil.getShell(true));
                tmpdos = new DataOutputStream(procForKill.getOutputStream());
                String[] parts = line.split("[\\s]+");
                tmpdos.writeBytes("kill " + parts[1]);
                tmpdos.flush();
                tmpdos.close();
                try {
                    try {
                        proc.getOutputStream().close();
                    } catch (IOException e) {
                    }
                    proc.waitFor();
                } catch (InterruptedException e) {
                    proc.destroy();
                }

                line = inputBufferedReader.readLine();
            }

            inputBufferedReader.close();
            proc.getInputStream().close();
        } catch (Exception e) {
        }
    }

    private String getThrowableString(Throwable ex){
        if (ex == null) return "";
        StringWriter writer = new StringWriter();
        PrintWriter printWriter = new PrintWriter(writer);
        ex.printStackTrace(printWriter);
        Throwable cause = ex.getCause();
        while (cause != null) {
            cause.printStackTrace(printWriter);
            cause = cause.getCause();
        }
        printWriter.close();
        return writer.toString();
    }

    public void Func1() {
        Func2();
    }
    public void Func2() {
        Func3();
    }
    public int Func3() {
        return (2 / 0);
    }

    public boolean checkDeviceHasNavigationBar() {
        boolean hasNavigationBar = false;
        Resources rs = getResources();
        int id = rs.getIdentifier("config_showNavigationBar", "bool", "android");
        if (id > 0) {
            hasNavigationBar = rs.getBoolean(id);
        }
        try {
            Class systemPropertiesClass = Class.forName("android.os.SystemProperties");
            Method m = systemPropertiesClass.getMethod("get", String.class);
            String navBarOverride = (String) m.invoke(systemPropertiesClass, "qemu.hw.mainkeys");
            if ("1".equals(navBarOverride)) {
                hasNavigationBar = false;
            } else if ("0".equals(navBarOverride)) {
                hasNavigationBar = true;
            }
        } catch (Exception e) {

        }
        return hasNavigationBar;

    }

    private void hideNavigationBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void showNavigationBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_VISIBLE;
        decorView.setSystemUiVisibility(uiOptions);
    }

    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent serviceIntent = new Intent("com.example.cga2351.testapp.RemoteInterfaceService");
        serviceIntent.setPackage("com.example.cga2351.testapp");
        bindService(serviceIntent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                remoteInterface = IRemoteInterface.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                remoteInterface = null;
            }
        }, ContextWrapper.BIND_AUTO_CREATE);

        bindService(new Intent(MainActivity.this, TestService.class), testServiceConnection, Service.BIND_AUTO_CREATE);

        //
        initHookInterface();

        btnTest1 = findViewById(R.id.btn_test1);
        btnTest2 = findViewById(R.id.btn_test2);
//        tvInfo = findViewById(R.id.tv_info);
        sv_1 = findViewById(R.id.sv_1);
        surfaceHolder = sv_1.getHolder();

        btnTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /////////////////////////////////////////////////////////////////////////////////

                /////////////////////////////////////////////////////////////////////////////////
//                if (flag) {
//                    String cmdResult1 = ShellUtil.command(false, "wm overscan 0,-100,0,-100");
//                    Logger.debug("-mqmsdebug", "ScriptCmdPlayVideo.execute(), adjust display, cmdResult1=" + cmdResult1);
//                } else {
//                    String cmdResult2 = ShellUtil.command(false, "wm overscan 0,0,0,0");
//                    Logger.debug("-mqmsdebug", "ScriptCmdPlayVideo.execute(), adjust display, cmdResult2=" + cmdResult2);
//                }
//                flag = !flag;

                /////////////////////////////////////////////////////////////////////////////////
                int navigationBarHeight = 0;
                int statusBarHeight = 0;
                Resources resources = getResources();
                int navigationBarId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
                int statusBarId = resources.getIdentifier("status_bar_height", "dimen", "android");
                if (navigationBarId > 0) {
                    navigationBarHeight = resources.getDimensionPixelSize(navigationBarId);
                }
                if (statusBarId > 0) {
                    statusBarHeight = resources.getDimensionPixelSize(statusBarId);
                }
                boolean navigationBarDisplay = checkDeviceHasNavigationBar();
                Logger.debug("-yuliang",
                        "navigationBarHeight=" + navigationBarHeight + "" +
                                ", statusBarHeight=" + statusBarHeight +
                                ", navigationBarDisplay=" + navigationBarDisplay
                );
                /////////////////////////////////////////////////////////////////////////////////
//                try {
//                    Func1();
//                } catch (Exception e) {
//                    String info = getThrowableString(e);
//                    Log.d("-yuliang", "info:" + info);
//                }
                /////////////////////////////////////////////////////////////////////////////////
//                testFlag = !testFlag;
//                Camera.Parameters parameters1 = camera.getParameters();
//                Camera.Parameters parameters2 = camera.getParameters();
//                Log.d("-mqmsdebug", "onViewClicked() 2, parameters1=" + parameters1 + ", parameters2=" + parameters2);
//
//                if (testFlag) {
//                    Log.d("-mqmsdebug", "onViewClicked() 2, set preview fps to 15");
//                    parameters2.setPreviewFpsRange(15 * 1000, 15 * 1000);
//                } else {
//                    Log.d("-mqmsdebug", "onViewClicked() 2, set preview fps to 30");
//                    parameters2.setPreviewFpsRange(30 * 1000, 30 * 1000);
//                }
////                camera.stopPreview();
//                camera.setParameters(parameters2);
////                camera.startPreview();
//
//                int[] fps = new int[2];
//                camera.getParameters().getPreviewFpsRange(fps);
//                Log.d("-mqmsdebug", "onViewClicked() 2, after set preview fps:" + Arrays.toString(fps));
                /////////////////////////////////////////////////////////////////////////////////
            }
        });

        btnTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getResources();
                count++;
                testFlag = !testFlag;
                /////////////////////////////////////////////////////////////////////////////////
                ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
//                byteBuffer.flip();
                byte[] data = new byte[128];
                byteBuffer.put(data);
                Logger.debug("-mqmsdebug", "byteBuffer=" + byteBuffer);
                /////////////////////////////////////////////////////////////////////////////////
//                try {
//                    MediaCodec codec1 = MediaCodec.createByCodecName("OMX.Exynos.VP8.Encoder");
//                    MediaCodec codec2 = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_VP8);
//                    MediaCodec codec3 = MediaCodec.createByCodecName("OMX.Exynos.VP8.Encoder");
//
//                    MediaFormat mediaFormat = MediaFormat.createVideoFormat(codec1.getCodecInfo().getSupportedTypes()[0], 640, 480);;
//                    mediaFormat.setInteger(MediaFormat.KEY_BIT_RATE, 6000 * 1024);
//                    mediaFormat.setInteger(MediaFormat.KEY_BITRATE_MODE, 2);
//                    mediaFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface);
//                    mediaFormat.setInteger(MediaFormat.KEY_FRAME_RATE, 50);
//                    mediaFormat.setInteger(MediaFormat.KEY_I_FRAME_INTERVAL, 100);
//
//                    codec1.configure(mediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
//                    codec3.configure(mediaFormat, null, null, MediaCodec.CONFIGURE_FLAG_ENCODE);
//
//                    codec1.getCodecInfo().getSupportedTypes();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                /////////////////////////////////////////////////////////////////////////////////
//                if (!testFlag) {
//                    killTcpdump();
//                } else {
//                    startTcpdump("/sdcard/mqms/tmp/tmpTcpdump.pcap");
//                }
                /////////////////////////////////////////////////////////////////////////////////
//                try {
//                    MediaCodec mediaCodec = MediaCodec.createEncoderByType(MediaFormat.MIMETYPE_VIDEO_MPEG4);
//                    MediaCodecInfo.CodecCapabilities capabilities = mediaCodec.getCodecInfo().getCapabilitiesForType(MediaFormat.MIMETYPE_VIDEO_MPEG4);
//                    for (int i = 0; i < capabilities.colorFormats.length; i++) {
//                        String supportedColorFormat = null;
//                        if (capabilities.colorFormats[i] > 100) {
//                            supportedColorFormat = String.format("%x", capabilities.colorFormats[i]);
//                        } else {
//                            supportedColorFormat = String.format("%d", capabilities.colorFormats[i]);
//                        }
//                        Log.d(TAG, "supported color format:" + supportedColorFormat);
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                /////////////////////////////////////////////////////////////////////////////////
//                camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
//                List<int[]> supportedPreviewFrameRates = camera.getParameters().getSupportedPreviewFpsRange();
//                Log.d(TAG, "supportedPreviewFrameRates=" + Arrays.toString(supportedPreviewFrameRates.toArray()));
                /////////////////////////////////////////////////////////////////////////////////
//                if (preview) {
//                    stopPreview();
//                } else {
//                    initCamera();
//                    startPreview();
//                }
                /////////////////////////////////////////////////////////////////////////////////
//                Camera camera = Camera.open(Camera.CameraInfo.CAMERA_FACING_BACK);
//                List<Camera.Size> supportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
//                for (Camera.Size size : supportedPreviewSizes) {
//                    Log.d(TAG, "size.width=" + size.width + ", size.height=" + size.height);
//                }
//                try {
//                    MediaCodec videoEncoder = MediaCodec.createEncoderByType(videoMediaFormatType);
//                    // get supported color format
//                    int colorFormat = 0;
//                    MediaCodecInfo.CodecCapabilities capabilities =  videoEncoder.getCodecInfo().getCapabilitiesForType(videoMediaFormatType);
//                    for (int i = 0; i < capabilities.colorFormats.length; i++) {
//                        Log.d(TAG, "supported color format:0x" + Integer.toHexString(capabilities.colorFormats[i]));
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
                /////////////////////////////////////////////////////////////////////////////////
//                if (hookInterface != null) {
//                    try {
//                        String packageName = hookInterface.getTargetAppPackageName();
//                        Log.d("-yuliang", "get packageName from hook interface = " + packageName);
//                    } catch (RemoteException e) {
//                        e.printStackTrace();
//                    }
//                }
                /////////////////////////////////////////////////////////////////////////////////s
            }
        });
    }

    private void stopPreview() {
        Log.d(TAG, "stopPreview(), stop preview");
        camera.stopPreview();
        camera.release();
        preview = false;
        camera = null;
    }
    private void startPreview() {
        try {
            camera.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        camera.startPreview();
        preview = true;
        camera.addCallbackBuffer(previewDataBuf);;
    }

    private void initCamera() {
        int mCameraId = Camera.CameraInfo.CAMERA_FACING_BACK;
        camera = Camera.open(mCameraId);
        Camera.Parameters parameters = camera.getParameters();
        parameters.set("orientation", "portrait");
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_CONTINUOUS_VIDEO);
        parameters.setPreviewSize(previewWidth, previewHeight);
        parameters.setPreviewFormat(ImageFormat.NV21);
        parameters.setPreviewFpsRange(15 * 1000, 30 * 1000);

        camera.setDisplayOrientation(90);
        camera.setParameters(parameters);
        camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback() {
            @Override
            public void onPreviewFrame(byte[] data, Camera camera) {
                Log.d(TAG, "onPreviewFrame(), frame time interval:" + (System.currentTimeMillis() - lastFrameTime));
                lastFrameTime = System.currentTimeMillis();
                camera.addCallbackBuffer(data);
            }
        });
    }

    private void initHookInterface() {
        Intent hookServiceIntent = new Intent();
        hookServiceIntent.setAction("com.navercorp.ncp.mqms.testxposedsubstrate.hookservice");
        hookServiceIntent.setPackage("com.navercorp.ncp.mqms.testxposedsubstrate");

        bindService(hookServiceIntent, hookInterfaceServiceConnection, Service.BIND_AUTO_CREATE);
    }

    public class TestServiceConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
        }
    }
}
