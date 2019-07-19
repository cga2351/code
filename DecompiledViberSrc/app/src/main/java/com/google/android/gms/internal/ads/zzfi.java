package com.google.android.gms.internal.ads;

import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class zzfi
{
  private static final String TAG = zzfi.class.getSimpleName();
  private final String className;
  private final zzdy zzvd;
  private final String zzzu;
  private final int zzzv = 2;
  private volatile Method zzzw = null;
  private final Class<?>[] zzzx;
  private CountDownLatch zzzy = new CountDownLatch(1);

  public zzfi(zzdy paramzzdy, String paramString1, String paramString2, Class<?>[] paramArrayOfClass)
  {
    this.zzvd = paramzzdy;
    this.className = paramString1;
    this.zzzu = paramString2;
    this.zzzx = paramArrayOfClass;
    this.zzvd.zzch().submit(new zzfj(this));
  }

  private final String zzb(byte[] paramArrayOfByte, String paramString)
    throws zzdk, UnsupportedEncodingException
  {
    return new String(this.zzvd.zzcj().zza(paramArrayOfByte, paramString), "UTF-8");
  }

  private final void zzdb()
  {
    try
    {
      Class localClass = this.zzvd.zzci().loadClass(zzb(this.zzvd.zzck(), this.className));
      if (localClass == null)
        return;
      this.zzzw = localClass.getMethod(zzb(this.zzvd.zzck(), this.zzzu), this.zzzx);
      Method localMethod = this.zzzw;
      if (localMethod == null)
        return;
      return;
    }
    catch (zzdk localzzdk)
    {
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    finally
    {
      this.zzzy.countDown();
    }
  }

  public final Method zzdc()
  {
    Method localMethod1;
    if (this.zzzw != null)
      localMethod1 = this.zzzw;
    while (true)
    {
      return localMethod1;
      try
      {
        boolean bool = this.zzzy.await(2L, TimeUnit.SECONDS);
        localMethod1 = null;
        if (bool)
        {
          Method localMethod2 = this.zzzw;
          return localMethod2;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzfi
 * JD-Core Version:    0.6.2
 */