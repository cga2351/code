package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.hardware.SensorManager;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.AsyncTask;
import android.util.Pair;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R.string;
import com.facebook.react.bridge.DefaultNativeModuleCallExceptionHandler;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.ShakeDetector.ShakeListener;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.packagerconnection.PackagerConnectionSettings;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

public class DevSupportManagerImpl
  implements DevInternalSettings.Listener, DevServerHelper.PackagerCommandListener, DevSupportManager
{
  public static final String EMOJI_FACE_WITH_NO_GOOD_GESTURE = " 🙅";
  public static final String EMOJI_HUNDRED_POINTS_SYMBOL = " 💯";
  private static final String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
  private static final int JAVA_ERROR_COOKIE = -1;
  private static final int JSEXCEPTION_ERROR_COOKIE = -1;
  private static final String JS_BUNDLE_FILE_NAME = "ReactNativeDevBundle.js";
  private static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
  private final Context mApplicationContext;
  private DevBundleDownloadListener mBundleDownloadListener;
  private InspectorPackagerConnection.BundleStatus mBundleStatus;
  private ReactContext mCurrentContext;
  private final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions = new LinkedHashMap();
  private Map<String, RequestHandler> mCustomPackagerCommandHandlers;
  private DebugOverlayController mDebugOverlayController;
  private final DefaultNativeModuleCallExceptionHandler mDefaultNativeModuleCallExceptionHandler;
  private final DevLoadingViewController mDevLoadingViewController;
  private boolean mDevLoadingViewVisible = false;
  private AlertDialog mDevOptionsDialog;
  private final DevServerHelper mDevServerHelper;
  private DevInternalSettings mDevSettings;
  private List<ErrorCustomizer> mErrorCustomizers;
  private final List<ExceptionLogger> mExceptionLoggers = new ArrayList();
  private boolean mIsDevSupportEnabled = false;
  private boolean mIsReceiverRegistered = false;
  private boolean mIsShakeDetectorStarted = false;
  private final String mJSAppBundleName;
  private final File mJSBundleTempFile;
  private int mLastErrorCookie = 0;
  private StackFrame[] mLastErrorStack;
  private String mLastErrorTitle;
  private ErrorType mLastErrorType;
  private final ReactInstanceManagerDevHelper mReactInstanceManagerHelper;
  private RedBoxDialog mRedBoxDialog;
  private RedBoxHandler mRedBoxHandler;
  private final BroadcastReceiver mReloadAppBroadcastReceiver;
  private final ShakeDetector mShakeDetector;

  public DevSupportManagerImpl(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper, String paramString, boolean paramBoolean, int paramInt)
  {
    this(paramContext, paramReactInstanceManagerDevHelper, paramString, paramBoolean, null, null, paramInt, null);
  }

  public DevSupportManagerImpl(Context paramContext, ReactInstanceManagerDevHelper paramReactInstanceManagerDevHelper, String paramString, boolean paramBoolean, RedBoxHandler paramRedBoxHandler, DevBundleDownloadListener paramDevBundleDownloadListener, int paramInt, Map<String, RequestHandler> paramMap)
  {
    this.mReactInstanceManagerHelper = paramReactInstanceManagerDevHelper;
    this.mApplicationContext = paramContext;
    this.mJSAppBundleName = paramString;
    this.mDevSettings = new DevInternalSettings(paramContext, this);
    this.mBundleStatus = new InspectorPackagerConnection.BundleStatus();
    this.mDevServerHelper = new DevServerHelper(this.mDevSettings, this.mApplicationContext.getPackageName(), new InspectorPackagerConnection.BundleStatusProvider()
    {
      public InspectorPackagerConnection.BundleStatus getBundleStatus()
      {
        return DevSupportManagerImpl.this.mBundleStatus;
      }
    });
    this.mBundleDownloadListener = paramDevBundleDownloadListener;
    this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener()
    {
      public void onShake()
      {
        DevSupportManagerImpl.this.showDevOptionsDialog();
      }
    }
    , paramInt);
    this.mCustomPackagerCommandHandlers = paramMap;
    this.mReloadAppBroadcastReceiver = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        String str = paramAnonymousIntent.getAction();
        if (DevSupportManagerImpl.getReloadAppAction(paramAnonymousContext).equals(str))
        {
          if (!paramAnonymousIntent.getBooleanExtra("jsproxy", false))
            break label55;
          DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(true);
          DevSupportManagerImpl.this.mDevServerHelper.launchJSDevtools();
        }
        while (true)
        {
          DevSupportManagerImpl.this.handleReloadJS();
          return;
          label55: DevSupportManagerImpl.this.mDevSettings.setRemoteJSDebugEnabled(false);
        }
      }
    };
    this.mJSBundleTempFile = new File(paramContext.getFilesDir(), "ReactNativeDevBundle.js");
    this.mDefaultNativeModuleCallExceptionHandler = new DefaultNativeModuleCallExceptionHandler();
    setDevSupportEnabled(paramBoolean);
    this.mRedBoxHandler = paramRedBoxHandler;
    this.mDevLoadingViewController = new DevLoadingViewController(paramContext, paramReactInstanceManagerDevHelper);
    this.mExceptionLoggers.add(new JSExceptionLogger(null));
  }

  private WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> paramSimpleSettableFuture)
  {
    return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback()
    {
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$2002(DevSupportManagerImpl.this, false);
        FLog.e("ReactNative", "Unable to connect to remote debugger", paramAnonymousThrowable);
        paramSimpleSettableFuture.setException(new IOException(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_remotedbg_error), paramAnonymousThrowable));
      }

      public void onSuccess()
      {
        paramSimpleSettableFuture.set(Boolean.valueOf(true));
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$2002(DevSupportManagerImpl.this, false);
      }
    };
  }

  private static String getReloadAppAction(Context paramContext)
  {
    return paramContext.getPackageName() + ".RELOAD_APP_ACTION";
  }

  private void handleCaptureHeap(final Responder paramResponder)
  {
    if (this.mCurrentContext == null)
      return;
    ((JSCHeapCapture)this.mCurrentContext.getNativeModule(JSCHeapCapture.class)).captureHeap(this.mApplicationContext.getCacheDir().getPath(), new JSCHeapCapture.CaptureCallback()
    {
      public void onFailure(JSCHeapCapture.CaptureException paramAnonymousCaptureException)
      {
        paramResponder.error(paramAnonymousCaptureException.toString());
      }

      public void onSuccess(File paramAnonymousFile)
      {
        paramResponder.respond(paramAnonymousFile.toString());
      }
    });
  }

  private void handlePokeSamplingProfiler()
  {
    while (true)
    {
      try
      {
        Iterator localIterator = JSCSamplingProfiler.poke(60000L).iterator();
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          ReactContext localReactContext = this.mCurrentContext;
          if (str1 != null)
            break label98;
          str2 = "Started JSC Sampling Profiler";
          Toast.makeText(localReactContext, str2, 1).show();
          new JscProfileTask(getSourceUrl(), null).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[] { str1 });
          continue;
        }
      }
      catch (JSCSamplingProfiler.ProfilerException localProfilerException)
      {
        showNewJavaError(localProfilerException.getMessage(), localProfilerException);
      }
      return;
      label98: String str2 = "Stopped JSC Sampling Profiler";
    }
  }

  private void hideDevOptionsDialog()
  {
    if (this.mDevOptionsDialog != null)
    {
      this.mDevOptionsDialog.dismiss();
      this.mDevOptionsDialog = null;
    }
  }

  private Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> paramPair)
  {
    if (this.mErrorCustomizers == null);
    while (true)
    {
      return paramPair;
      Iterator localIterator = this.mErrorCustomizers.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = ((ErrorCustomizer)localIterator.next()).customizeErrorInfo(paramPair);
        if (localPair != null)
          paramPair = localPair;
      }
    }
  }

  private void reload()
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mIsDevSupportEnabled)
    {
      if (this.mDebugOverlayController != null)
        this.mDebugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
      if (!this.mIsShakeDetectorStarted)
      {
        this.mShakeDetector.start((SensorManager)this.mApplicationContext.getSystemService("sensor"));
        this.mIsShakeDetectorStarted = true;
      }
      if (!this.mIsReceiverRegistered)
      {
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction(getReloadAppAction(this.mApplicationContext));
        this.mApplicationContext.registerReceiver(this.mReloadAppBroadcastReceiver, localIntentFilter);
        this.mIsReceiverRegistered = true;
      }
      if (this.mDevLoadingViewVisible)
        this.mDevLoadingViewController.showMessage("Reloading...");
      this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), this);
      if (this.mDevSettings.isReloadOnJSChangeEnabled())
      {
        this.mDevServerHelper.startPollingOnChangeEndpoint(new DevServerHelper.OnServerContentChangeListener()
        {
          public void onServerContentChanged()
          {
            DevSupportManagerImpl.this.handleReloadJS();
          }
        });
        return;
      }
      this.mDevServerHelper.stopPollingOnChangeEndpoint();
      return;
    }
    if (this.mDebugOverlayController != null)
      this.mDebugOverlayController.setFpsDebugViewVisible(false);
    if (this.mIsShakeDetectorStarted)
    {
      this.mShakeDetector.stop();
      this.mIsShakeDetectorStarted = false;
    }
    if (this.mIsReceiverRegistered)
    {
      this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
      this.mIsReceiverRegistered = false;
    }
    hideRedboxDialog();
    hideDevOptionsDialog();
    this.mDevLoadingViewController.hide();
    this.mDevServerHelper.closePackagerConnection();
    this.mDevServerHelper.stopPollingOnChangeEndpoint();
  }

  private void reloadJSInProxyMode()
  {
    this.mDevServerHelper.launchJSDevtools();
    JavaJSExecutor.Factory local22 = new JavaJSExecutor.Factory()
    {
      public JavaJSExecutor create()
        throws Exception
      {
        WebsocketJavaScriptExecutor localWebsocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
        SimpleSettableFuture localSimpleSettableFuture = new SimpleSettableFuture();
        localWebsocketJavaScriptExecutor.connect(DevSupportManagerImpl.this.mDevServerHelper.getWebsocketProxyURL(), DevSupportManagerImpl.this.getExecutorConnectCallback(localSimpleSettableFuture));
        try
        {
          localSimpleSettableFuture.get(90L, TimeUnit.SECONDS);
          return localWebsocketJavaScriptExecutor;
        }
        catch (ExecutionException localExecutionException)
        {
          throw ((Exception)localExecutionException.getCause());
        }
        catch (InterruptedException localInterruptedException)
        {
          throw new RuntimeException(localInterruptedException);
        }
        catch (TimeoutException localTimeoutException)
        {
          label63: break label63;
        }
      }
    };
    this.mReactInstanceManagerHelper.onReloadWithJSDebugger(local22);
  }

  private void resetCurrentContext(ReactContext paramReactContext)
  {
    if (this.mCurrentContext == paramReactContext)
      return;
    this.mCurrentContext = paramReactContext;
    if (this.mDebugOverlayController != null)
      this.mDebugOverlayController.setFpsDebugViewVisible(false);
    if (paramReactContext != null)
      this.mDebugOverlayController = new DebugOverlayController(paramReactContext);
    if ((this.mDevSettings.isHotModuleReplacementEnabled()) && (this.mCurrentContext != null));
    try
    {
      URL localURL = new URL(getSourceUrl());
      String str1 = localURL.getPath().substring(1);
      String str2 = localURL.getHost();
      int i = localURL.getPort();
      ((HMRClient)this.mCurrentContext.getJSModule(HMRClient.class)).enable("android", str1, str2, i);
      reloadSettings();
      return;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      while (true)
        showNewJavaError(localMalformedURLException.getMessage(), localMalformedURLException);
    }
  }

  private void showNewError(final String paramString, final StackFrame[] paramArrayOfStackFrame, final int paramInt, final ErrorType paramErrorType)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if (DevSupportManagerImpl.this.mRedBoxDialog == null)
        {
          localActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
          if ((localActivity == null) || (localActivity.isFinishing()))
            FLog.e("ReactNative", "Unable to launch redbox because react activity is not available, here is the error that redbox would've displayed: " + paramString);
        }
        while (DevSupportManagerImpl.this.mRedBoxDialog.isShowing())
        {
          Activity localActivity;
          return;
          DevSupportManagerImpl.access$602(DevSupportManagerImpl.this, new RedBoxDialog(localActivity, DevSupportManagerImpl.this, DevSupportManagerImpl.this.mRedBoxHandler));
        }
        Pair localPair = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(paramString, paramArrayOfStackFrame));
        DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String)localPair.first, (StackFrame[])localPair.second);
        DevSupportManagerImpl.this.updateLastErrorInfo(paramString, paramArrayOfStackFrame, paramInt, paramErrorType);
        if ((DevSupportManagerImpl.this.mRedBoxHandler != null) && (paramErrorType == DevSupportManagerImpl.ErrorType.NATIVE))
          DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(paramString, paramArrayOfStackFrame, RedBoxHandler.ErrorType.NATIVE);
        DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
        DevSupportManagerImpl.this.mRedBoxDialog.show();
      }
    });
  }

  private void updateLastErrorInfo(String paramString, StackFrame[] paramArrayOfStackFrame, int paramInt, ErrorType paramErrorType)
  {
    this.mLastErrorTitle = paramString;
    this.mLastErrorStack = paramArrayOfStackFrame;
    this.mLastErrorCookie = paramInt;
    this.mLastErrorType = paramErrorType;
  }

  public void addCustomDevOption(String paramString, DevOptionHandler paramDevOptionHandler)
  {
    this.mCustomDevOptions.put(paramString, paramDevOptionHandler);
  }

  public Map<String, RequestHandler> customCommandHandlers()
  {
    return this.mCustomPackagerCommandHandlers;
  }

  public File downloadBundleResourceFromUrlSync(String paramString, File paramFile)
  {
    return this.mDevServerHelper.downloadBundleResourceFromUrlSync(paramString, paramFile);
  }

  public DeveloperSettings getDevSettings()
  {
    return this.mDevSettings;
  }

  public boolean getDevSupportEnabled()
  {
    return this.mIsDevSupportEnabled;
  }

  public String getDownloadedJSBundleFile()
  {
    return this.mJSBundleTempFile.getAbsolutePath();
  }

  public String getJSBundleURLForRemoteDebugging()
  {
    return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String)Assertions.assertNotNull(this.mJSAppBundleName));
  }

  public StackFrame[] getLastErrorStack()
  {
    return this.mLastErrorStack;
  }

  public String getLastErrorTitle()
  {
    return this.mLastErrorTitle;
  }

  public String getSourceMapUrl()
  {
    if (this.mJSAppBundleName == null)
      return "";
    return this.mDevServerHelper.getSourceMapUrl((String)Assertions.assertNotNull(this.mJSAppBundleName));
  }

  public String getSourceUrl()
  {
    if (this.mJSAppBundleName == null)
      return "";
    return this.mDevServerHelper.getSourceUrl((String)Assertions.assertNotNull(this.mJSAppBundleName));
  }

  public void handleException(Exception paramException)
  {
    if (this.mIsDevSupportEnabled)
    {
      Iterator localIterator = this.mExceptionLoggers.iterator();
      while (localIterator.hasNext())
        ((ExceptionLogger)localIterator.next()).log(paramException);
    }
    this.mDefaultNativeModuleCallExceptionHandler.handleException(paramException);
  }

  public void handleReloadJS()
  {
    UiThreadUtil.assertOnUiThread();
    ReactMarker.logMarker(ReactMarkerConstants.RELOAD, this.mDevSettings.getPackagerConnectionSettings().getDebugServerHost());
    hideRedboxDialog();
    if (this.mDevSettings.isRemoteJSDebugEnabled())
    {
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
      this.mDevLoadingViewController.showForRemoteJSEnabled();
      this.mDevLoadingViewVisible = true;
      reloadJSInProxyMode();
      return;
    }
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
    reloadJSFromServer(this.mDevServerHelper.getDevServerBundleURL((String)Assertions.assertNotNull(this.mJSAppBundleName)));
  }

  public boolean hasBundleInAssets(String paramString)
  {
    try
    {
      String[] arrayOfString = this.mApplicationContext.getAssets().list("");
      for (int i = 0; ; i++)
      {
        int j = arrayOfString.length;
        boolean bool1 = false;
        if (i < j)
        {
          boolean bool2 = arrayOfString[i].equals(paramString);
          if (bool2)
            bool1 = true;
        }
        else
        {
          return bool1;
        }
      }
    }
    catch (IOException localIOException)
    {
      FLog.e("ReactNative", "Error while loading assets list");
    }
    return false;
  }

  public boolean hasUpToDateJSBundleInCache()
  {
    if ((this.mIsDevSupportEnabled) && (this.mJSBundleTempFile.exists()))
      try
      {
        String str = this.mApplicationContext.getPackageName();
        PackageInfo localPackageInfo = this.mApplicationContext.getPackageManager().getPackageInfo(str, 0);
        if (this.mJSBundleTempFile.lastModified() > localPackageInfo.lastUpdateTime)
        {
          File localFile = new File(String.format(Locale.US, "/data/local/tmp/exopackage/%s//secondary-dex", new Object[] { str }));
          long l1;
          long l2;
          if (localFile.exists())
          {
            l1 = this.mJSBundleTempFile.lastModified();
            l2 = localFile.lastModified();
          }
          return l1 > l2;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
        FLog.e("ReactNative", "DevSupport is unable to get current app info");
      }
    return false;
  }

  public void hideRedboxDialog()
  {
    if (this.mRedBoxDialog != null)
    {
      this.mRedBoxDialog.dismiss();
      this.mRedBoxDialog = null;
    }
  }

  public void isPackagerRunning(PackagerStatusCallback paramPackagerStatusCallback)
  {
    this.mDevServerHelper.isPackagerRunning(paramPackagerStatusCallback);
  }

  public void onCaptureHeapCommand(final Responder paramResponder)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevSupportManagerImpl.this.handleCaptureHeap(paramResponder);
      }
    });
  }

  public void onInternalSettingsChanged()
  {
    reloadSettings();
  }

  public void onNewReactContextCreated(ReactContext paramReactContext)
  {
    resetCurrentContext(paramReactContext);
  }

  public void onPackagerConnected()
  {
  }

  public void onPackagerDevMenuCommand()
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevSupportManagerImpl.this.showDevOptionsDialog();
      }
    });
  }

  public void onPackagerDisconnected()
  {
  }

  public void onPackagerReloadCommand()
  {
    this.mDevServerHelper.disableDebugger();
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevSupportManagerImpl.this.handleReloadJS();
      }
    });
  }

  public void onReactInstanceDestroyed(ReactContext paramReactContext)
  {
    if (paramReactContext == this.mCurrentContext)
      resetCurrentContext(null);
  }

  public void registerErrorCustomizer(ErrorCustomizer paramErrorCustomizer)
  {
    if (this.mErrorCustomizers == null)
      this.mErrorCustomizers = new ArrayList();
    this.mErrorCustomizers.add(paramErrorCustomizer);
  }

  public void reloadJSFromServer(String paramString)
  {
    ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
    this.mDevLoadingViewController.showForUrl(paramString);
    this.mDevLoadingViewVisible = true;
    final BundleDownloader.BundleInfo localBundleInfo = new BundleDownloader.BundleInfo();
    this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener()
    {
      public void onFailure(final Exception paramAnonymousException)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$2002(DevSupportManagerImpl.this, false);
        synchronized (DevSupportManagerImpl.this)
        {
          DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = Boolean.valueOf(false);
          if (DevSupportManagerImpl.this.mBundleDownloadListener != null)
            DevSupportManagerImpl.this.mBundleDownloadListener.onFailure(paramAnonymousException);
          FLog.e("ReactNative", "Unable to download JS bundle", paramAnonymousException);
          UiThreadUtil.runOnUiThread(new Runnable()
          {
            public void run()
            {
              if ((paramAnonymousException instanceof DebugServerException))
              {
                DebugServerException localDebugServerException = (DebugServerException)paramAnonymousException;
                DevSupportManagerImpl.this.showNewJavaError(localDebugServerException.getMessage(), paramAnonymousException);
                return;
              }
              DevSupportManagerImpl.this.showNewJavaError(DevSupportManagerImpl.this.mApplicationContext.getString(R.string.catalyst_jsload_error), paramAnonymousException);
            }
          });
          return;
        }
      }

      public void onProgress(String paramAnonymousString, Integer paramAnonymousInteger1, Integer paramAnonymousInteger2)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.updateProgress(paramAnonymousString, paramAnonymousInteger1, paramAnonymousInteger2);
        if (DevSupportManagerImpl.this.mBundleDownloadListener != null)
          DevSupportManagerImpl.this.mBundleDownloadListener.onProgress(paramAnonymousString, paramAnonymousInteger1, paramAnonymousInteger2);
      }

      public void onSuccess(final NativeDeltaClient paramAnonymousNativeDeltaClient)
      {
        DevSupportManagerImpl.this.mDevLoadingViewController.hide();
        DevSupportManagerImpl.access$2002(DevSupportManagerImpl.this, false);
        synchronized (DevSupportManagerImpl.this)
        {
          DevSupportManagerImpl.this.mBundleStatus.isLastDownloadSucess = Boolean.valueOf(true);
          DevSupportManagerImpl.this.mBundleStatus.updateTimestamp = System.currentTimeMillis();
          if (DevSupportManagerImpl.this.mBundleDownloadListener != null)
            DevSupportManagerImpl.this.mBundleDownloadListener.onSuccess(paramAnonymousNativeDeltaClient);
          UiThreadUtil.runOnUiThread(new Runnable()
          {
            public void run()
            {
              ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, DevSupportManagerImpl.24.this.val$bundleInfo.toJSONString());
              DevSupportManagerImpl.this.mReactInstanceManagerHelper.onJSBundleLoadedFromServer(paramAnonymousNativeDeltaClient);
            }
          });
          return;
        }
      }
    }
    , this.mJSBundleTempFile, paramString, localBundleInfo);
  }

  public void reloadSettings()
  {
    if (UiThreadUtil.isOnUiThread())
    {
      reload();
      return;
    }
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        DevSupportManagerImpl.this.reload();
      }
    });
  }

  public void setDevSupportEnabled(boolean paramBoolean)
  {
    this.mIsDevSupportEnabled = paramBoolean;
    reloadSettings();
  }

  public void showDevOptionsDialog()
  {
    if ((this.mDevOptionsDialog != null) || (!this.mIsDevSupportEnabled) || (ActivityManager.isUserAMonkey()))
      return;
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_reloadjs), new DevOptionHandler()
    {
      public void onOptionSelected()
      {
        DevSupportManagerImpl.this.handleReloadJS();
      }
    });
    if (this.mDevSettings.isNuclideJSDebugEnabled())
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_debugjs_nuclide) + " 💯", new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevSupportManagerImpl.this.mDevServerHelper.attachDebugger(DevSupportManagerImpl.this.mApplicationContext, "ReactNative");
        }
      });
    String str1;
    String str2;
    label190: String str3;
    if (this.mDevSettings.isRemoteJSDebugEnabled())
    {
      str1 = this.mApplicationContext.getString(R.string.catalyst_debugjs_off);
      if (this.mDevSettings.isNuclideJSDebugEnabled())
        str1 = str1 + " 🙅";
      localLinkedHashMap.put(str1, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isRemoteJSDebugEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setRemoteJSDebugEnabled(bool);
            DevSupportManagerImpl.this.handleReloadJS();
            return;
          }
        }
      });
      if (!this.mDevSettings.isReloadOnJSChangeEnabled())
        break label432;
      str2 = this.mApplicationContext.getString(R.string.catalyst_live_reload_off);
      localLinkedHashMap.put(str2, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isReloadOnJSChangeEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setReloadOnJSChangeEnabled(bool);
            return;
          }
        }
      });
      if (!this.mDevSettings.isHotModuleReplacementEnabled())
        break label447;
      str3 = this.mApplicationContext.getString(R.string.catalyst_hot_module_replacement_off);
      label227: localLinkedHashMap.put(str3, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isHotModuleReplacementEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setHotModuleReplacementEnabled(bool);
            DevSupportManagerImpl.this.handleReloadJS();
            return;
          }
        }
      });
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_element_inspector), new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevInternalSettings localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isElementInspectorEnabled());
          for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setElementInspectorEnabled(bool);
            DevSupportManagerImpl.this.mReactInstanceManagerHelper.toggleElementInspector();
            return;
          }
        }
      });
      if (!this.mDevSettings.isFpsDebugEnabled())
        break label462;
    }
    final DevOptionHandler[] arrayOfDevOptionHandler;
    Activity localActivity;
    label432: label447: label462: for (String str4 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor_off); ; str4 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor))
    {
      localLinkedHashMap.put(str4, new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          Activity localActivity;
          DevInternalSettings localDevInternalSettings;
          if (!DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled())
          {
            localActivity = DevSupportManagerImpl.this.mReactInstanceManagerHelper.getCurrentActivity();
            if (localActivity == null)
              FLog.e("ReactNative", "Unable to get reference to react activity");
          }
          else
          {
            localDevInternalSettings = DevSupportManagerImpl.this.mDevSettings;
            if (DevSupportManagerImpl.this.mDevSettings.isFpsDebugEnabled())
              break label73;
          }
          label73: for (boolean bool = true; ; bool = false)
          {
            localDevInternalSettings.setFpsDebugEnabled(bool);
            return;
            DebugOverlayController.requestPermission(localActivity);
            break;
          }
        }
      });
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_poke_sampling_profiler), new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          DevSupportManagerImpl.this.handlePokeSamplingProfiler();
        }
      });
      localLinkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_settings), new DevOptionHandler()
      {
        public void onOptionSelected()
        {
          Intent localIntent = new Intent(DevSupportManagerImpl.this.mApplicationContext, DevSettingsActivity.class);
          localIntent.setFlags(268435456);
          DevSupportManagerImpl.this.mApplicationContext.startActivity(localIntent);
        }
      });
      if (this.mCustomDevOptions.size() > 0)
        localLinkedHashMap.putAll(this.mCustomDevOptions);
      arrayOfDevOptionHandler = (DevOptionHandler[])localLinkedHashMap.values().toArray(new DevOptionHandler[0]);
      localActivity = this.mReactInstanceManagerHelper.getCurrentActivity();
      if ((localActivity != null) && (!localActivity.isFinishing()))
        break label477;
      FLog.e("ReactNative", "Unable to launch dev options menu because react activity isn't available");
      return;
      str1 = this.mApplicationContext.getString(R.string.catalyst_debugjs);
      break;
      str2 = this.mApplicationContext.getString(R.string.catalyst_live_reload);
      break label190;
      str3 = this.mApplicationContext.getString(R.string.catalyst_hot_module_replacement);
      break label227;
    }
    label477: this.mDevOptionsDialog = new AlertDialog.Builder(localActivity).setItems((CharSequence[])localLinkedHashMap.keySet().toArray(new String[0]), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        arrayOfDevOptionHandler[paramAnonymousInt].onOptionSelected();
        DevSupportManagerImpl.access$1402(DevSupportManagerImpl.this, null);
      }
    }).setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        DevSupportManagerImpl.access$1402(DevSupportManagerImpl.this, null);
      }
    }).create();
    this.mDevOptionsDialog.show();
  }

  public void showNewJSError(String paramString, ReadableArray paramReadableArray, int paramInt)
  {
    showNewError(paramString, StackTraceHelper.convertJsStackTrace(paramReadableArray), paramInt, ErrorType.JS);
  }

  public void showNewJavaError(String paramString, Throwable paramThrowable)
  {
    FLog.e("ReactNative", "Exception in native call", paramThrowable);
    showNewError(paramString, StackTraceHelper.convertJavaStackTrace(paramThrowable), -1, ErrorType.NATIVE);
  }

  public void startInspector()
  {
    if (this.mIsDevSupportEnabled)
      this.mDevServerHelper.openInspectorConnection();
  }

  public void stopInspector()
  {
    this.mDevServerHelper.closeInspectorConnection();
  }

  public void updateJSError(final String paramString, final ReadableArray paramReadableArray, final int paramInt)
  {
    UiThreadUtil.runOnUiThread(new Runnable()
    {
      public void run()
      {
        if ((DevSupportManagerImpl.this.mRedBoxDialog == null) || (!DevSupportManagerImpl.this.mRedBoxDialog.isShowing()) || (paramInt != DevSupportManagerImpl.this.mLastErrorCookie))
          return;
        StackFrame[] arrayOfStackFrame = StackTraceHelper.convertJsStackTrace(paramReadableArray);
        Pair localPair = DevSupportManagerImpl.this.processErrorCustomizers(Pair.create(paramString, arrayOfStackFrame));
        DevSupportManagerImpl.this.mRedBoxDialog.setExceptionDetails((String)localPair.first, (StackFrame[])localPair.second);
        DevSupportManagerImpl.this.updateLastErrorInfo(paramString, arrayOfStackFrame, paramInt, DevSupportManagerImpl.ErrorType.JS);
        if (DevSupportManagerImpl.this.mRedBoxHandler != null)
        {
          DevSupportManagerImpl.this.mRedBoxHandler.handleRedbox(paramString, arrayOfStackFrame, RedBoxHandler.ErrorType.JS);
          DevSupportManagerImpl.this.mRedBoxDialog.resetReporting();
        }
        DevSupportManagerImpl.this.mRedBoxDialog.show();
      }
    });
  }

  private static enum ErrorType
  {
    static
    {
      ErrorType[] arrayOfErrorType = new ErrorType[2];
      arrayOfErrorType[0] = JS;
      arrayOfErrorType[1] = NATIVE;
    }
  }

  private static abstract interface ExceptionLogger
  {
    public abstract void log(Exception paramException);
  }

  private class JSExceptionLogger
    implements DevSupportManagerImpl.ExceptionLogger
  {
    private JSExceptionLogger()
    {
    }

    public void log(Exception paramException)
    {
      if (paramException.getMessage() == null);
      StringBuilder localStringBuilder;
      for (String str1 = "Exception in native call from JS"; ; str1 = paramException.getMessage())
      {
        localStringBuilder = new StringBuilder(str1);
        for (Throwable localThrowable = paramException.getCause(); localThrowable != null; localThrowable = localThrowable.getCause())
          localStringBuilder.append("\n\n").append(localThrowable.getMessage());
      }
      if ((paramException instanceof JSException))
      {
        FLog.e("ReactNative", "Exception in native call from JS", paramException);
        String str2 = ((JSException)paramException).getStack();
        localStringBuilder.append("\n\n").append(str2);
        DevSupportManagerImpl.this.showNewError(localStringBuilder.toString(), new StackFrame[0], -1, DevSupportManagerImpl.ErrorType.JS);
        return;
      }
      DevSupportManagerImpl.this.showNewJavaError(localStringBuilder.toString(), paramException);
    }
  }

  private static class JscProfileTask extends AsyncTask<String, Void, Void>
  {
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final String mSourceUrl;

    private JscProfileTask(String paramString)
    {
      this.mSourceUrl = paramString;
    }

    protected Void doInBackground(String[] paramArrayOfString)
    {
      try
      {
        String str1 = Uri.parse(this.mSourceUrl).buildUpon().path("/jsc-profile").query(null).build().toString();
        OkHttpClient localOkHttpClient = new OkHttpClient();
        int i = paramArrayOfString.length;
        for (int j = 0; j < i; j++)
        {
          String str2 = paramArrayOfString[j];
          RequestBody localRequestBody = RequestBody.create(JSON, str2);
          localOkHttpClient.newCall(new Request.Builder().url(str1).post(localRequestBody).build()).execute();
        }
      }
      catch (IOException localIOException)
      {
        FLog.e("ReactNative", "Failed not talk to server", localIOException);
      }
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevSupportManagerImpl
 * JD-Core Version:    0.6.2
 */