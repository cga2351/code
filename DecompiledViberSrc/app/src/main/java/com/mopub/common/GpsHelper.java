package com.mopub.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;
import com.mopub.common.util.Reflection.MethodBuilder;
import java.lang.ref.WeakReference;

public class GpsHelper
{
  public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
  public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
  private static String a = "com.google.android.gms.ads.identifier.AdvertisingIdClient";

  static String a(Object paramObject, String paramString)
  {
    try
    {
      String str = (String)MethodBuilderFactory.create(paramObject, "getId").execute();
      return str;
    }
    catch (Exception localException)
    {
    }
    return paramString;
  }

  private static void a(Context paramContext, GpsHelperListener paramGpsHelperListener)
  {
    if (!Reflection.classFound(a))
      if (paramGpsHelperListener != null)
        paramGpsHelperListener.onFetchAdInfoCompleted();
    do
    {
      return;
      try
      {
        AsyncTasks.safeExecuteOnExecutor(new a(paramContext, paramGpsHelperListener), new Void[0]);
        return;
      }
      catch (Exception localException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Error executing FetchAdvertisingInfoTask", localException });
      }
    }
    while (paramGpsHelperListener == null);
    paramGpsHelperListener.onFetchAdInfoCompleted();
  }

  static boolean a(Object paramObject, boolean paramBoolean)
  {
    try
    {
      Boolean localBoolean = (Boolean)MethodBuilderFactory.create(paramObject, "isLimitAdTrackingEnabled").execute();
      if (localBoolean != null)
      {
        boolean bool = localBoolean.booleanValue();
        paramBoolean = bool;
      }
      return paramBoolean;
    }
    catch (Exception localException)
    {
    }
    return paramBoolean;
  }

  public static void fetchAdvertisingInfoAsync(Context paramContext, GpsHelperListener paramGpsHelperListener)
  {
    a(paramContext, paramGpsHelperListener);
  }

  public static AdvertisingInfo fetchAdvertisingInfoSync(Context paramContext)
  {
    if (paramContext == null)
      return null;
    try
    {
      Object localObject = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(a)).addParam(Context.class, paramContext).execute();
      String str = a(localObject, null);
      boolean bool = a(localObject, false);
      return new AdvertisingInfo(str, bool);
    }
    catch (Exception localException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to obtain Google AdvertisingIdClient.Info via reflection." });
    }
    return null;
  }

  public static boolean isLimitAdTrackingEnabled(Context paramContext)
  {
    return SharedPreferencesHelper.getSharedPreferences(paramContext).getBoolean("isLimitAdTrackingEnabled", false);
  }

  public static class AdvertisingInfo
  {
    public final String advertisingId;
    public final boolean limitAdTracking;

    public AdvertisingInfo(String paramString, boolean paramBoolean)
    {
      this.advertisingId = paramString;
      this.limitAdTracking = paramBoolean;
    }
  }

  public static abstract interface GpsHelperListener
  {
    public abstract void onFetchAdInfoCompleted();
  }

  private static class a extends AsyncTask<Void, Void, Void>
  {
    private WeakReference<Context> a;
    private WeakReference<GpsHelper.GpsHelperListener> b;

    public a(Context paramContext, GpsHelper.GpsHelperListener paramGpsHelperListener)
    {
      this.a = new WeakReference(paramContext);
      this.b = new WeakReference(paramGpsHelperListener);
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      try
      {
        Context localContext = (Context)this.a.get();
        if (localContext == null)
          return null;
        Object localObject = MethodBuilderFactory.create(null, "getAdvertisingIdInfo").setStatic(Class.forName(GpsHelper.a())).addParam(Context.class, localContext).execute();
        if (localObject != null)
          return null;
      }
      catch (Exception localException)
      {
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to obtain Google AdvertisingIdClient.Info via reflection." });
      }
      return null;
    }

    protected void a(Void paramVoid)
    {
      GpsHelper.GpsHelperListener localGpsHelperListener = (GpsHelper.GpsHelperListener)this.b.get();
      if (localGpsHelperListener != null)
        localGpsHelperListener.onFetchAdInfoCompleted();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.GpsHelper
 * JD-Core Version:    0.6.2
 */