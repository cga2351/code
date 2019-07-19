package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.d.g;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

public class FirebaseInstanceId
{
  private static final long zzaq = TimeUnit.HOURS.toSeconds(8L);
  private static aa zzar;

  @VisibleForTesting
  @GuardedBy("FirebaseInstanceId.class")
  private static ScheduledThreadPoolExecutor zzas;
  private final Executor zzat;
  private final FirebaseApp zzau;
  private final p zzav;
  private b zzaw;
  private final u zzax;
  private final ae zzay;

  @GuardedBy("this")
  private boolean zzaz = false;
  private final a zzba;

  FirebaseInstanceId(FirebaseApp paramFirebaseApp, com.google.firebase.a.d paramd, g paramg)
  {
    this(paramFirebaseApp, new p(paramFirebaseApp.a()), aj.b(), aj.b(), paramd, paramg);
  }

  private FirebaseInstanceId(FirebaseApp paramFirebaseApp, p paramp, Executor paramExecutor1, Executor paramExecutor2, com.google.firebase.a.d paramd, g paramg)
  {
    if (p.a(paramFirebaseApp) == null)
      throw new IllegalStateException("FirebaseInstanceId failed to initialize, FirebaseApp is missing project ID");
    while (true)
    {
      try
      {
        if (zzar == null)
          zzar = new aa(paramFirebaseApp.a());
        this.zzau = paramFirebaseApp;
        this.zzav = paramp;
        if (this.zzaw == null)
        {
          b localb = (b)paramFirebaseApp.a(b.class);
          if ((localb != null) && (localb.a()))
            this.zzaw = localb;
        }
        else
        {
          this.zzaw = this.zzaw;
          this.zzat = paramExecutor2;
          this.zzay = new ae(zzar);
          this.zzba = new a(paramd);
          this.zzax = new u(paramExecutor1);
          if (this.zzba.a())
            zzh();
          return;
        }
      }
      finally
      {
      }
      this.zzaw = new as(paramFirebaseApp, paramp, paramExecutor1, paramg);
    }
  }

  public static FirebaseInstanceId getInstance()
  {
    return getInstance(FirebaseApp.getInstance());
  }

  @Keep
  public static FirebaseInstanceId getInstance(FirebaseApp paramFirebaseApp)
  {
    return (FirebaseInstanceId)paramFirebaseApp.a(FirebaseInstanceId.class);
  }

  private final void startSync()
  {
    try
    {
      if (!this.zzaz)
        zza(0L);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private final Task<a> zza(String paramString1, String paramString2)
  {
    String str = zzd(paramString2);
    return Tasks.forResult(null).continueWithTask(this.zzat, new ap(this, paramString1, str));
  }

  private final <T> T zza(Task<T> paramTask)
    throws IOException
  {
    try
    {
      Object localObject = Tasks.await(paramTask, 30000L, TimeUnit.MILLISECONDS);
      return localObject;
    }
    catch (ExecutionException localExecutionException)
    {
      Throwable localThrowable = localExecutionException.getCause();
      if ((localThrowable instanceof IOException))
      {
        if ("INSTANCE_ID_RESET".equals(localThrowable.getMessage()))
          zzn();
        throw ((IOException)localThrowable);
      }
      if ((localThrowable instanceof RuntimeException))
        throw ((RuntimeException)localThrowable);
      throw new IOException(localExecutionException);
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException("SERVICE_NOT_AVAILABLE");
    }
    catch (TimeoutException localTimeoutException)
    {
      label80: break label80;
    }
  }

  static void zza(Runnable paramRunnable, long paramLong)
  {
    try
    {
      if (zzas == null)
        zzas = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("FirebaseInstanceId"));
      zzas.schedule(paramRunnable, paramLong, TimeUnit.SECONDS);
      return;
    }
    finally
    {
    }
  }

  @VisibleForTesting
  private static z zzb(String paramString1, String paramString2)
  {
    return zzar.a("", paramString1, paramString2);
  }

  private static String zzd(String paramString)
  {
    if ((paramString.isEmpty()) || (paramString.equalsIgnoreCase("fcm")) || (paramString.equalsIgnoreCase("gcm")))
      paramString = "*";
    return paramString;
  }

  private final void zzh()
  {
    z localz = zzk();
    if ((zzr()) || (zza(localz)) || (this.zzay.a()))
      startSync();
  }

  private static String zzj()
  {
    return p.a(zzar.b("").a());
  }

  static boolean zzm()
  {
    return (Log.isLoggable("FirebaseInstanceId", 3)) || ((Build.VERSION.SDK_INT == 23) && (Log.isLoggable("FirebaseInstanceId", 3)));
  }

  public void deleteInstanceId()
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IOException("MAIN_THREAD");
    String str = zzj();
    zza(this.zzaw.a(str));
    zzn();
  }

  public void deleteToken(String paramString1, String paramString2)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IOException("MAIN_THREAD");
    String str1 = zzd(paramString2);
    String str2 = zzj();
    String str3 = z.a(zzb(paramString1, str1));
    zza(this.zzaw.b(str2, str3, paramString1, str1));
    zzar.b("", paramString1, str1);
  }

  public long getCreationTime()
  {
    return zzar.b("").b();
  }

  public String getId()
  {
    zzh();
    return zzj();
  }

  public Task<a> getInstanceId()
  {
    return zza(p.a(this.zzau), "*");
  }

  @Deprecated
  public String getToken()
  {
    z localz = zzk();
    if ((this.zzaw.b()) || (zza(localz)))
      startSync();
    return z.a(localz);
  }

  public String getToken(String paramString1, String paramString2)
    throws IOException
  {
    if (Looper.getMainLooper() == Looper.myLooper())
      throw new IOException("MAIN_THREAD");
    return ((a)zza(zza(paramString1, paramString2))).a();
  }

  public final Task<Void> zza(String paramString)
  {
    try
    {
      Task localTask = this.zzay.a(paramString);
      startSync();
      return localTask;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final void zza(long paramLong)
  {
    long l1 = paramLong << 1;
    try
    {
      long l2 = Math.min(Math.max(30L, l1), zzaq);
      zza(new ac(this, this.zzav, this.zzay, l2), paramLong);
      this.zzaz = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final void zza(boolean paramBoolean)
  {
    try
    {
      this.zzaz = paramBoolean;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final boolean zza(z paramz)
  {
    return (paramz == null) || (paramz.b(this.zzav.b()));
  }

  final void zzb(String paramString)
    throws IOException
  {
    z localz = zzk();
    if (zza(localz))
      throw new IOException("token not available");
    String str1 = zzj();
    String str2 = localz.a;
    zza(this.zzaw.a(str1, str2, paramString));
  }

  @VisibleForTesting
  public final void zzb(boolean paramBoolean)
  {
    this.zzba.a(paramBoolean);
  }

  final void zzc(String paramString)
    throws IOException
  {
    z localz = zzk();
    if (zza(localz))
      throw new IOException("token not available");
    String str = zzj();
    zza(this.zzaw.b(str, localz.a, paramString));
  }

  final FirebaseApp zzi()
  {
    return this.zzau;
  }

  final z zzk()
  {
    return zzb(p.a(this.zzau), "*");
  }

  final String zzl()
    throws IOException
  {
    return getToken(p.a(this.zzau), "*");
  }

  final void zzn()
  {
    try
    {
      zzar.b();
      if (this.zzba.a())
        startSync();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  final boolean zzo()
  {
    return this.zzaw.a();
  }

  final void zzp()
  {
    zzar.c("");
    startSync();
  }

  @VisibleForTesting
  public final boolean zzq()
  {
    return this.zzba.a();
  }

  final boolean zzr()
  {
    return this.zzaw.b();
  }

  private final class a
  {
    private final boolean b;
    private final com.google.firebase.a.d c;

    @GuardedBy("this")
    private com.google.firebase.a.b<com.google.firebase.a> d;

    @GuardedBy("this")
    private Boolean e;

    a(com.google.firebase.a.d arg2)
    {
      Object localObject;
      this.c = localObject;
      this.b = c();
      this.e = b();
      if ((this.e == null) && (this.b))
      {
        this.d = new ar(this);
        localObject.a(com.google.firebase.a.class, this.d);
      }
    }

    private final Boolean b()
    {
      Context localContext = FirebaseInstanceId.zza(FirebaseInstanceId.this).a();
      SharedPreferences localSharedPreferences = localContext.getSharedPreferences("com.google.firebase.messaging", 0);
      if (localSharedPreferences.contains("auto_init"))
        return Boolean.valueOf(localSharedPreferences.getBoolean("auto_init", false));
      try
      {
        PackageManager localPackageManager = localContext.getPackageManager();
        if (localPackageManager != null)
        {
          ApplicationInfo localApplicationInfo = localPackageManager.getApplicationInfo(localContext.getPackageName(), 128);
          if ((localApplicationInfo != null) && (localApplicationInfo.metaData != null) && (localApplicationInfo.metaData.containsKey("firebase_messaging_auto_init_enabled")))
          {
            Boolean localBoolean = Boolean.valueOf(localApplicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
            return localBoolean;
          }
        }
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException)
      {
      }
      return null;
    }

    private final boolean c()
    {
      try
      {
        Class.forName("com.google.firebase.messaging.a");
        return true;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        ResolveInfo localResolveInfo;
        do
        {
          Context localContext = FirebaseInstanceId.zza(FirebaseInstanceId.this).a();
          Intent localIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
          localIntent.setPackage(localContext.getPackageName());
          localResolveInfo = localContext.getPackageManager().resolveService(localIntent, 0);
          if (localResolveInfo == null)
            break;
        }
        while (localResolveInfo.serviceInfo != null);
      }
      return false;
    }

    final void a(boolean paramBoolean)
    {
      try
      {
        if (this.d != null)
        {
          this.c.b(com.google.firebase.a.class, this.d);
          this.d = null;
        }
        SharedPreferences.Editor localEditor = FirebaseInstanceId.zza(FirebaseInstanceId.this).a().getSharedPreferences("com.google.firebase.messaging", 0).edit();
        localEditor.putBoolean("auto_init", paramBoolean);
        localEditor.apply();
        if (paramBoolean)
          FirebaseInstanceId.zzb(FirebaseInstanceId.this);
        this.e = Boolean.valueOf(paramBoolean);
        return;
      }
      finally
      {
      }
    }

    final boolean a()
    {
      try
      {
        boolean bool1;
        if (this.e != null)
        {
          boolean bool3 = this.e.booleanValue();
          bool1 = bool3;
        }
        while (true)
        {
          return bool1;
          if (this.b)
          {
            boolean bool2 = FirebaseInstanceId.zza(FirebaseInstanceId.this).isDataCollectionDefaultEnabled();
            if (bool2)
              bool1 = true;
          }
          else
          {
            bool1 = false;
          }
        }
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.FirebaseInstanceId
 * JD-Core Version:    0.6.2
 */