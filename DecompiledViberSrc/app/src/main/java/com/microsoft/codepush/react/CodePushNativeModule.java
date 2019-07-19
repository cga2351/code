package com.microsoft.codepush.react;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.ChoreographerCompat.FrameCallback;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.core.ReactChoreographer.CallbackType;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CodePushNativeModule extends ReactContextBaseJavaModule
{
  private String mBinaryContentsHash = null;
  private String mClientUniqueId = null;
  private a mCodePush;
  private LifecycleEventListener mLifecycleEventListener = null;
  private int mMinimumBackgroundDuration = 0;
  private o mSettingsManager;
  private e mTelemetryManager;
  private g mUpdateManager;

  public CodePushNativeModule(ReactApplicationContext paramReactApplicationContext, a parama, g paramg, e parame, o paramo)
  {
    super(paramReactApplicationContext);
    this.mCodePush = parama;
    this.mSettingsManager = paramo;
    this.mTelemetryManager = parame;
    this.mUpdateManager = paramg;
    this.mBinaryContentsHash = i.a(paramReactApplicationContext, this.mCodePush.j());
    this.mClientUniqueId = Settings.Secure.getString(paramReactApplicationContext.getContentResolver(), "android_id");
  }

  private void clearLifecycleEventListener()
  {
    if (this.mLifecycleEventListener != null)
    {
      getReactApplicationContext().removeLifecycleEventListener(this.mLifecycleEventListener);
      this.mLifecycleEventListener = null;
    }
  }

  // ERROR //
  private void loadBundle()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 109	com/microsoft/codepush/react/CodePushNativeModule:clearLifecycleEventListener	()V
    //   4: aload_0
    //   5: getfield 34	com/microsoft/codepush/react/CodePushNativeModule:mCodePush	Lcom/microsoft/codepush/react/a;
    //   8: aload_0
    //   9: invokespecial 113	com/microsoft/codepush/react/CodePushNativeModule:resolveInstanceManager	()Lcom/facebook/react/ReactInstanceManager;
    //   12: invokevirtual 116	com/microsoft/codepush/react/a:a	(Lcom/facebook/react/ReactInstanceManager;)V
    //   15: aload_0
    //   16: invokespecial 113	com/microsoft/codepush/react/CodePushNativeModule:resolveInstanceManager	()Lcom/facebook/react/ReactInstanceManager;
    //   19: astore_3
    //   20: aload_3
    //   21: ifnonnull +16 -> 37
    //   24: return
    //   25: astore_1
    //   26: aload_0
    //   27: getfield 34	com/microsoft/codepush/react/CodePushNativeModule:mCodePush	Lcom/microsoft/codepush/react/a;
    //   30: aconst_null
    //   31: invokevirtual 116	com/microsoft/codepush/react/a:a	(Lcom/facebook/react/ReactInstanceManager;)V
    //   34: goto -19 -> 15
    //   37: aload_0
    //   38: aload_3
    //   39: aload_0
    //   40: getfield 34	com/microsoft/codepush/react/CodePushNativeModule:mCodePush	Lcom/microsoft/codepush/react/a;
    //   43: aload_0
    //   44: getfield 34	com/microsoft/codepush/react/CodePushNativeModule:mCodePush	Lcom/microsoft/codepush/react/a;
    //   47: invokevirtual 120	com/microsoft/codepush/react/a:c	()Ljava/lang/String;
    //   50: invokevirtual 123	com/microsoft/codepush/react/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   53: invokespecial 127	com/microsoft/codepush/react/CodePushNativeModule:setJSBundle	(Lcom/facebook/react/ReactInstanceManager;Ljava/lang/String;)V
    //   56: new 129	android/os/Handler
    //   59: dup
    //   60: invokestatic 135	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   63: invokespecial 138	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   66: new 140	com/microsoft/codepush/react/CodePushNativeModule$2
    //   69: dup
    //   70: aload_0
    //   71: aload_3
    //   72: invokespecial 143	com/microsoft/codepush/react/CodePushNativeModule$2:<init>	(Lcom/microsoft/codepush/react/CodePushNativeModule;Lcom/facebook/react/ReactInstanceManager;)V
    //   75: invokevirtual 147	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   78: pop
    //   79: return
    //   80: astore_2
    //   81: new 149	java/lang/StringBuilder
    //   84: dup
    //   85: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   88: ldc 153
    //   90: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_2
    //   94: invokevirtual 160	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   97: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 163	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 169	com/microsoft/codepush/react/j:b	(Ljava/lang/String;)V
    //   106: aload_0
    //   107: invokespecial 74	com/microsoft/codepush/react/CodePushNativeModule:loadBundleLegacy	()V
    //   110: return
    //
    // Exception table:
    //   from	to	target	type
    //   4	15	25	java/lang/Exception
    //   15	20	80	java/lang/Exception
    //   37	79	80	java/lang/Exception
  }

  private void loadBundleLegacy()
  {
    final Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      return;
    this.mCodePush.i();
    localActivity.runOnUiThread(new Runnable()
    {
      public void run()
      {
        localActivity.recreate();
      }
    });
  }

  private void resetReactRootViews(ReactInstanceManager paramReactInstanceManager)
    throws NoSuchFieldException, IllegalAccessException
  {
    Field localField = paramReactInstanceManager.getClass().getDeclaredField("mAttachedRootViews");
    localField.setAccessible(true);
    List localList = (List)localField.get(paramReactInstanceManager);
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      ReactRootView localReactRootView = (ReactRootView)localIterator.next();
      localReactRootView.removeAllViews();
      localReactRootView.setId(-1);
    }
    localField.set(paramReactInstanceManager, localList);
  }

  private ReactInstanceManager resolveInstanceManager()
    throws NoSuchFieldException, IllegalAccessException
  {
    ReactInstanceManager localReactInstanceManager = a.o();
    if (localReactInstanceManager != null)
      return localReactInstanceManager;
    Activity localActivity = getCurrentActivity();
    if (localActivity == null)
      return null;
    return ((ReactApplication)localActivity.getApplication()).getReactNativeHost().getReactInstanceManager();
  }

  private void setJSBundle(ReactInstanceManager paramReactInstanceManager, String paramString)
    throws IllegalAccessException
  {
    try
    {
      if (paramString.toLowerCase().startsWith("assets://"));
      JSBundleLoader localJSBundleLoader;
      for (Object localObject = JSBundleLoader.createAssetLoader(getReactApplicationContext(), paramString, false); ; localObject = localJSBundleLoader)
      {
        Field localField = paramReactInstanceManager.getClass().getDeclaredField("mBundleLoader");
        localField.setAccessible(true);
        localField.set(paramReactInstanceManager, localObject);
        return;
        localJSBundleLoader = JSBundleLoader.createFileLoader(paramString);
      }
    }
    catch (Exception localException)
    {
      j.b("Unable to set JSBundle - CodePush may not support this version of React Native");
    }
    throw new IllegalAccessException("Could not setJSBundle");
  }

  @ReactMethod
  public void clearUpdates()
  {
    j.b("Clearing updates.");
    this.mCodePush.n();
  }

  @ReactMethod
  public void downloadAndReplaceCurrentBundle(String paramString)
  {
    try
    {
      boolean bool = a.m();
      if (bool);
      try
      {
        this.mUpdateManager.a(paramString, this.mCodePush.c());
        return;
      }
      catch (IOException localIOException)
      {
        throw new f("Unable to replace current bundle", localIOException);
      }
    }
    catch (f localf)
    {
      j.a(localf);
      return;
    }
    catch (d locald)
    {
      label47: break label47;
    }
  }

  @ReactMethod
  public void downloadUpdate(final ReadableMap paramReadableMap, final boolean paramBoolean, final Promise paramPromise)
  {
    new AsyncTask()
    {
      protected Void a(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          JSONObject localJSONObject1 = j.a(paramReadableMap);
          j.a(localJSONObject1, "binaryModifiedTime", "" + CodePushNativeModule.this.mCodePush.e());
          CodePushNativeModule.this.mUpdateManager.a(localJSONObject1, CodePushNativeModule.this.mCodePush.c(), new l()
          {
            private boolean b = false;
            private k c = null;

            public void a()
            {
              ((DeviceEventManagerModule.RCTDeviceEventEmitter)CodePushNativeModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("CodePushDownloadProgress", this.c.a());
            }

            public void a(k paramAnonymous2k)
            {
              if (!CodePushNativeModule.3.this.b);
              do
              {
                return;
                this.c = paramAnonymous2k;
                if (this.c.b())
                {
                  a();
                  return;
                }
              }
              while (this.b);
              this.b = true;
              CodePushNativeModule.this.getReactApplicationContext().runOnUiQueueThread(new Runnable()
              {
                public void run()
                {
                  ReactChoreographer.getInstance().postFrameCallback(ReactChoreographer.CallbackType.TIMERS_EVENTS, new ChoreographerCompat.FrameCallback()
                  {
                    public void doFrame(long paramAnonymous4Long)
                    {
                      if (!CodePushNativeModule.3.1.a(CodePushNativeModule.3.1.this).b())
                        CodePushNativeModule.3.1.this.a();
                      CodePushNativeModule.3.1.a(CodePushNativeModule.3.1.this, false);
                    }
                  });
                }
              });
            }
          }
          , CodePushNativeModule.this.mCodePush.d());
          JSONObject localJSONObject2 = CodePushNativeModule.this.mUpdateManager.c(j.a(paramReadableMap, "packageHash"));
          paramPromise.resolve(j.a(localJSONObject2));
          return null;
        }
        catch (c localc)
        {
          while (true)
          {
            j.a(localc);
            CodePushNativeModule.this.mSettingsManager.a(j.a(paramReadableMap));
            paramPromise.reject(localc);
          }
        }
        catch (IOException localIOException)
        {
          while (true)
          {
            j.a(localIOException);
            paramPromise.reject(localIOException);
          }
        }
        catch (f localf)
        {
          label157: break label157;
        }
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @ReactMethod
  public void getConfiguration(Promise paramPromise)
  {
    try
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putString("appVersion", this.mCodePush.b());
      localWritableMap.putString("clientUniqueId", this.mClientUniqueId);
      localWritableMap.putString("deploymentKey", this.mCodePush.f());
      localWritableMap.putString("serverUrl", this.mCodePush.g());
      if (this.mBinaryContentsHash != null)
        localWritableMap.putString("packageHash", this.mBinaryContentsHash);
      paramPromise.resolve(localWritableMap);
      return;
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }

  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("codePushInstallModeImmediate", Integer.valueOf(b.a.a()));
    localHashMap.put("codePushInstallModeOnNextRestart", Integer.valueOf(b.b.a()));
    localHashMap.put("codePushInstallModeOnNextResume", Integer.valueOf(b.c.a()));
    localHashMap.put("codePushInstallModeOnNextSuspend", Integer.valueOf(b.d.a()));
    localHashMap.put("codePushUpdateStateRunning", Integer.valueOf(h.a.a()));
    localHashMap.put("codePushUpdateStatePending", Integer.valueOf(h.b.a()));
    localHashMap.put("codePushUpdateStateLatest", Integer.valueOf(h.c.a()));
    return localHashMap;
  }

  @ReactMethod
  public void getLatestRollbackInfo(Promise paramPromise)
  {
    try
    {
      JSONObject localJSONObject = this.mSettingsManager.e();
      if (localJSONObject != null)
      {
        paramPromise.resolve(j.a(localJSONObject));
        return;
      }
      paramPromise.resolve(null);
      return;
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }

  public String getName()
  {
    return "CodePush";
  }

  @ReactMethod
  public void getNewStatusReport(final Promise paramPromise)
  {
    new AsyncTask()
    {
      protected Void a(Void[] paramAnonymousArrayOfVoid)
      {
        try
        {
          if (CodePushNativeModule.this.mCodePush.l())
          {
            CodePushNativeModule.this.mCodePush.a(false);
            JSONArray localJSONArray = CodePushNativeModule.this.mSettingsManager.a();
            if (localJSONArray == null)
              break label278;
            int i = localJSONArray.length();
            if (i <= 0)
              break label278;
            try
            {
              WritableMap localWritableMap4 = j.a(localJSONArray.getJSONObject(-1 + localJSONArray.length()));
              WritableMap localWritableMap5 = CodePushNativeModule.this.mTelemetryManager.a(localWritableMap4);
              if (localWritableMap5 == null)
                break label278;
              paramPromise.resolve(localWritableMap5);
              return null;
            }
            catch (JSONException localJSONException)
            {
              throw new f("Unable to read failed updates information stored in SharedPreferences.", localJSONException);
            }
          }
        }
        catch (f localf)
        {
          j.a(localf);
          paramPromise.reject(localf);
          return null;
        }
        if (CodePushNativeModule.this.mCodePush.a())
        {
          JSONObject localJSONObject = CodePushNativeModule.this.mUpdateManager.e();
          if (localJSONObject != null)
          {
            WritableMap localWritableMap3 = CodePushNativeModule.this.mTelemetryManager.b(j.a(localJSONObject));
            if (localWritableMap3 != null)
            {
              paramPromise.resolve(localWritableMap3);
              return null;
            }
          }
        }
        else if (CodePushNativeModule.this.mCodePush.k())
        {
          WritableMap localWritableMap2 = CodePushNativeModule.this.mTelemetryManager.a(CodePushNativeModule.this.mCodePush.b());
          if (localWritableMap2 != null)
          {
            paramPromise.resolve(localWritableMap2);
            return null;
          }
        }
        else
        {
          WritableMap localWritableMap1 = CodePushNativeModule.this.mTelemetryManager.a();
          if (localWritableMap1 != null)
          {
            paramPromise.resolve(localWritableMap1);
            return null;
          }
        }
        label278: paramPromise.resolve("");
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @ReactMethod
  public void getUpdateMetadata(final int paramInt, final Promise paramPromise)
  {
    new AsyncTask()
    {
      protected Void a(Void[] paramAnonymousArrayOfVoid)
      {
        JSONObject localJSONObject1;
        Boolean localBoolean;
        JSONObject localJSONObject2;
        try
        {
          localJSONObject1 = CodePushNativeModule.this.mUpdateManager.e();
          if (localJSONObject1 == null)
          {
            paramPromise.resolve(null);
            return null;
          }
          localBoolean = Boolean.valueOf(false);
          if (localJSONObject1.has("packageHash"))
          {
            String str = localJSONObject1.optString("packageHash", null);
            localBoolean = Boolean.valueOf(CodePushNativeModule.this.mSettingsManager.b(str));
          }
          if ((paramInt == h.b.a()) && (!localBoolean.booleanValue()))
          {
            paramPromise.resolve(null);
            return null;
          }
        }
        catch (d locald)
        {
          j.b(locald.getMessage());
          CodePushNativeModule.this.clearUpdates();
          paramPromise.resolve(null);
          return null;
          if ((paramInt != h.a.a()) || (!localBoolean.booleanValue()))
            break label215;
          localJSONObject2 = CodePushNativeModule.this.mUpdateManager.f();
          if (localJSONObject2 == null)
          {
            paramPromise.resolve(null);
            return null;
          }
        }
        catch (f localf)
        {
          j.a(localf);
          paramPromise.reject(localf);
          return null;
        }
        paramPromise.resolve(j.a(localJSONObject2));
        return null;
        label215: if (CodePushNativeModule.this.mCodePush.k())
          j.a(localJSONObject1, "_isDebugOnly", Boolean.valueOf(true));
        j.a(localJSONObject1, "isPending", localBoolean);
        paramPromise.resolve(j.a(localJSONObject1));
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @ReactMethod
  public void installUpdate(final ReadableMap paramReadableMap, final int paramInt1, final int paramInt2, final Promise paramPromise)
  {
    new AsyncTask()
    {
      protected Void a(Void[] paramAnonymousArrayOfVoid)
      {
        String str;
        try
        {
          CodePushNativeModule.this.mUpdateManager.a(j.a(paramReadableMap), CodePushNativeModule.this.mSettingsManager.b(null));
          str = j.a(paramReadableMap, "packageHash");
          if (str == null)
            throw new f("Update package to be installed has no hash.");
        }
        catch (f localf)
        {
          j.a(localf);
          paramPromise.reject(localf);
          return null;
        }
        CodePushNativeModule.this.mSettingsManager.a(str, false);
        if ((paramInt1 == b.c.a()) || (paramInt1 == b.a.a()) || (paramInt1 == b.d.a()))
        {
          CodePushNativeModule.access$902(CodePushNativeModule.this, paramInt2);
          if (CodePushNativeModule.this.mLifecycleEventListener == null)
          {
            CodePushNativeModule.access$1002(CodePushNativeModule.this, new LifecycleEventListener()
            {
              private Date b = null;
              private Handler c = new Handler(Looper.getMainLooper());
              private Runnable d = new Runnable()
              {
                public void run()
                {
                  j.b("Loading bundle on suspend");
                  CodePushNativeModule.this.loadBundle();
                }
              };

              public void onHostDestroy()
              {
              }

              public void onHostPause()
              {
                this.b = new Date();
                if ((CodePushNativeModule.6.this.b == b.d.a()) && (CodePushNativeModule.this.mSettingsManager.b(null)))
                  this.c.postDelayed(this.d, 1000 * CodePushNativeModule.6.this.c);
              }

              public void onHostResume()
              {
                this.c.removeCallbacks(this.d);
                if (this.b != null)
                {
                  long l = (new Date().getTime() - this.b.getTime()) / 1000L;
                  if ((CodePushNativeModule.6.this.b == b.a.a()) || (l >= CodePushNativeModule.this.mMinimumBackgroundDuration))
                  {
                    j.b("Loading bundle on resume");
                    CodePushNativeModule.this.loadBundle();
                  }
                }
              }
            });
            CodePushNativeModule.this.getReactApplicationContext().addLifecycleEventListener(CodePushNativeModule.this.mLifecycleEventListener);
          }
        }
        paramPromise.resolve("");
        return null;
      }
    }
    .executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
  }

  @ReactMethod
  public void isFailedUpdate(String paramString, Promise paramPromise)
  {
    try
    {
      paramPromise.resolve(Boolean.valueOf(this.mSettingsManager.a(paramString)));
      return;
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }

  @ReactMethod
  public void isFirstRun(String paramString, Promise paramPromise)
  {
    try
    {
      if ((this.mCodePush.a()) && (paramString != null) && (paramString.length() > 0) && (paramString.equals(this.mUpdateManager.c())));
      for (boolean bool = true; ; bool = false)
      {
        paramPromise.resolve(Boolean.valueOf(bool));
        return;
      }
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }

  @ReactMethod
  public void notifyApplicationReady(Promise paramPromise)
  {
    try
    {
      this.mSettingsManager.d();
      paramPromise.resolve("");
      return;
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }

  @ReactMethod
  public void recordStatusReported(ReadableMap paramReadableMap)
  {
    try
    {
      this.mTelemetryManager.a(paramReadableMap);
      return;
    }
    catch (f localf)
    {
      j.a(localf);
    }
  }

  @ReactMethod
  public void restartApp(boolean paramBoolean, Promise paramPromise)
  {
    if (paramBoolean);
    try
    {
      if (this.mSettingsManager.b(null))
      {
        loadBundle();
        paramPromise.resolve(Boolean.valueOf(true));
        return;
      }
      paramPromise.resolve(Boolean.valueOf(false));
      return;
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }

  @ReactMethod
  public void saveStatusReportForRetry(ReadableMap paramReadableMap)
  {
    try
    {
      this.mTelemetryManager.b(paramReadableMap);
      return;
    }
    catch (f localf)
    {
      j.a(localf);
    }
  }

  @ReactMethod
  public void setLatestRollbackInfo(String paramString, Promise paramPromise)
  {
    try
    {
      this.mSettingsManager.c(paramString);
      paramPromise.resolve(null);
      return;
    }
    catch (f localf)
    {
      j.a(localf);
      paramPromise.reject(localf);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.CodePushNativeModule
 * JD-Core Version:    0.6.2
 */