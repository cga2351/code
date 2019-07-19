package com.mopub.common.privacy;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.AsyncTask;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import com.mopub.common.GpsHelper;
import com.mopub.common.GpsHelper.AdvertisingInfo;
import com.mopub.common.Preconditions;
import com.mopub.common.Preconditions.NoThrow;
import com.mopub.common.SdkInitializationListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.LogLevel;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.AsyncTasks;
import java.util.Calendar;

public class MoPubIdentifier
{
  private AdvertisingId a;
  private final Context b;
  private AdvertisingIdChangeListener c;
  private boolean d;
  private boolean e;
  private volatile SdkInitializationListener f;

  public MoPubIdentifier(Context paramContext)
  {
    this(paramContext, null);
  }

  @VisibleForTesting
  MoPubIdentifier(Context paramContext, AdvertisingIdChangeListener paramAdvertisingIdChangeListener)
  {
    Preconditions.checkNotNull(paramContext);
    this.b = paramContext;
    this.c = paramAdvertisingIdChangeListener;
    this.a = a(this.b);
    if (this.a == null)
      this.a = AdvertisingId.b();
    c();
  }

  static AdvertisingId a(Context paramContext)
  {
    try
    {
      Preconditions.checkNotNull(paramContext);
      Calendar localCalendar = Calendar.getInstance();
      try
      {
        SharedPreferences localSharedPreferences = SharedPreferencesHelper.getSharedPreferences(paramContext, "com.mopub.settings.identifier");
        String str1 = localSharedPreferences.getString("privacy.identifier.ifa", "");
        String str2 = localSharedPreferences.getString("privacy.identifier.mopub", "");
        long l = localSharedPreferences.getLong("privacy.identifier.time", localCalendar.getTimeInMillis());
        boolean bool = localSharedPreferences.getBoolean("privacy.limit.ad.tracking", false);
        if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
        {
          localAdvertisingId = new AdvertisingId(str1, str2, bool, l);
          return localAdvertisingId;
        }
      }
      catch (ClassCastException localClassCastException)
      {
        while (true)
        {
          MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Cannot read identifier from shared preferences" });
          AdvertisingId localAdvertisingId = null;
        }
      }
    }
    finally
    {
    }
  }

  private static void a(Context paramContext, AdvertisingId paramAdvertisingId)
  {
    try
    {
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramAdvertisingId);
      SharedPreferences.Editor localEditor = SharedPreferencesHelper.getSharedPreferences(paramContext, "com.mopub.settings.identifier").edit();
      localEditor.putBoolean("privacy.limit.ad.tracking", paramAdvertisingId.d);
      localEditor.putString("privacy.identifier.ifa", paramAdvertisingId.b);
      localEditor.putString("privacy.identifier.mopub", paramAdvertisingId.c);
      localEditor.putLong("privacy.identifier.time", paramAdvertisingId.a.getTimeInMillis());
      localEditor.apply();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void a(AdvertisingId paramAdvertisingId1, AdvertisingId paramAdvertisingId2)
  {
    Preconditions.checkNotNull(paramAdvertisingId2);
    if (this.c != null)
      this.c.onIdChanged(paramAdvertisingId1, paramAdvertisingId2);
  }

  private void a(String paramString1, String paramString2, boolean paramBoolean, long paramLong)
  {
    Preconditions.checkNotNull(paramString1);
    Preconditions.checkNotNull(paramString2);
    a(new AdvertisingId(paramString1, paramString2, paramBoolean, paramLong));
  }

  private AdvertisingId b(Context paramContext)
  {
    Preconditions.NoThrow.checkNotNull(paramContext);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    int i = Settings.Secure.getInt(localContentResolver, "limit_ad_tracking", -1);
    String str = Settings.Secure.getString(localContentResolver, "advertising_id");
    if ((i != -1) && (!TextUtils.isEmpty(str)))
    {
      if (i != 0);
      for (boolean bool = true; ; bool = false)
      {
        AdvertisingId localAdvertisingId = this.a;
        return new AdvertisingId(str, localAdvertisingId.c, bool, localAdvertisingId.a.getTimeInMillis());
      }
    }
    return null;
  }

  private void c()
  {
    if (this.d)
      return;
    this.d = true;
    AsyncTasks.safeExecuteOnExecutor(new a(null), new Void[0]);
  }

  private void d()
  {
    try
    {
      SdkInitializationListener localSdkInitializationListener = this.f;
      if (localSdkInitializationListener != null)
      {
        this.f = null;
        localSdkInitializationListener.onInitializationFinished();
      }
      return;
    }
    finally
    {
    }
  }

  void a()
  {
    long l1 = Calendar.getInstance().getTimeInMillis();
    AdvertisingId localAdvertisingId1 = this.a;
    GpsHelper.AdvertisingInfo localAdvertisingInfo = GpsHelper.fetchAdvertisingInfoSync(this.b);
    AdvertisingId localAdvertisingId2;
    String str;
    if ((localAdvertisingInfo != null) && (!TextUtils.isEmpty(localAdvertisingInfo.advertisingId)))
    {
      localAdvertisingId2 = new AdvertisingId(localAdvertisingInfo.advertisingId, localAdvertisingId1.c, localAdvertisingInfo.limitAdTracking, localAdvertisingId1.a.getTimeInMillis());
      if (localAdvertisingId2 != null)
      {
        if (!localAdvertisingId1.e())
          break label130;
        str = AdvertisingId.d();
        label84: if (!localAdvertisingId1.e())
          break label139;
      }
    }
    label130: label139: for (long l2 = l1; ; l2 = localAdvertisingId1.a.getTimeInMillis())
    {
      a(localAdvertisingId2.b, str, localAdvertisingId2.d, l2);
      b();
      return;
      localAdvertisingId2 = b(this.b);
      break;
      str = localAdvertisingId1.c;
      break label84;
    }
  }

  void a(SdkInitializationListener paramSdkInitializationListener)
  {
    this.f = paramSdkInitializationListener;
    if (this.e)
      d();
  }

  void a(AdvertisingId paramAdvertisingId)
  {
    AdvertisingId localAdvertisingId = this.a;
    this.a = paramAdvertisingId;
    a(this.b, this.a);
    if ((!this.a.equals(localAdvertisingId)) || (!this.e))
      a(localAdvertisingId, this.a);
    this.e = true;
    d();
  }

  void b()
  {
    if (this.a.b.endsWith("10ca1ad1abe1"))
      MoPubLog.setLogLevel(MoPubLog.LogLevel.DEBUG);
    if (!this.a.e())
    {
      a(this.a);
      return;
    }
    a(AdvertisingId.c());
  }

  public AdvertisingId getAdvertisingInfo()
  {
    if (this.e)
      b();
    AdvertisingId localAdvertisingId = this.a;
    c();
    return localAdvertisingId;
  }

  public void setIdChangeListener(AdvertisingIdChangeListener paramAdvertisingIdChangeListener)
  {
    this.c = paramAdvertisingIdChangeListener;
  }

  public static abstract interface AdvertisingIdChangeListener
  {
    public abstract void onIdChanged(AdvertisingId paramAdvertisingId1, AdvertisingId paramAdvertisingId2);
  }

  private class a extends AsyncTask<Void, Void, Void>
  {
    private a()
    {
    }

    protected Void a(Void[] paramArrayOfVoid)
    {
      MoPubIdentifier.this.a();
      MoPubIdentifier.a(MoPubIdentifier.this, false);
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.privacy.MoPubIdentifier
 * JD-Core Version:    0.6.2
 */