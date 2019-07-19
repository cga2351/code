package com.facebook.react.devsupport;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.string;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.network.OkHttpCallUtil;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.packagerconnection.ReconnectingWebSocket.ConnectionCallback;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.ConnectionPool;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevServerHelper
{
  private static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
  private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
  private static final int LONG_POLL_FAILURE_DELAY_MS = 5000;
  private static final int LONG_POLL_KEEP_ALIVE_DURATION_MS = 120000;
  private static final String PACKAGER_OK_STATUS = "packager-status:running";
  public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
  private final BundleDownloader mBundleDownloader;
  private InspectorPackagerConnection.BundleStatusProvider mBundlerStatusProvider;
  private final OkHttpClient mClient;

  @Nullable
  private InspectorPackagerConnection mInspectorPackagerConnection;

  @Nullable
  private OkHttpClient mOnChangePollingClient;
  private boolean mOnChangePollingEnabled;

  @Nullable
  private OnServerContentChangeListener mOnServerContentChangeListener;
  private final String mPackageName;

  @Nullable
  private JSPackagerClient mPackagerClient;
  private final Handler mRestartOnChangePollingHandler;
  private final DevInternalSettings mSettings;

  public DevServerHelper(DevInternalSettings paramDevInternalSettings, String paramString, InspectorPackagerConnection.BundleStatusProvider paramBundleStatusProvider)
  {
    this.mSettings = paramDevInternalSettings;
    this.mBundlerStatusProvider = paramBundleStatusProvider;
    this.mClient = new OkHttpClient.Builder().connectTimeout(5000L, TimeUnit.MILLISECONDS).readTimeout(0L, TimeUnit.MILLISECONDS).writeTimeout(0L, TimeUnit.MILLISECONDS).build();
    this.mBundleDownloader = new BundleDownloader(this.mClient);
    this.mRestartOnChangePollingHandler = new Handler(Looper.getMainLooper());
    this.mPackageName = paramString;
  }

  private String createBundleURL(String paramString, BundleType paramBundleType)
  {
    return createBundleURL(paramString, paramBundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
  }

  private String createBundleURL(String paramString1, BundleType paramBundleType, String paramString2)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramString2;
    arrayOfObject[1] = paramString1;
    arrayOfObject[2] = paramBundleType.typeID();
    arrayOfObject[3] = Boolean.valueOf(getDevMode());
    arrayOfObject[4] = Boolean.valueOf(getJSMinifyMode());
    return String.format(localLocale, "http://%s/%s.%s?platform=android&dev=%s&minify=%s", arrayOfObject);
  }

  private String createLaunchJSDevtoolsCommandUrl()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSettings.getPackagerConnectionSettings().getDebugServerHost();
    return String.format(localLocale, "http://%s/launch-js-devtools", arrayOfObject);
  }

  private String createOnChangeEndpointUrl()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSettings.getPackagerConnectionSettings().getDebugServerHost();
    return String.format(localLocale, "http://%s/onchange", arrayOfObject);
  }

  private static String createOpenStackFrameURL(String paramString)
  {
    return String.format(Locale.US, "http://%s/open-stack-frame", new Object[] { paramString });
  }

  private static String createPackagerStatusURL(String paramString)
  {
    return String.format(Locale.US, "http://%s/status", new Object[] { paramString });
  }

  private static String createResourceURL(String paramString1, String paramString2)
  {
    return String.format(Locale.US, "http://%s/%s", new Object[] { paramString1, paramString2 });
  }

  private static String createSymbolicateURL(String paramString)
  {
    return String.format(Locale.US, "http://%s/symbolicate", new Object[] { paramString });
  }

  private void enqueueOnChangeEndpointLongPolling()
  {
    Request localRequest = new Request.Builder().url(createOnChangeEndpointUrl()).tag(this).build();
    ((OkHttpClient)Assertions.assertNotNull(this.mOnChangePollingClient)).newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        if (DevServerHelper.this.mOnChangePollingEnabled)
        {
          FLog.d("ReactNative", "Error while requesting /onchange endpoint", paramAnonymousIOException);
          DevServerHelper.this.mRestartOnChangePollingHandler.postDelayed(new Runnable()
          {
            public void run()
            {
              DevServerHelper.this.handleOnChangePollingResponse(false);
            }
          }
          , 5000L);
        }
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        DevServerHelper localDevServerHelper = DevServerHelper.this;
        if (paramAnonymousResponse.code() == 205);
        for (boolean bool = true; ; bool = false)
        {
          localDevServerHelper.handleOnChangePollingResponse(bool);
          return;
        }
      }
    });
  }

  private BundleDeltaClient.ClientType getDeltaClientType()
  {
    if (this.mSettings.isBundleDeltasCppEnabled())
      return BundleDeltaClient.ClientType.NATIVE;
    if (this.mSettings.isBundleDeltasEnabled())
      return BundleDeltaClient.ClientType.DEV_SUPPORT;
    return BundleDeltaClient.ClientType.NONE;
  }

  private boolean getDevMode()
  {
    return this.mSettings.isJSDevModeEnabled();
  }

  private String getHostForJSProxy()
  {
    String str = (String)Assertions.assertNotNull(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    int i = str.lastIndexOf(':');
    if (i > -1)
      return "localhost" + str.substring(i);
    return "localhost";
  }

  private String getInspectorAttachUrl(String paramString)
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = AndroidInfoHelpers.getServerHost();
    arrayOfObject[1] = paramString;
    arrayOfObject[2] = this.mPackageName;
    arrayOfObject[3] = AndroidInfoHelpers.getFriendlyDeviceName();
    return String.format(localLocale, "http://%s/nuclide/attach-debugger-nuclide?title=%s&app=%s&device=%s", arrayOfObject);
  }

  private String getInspectorDeviceUrl()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.mSettings.getPackagerConnectionSettings().getInspectorServerHost();
    arrayOfObject[1] = AndroidInfoHelpers.getFriendlyDeviceName();
    arrayOfObject[2] = this.mPackageName;
    return String.format(localLocale, "http://%s/inspector/device?name=%s&app=%s", arrayOfObject);
  }

  private boolean getJSMinifyMode()
  {
    return this.mSettings.isJSMinifyEnabled();
  }

  private void handleOnChangePollingResponse(boolean paramBoolean)
  {
    if (this.mOnChangePollingEnabled)
    {
      if (paramBoolean)
        UiThreadUtil.runOnUiThread(new Runnable()
        {
          public void run()
          {
            if (DevServerHelper.this.mOnServerContentChangeListener != null)
              DevServerHelper.this.mOnServerContentChangeListener.onServerContentChanged();
          }
        });
      enqueueOnChangeEndpointLongPolling();
    }
  }

  public void attachDebugger(final Context paramContext, final String paramString)
  {
    new AsyncTask()
    {
      protected Boolean doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        return Boolean.valueOf(doSync());
      }

      public boolean doSync()
      {
        try
        {
          String str = DevServerHelper.this.getInspectorAttachUrl(paramString);
          new OkHttpClient().newCall(new Request.Builder().url(str).build()).execute();
          return true;
        }
        catch (IOException localIOException)
        {
          FLog.e("ReactNative", "Failed to send attach request to Inspector", localIOException);
        }
        return false;
      }

      protected void onPostExecute(Boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean.booleanValue())
        {
          String str = paramContext.getString(R.string.catalyst_debugjs_nuclide_failure);
          Toast.makeText(paramContext, str, 1).show();
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void closeInspectorConnection()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        if (DevServerHelper.this.mInspectorPackagerConnection != null)
        {
          DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
          DevServerHelper.access$202(DevServerHelper.this, null);
        }
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void closePackagerConnection()
  {
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        if (DevServerHelper.this.mPackagerClient != null)
        {
          DevServerHelper.this.mPackagerClient.close();
          DevServerHelper.access$002(DevServerHelper.this, null);
        }
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void disableDebugger()
  {
    if (this.mInspectorPackagerConnection != null)
      this.mInspectorPackagerConnection.sendEventToAllConnections("{ \"id\":1,\"method\":\"Debugger.disable\" }");
  }

  public void downloadBundleFromURL(DevBundleDownloadListener paramDevBundleDownloadListener, File paramFile, String paramString, BundleDownloader.BundleInfo paramBundleInfo)
  {
    this.mBundleDownloader.downloadBundleFromURL(paramDevBundleDownloadListener, paramFile, paramString, paramBundleInfo, getDeltaClientType());
  }

  public void downloadBundleFromURL(DevBundleDownloadListener paramDevBundleDownloadListener, File paramFile, String paramString, BundleDownloader.BundleInfo paramBundleInfo, Request.Builder paramBuilder)
  {
    this.mBundleDownloader.downloadBundleFromURL(paramDevBundleDownloadListener, paramFile, paramString, paramBundleInfo, getDeltaClientType(), paramBuilder);
  }

  // ERROR //
  @Nullable
  public File downloadBundleResourceFromUrlSync(String paramString, File paramFile)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 48	com/facebook/react/devsupport/DevServerHelper:mSettings	Lcom/facebook/react/devsupport/DevInternalSettings;
    //   4: invokevirtual 152	com/facebook/react/devsupport/DevInternalSettings:getPackagerConnectionSettings	()Lcom/facebook/react/packagerconnection/PackagerConnectionSettings;
    //   7: invokevirtual 157	com/facebook/react/packagerconnection/PackagerConnectionSettings:getDebugServerHost	()Ljava/lang/String;
    //   10: aload_1
    //   11: invokestatic 381	com/facebook/react/devsupport/DevServerHelper:createResourceURL	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_3
    //   15: new 214	okhttp3/Request$Builder
    //   18: dup
    //   19: invokespecial 215	okhttp3/Request$Builder:<init>	()V
    //   22: aload_3
    //   23: invokevirtual 221	okhttp3/Request$Builder:url	(Ljava/lang/String;)Lokhttp3/Request$Builder;
    //   26: invokevirtual 228	okhttp3/Request$Builder:build	()Lokhttp3/Request;
    //   29: astore 4
    //   31: aload_0
    //   32: getfield 77	com/facebook/react/devsupport/DevServerHelper:mClient	Lokhttp3/OkHttpClient;
    //   35: aload 4
    //   37: invokevirtual 242	okhttp3/OkHttpClient:newCall	(Lokhttp3/Request;)Lokhttp3/Call;
    //   40: invokeinterface 385 1 0
    //   45: astore 7
    //   47: aload 7
    //   49: invokevirtual 390	okhttp3/Response:isSuccessful	()Z
    //   52: istore 13
    //   54: iload 13
    //   56: ifne +80 -> 136
    //   59: aload 7
    //   61: ifnull +12 -> 73
    //   64: iconst_0
    //   65: ifeq +63 -> 128
    //   68: aload 7
    //   70: invokevirtual 393	okhttp3/Response:close	()V
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: areturn
    //   77: astore 20
    //   79: aconst_null
    //   80: aload 20
    //   82: invokevirtual 397	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   85: goto -12 -> 73
    //   88: astore 5
    //   90: iconst_3
    //   91: anewarray 4	java/lang/Object
    //   94: astore 6
    //   96: aload 6
    //   98: iconst_0
    //   99: aload_1
    //   100: aastore
    //   101: aload 6
    //   103: iconst_1
    //   104: aload_2
    //   105: invokevirtual 402	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   108: aastore
    //   109: aload 6
    //   111: iconst_2
    //   112: aload 5
    //   114: aastore
    //   115: ldc_w 404
    //   118: ldc_w 406
    //   121: aload 6
    //   123: invokestatic 412	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aconst_null
    //   127: areturn
    //   128: aload 7
    //   130: invokevirtual 393	okhttp3/Response:close	()V
    //   133: goto -60 -> 73
    //   136: aload_2
    //   137: invokestatic 418	f/l:b	(Ljava/io/File;)Lf/s;
    //   140: astore 16
    //   142: aload 16
    //   144: astore 15
    //   146: aload 7
    //   148: invokevirtual 422	okhttp3/Response:body	()Lokhttp3/ResponseBody;
    //   151: invokevirtual 428	okhttp3/ResponseBody:source	()Lf/e;
    //   154: invokestatic 432	f/l:a	(Lf/t;)Lf/e;
    //   157: aload 15
    //   159: invokeinterface 437 2 0
    //   164: pop2
    //   165: aload 15
    //   167: ifnull +10 -> 177
    //   170: aload 15
    //   172: invokeinterface 440 1 0
    //   177: aload 7
    //   179: ifnull -104 -> 75
    //   182: iconst_0
    //   183: ifeq +73 -> 256
    //   186: aload 7
    //   188: invokevirtual 393	okhttp3/Response:close	()V
    //   191: aload_2
    //   192: areturn
    //   193: astore 19
    //   195: aconst_null
    //   196: aload 19
    //   198: invokevirtual 397	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   201: aload_2
    //   202: areturn
    //   203: astore 14
    //   205: aconst_null
    //   206: astore 15
    //   208: aload 15
    //   210: ifnull +10 -> 220
    //   213: aload 15
    //   215: invokeinterface 440 1 0
    //   220: aload 14
    //   222: athrow
    //   223: astore 11
    //   225: aload 11
    //   227: athrow
    //   228: astore 12
    //   230: aload 11
    //   232: astore 9
    //   234: aload 12
    //   236: astore 8
    //   238: aload 7
    //   240: ifnull +13 -> 253
    //   243: aload 9
    //   245: ifnull +30 -> 275
    //   248: aload 7
    //   250: invokevirtual 393	okhttp3/Response:close	()V
    //   253: aload 8
    //   255: athrow
    //   256: aload 7
    //   258: invokevirtual 393	okhttp3/Response:close	()V
    //   261: aload_2
    //   262: areturn
    //   263: astore 10
    //   265: aload 9
    //   267: aload 10
    //   269: invokevirtual 397	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   272: goto -19 -> 253
    //   275: aload 7
    //   277: invokevirtual 393	okhttp3/Response:close	()V
    //   280: goto -27 -> 253
    //   283: astore 8
    //   285: aconst_null
    //   286: astore 9
    //   288: goto -50 -> 238
    //   291: astore 14
    //   293: goto -85 -> 208
    //
    // Exception table:
    //   from	to	target	type
    //   68	73	77	java/lang/Throwable
    //   31	47	88	java/lang/Exception
    //   68	73	88	java/lang/Exception
    //   79	85	88	java/lang/Exception
    //   128	133	88	java/lang/Exception
    //   186	191	88	java/lang/Exception
    //   195	201	88	java/lang/Exception
    //   248	253	88	java/lang/Exception
    //   253	256	88	java/lang/Exception
    //   256	261	88	java/lang/Exception
    //   265	272	88	java/lang/Exception
    //   275	280	88	java/lang/Exception
    //   186	191	193	java/lang/Throwable
    //   136	142	203	finally
    //   47	54	223	java/lang/Throwable
    //   170	177	223	java/lang/Throwable
    //   213	220	223	java/lang/Throwable
    //   220	223	223	java/lang/Throwable
    //   225	228	228	finally
    //   248	253	263	java/lang/Throwable
    //   47	54	283	finally
    //   170	177	283	finally
    //   213	220	283	finally
    //   220	223	283	finally
    //   146	165	291	finally
  }

  public String getDevServerBundleURL(String paramString)
  {
    if (this.mSettings.isBundleDeltasEnabled());
    for (BundleType localBundleType = BundleType.DELTA; ; localBundleType = BundleType.BUNDLE)
      return createBundleURL(paramString, localBundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
  }

  public String getJSBundleURLForRemoteDebugging(String paramString)
  {
    return createBundleURL(paramString, BundleType.BUNDLE, getHostForJSProxy());
  }

  public String getSourceMapUrl(String paramString)
  {
    return createBundleURL(paramString, BundleType.MAP);
  }

  public String getSourceUrl(String paramString)
  {
    if (this.mSettings.isBundleDeltasEnabled());
    for (BundleType localBundleType = BundleType.DELTA; ; localBundleType = BundleType.BUNDLE)
      return createBundleURL(paramString, localBundleType);
  }

  public String getWebsocketProxyURL()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mSettings.getPackagerConnectionSettings().getDebugServerHost();
    return String.format(localLocale, "ws://%s/debugger-proxy?role=client", arrayOfObject);
  }

  public void isPackagerRunning(final PackagerStatusCallback paramPackagerStatusCallback)
  {
    String str = createPackagerStatusURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    Request localRequest = new Request.Builder().url(str).build();
    this.mClient.newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        FLog.w("ReactNative", "The packager does not seem to be running as we got an IOException requesting its status: " + paramAnonymousIOException.getMessage());
        paramPackagerStatusCallback.onPackagerStatusFetched(false);
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        if (!paramAnonymousResponse.isSuccessful())
        {
          FLog.e("ReactNative", "Got non-success http code from packager when requesting status: " + paramAnonymousResponse.code());
          paramPackagerStatusCallback.onPackagerStatusFetched(false);
          return;
        }
        ResponseBody localResponseBody = paramAnonymousResponse.body();
        if (localResponseBody == null)
        {
          FLog.e("ReactNative", "Got null body response from packager when requesting status");
          paramPackagerStatusCallback.onPackagerStatusFetched(false);
          return;
        }
        String str = localResponseBody.string();
        if (!"packager-status:running".equals(str))
        {
          FLog.e("ReactNative", "Got unexpected response from packager when requesting status: " + str);
          paramPackagerStatusCallback.onPackagerStatusFetched(false);
          return;
        }
        paramPackagerStatusCallback.onPackagerStatusFetched(true);
      }
    });
  }

  public void launchJSDevtools()
  {
    Request localRequest = new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build();
    this.mClient.newCall(localRequest).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
      }
    });
  }

  public void openInspectorConnection()
  {
    if (this.mInspectorPackagerConnection != null)
    {
      FLog.w("ReactNative", "Inspector connection already open, nooping.");
      return;
    }
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        DevServerHelper.access$202(DevServerHelper.this, new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider));
        DevServerHelper.this.mInspectorPackagerConnection.connect();
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void openPackagerConnection(final String paramString, final PackagerCommandListener paramPackagerCommandListener)
  {
    if (this.mPackagerClient != null)
    {
      FLog.w("ReactNative", "Packager connection already open, nooping.");
      return;
    }
    new AsyncTask()
    {
      protected Void doInBackground(Void[] paramAnonymousArrayOfVoid)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("reload", new NotificationOnlyHandler()
        {
          public void onNotification(@Nullable Object paramAnonymous2Object)
          {
            DevServerHelper.1.this.val$commandListener.onPackagerReloadCommand();
          }
        });
        localHashMap.put("devMenu", new NotificationOnlyHandler()
        {
          public void onNotification(@Nullable Object paramAnonymous2Object)
          {
            DevServerHelper.1.this.val$commandListener.onPackagerDevMenuCommand();
          }
        });
        localHashMap.put("captureHeap", new RequestOnlyHandler()
        {
          public void onRequest(@Nullable Object paramAnonymous2Object, Responder paramAnonymous2Responder)
          {
            DevServerHelper.1.this.val$commandListener.onCaptureHeapCommand(paramAnonymous2Responder);
          }
        });
        Map localMap = paramPackagerCommandListener.customCommandHandlers();
        if (localMap != null)
          localHashMap.putAll(localMap);
        localHashMap.putAll(new FileIoHandler().handlers());
        ReconnectingWebSocket.ConnectionCallback local4 = new ReconnectingWebSocket.ConnectionCallback()
        {
          public void onConnected()
          {
            DevServerHelper.1.this.val$commandListener.onPackagerConnected();
          }

          public void onDisconnected()
          {
            DevServerHelper.1.this.val$commandListener.onPackagerDisconnected();
          }
        };
        DevServerHelper.access$002(DevServerHelper.this, new JSPackagerClient(paramString, DevServerHelper.this.mSettings.getPackagerConnectionSettings(), localHashMap, local4));
        DevServerHelper.this.mPackagerClient.init();
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  public void openStackFrameCall(StackFrame paramStackFrame)
  {
    String str = createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    Request localRequest = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/json"), paramStackFrame.toJSON().toString())).build();
    ((Call)Assertions.assertNotNull(this.mClient.newCall(localRequest))).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        FLog.w("ReactNative", "Got IOException when attempting to open stack frame: " + paramAnonymousIOException.getMessage());
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
      }
    });
  }

  public void startPollingOnChangeEndpoint(OnServerContentChangeListener paramOnServerContentChangeListener)
  {
    if (this.mOnChangePollingEnabled)
      return;
    this.mOnChangePollingEnabled = true;
    this.mOnServerContentChangeListener = paramOnServerContentChangeListener;
    this.mOnChangePollingClient = new OkHttpClient.Builder().connectionPool(new ConnectionPool(1, 120000L, TimeUnit.MILLISECONDS)).connectTimeout(5000L, TimeUnit.MILLISECONDS).build();
    enqueueOnChangeEndpointLongPolling();
  }

  public void stopPollingOnChangeEndpoint()
  {
    this.mOnChangePollingEnabled = false;
    this.mRestartOnChangePollingHandler.removeCallbacksAndMessages(null);
    if (this.mOnChangePollingClient != null)
    {
      OkHttpCallUtil.cancelTag(this.mOnChangePollingClient, this);
      this.mOnChangePollingClient = null;
    }
    this.mOnServerContentChangeListener = null;
  }

  public void symbolicateStackTrace(Iterable<StackFrame> paramIterable, final SymbolicationListener paramSymbolicationListener)
  {
    String str;
    JSONArray localJSONArray;
    try
    {
      str = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
      localJSONArray = new JSONArray();
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((StackFrame)localIterator.next()).toJSON());
    }
    catch (JSONException localJSONException)
    {
      FLog.w("ReactNative", "Got JSONException when attempting symbolicate stack trace: " + localJSONException.getMessage());
      return;
    }
    Request localRequest = new Request.Builder().url(str).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("stack", localJSONArray).toString())).build();
    ((Call)Assertions.assertNotNull(this.mClient.newCall(localRequest))).enqueue(new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        FLog.w("ReactNative", "Got IOException when attempting symbolicate stack trace: " + paramAnonymousIOException.getMessage());
        paramSymbolicationListener.onSymbolicationComplete(null);
      }

      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
        throws IOException
      {
        try
        {
          paramSymbolicationListener.onSymbolicationComplete(Arrays.asList(StackTraceHelper.convertJsStackTrace(new JSONObject(paramAnonymousResponse.body().string()).getJSONArray("stack"))));
          return;
        }
        catch (JSONException localJSONException)
        {
          paramSymbolicationListener.onSymbolicationComplete(null);
        }
      }
    });
  }

  private static enum BundleType
  {
    private final String mTypeID;

    static
    {
      BundleType[] arrayOfBundleType = new BundleType[3];
      arrayOfBundleType[0] = BUNDLE;
      arrayOfBundleType[1] = DELTA;
      arrayOfBundleType[2] = MAP;
    }

    private BundleType(String paramString)
    {
      this.mTypeID = paramString;
    }

    public String typeID()
    {
      return this.mTypeID;
    }
  }

  public static abstract interface OnServerContentChangeListener
  {
    public abstract void onServerContentChanged();
  }

  public static abstract interface PackagerCommandListener
  {
    @Nullable
    public abstract Map<String, RequestHandler> customCommandHandlers();

    public abstract void onCaptureHeapCommand(Responder paramResponder);

    public abstract void onPackagerConnected();

    public abstract void onPackagerDevMenuCommand();

    public abstract void onPackagerDisconnected();

    public abstract void onPackagerReloadCommand();
  }

  public static abstract interface PackagerCustomCommandProvider
  {
  }

  public static abstract interface SymbolicationListener
  {
    public abstract void onSymbolicationComplete(@Nullable Iterable<StackFrame> paramIterable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevServerHelper
 * JD-Core Version:    0.6.2
 */