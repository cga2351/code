package com.google.android.gms.common.config;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.HashSet;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public abstract class GservicesValue<T>
{
  private static final Object sLock = new Object();
  private static zza zzbl = null;
  private static int zzbm = 0;
  private static Context zzbn;

  @GuardedBy("sLock")
  private static HashSet<String> zzbo;
  protected final String mKey;
  protected final T zzbp;
  private T zzbq = null;

  protected GservicesValue(String paramString, T paramT)
  {
    this.mKey = paramString;
    this.zzbp = paramT;
  }

  @KeepForSdk
  public static boolean isInitialized()
  {
    synchronized (sLock)
    {
      return false;
    }
  }

  @KeepForSdk
  public static GservicesValue<Float> value(String paramString, Float paramFloat)
  {
    return new zzd(paramString, paramFloat);
  }

  @KeepForSdk
  public static GservicesValue<Integer> value(String paramString, Integer paramInteger)
  {
    return new zzc(paramString, paramInteger);
  }

  @KeepForSdk
  public static GservicesValue<Long> value(String paramString, Long paramLong)
  {
    return new zzb(paramString, paramLong);
  }

  @KeepForSdk
  public static GservicesValue<String> value(String paramString1, String paramString2)
  {
    return new zze(paramString1, paramString2);
  }

  @KeepForSdk
  public static GservicesValue<Boolean> value(String paramString, boolean paramBoolean)
  {
    return new zza(paramString, Boolean.valueOf(paramBoolean));
  }

  private static boolean zzi()
  {
    synchronized (sLock)
    {
      return false;
    }
  }

  // ERROR //
  @KeepForSdk
  public final T get()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 38	com/google/android/gms/common/config/GservicesValue:zzbq	Ljava/lang/Object;
    //   4: ifnull +8 -> 12
    //   7: aload_0
    //   8: getfield 38	com/google/android/gms/common/config/GservicesValue:zzbq	Ljava/lang/Object;
    //   11: areturn
    //   12: invokestatic 91	android/os/StrictMode:allowThreadDiskReads	()Landroid/os/StrictMode$ThreadPolicy;
    //   15: astore_1
    //   16: getstatic 31	com/google/android/gms/common/config/GservicesValue:sLock	Ljava/lang/Object;
    //   19: astore_2
    //   20: aload_2
    //   21: monitorenter
    //   22: aload_2
    //   23: monitorexit
    //   24: getstatic 31	com/google/android/gms/common/config/GservicesValue:sLock	Ljava/lang/Object;
    //   27: astore 4
    //   29: aload 4
    //   31: monitorenter
    //   32: aconst_null
    //   33: putstatic 93	com/google/android/gms/common/config/GservicesValue:zzbo	Ljava/util/HashSet;
    //   36: aconst_null
    //   37: putstatic 95	com/google/android/gms/common/config/GservicesValue:zzbn	Landroid/content/Context;
    //   40: aload 4
    //   42: monitorexit
    //   43: aload_0
    //   44: aload_0
    //   45: getfield 40	com/google/android/gms/common/config/GservicesValue:mKey	Ljava/lang/String;
    //   48: invokevirtual 99	com/google/android/gms/common/config/GservicesValue:zzd	(Ljava/lang/String;)Ljava/lang/Object;
    //   51: astore 12
    //   53: aload_1
    //   54: invokestatic 103	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   57: aload 12
    //   59: areturn
    //   60: astore_3
    //   61: aload_2
    //   62: monitorexit
    //   63: aload_3
    //   64: athrow
    //   65: astore 5
    //   67: aload 4
    //   69: monitorexit
    //   70: aload 5
    //   72: athrow
    //   73: astore 7
    //   75: invokestatic 109	android/os/Binder:clearCallingIdentity	()J
    //   78: lstore 8
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 40	com/google/android/gms/common/config/GservicesValue:mKey	Ljava/lang/String;
    //   85: invokevirtual 99	com/google/android/gms/common/config/GservicesValue:zzd	(Ljava/lang/String;)Ljava/lang/Object;
    //   88: astore 11
    //   90: lload 8
    //   92: invokestatic 113	android/os/Binder:restoreCallingIdentity	(J)V
    //   95: aload_1
    //   96: invokestatic 103	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   99: aload 11
    //   101: areturn
    //   102: astore 10
    //   104: lload 8
    //   106: invokestatic 113	android/os/Binder:restoreCallingIdentity	(J)V
    //   109: aload 10
    //   111: athrow
    //   112: astore 6
    //   114: aload_1
    //   115: invokestatic 103	android/os/StrictMode:setThreadPolicy	(Landroid/os/StrictMode$ThreadPolicy;)V
    //   118: aload 6
    //   120: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   22	24	60	finally
    //   61	63	60	finally
    //   32	43	65	finally
    //   67	70	65	finally
    //   43	53	73	java/lang/SecurityException
    //   80	90	102	finally
    //   43	53	112	finally
    //   75	80	112	finally
    //   90	95	112	finally
    //   104	112	112	finally
  }

  @Deprecated
  @KeepForSdk
  public final T getBinderSafe()
  {
    return get();
  }

  @KeepForSdk
  @VisibleForTesting
  public void override(T paramT)
  {
    Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
    this.zzbq = paramT;
    synchronized (sLock)
    {
      zzi();
      return;
    }
  }

  @KeepForSdk
  @VisibleForTesting
  public void resetOverride()
  {
    this.zzbq = null;
  }

  protected abstract T zzd(String paramString);

  private static abstract interface zza
  {
    public abstract Long getLong(String paramString, Long paramLong);

    public abstract String getString(String paramString1, String paramString2);

    public abstract Boolean zza(String paramString, Boolean paramBoolean);

    public abstract Float zza(String paramString, Float paramFloat);

    public abstract Integer zza(String paramString, Integer paramInteger);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.config.GservicesValue
 * JD-Core Version:    0.6.2
 */