package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public final class zzaqy
  implements zzarc
{
  private static final Object lock = new Object();

  @VisibleForTesting
  private static zzarc zzdlb = null;

  @VisibleForTesting
  private static zzarc zzdlc = null;
  private final Context zzckp;
  private final Object zzdld = new Object();
  private final WeakHashMap<Thread, Boolean> zzdle = new WeakHashMap();
  private final zzbaj zzdlf;
  private final ExecutorService zzxf = Executors.newCachedThreadPool();

  private zzaqy(Context paramContext)
  {
    this(paramContext, zzbaj.zzxc());
  }

  private zzaqy(Context paramContext, zzbaj paramzzbaj)
  {
    if (paramContext.getApplicationContext() != null)
      paramContext = paramContext.getApplicationContext();
    this.zzckp = paramContext;
    this.zzdlf = paramzzbaj;
  }

  @VisibleForTesting
  private final Uri.Builder zza(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    try
    {
      boolean bool2 = Wrappers.packageManager(this.zzckp).isCallerInstantApp();
      bool1 = bool2;
      localObject = "unknown";
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        boolean bool1;
        String str3 = this.zzckp.getPackageName();
        Object localObject = str3;
        Uri.Builder localBuilder1 = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(bool1)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        str1 = Build.MANUFACTURER;
        str2 = Build.MODEL;
        if (str2.startsWith(str1))
        {
          Uri.Builder localBuilder2 = localBuilder1.appendQueryParameter("device", str2).appendQueryParameter("js", this.zzdlf.zzbsy).appendQueryParameter("appid", (String)localObject).appendQueryParameter("exceptiontype", paramString1).appendQueryParameter("stacktrace", paramString2).appendQueryParameter("eids", TextUtils.join(",", zzact.zzqn())).appendQueryParameter("exceptionkey", paramString3).appendQueryParameter("cl", "237950021").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzyr.zzpf()).appendQueryParameter("sampling_rate", Integer.toString(paramInt));
          zzaci localzzaci = zzact.zzcwf;
          return localBuilder2.appendQueryParameter("pb_tm", String.valueOf(zzyr.zzpe().zzd(localzzaci)));
          localThrowable1 = localThrowable1;
          zzbae.zzc("Error fetching instant app info", localThrowable1);
          bool1 = false;
        }
      }
      catch (Throwable localThrowable2)
      {
        while (true)
        {
          String str1;
          zzbae.zzep("Cannot obtain package name, proceeding.");
          continue;
          String str2 = 1 + String.valueOf(str1).length() + String.valueOf(str2).length() + str1 + " " + str2;
        }
      }
    }
  }

  public static zzarc zzc(Context paramContext, zzbaj paramzzbaj)
  {
    while (true)
    {
      synchronized (lock)
      {
        zzaqy localzzaqy;
        Thread localThread;
        if (zzdlc == null)
        {
          zzaci localzzaci = zzact.zzclf;
          if (!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
            break label144;
          localzzaqy = new zzaqy(paramContext, paramzzbaj);
          localThread = Looper.getMainLooper().getThread();
          if (localThread == null);
        }
        synchronized (localzzaqy.zzdld)
        {
          localzzaqy.zzdle.put(localThread, Boolean.valueOf(true));
          localThread.setUncaughtExceptionHandler(new zzara(localzzaqy, localThread.getUncaughtExceptionHandler()));
          Thread.setDefaultUncaughtExceptionHandler(new zzaqz(localzzaqy, Thread.getDefaultUncaughtExceptionHandler()));
          zzdlc = localzzaqy;
          return zzdlc;
        }
      }
      label144: zzdlc = new zzard();
    }
  }

  public static zzarc zzo(Context paramContext)
  {
    synchronized (lock)
    {
      if (zzdlb == null)
      {
        zzaci localzzaci = zzact.zzclf;
        if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
          zzdlb = new zzaqy(paramContext);
      }
      else
      {
        return zzdlb;
      }
      zzdlb = new zzard();
    }
  }

  protected final void zza(Thread paramThread, Throwable paramThrowable)
  {
    int i = 1;
    if (paramThrowable != null)
    {
      int j = 0;
      int k = 0;
      for (Throwable localThrowable = paramThrowable; localThrowable != null; localThrowable = localThrowable.getCause())
        for (StackTraceElement localStackTraceElement : localThrowable.getStackTrace())
        {
          if (zzazu.zzej(localStackTraceElement.getClassName()))
            k = i;
          if (getClass().getName().equals(localStackTraceElement.getClassName()))
            j = i;
        }
      if ((k == 0) || (j != 0));
    }
    while (true)
    {
      if (i != 0)
        zza(paramThrowable, "", 1.0F);
      return;
      i = 0;
    }
  }

  public final void zza(Throwable paramThrowable, String paramString)
  {
    zza(paramThrowable, paramString, 1.0F);
  }

  public final void zza(Throwable paramThrowable, String paramString, float paramFloat)
  {
    if (zzazu.zzc(paramThrowable) == null);
    label58: label187: label191: 
    while (true)
    {
      return;
      String str1 = paramThrowable.getClass().getName();
      StringWriter localStringWriter = new StringWriter();
      zzdma.zza(paramThrowable, new PrintWriter(localStringWriter));
      String str2 = localStringWriter.toString();
      int i;
      if (Math.random() < paramFloat)
      {
        i = 1;
        if (paramFloat <= 0.0F)
          break label187;
      }
      for (int j = (int)(1.0F / paramFloat); ; j = 1)
      {
        if (i == 0)
          break label191;
        ArrayList localArrayList1 = new ArrayList();
        localArrayList1.add(zza(str1, str2, paramString, j).toString());
        ArrayList localArrayList2 = (ArrayList)localArrayList1;
        int k = localArrayList2.size();
        int m = 0;
        while (m < k)
        {
          Object localObject = localArrayList2.get(m);
          m++;
          String str3 = (String)localObject;
          zzbai localzzbai = new zzbai();
          this.zzxf.submit(new zzarb(this, localzzbai, str3));
        }
        break;
        i = 0;
        break label58;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaqy
 * JD-Core Version:    0.6.2
 */