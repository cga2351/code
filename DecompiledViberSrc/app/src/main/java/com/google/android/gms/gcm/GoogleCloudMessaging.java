package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.iid.InstanceID;
import com.google.android.gms.iid.zzaf;
import com.google.android.gms.iid.zzak;
import java.io.IOException;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Deprecated
public class GoogleCloudMessaging
{
  public static final String ERROR_MAIN_THREAD = "MAIN_THREAD";
  public static final String ERROR_SERVICE_NOT_AVAILABLE = "SERVICE_NOT_AVAILABLE";
  public static final String INSTANCE_ID_SCOPE = "GCM";

  @Deprecated
  public static final String MESSAGE_TYPE_DELETED = "deleted_messages";

  @Deprecated
  public static final String MESSAGE_TYPE_MESSAGE = "gcm";

  @Deprecated
  public static final String MESSAGE_TYPE_SEND_ERROR = "send_error";

  @Deprecated
  public static final String MESSAGE_TYPE_SEND_EVENT = "send_event";
  private static GoogleCloudMessaging zzae;
  private static final AtomicInteger zzah = new AtomicInteger(1);
  private PendingIntent zzaf;
  private final Map<String, Handler> zzag = Collections.synchronizedMap(new ArrayMap());
  private final BlockingQueue<Intent> zzai = new LinkedBlockingQueue();
  private final Messenger zzaj = new Messenger(new zzf(this, Looper.getMainLooper()));
  private Context zzl;

  @Deprecated
  public static GoogleCloudMessaging getInstance(Context paramContext)
  {
    try
    {
      if (zzae == null)
      {
        zze(paramContext);
        GoogleCloudMessaging localGoogleCloudMessaging2 = new GoogleCloudMessaging();
        zzae = localGoogleCloudMessaging2;
        localGoogleCloudMessaging2.zzl = paramContext.getApplicationContext();
      }
      GoogleCloudMessaging localGoogleCloudMessaging1 = zzae;
      return localGoogleCloudMessaging1;
    }
    finally
    {
    }
  }

  @Deprecated
  private final Intent zzd(Bundle paramBundle, boolean paramBoolean)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IOException("MAIN_THREAD");
    if (zzf(this.zzl) < 0)
      throw new IOException("Google Play Services missing");
    String str;
    if (paramBoolean)
      str = "com.google.iid.TOKEN_REQUEST";
    while (true)
    {
      Intent localIntent1 = new Intent(str);
      localIntent1.setPackage(zzaf.zzl(this.zzl));
      zze(localIntent1);
      int i = zzah.getAndIncrement();
      localIntent1.putExtra("google.message_id", 21 + "google.rpc" + i);
      localIntent1.putExtras(paramBundle);
      localIntent1.putExtra("google.messenger", this.zzaj);
      if (paramBoolean)
        this.zzl.sendBroadcast(localIntent1);
      try
      {
        while (true)
        {
          Intent localIntent2 = (Intent)this.zzai.poll(30000L, TimeUnit.MILLISECONDS);
          return localIntent2;
          str = "com.google.android.c2dm.intent.REGISTER";
          break;
          this.zzl.startService(localIntent1);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        throw new IOException(localInterruptedException.getMessage());
      }
    }
  }

  @Deprecated
  @ShowFirstParty
  @VisibleForTesting
  private final String zzd(boolean paramBoolean, String[] paramArrayOfString)
    throws IOException
  {
    String str1;
    try
    {
      str1 = zzaf.zzl(this.zzl);
      if (str1 == null)
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    finally
    {
    }
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
      throw new IllegalArgumentException("No senderIds");
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfString[0]);
    for (int i = 1; i < paramArrayOfString.length; i++)
      localStringBuilder.append(',').append(paramArrayOfString[i]);
    String str2 = localStringBuilder.toString();
    Bundle localBundle = new Bundle();
    String str3;
    if (str1.contains(".gsf"))
    {
      localBundle.putString("legacy.sender", str2);
      String str5 = InstanceID.getInstance(this.zzl).getToken(str2, "GCM", localBundle);
      str3 = str5;
    }
    Intent localIntent;
    do
    {
      return str3;
      localBundle.putString("sender", str2);
      localIntent = zzd(localBundle, paramBoolean);
      if (localIntent == null)
        throw new IOException("SERVICE_NOT_AVAILABLE");
      str3 = localIntent.getStringExtra("registration_id");
    }
    while (str3 != null);
    String str4 = localIntent.getStringExtra("error");
    if (str4 != null)
      throw new IOException(str4);
    throw new IOException("SERVICE_NOT_AVAILABLE");
  }

  private final boolean zzd(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("In-Reply-To");
    if ((str == null) && (paramIntent.hasExtra("error")))
      str = paramIntent.getStringExtra("google.message_id");
    if (str != null)
    {
      Handler localHandler = (Handler)this.zzag.remove(str);
      if (localHandler != null)
      {
        Message localMessage = Message.obtain();
        localMessage.obj = paramIntent;
        return localHandler.sendMessage(localMessage);
      }
    }
    return false;
  }

  static void zze(Context paramContext)
  {
    String str = paramContext.getPackageName();
    Log.w("GCM", 48 + String.valueOf(str).length() + "GCM SDK is deprecated, " + str + " should update to use FCM");
  }

  private final void zze(Intent paramIntent)
  {
    try
    {
      if (this.zzaf == null)
      {
        Intent localIntent = new Intent();
        localIntent.setPackage("com.google.example.invalidpackage");
        this.zzaf = PendingIntent.getBroadcast(this.zzl, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", this.zzaf);
      return;
    }
    finally
    {
    }
  }

  public static int zzf(Context paramContext)
  {
    String str = zzaf.zzl(paramContext);
    if (str != null)
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(str, 0);
        if (localPackageInfo != null)
        {
          int i = localPackageInfo.versionCode;
          return i;
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
    return -1;
  }

  private final void zzh()
  {
    try
    {
      if (this.zzaf != null)
      {
        this.zzaf.cancel();
        this.zzaf = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Deprecated
  public void close()
  {
    zzae = null;
    zzd.zzk = null;
    zzh();
  }

  @Deprecated
  public String getMessageType(Intent paramIntent)
  {
    String str;
    if (!"com.google.android.c2dm.intent.RECEIVE".equals(paramIntent.getAction()))
      str = null;
    do
    {
      return str;
      str = paramIntent.getStringExtra("message_type");
    }
    while (str != null);
    return "gcm";
  }

  @Deprecated
  public String register(String[] paramArrayOfString)
    throws IOException
  {
    try
    {
      String str = zzd(zzaf.zzk(this.zzl), paramArrayOfString);
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @Deprecated
  public void send(String paramString1, String paramString2, long paramLong, Bundle paramBundle)
    throws IOException
  {
    if (paramString1 == null)
      throw new IllegalArgumentException("Missing 'to'");
    String str1 = zzaf.zzl(this.zzl);
    if (str1 == null)
      throw new IOException("SERVICE_NOT_AVAILABLE");
    Intent localIntent = new Intent("com.google.android.gcm.intent.SEND");
    if (paramBundle != null)
      localIntent.putExtras(paramBundle);
    zze(localIntent);
    localIntent.setPackage(str1);
    localIntent.putExtra("google.to", paramString1);
    localIntent.putExtra("google.message_id", paramString2);
    localIntent.putExtra("google.ttl", Long.toString(paramLong));
    int i = paramString1.indexOf('@');
    String str2;
    Bundle localBundle;
    label193: Object localObject;
    String str4;
    if (i > 0)
    {
      str2 = paramString1.substring(0, i);
      InstanceID.getInstance(this.zzl);
      localIntent.putExtra("google.from", InstanceID.zzp().zzf("", str2, "GCM"));
      if (!str1.contains(".gsf"))
        break label329;
      localBundle = new Bundle();
      Iterator localIterator = paramBundle.keySet().iterator();
      String str3;
      do
      {
        if (!localIterator.hasNext())
          break;
        str3 = (String)localIterator.next();
        localObject = paramBundle.get(str3);
      }
      while (!(localObject instanceof String));
      str4 = String.valueOf(str3);
      if (str4.length() == 0)
        break label278;
    }
    label278: for (String str5 = "gcm.".concat(str4); ; str5 = new String("gcm."))
    {
      localBundle.putString(str5, (String)localObject);
      break label193;
      str2 = paramString1;
      break;
    }
    localBundle.putString("google.to", paramString1);
    localBundle.putString("google.message_id", paramString2);
    InstanceID.getInstance(this.zzl).zze("GCM", "upstream", localBundle);
    return;
    label329: this.zzl.sendOrderedBroadcast(localIntent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
  }

  @Deprecated
  public void send(String paramString1, String paramString2, Bundle paramBundle)
    throws IOException
  {
    send(paramString1, paramString2, -1L, paramBundle);
  }

  @Deprecated
  public void unregister()
    throws IOException
  {
    try
    {
      if (Looper.getMainLooper() == Looper.myLooper())
        throw new IOException("MAIN_THREAD");
    }
    finally
    {
    }
    InstanceID.getInstance(this.zzl).deleteInstanceID();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.gcm.GoogleCloudMessaging
 * JD-Core Version:    0.6.2
 */