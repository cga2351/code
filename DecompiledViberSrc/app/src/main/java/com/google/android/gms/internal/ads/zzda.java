package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadLocalRandom;

public class zzda
{
  private static final ConditionVariable zzve = new ConditionVariable();
  protected static volatile zzwm zzvf = null;
  private static volatile Random zzvh = null;
  private zzdy zzvd;
  protected volatile Boolean zzvg;

  public zzda(zzdy paramzzdy)
  {
    this.zzvd = paramzzdy;
    paramzzdy.zzch().execute(new zzdb(this));
  }

  public static int zzcd()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
        return ThreadLocalRandom.current().nextInt();
      int i = zzce().nextInt();
      return i;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return zzce().nextInt();
  }

  private static Random zzce()
  {
    if (zzvh == null);
    try
    {
      if (zzvh == null)
        zzvh = new Random();
      return zzvh;
    }
    finally
    {
    }
  }

  public final void zza(int paramInt1, int paramInt2, long paramLong)
  {
    zza(paramInt1, paramInt2, paramLong, null);
  }

  public final void zza(int paramInt1, int paramInt2, long paramLong, Exception paramException)
  {
    try
    {
      zzve.block();
      if ((this.zzvg.booleanValue()) && (zzvf != null))
      {
        zzbi.zza.zza localzza = zzbi.zza.zzs().zzl(this.zzvd.zzlj.getPackageName()).zzd(paramLong);
        if (paramException != null)
        {
          StringWriter localStringWriter = new StringWriter();
          zzdma.zza(paramException, new PrintWriter(localStringWriter));
          localzza.zzm(localStringWriter.toString()).zzn(paramException.getClass().getName());
        }
        zzwq localzzwq = zzvf.zzg(((zzbi.zza)localzza.zzaya()).toByteArray());
        localzzwq.zzby(paramInt1);
        if (paramInt2 != -1)
          localzzwq.zzbx(paramInt2);
        localzzwq.zzdj();
      }
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzda
 * JD-Core Version:    0.6.2
 */