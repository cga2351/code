package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Iterator;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@zzare
@ParametersAreNonnullByDefault
@TargetApi(14)
public final class zzus extends Thread
{
  private final Object lock;
  private boolean started = false;
  private final int zzbua;
  private final int zzbuc;
  private final boolean zzbud;
  private boolean zzbva = false;
  private boolean zzbvb = false;
  private final zzun zzbvc;
  private final int zzbvd;
  private final int zzbve;
  private final int zzbvf;
  private final int zzbvg;
  private final int zzbvh;
  private final int zzbvi;
  private final String zzbvj;
  private final boolean zzbvk;
  private final boolean zzbvl;

  public zzus()
  {
    this(new zzun());
  }

  @VisibleForTesting
  private zzus(zzun paramzzun)
  {
    this.zzbvc = paramzzun;
    this.lock = new Object();
    zzaci localzzaci1 = zzact.zzcnc;
    this.zzbua = ((Integer)zzyr.zzpe().zzd(localzzaci1)).intValue();
    zzaci localzzaci2 = zzact.zzcnd;
    this.zzbve = ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue();
    zzaci localzzaci3 = zzact.zzcne;
    this.zzbuc = ((Integer)zzyr.zzpe().zzd(localzzaci3)).intValue();
    zzaci localzzaci4 = zzact.zzcnf;
    this.zzbvf = ((Integer)zzyr.zzpe().zzd(localzzaci4)).intValue();
    zzaci localzzaci5 = zzact.zzcnh;
    this.zzbvg = ((Integer)zzyr.zzpe().zzd(localzzaci5)).intValue();
    zzaci localzzaci6 = zzact.zzcni;
    this.zzbvh = ((Integer)zzyr.zzpe().zzd(localzzaci6)).intValue();
    zzaci localzzaci7 = zzact.zzcnj;
    this.zzbvi = ((Integer)zzyr.zzpe().zzd(localzzaci7)).intValue();
    zzaci localzzaci8 = zzact.zzcng;
    this.zzbvd = ((Integer)zzyr.zzpe().zzd(localzzaci8)).intValue();
    zzaci localzzaci9 = zzact.zzcnl;
    this.zzbvj = ((String)zzyr.zzpe().zzd(localzzaci9));
    zzaci localzzaci10 = zzact.zzcnm;
    this.zzbvk = ((Boolean)zzyr.zzpe().zzd(localzzaci10)).booleanValue();
    zzaci localzzaci11 = zzact.zzcnq;
    this.zzbud = ((Boolean)zzyr.zzpe().zzd(localzzaci11)).booleanValue();
    zzaci localzzaci12 = zzact.zzcnr;
    this.zzbvl = ((Boolean)zzyr.zzpe().zzd(localzzaci12)).booleanValue();
    setName("ContentFetchTask");
  }

  @VisibleForTesting
  private final zzuw zza(View paramView, zzum paramzzum)
  {
    int i = 0;
    if (paramView == null)
      return new zzuw(this, 0, 0);
    boolean bool = paramView.getGlobalVisibleRect(new Rect());
    if (((paramView instanceof TextView)) && (!(paramView instanceof EditText)))
    {
      CharSequence localCharSequence = ((TextView)paramView).getText();
      if (!TextUtils.isEmpty(localCharSequence))
      {
        paramzzum.zzb(localCharSequence.toString(), bool, paramView.getX(), paramView.getY(), paramView.getWidth(), paramView.getHeight());
        return new zzuw(this, 1, 0);
      }
      return new zzuw(this, 0, 0);
    }
    if (((paramView instanceof WebView)) && (!(paramView instanceof zzbha)))
    {
      WebView localWebView = (WebView)paramView;
      if (!PlatformVersion.isAtLeastKitKat());
      for (int m = 0; m != 0; m = 1)
      {
        return new zzuw(this, 0, 1);
        paramzzum.zzmr();
        localWebView.post(new zzuu(this, paramzzum, localWebView, bool));
      }
      return new zzuw(this, 0, 0);
    }
    if ((paramView instanceof ViewGroup))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView;
      int j = 0;
      int k = 0;
      while (j < localViewGroup.getChildCount())
      {
        zzuw localzzuw = zza(localViewGroup.getChildAt(j), paramzzum);
        k += localzzuw.zzbvt;
        i += localzzuw.zzbvu;
        j++;
      }
      return new zzuw(this, k, i);
    }
    return new zzuw(this, 0, 0);
  }

  @VisibleForTesting
  private static boolean zzmw()
  {
    int i;
    label172: 
    do
    {
      try
      {
        Context localContext = zzk.zzlj().getContext();
        if (localContext == null)
          return false;
        ActivityManager localActivityManager = (ActivityManager)localContext.getSystemService("activity");
        KeyguardManager localKeyguardManager = (KeyguardManager)localContext.getSystemService("keyguard");
        if ((localActivityManager != null) && (localKeyguardManager != null))
        {
          List localList = localActivityManager.getRunningAppProcesses();
          if (localList == null)
            return false;
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (Process.myPid() == localRunningAppProcessInfo.pid)
              if ((localRunningAppProcessInfo.importance == 100) && (!localKeyguardManager.inKeyguardRestrictedInputMode()))
              {
                PowerManager localPowerManager = (PowerManager)localContext.getSystemService("power");
                if (localPowerManager == null)
                {
                  i = 0;
                  break label172;
                }
                boolean bool = localPowerManager.isScreenOn();
                i = bool;
                break label172;
              }
          }
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        zzk.zzlk().zza(localThrowable, "ContentFetchTask.isInForeground");
        return false;
      }
      return false;
    }
    while (i == 0);
    return true;
  }

  private final void zzmy()
  {
    synchronized (this.lock)
    {
      this.zzbva = true;
      boolean bool = this.zzbva;
      zzaxa.zzdp(42 + "ContentFetchThread: paused, mPause = " + bool);
      return;
    }
  }

  // ERROR //
  public final void run()
  {
    // Byte code:
    //   0: invokestatic 353	com/google/android/gms/internal/ads/zzus:zzmw	()Z
    //   3: ifeq +223 -> 226
    //   6: invokestatic 252	com/google/android/gms/ads/internal/zzk:zzlj	()Lcom/google/android/gms/internal/ads/zzuo;
    //   9: invokevirtual 357	com/google/android/gms/internal/ads/zzuo:getActivity	()Landroid/app/Activity;
    //   12: astore 7
    //   14: aload 7
    //   16: ifnonnull +64 -> 80
    //   19: ldc_w 359
    //   22: invokestatic 346	com/google/android/gms/internal/ads/zzaxa:zzdp	(Ljava/lang/String;)V
    //   25: aload_0
    //   26: invokespecial 361	com/google/android/gms/internal/ads/zzus:zzmy	()V
    //   29: sipush 1000
    //   32: aload_0
    //   33: getfield 116	com/google/android/gms/internal/ads/zzus:zzbvd	I
    //   36: imul
    //   37: i2l
    //   38: invokestatic 365	java/lang/Thread:sleep	(J)V
    //   41: aload_0
    //   42: getfield 55	com/google/android/gms/internal/ads/zzus:lock	Ljava/lang/Object;
    //   45: astore_2
    //   46: aload_2
    //   47: monitorenter
    //   48: aload_0
    //   49: getfield 46	com/google/android/gms/internal/ads/zzus:zzbva	Z
    //   52: istore 4
    //   54: iload 4
    //   56: ifeq +183 -> 239
    //   59: ldc_w 367
    //   62: invokestatic 346	com/google/android/gms/internal/ads/zzaxa:zzdp	(Ljava/lang/String;)V
    //   65: aload_0
    //   66: getfield 55	com/google/android/gms/internal/ads/zzus:lock	Ljava/lang/Object;
    //   69: invokevirtual 370	java/lang/Object:wait	()V
    //   72: goto -24 -> 48
    //   75: astore 5
    //   77: goto -29 -> 48
    //   80: aload 7
    //   82: ifnull -53 -> 29
    //   85: aload 7
    //   87: invokevirtual 376	android/app/Activity:getWindow	()Landroid/view/Window;
    //   90: astore 11
    //   92: aconst_null
    //   93: astore 9
    //   95: aload 11
    //   97: ifnull +41 -> 138
    //   100: aload 7
    //   102: invokevirtual 376	android/app/Activity:getWindow	()Landroid/view/Window;
    //   105: invokevirtual 382	android/view/Window:getDecorView	()Landroid/view/View;
    //   108: astore 12
    //   110: aconst_null
    //   111: astore 9
    //   113: aload 12
    //   115: ifnull +23 -> 138
    //   118: aload 7
    //   120: invokevirtual 376	android/app/Activity:getWindow	()Landroid/view/Window;
    //   123: invokevirtual 382	android/view/Window:getDecorView	()Landroid/view/View;
    //   126: ldc_w 383
    //   129: invokevirtual 386	android/view/View:findViewById	(I)Landroid/view/View;
    //   132: astore 13
    //   134: aload 13
    //   136: astore 9
    //   138: aload 9
    //   140: ifnull -111 -> 29
    //   143: aload 9
    //   145: ifnull -116 -> 29
    //   148: aload 9
    //   150: new 388	com/google/android/gms/internal/ads/zzut
    //   153: dup
    //   154: aload_0
    //   155: aload 9
    //   157: invokespecial 391	com/google/android/gms/internal/ads/zzut:<init>	(Lcom/google/android/gms/internal/ads/zzus;Landroid/view/View;)V
    //   160: invokevirtual 392	android/view/View:post	(Ljava/lang/Runnable;)Z
    //   163: pop
    //   164: goto -135 -> 29
    //   167: astore 6
    //   169: ldc_w 394
    //   172: aload 6
    //   174: invokestatic 398	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   177: goto -136 -> 41
    //   180: astore 8
    //   182: invokestatic 318	com/google/android/gms/ads/internal/zzk:zzlk	()Lcom/google/android/gms/internal/ads/zzawn;
    //   185: aload 8
    //   187: ldc_w 400
    //   190: invokevirtual 325	com/google/android/gms/internal/ads/zzawn:zza	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   193: ldc_w 402
    //   196: invokestatic 346	com/google/android/gms/internal/ads/zzaxa:zzdp	(Ljava/lang/String;)V
    //   199: aconst_null
    //   200: astore 9
    //   202: goto -64 -> 138
    //   205: astore_1
    //   206: ldc_w 394
    //   209: aload_1
    //   210: invokestatic 398	com/google/android/gms/internal/ads/zzaxa:zzc	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: invokestatic 318	com/google/android/gms/ads/internal/zzk:zzlk	()Lcom/google/android/gms/internal/ads/zzawn;
    //   216: aload_1
    //   217: ldc_w 404
    //   220: invokevirtual 325	com/google/android/gms/internal/ads/zzawn:zza	(Ljava/lang/Throwable;Ljava/lang/String;)V
    //   223: goto -182 -> 41
    //   226: ldc_w 406
    //   229: invokestatic 346	com/google/android/gms/internal/ads/zzaxa:zzdp	(Ljava/lang/String;)V
    //   232: aload_0
    //   233: invokespecial 361	com/google/android/gms/internal/ads/zzus:zzmy	()V
    //   236: goto -207 -> 29
    //   239: aload_2
    //   240: monitorexit
    //   241: goto -241 -> 0
    //   244: astore_3
    //   245: aload_2
    //   246: monitorexit
    //   247: aload_3
    //   248: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   59	72	75	java/lang/InterruptedException
    //   0	14	167	java/lang/InterruptedException
    //   19	29	167	java/lang/InterruptedException
    //   29	41	167	java/lang/InterruptedException
    //   85	92	167	java/lang/InterruptedException
    //   100	110	167	java/lang/InterruptedException
    //   118	134	167	java/lang/InterruptedException
    //   148	164	167	java/lang/InterruptedException
    //   182	199	167	java/lang/InterruptedException
    //   226	236	167	java/lang/InterruptedException
    //   85	92	180	java/lang/Exception
    //   100	110	180	java/lang/Exception
    //   118	134	180	java/lang/Exception
    //   0	14	205	java/lang/Exception
    //   19	29	205	java/lang/Exception
    //   29	41	205	java/lang/Exception
    //   148	164	205	java/lang/Exception
    //   182	199	205	java/lang/Exception
    //   226	236	205	java/lang/Exception
    //   48	54	244	finally
    //   59	72	244	finally
    //   239	241	244	finally
    //   245	247	244	finally
  }

  public final void wakeup()
  {
    synchronized (this.lock)
    {
      this.zzbva = false;
      this.lock.notifyAll();
      zzaxa.zzdp("ContentFetchThread: wakeup");
      return;
    }
  }

  @VisibleForTesting
  final void zza(zzum paramzzum, WebView paramWebView, String paramString, boolean paramBoolean)
  {
    paramzzum.zzmq();
    try
    {
      String str1;
      if (!TextUtils.isEmpty(paramString))
      {
        str1 = new JSONObject(paramString).optString("text");
        if ((this.zzbvk) || (TextUtils.isEmpty(paramWebView.getTitle())))
          break label136;
        String str2 = paramWebView.getTitle();
        paramzzum.zza(1 + String.valueOf(str2).length() + String.valueOf(str1).length() + str2 + "\n" + str1, paramBoolean, paramWebView.getX(), paramWebView.getY(), paramWebView.getWidth(), paramWebView.getHeight());
      }
      while (paramzzum.zzml())
      {
        this.zzbvc.zzb(paramzzum);
        return;
        label136: paramzzum.zza(str1, paramBoolean, paramWebView.getX(), paramWebView.getY(), paramWebView.getWidth(), paramWebView.getHeight());
      }
    }
    catch (JSONException localJSONException)
    {
      zzaxa.zzdp("Json string may be malformed.");
      return;
    }
    catch (Throwable localThrowable)
    {
      zzaxa.zzb("Failed to get webview content.", localThrowable);
      zzk.zzlk().zza(localThrowable, "ContentFetchTask.processWebViewContent");
    }
  }

  @VisibleForTesting
  final void zzi(View paramView)
  {
    try
    {
      zzum localzzum = new zzum(this.zzbua, this.zzbve, this.zzbuc, this.zzbvf, this.zzbvg, this.zzbvh, this.zzbvi, this.zzbud);
      Context localContext = zzk.zzlj().getContext();
      if ((localContext != null) && (!TextUtils.isEmpty(this.zzbvj)))
      {
        Resources localResources = localContext.getResources();
        zzaci localzzaci = zzact.zzcnk;
        String str = (String)paramView.getTag(localResources.getIdentifier((String)zzyr.zzpe().zzd(localzzaci), "id", localContext.getPackageName()));
        if ((str != null) && (str.equals(this.zzbvj)))
          return;
      }
      zzuw localzzuw = zza(paramView, localzzum);
      localzzum.zzmt();
      if (((localzzuw.zzbvt != 0) || (localzzuw.zzbvu != 0)) && ((localzzuw.zzbvu != 0) || (localzzum.zzmu() != 0)) && ((localzzuw.zzbvu != 0) || (!this.zzbvc.zza(localzzum))))
      {
        this.zzbvc.zzc(localzzum);
        return;
      }
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Exception in fetchContentOnUIThread", localException);
      zzk.zzlk().zza(localException, "ContentFetchTask.fetchContent");
    }
  }

  public final void zzmv()
  {
    synchronized (this.lock)
    {
      if (this.started)
      {
        zzaxa.zzdp("Content hash thread already started, quiting...");
        return;
      }
      this.started = true;
      start();
      return;
    }
  }

  public final zzum zzmx()
  {
    return this.zzbvc.zzo(this.zzbvl);
  }

  public final boolean zzmz()
  {
    return this.zzbva;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzus
 * JD-Core Version:    0.6.2
 */