package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
public final class zzayj
{
  private final Object lock = new Object();

  @GuardedBy("lock")
  private String zzdwp = "";

  @GuardedBy("lock")
  private String zzdwq = "";

  @GuardedBy("lock")
  private boolean zzdwr = false;

  @VisibleForTesting
  private String zzdws = "";

  @VisibleForTesting
  private final void zza(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!(paramContext instanceof Activity))
    {
      zzaxa.zzeo("Can not create dialog without Activity Context");
      return;
    }
    zzaxj.zzdvx.post(new zzayk(this, paramContext, paramString, paramBoolean1, paramBoolean2));
  }

  private final String zzbb(Context paramContext)
  {
    synchronized (this.lock)
    {
      if (TextUtils.isEmpty(this.zzdwp))
      {
        zzk.zzlg();
        this.zzdwp = zzaxj.zzr(paramContext, "debug_signals_id.txt");
        if (TextUtils.isEmpty(this.zzdwp))
        {
          zzk.zzlg();
          this.zzdwp = zzaxj.zzwb();
          zzk.zzlg();
          zzaxj.zzc(paramContext, "debug_signals_id.txt", this.zzdwp);
        }
      }
      String str = this.zzdwp;
      return str;
    }
  }

  private final void zzc(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    zzaci localzzaci = zzact.zzcuf;
    Uri.Builder localBuilder = zzd(paramContext, (String)zzyr.zzpe().zzd(localzzaci), paramString3, paramString1).buildUpon();
    localBuilder.appendQueryParameter("debugData", paramString2);
    zzk.zzlg();
    zzaxj.zzb(paramContext, paramString1, localBuilder.build().toString());
  }

  private final Uri zzd(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    Uri.Builder localBuilder = Uri.parse(paramString1).buildUpon();
    localBuilder.appendQueryParameter("linkedDeviceId", zzbb(paramContext));
    localBuilder.appendQueryParameter("adSlotPath", paramString2);
    localBuilder.appendQueryParameter("afmaVersion", paramString3);
    return localBuilder.build();
  }

  // ERROR //
  @VisibleForTesting
  private final boolean zzf(Context paramContext, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: getstatic 156	com/google/android/gms/internal/ads/zzact:zzcud	Lcom/google/android/gms/internal/ads/zzaci;
    //   3: astore 4
    //   5: aload_1
    //   6: aload_0
    //   7: aload_1
    //   8: invokestatic 102	com/google/android/gms/internal/ads/zzyr:zzpe	()Lcom/google/android/gms/internal/ads/zzacq;
    //   11: aload 4
    //   13: invokevirtual 108	com/google/android/gms/internal/ads/zzacq:zzd	(Lcom/google/android/gms/internal/ads/zzaci;)Ljava/lang/Object;
    //   16: checkcast 110	java/lang/String
    //   19: aload_2
    //   20: aload_3
    //   21: invokespecial 113	com/google/android/gms/internal/ads/zzayj:zzd	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;
    //   24: invokevirtual 134	android/net/Uri:toString	()Ljava/lang/String;
    //   27: aload_3
    //   28: invokestatic 160	com/google/android/gms/internal/ads/zzayj:zzh	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   31: astore 5
    //   33: aload 5
    //   35: invokestatic 69	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +10 -> 48
    //   41: ldc 162
    //   43: invokestatic 165	com/google/android/gms/internal/ads/zzaxa:zzdp	(Ljava/lang/String;)V
    //   46: iconst_0
    //   47: ireturn
    //   48: aload 5
    //   50: invokevirtual 168	java/lang/String:trim	()Ljava/lang/String;
    //   53: astore 6
    //   55: new 170	org/json/JSONObject
    //   58: dup
    //   59: aload 6
    //   61: invokespecial 172	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   64: astore 7
    //   66: aload 7
    //   68: ldc 174
    //   70: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 9
    //   75: aload_0
    //   76: aload 7
    //   78: ldc 180
    //   80: invokevirtual 178	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   83: putfield 32	com/google/android/gms/internal/ads/zzayj:zzdws	Ljava/lang/String;
    //   86: aload_0
    //   87: getfield 22	com/google/android/gms/internal/ads/zzayj:lock	Ljava/lang/Object;
    //   90: astore 10
    //   92: aload 10
    //   94: monitorenter
    //   95: aload_0
    //   96: aload 9
    //   98: putfield 28	com/google/android/gms/internal/ads/zzayj:zzdwq	Ljava/lang/String;
    //   101: aload 10
    //   103: monitorexit
    //   104: iconst_1
    //   105: ireturn
    //   106: astore 8
    //   108: ldc 182
    //   110: aload 8
    //   112: invokestatic 185	com/google/android/gms/internal/ads/zzaxa:zzd	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: iconst_0
    //   116: ireturn
    //   117: astore 11
    //   119: aload 10
    //   121: monitorexit
    //   122: aload 11
    //   124: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   55	86	106	org/json/JSONException
    //   95	104	117	finally
    //   119	122	117	finally
  }

  @VisibleForTesting
  private final boolean zzg(Context paramContext, String paramString1, String paramString2)
  {
    zzaci localzzaci = zzact.zzcue;
    String str1 = zzh(paramContext, zzd(paramContext, (String)zzyr.zzpe().zzd(localzzaci), paramString1, paramString2).toString(), paramString2);
    if (TextUtils.isEmpty(str1))
    {
      zzaxa.zzdp("Not linked for debug signals.");
      return false;
    }
    String str2 = str1.trim();
    try
    {
      String str3 = new JSONObject(str2).optString("debug_mode");
      boolean bool = "1".equals(str3);
      synchronized (this.lock)
      {
        this.zzdwr = bool;
        return bool;
      }
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzd("Fail to get debug mode response json.", localJSONException);
    }
    return false;
  }

  @VisibleForTesting
  private static String zzh(Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("User-Agent", zzk.zzlg().zzq(paramContext, paramString2));
    zzbbi localzzbbi = new zzayv(paramContext).zzc(paramString1, localHashMap);
    String str1;
    try
    {
      zzaci localzzaci = zzact.zzcug;
      String str7 = (String)localzzbbi.get(((Integer)zzyr.zzpe().zzd(localzzaci)).intValue(), TimeUnit.MILLISECONDS);
      return str7;
    }
    catch (TimeoutException localTimeoutException)
    {
      String str5 = String.valueOf(paramString1);
      if (str5.length() != 0);
      for (String str6 = "Timeout while retriving a response from: ".concat(str5); ; str6 = new String("Timeout while retriving a response from: "))
      {
        zzaxa.zzc(str6, localTimeoutException);
        localzzbbi.cancel(true);
        return null;
      }
    }
    catch (InterruptedException localInterruptedException)
    {
      String str3 = String.valueOf(paramString1);
      if (str3.length() != 0);
      for (String str4 = "Interrupted while retriving a response from: ".concat(str3); ; str4 = new String("Interrupted while retriving a response from: "))
      {
        zzaxa.zzc(str4, localInterruptedException);
        localzzbbi.cancel(true);
        break;
      }
    }
    catch (Exception localException)
    {
      str1 = String.valueOf(paramString1);
      if (str1.length() == 0);
    }
    for (String str2 = "Error retriving a response from: ".concat(str1); ; str2 = new String("Error retriving a response from: "))
    {
      zzaxa.zzc(str2, localException);
      break;
    }
  }

  private final void zzi(Context paramContext, String paramString1, String paramString2)
  {
    zzk.zzlg();
    zzaci localzzaci = zzact.zzcuc;
    zzaxj.zza(paramContext, zzd(paramContext, (String)zzyr.zzpe().zzd(localzzaci), paramString1, paramString2));
  }

  public final void zza(Context paramContext, String paramString1, String paramString2, @Nullable String paramString3)
  {
    boolean bool = zzwo();
    if (zzg(paramContext, paramString1, paramString2))
    {
      if ((!bool) && (!TextUtils.isEmpty(paramString3)))
        zzc(paramContext, paramString2, paramString3, paramString1);
      zzaxa.zzdp("Device is linked for debug signals.");
      zza(paramContext, "The device is successfully linked for troubleshooting.", false, true);
      return;
    }
    zzi(paramContext, paramString1, paramString2);
  }

  public final boolean zzb(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString2)) || (!zzk.zzlq().zzwo()))
      return false;
    zzaxa.zzdp("Sending troubleshooting signals to the server.");
    zzc(paramContext, paramString1, paramString2, paramString3);
    return true;
  }

  public final void zze(Context paramContext, String paramString1, String paramString2)
  {
    if (!zzf(paramContext, paramString1, paramString2))
      zza(paramContext, "In-app preview failed to load because of a system error. Please try again later.", true, true);
    do
    {
      return;
      if ("2".equals(this.zzdws))
      {
        zzaxa.zzdp("Creative is not pushed for this device.");
        zza(paramContext, "There was no creative pushed from DFP to the device.", false, false);
        return;
      }
      if ("1".equals(this.zzdws))
      {
        zzaxa.zzdp("The app is not linked for creative preview.");
        zzi(paramContext, paramString1, paramString2);
        return;
      }
    }
    while (!"0".equals(this.zzdws));
    zzaxa.zzdp("Device is linked for in app preview.");
    zza(paramContext, "The device is successfully linked for creative preview.", false, true);
  }

  public final String zzwn()
  {
    synchronized (this.lock)
    {
      String str = this.zzdwq;
      return str;
    }
  }

  public final boolean zzwo()
  {
    synchronized (this.lock)
    {
      boolean bool = this.zzdwr;
      return bool;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayj
 * JD-Core Version:    0.6.2
 */