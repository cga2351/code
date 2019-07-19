package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.SystemClock;
import com.google.android.gms.common.BlockingServiceConnection;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads_identifier.zze;
import com.google.android.gms.internal.ads_identifier.zzf;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@KeepForSdk
public class AdvertisingIdClient
{

  @GuardedBy("this")
  private final Context mContext;

  @GuardedBy("this")
  private BlockingServiceConnection zze;

  @GuardedBy("this")
  private zze zzf;

  @GuardedBy("this")
  private boolean zzg;
  private final Object zzh = new Object();

  @GuardedBy("mAutoDisconnectTaskLock")
  private zza zzi;
  private final boolean zzj;
  private final long zzk;

  @KeepForSdk
  public AdvertisingIdClient(Context paramContext)
  {
    this(paramContext, 30000L, false, false);
  }

  @VisibleForTesting
  private AdvertisingIdClient(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    Preconditions.checkNotNull(paramContext);
    Context localContext;
    if (paramBoolean1)
    {
      localContext = paramContext.getApplicationContext();
      if (localContext != null);
    }
    for (this.mContext = paramContext; ; this.mContext = paramContext)
    {
      this.zzg = false;
      this.zzk = paramLong;
      this.zzj = paramBoolean2;
      return;
      paramContext = localContext;
      break;
    }
  }

  @KeepForSdk
  public static Info getAdvertisingIdInfo(Context paramContext)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzb localzzb = new zzb(paramContext);
    boolean bool = localzzb.getBoolean("gads:ad_id_app_context:enabled", false);
    float f = localzzb.getFloat("gads:ad_id_app_context:ping_ratio", 0.0F);
    String str = localzzb.getString("gads:ad_id_use_shared_preference:experiment_id", "");
    AdvertisingIdClient localAdvertisingIdClient = new AdvertisingIdClient(paramContext, -1L, bool, localzzb.getBoolean("gads:ad_id_use_persistent_service:enabled", false));
    try
    {
      long l = SystemClock.elapsedRealtime();
      localAdvertisingIdClient.zza(false);
      Info localInfo = localAdvertisingIdClient.getInfo();
      localAdvertisingIdClient.zza(localInfo, bool, f, SystemClock.elapsedRealtime() - l, str, null);
      return localInfo;
    }
    catch (Throwable localThrowable)
    {
      localAdvertisingIdClient.zza(null, bool, f, -1L, str, localThrowable);
      throw localThrowable;
    }
    finally
    {
      localAdvertisingIdClient.finish();
    }
  }

  @KeepForSdk
  public static boolean getIsAdIdFakeForDebugLogging(Context paramContext)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zzb localzzb = new zzb(paramContext);
    AdvertisingIdClient localAdvertisingIdClient = new AdvertisingIdClient(paramContext, -1L, localzzb.getBoolean("gads:ad_id_app_context:enabled", false), localzzb.getBoolean("com.google.android.gms.ads.identifier.service.PERSISTENT_START", false));
    try
    {
      localAdvertisingIdClient.zza(false);
      boolean bool = localAdvertisingIdClient.zzb();
      return bool;
    }
    finally
    {
      localAdvertisingIdClient.finish();
    }
  }

  @KeepForSdk
  public static void setShouldSkipGmsCoreVersionCheck(boolean paramBoolean)
  {
  }

  private static BlockingServiceConnection zza(Context paramContext, boolean paramBoolean)
    throws IOException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    try
    {
      paramContext.getPackageManager().getPackageInfo("com.android.vending", 0);
      switch (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(paramContext, 12451000))
      {
      case 1:
      default:
        throw new IOException("Google Play services not available");
      case 0:
      case 2:
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new GooglePlayServicesNotAvailableException(9);
    }
    String str;
    if (paramBoolean)
      str = "com.google.android.gms.ads.identifier.service.PERSISTENT_START";
    while (true)
    {
      BlockingServiceConnection localBlockingServiceConnection = new BlockingServiceConnection();
      Intent localIntent = new Intent(str);
      localIntent.setPackage("com.google.android.gms");
      try
      {
        boolean bool = ConnectionTracker.getInstance().bindService(paramContext, localIntent, localBlockingServiceConnection, 1);
        if (bool)
        {
          return localBlockingServiceConnection;
          str = "com.google.android.gms.ads.identifier.service.START";
        }
      }
      catch (Throwable localThrowable)
      {
        throw new IOException(localThrowable);
      }
    }
    throw new IOException("Connection failure");
  }

  @VisibleForTesting
  private static zze zza(Context paramContext, BlockingServiceConnection paramBlockingServiceConnection)
    throws IOException
  {
    try
    {
      zze localzze = zzf.zza(paramBlockingServiceConnection.getServiceWithTimeout(10000L, TimeUnit.MILLISECONDS));
      return localzze;
    }
    catch (InterruptedException localInterruptedException)
    {
      throw new IOException("Interrupted exception");
    }
    catch (Throwable localThrowable)
    {
      throw new IOException(localThrowable);
    }
  }

  private final void zza()
  {
    synchronized (this.zzh)
    {
      if (this.zzi != null)
        this.zzi.zzo.countDown();
    }
    try
    {
      this.zzi.join();
      label31: if (this.zzk > 0L)
        this.zzi = new zza(this, this.zzk);
      return;
      localObject2 = finally;
      throw localObject2;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label31;
    }
  }

  @VisibleForTesting
  private final void zza(boolean paramBoolean)
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    Preconditions.checkNotMainThread("Calling this from your main thread can lead to deadlock");
    try
    {
      if (this.zzg)
        finish();
      this.zze = zza(this.mContext, this.zzj);
      this.zzf = zza(this.mContext, this.zze);
      this.zzg = true;
      if (paramBoolean)
        zza();
      return;
    }
    finally
    {
    }
  }

  @VisibleForTesting
  private final boolean zza(Info paramInfo, boolean paramBoolean, float paramFloat, long paramLong, String paramString, Throwable paramThrowable)
  {
    if (Math.random() > paramFloat)
      return false;
    HashMap localHashMap = new HashMap();
    String str1;
    if (paramBoolean)
    {
      str1 = "1";
      localHashMap.put("app_context", str1);
      if (paramInfo != null)
        if (!paramInfo.isLimitAdTrackingEnabled())
          break label206;
    }
    label206: for (String str2 = "1"; ; str2 = "0")
    {
      localHashMap.put("limit_ad_tracking", str2);
      if ((paramInfo != null) && (paramInfo.getId() != null))
        localHashMap.put("ad_id_size", Integer.toString(paramInfo.getId().length()));
      if (paramThrowable != null)
        localHashMap.put("error", paramThrowable.getClass().getName());
      if ((paramString != null) && (!paramString.isEmpty()))
        localHashMap.put("experiment_id", paramString);
      localHashMap.put("tag", "AdvertisingIdClient");
      localHashMap.put("time_spent", Long.toString(paramLong));
      new zza(this, localHashMap).start();
      return true;
      str1 = "0";
      break;
    }
  }

  // ERROR //
  private final boolean zzb()
    throws IOException
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 235	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 54	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   11: ifne +94 -> 105
    //   14: aload_0
    //   15: getfield 38	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzh	Ljava/lang/Object;
    //   18: astore 7
    //   20: aload 7
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 213	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: getfield 213	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   34: getfield 333	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzp	Z
    //   37: ifne +27 -> 64
    //   40: new 62	java/io/IOException
    //   43: dup
    //   44: ldc_w 335
    //   47: invokespecial 158	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: astore 8
    //   53: aload 7
    //   55: monitorexit
    //   56: aload 8
    //   58: athrow
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aload 7
    //   66: monitorexit
    //   67: aload_0
    //   68: iconst_0
    //   69: invokespecial 108	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Z)V
    //   72: aload_0
    //   73: getfield 54	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   76: ifne +29 -> 105
    //   79: new 62	java/io/IOException
    //   82: dup
    //   83: ldc_w 337
    //   86: invokespecial 158	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore 9
    //   92: new 62	java/io/IOException
    //   95: dup
    //   96: ldc_w 337
    //   99: aload 9
    //   101: invokespecial 340	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: aload_0
    //   106: getfield 239	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   109: invokestatic 44	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_0
    //   114: getfield 243	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   117: invokestatic 44	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload_0
    //   122: getfield 243	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   125: invokeinterface 345 1 0
    //   130: istore 6
    //   132: aload_0
    //   133: monitorexit
    //   134: aload_0
    //   135: invokespecial 245	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	()V
    //   138: iload 6
    //   140: ireturn
    //   141: astore 4
    //   143: ldc_w 309
    //   146: ldc_w 347
    //   149: aload 4
    //   151: invokestatic 353	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   154: pop
    //   155: new 62	java/io/IOException
    //   158: dup
    //   159: ldc_w 355
    //   162: invokespecial 158	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   165: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   23	40	51	finally
    //   40	51	51	finally
    //   53	56	51	finally
    //   64	67	51	finally
    //   7	23	59	finally
    //   56	59	59	finally
    //   60	62	59	finally
    //   67	72	59	finally
    //   72	90	59	finally
    //   92	105	59	finally
    //   105	121	59	finally
    //   121	132	59	finally
    //   132	134	59	finally
    //   143	166	59	finally
    //   67	72	90	java/lang/Exception
    //   121	132	141	android/os/RemoteException
  }

  protected void finalize()
    throws Throwable
  {
    finish();
    super.finalize();
  }

  // ERROR //
  public final void finish()
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 235	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 52	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   11: ifnull +10 -> 21
    //   14: aload_0
    //   15: getfield 239	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   18: ifnonnull +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: getfield 54	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   28: ifeq +17 -> 45
    //   31: invokestatic 178	com/google/android/gms/common/stats/ConnectionTracker:getInstance	()Lcom/google/android/gms/common/stats/ConnectionTracker;
    //   34: aload_0
    //   35: getfield 52	com/google/android/gms/ads/identifier/AdvertisingIdClient:mContext	Landroid/content/Context;
    //   38: aload_0
    //   39: getfield 239	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   42: invokevirtual 362	com/google/android/gms/common/stats/ConnectionTracker:unbindService	(Landroid/content/Context;Landroid/content/ServiceConnection;)V
    //   45: aload_0
    //   46: iconst_0
    //   47: putfield 54	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   50: aload_0
    //   51: aconst_null
    //   52: putfield 243	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   55: aload_0
    //   56: aconst_null
    //   57: putfield 239	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   60: aload_0
    //   61: monitorexit
    //   62: return
    //   63: astore_1
    //   64: aload_0
    //   65: monitorexit
    //   66: aload_1
    //   67: athrow
    //   68: astore_2
    //   69: ldc_w 309
    //   72: ldc_w 364
    //   75: aload_2
    //   76: invokestatic 353	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   79: pop
    //   80: goto -35 -> 45
    //
    // Exception table:
    //   from	to	target	type
    //   7	21	63	finally
    //   21	23	63	finally
    //   24	45	63	finally
    //   45	62	63	finally
    //   64	66	63	finally
    //   69	80	63	finally
    //   24	45	68	java/lang/Throwable
  }

  // ERROR //
  @KeepForSdk
  public Info getInfo()
    throws IOException
  {
    // Byte code:
    //   0: ldc 232
    //   2: invokestatic 235	com/google/android/gms/common/internal/Preconditions:checkNotMainThread	(Ljava/lang/String;)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 54	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   11: ifne +94 -> 105
    //   14: aload_0
    //   15: getfield 38	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzh	Ljava/lang/Object;
    //   18: astore 7
    //   20: aload 7
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 213	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   27: ifnull +13 -> 40
    //   30: aload_0
    //   31: getfield 213	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzi	Lcom/google/android/gms/ads/identifier/AdvertisingIdClient$zza;
    //   34: getfield 333	com/google/android/gms/ads/identifier/AdvertisingIdClient$zza:zzp	Z
    //   37: ifne +27 -> 64
    //   40: new 62	java/io/IOException
    //   43: dup
    //   44: ldc_w 335
    //   47: invokespecial 158	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   50: athrow
    //   51: astore 8
    //   53: aload 7
    //   55: monitorexit
    //   56: aload 8
    //   58: athrow
    //   59: astore_1
    //   60: aload_0
    //   61: monitorexit
    //   62: aload_1
    //   63: athrow
    //   64: aload 7
    //   66: monitorexit
    //   67: aload_0
    //   68: iconst_0
    //   69: invokespecial 108	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	(Z)V
    //   72: aload_0
    //   73: getfield 54	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzg	Z
    //   76: ifne +29 -> 105
    //   79: new 62	java/io/IOException
    //   82: dup
    //   83: ldc_w 337
    //   86: invokespecial 158	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: athrow
    //   90: astore 9
    //   92: new 62	java/io/IOException
    //   95: dup
    //   96: ldc_w 337
    //   99: aload 9
    //   101: invokespecial 340	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   104: athrow
    //   105: aload_0
    //   106: getfield 239	com/google/android/gms/ads/identifier/AdvertisingIdClient:zze	Lcom/google/android/gms/common/BlockingServiceConnection;
    //   109: invokestatic 44	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   112: pop
    //   113: aload_0
    //   114: getfield 243	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   117: invokestatic 44	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: new 266	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info
    //   124: dup
    //   125: aload_0
    //   126: getfield 243	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   129: invokeinterface 365 1 0
    //   134: aload_0
    //   135: getfield 243	com/google/android/gms/ads/identifier/AdvertisingIdClient:zzf	Lcom/google/android/gms/internal/ads_identifier/zze;
    //   138: iconst_1
    //   139: invokeinterface 368 2 0
    //   144: invokespecial 371	com/google/android/gms/ads/identifier/AdvertisingIdClient$Info:<init>	(Ljava/lang/String;Z)V
    //   147: astore 4
    //   149: aload_0
    //   150: monitorexit
    //   151: aload_0
    //   152: invokespecial 245	com/google/android/gms/ads/identifier/AdvertisingIdClient:zza	()V
    //   155: aload 4
    //   157: areturn
    //   158: astore 5
    //   160: ldc_w 309
    //   163: ldc_w 347
    //   166: aload 5
    //   168: invokestatic 353	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   171: pop
    //   172: new 62	java/io/IOException
    //   175: dup
    //   176: ldc_w 355
    //   179: invokespecial 158	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   182: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   23	40	51	finally
    //   40	51	51	finally
    //   53	56	51	finally
    //   64	67	51	finally
    //   7	23	59	finally
    //   56	59	59	finally
    //   60	62	59	finally
    //   67	72	59	finally
    //   72	90	59	finally
    //   92	105	59	finally
    //   105	121	59	finally
    //   121	149	59	finally
    //   149	151	59	finally
    //   160	183	59	finally
    //   67	72	90	java/lang/Exception
    //   121	149	158	android/os/RemoteException
  }

  @KeepForSdk
  public void start()
    throws IOException, IllegalStateException, GooglePlayServicesNotAvailableException, GooglePlayServicesRepairableException
  {
    zza(true);
  }

  @KeepForSdkWithMembers
  public static final class Info
  {
    private final String zzq;
    private final boolean zzr;

    public Info(String paramString, boolean paramBoolean)
    {
      this.zzq = paramString;
      this.zzr = paramBoolean;
    }

    public final String getId()
    {
      return this.zzq;
    }

    public final boolean isLimitAdTrackingEnabled()
    {
      return this.zzr;
    }

    public final String toString()
    {
      String str = this.zzq;
      boolean bool = this.zzr;
      return 7 + String.valueOf(str).length() + "{" + str + "}" + bool;
    }
  }

  @VisibleForTesting
  static final class zza extends Thread
  {
    private WeakReference<AdvertisingIdClient> zzm;
    private long zzn;
    CountDownLatch zzo;
    boolean zzp;

    public zza(AdvertisingIdClient paramAdvertisingIdClient, long paramLong)
    {
      this.zzm = new WeakReference(paramAdvertisingIdClient);
      this.zzn = paramLong;
      this.zzo = new CountDownLatch(1);
      this.zzp = false;
      start();
    }

    private final void disconnect()
    {
      AdvertisingIdClient localAdvertisingIdClient = (AdvertisingIdClient)this.zzm.get();
      if (localAdvertisingIdClient != null)
      {
        localAdvertisingIdClient.finish();
        this.zzp = true;
      }
    }

    public final void run()
    {
      try
      {
        if (!this.zzo.await(this.zzn, TimeUnit.MILLISECONDS))
          disconnect();
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        disconnect();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.identifier.AdvertisingIdClient
 * JD-Core Version:    0.6.2
 */