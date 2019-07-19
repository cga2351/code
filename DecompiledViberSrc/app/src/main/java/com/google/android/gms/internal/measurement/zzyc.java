package com.google.android.gms.internal.measurement;

import java.io.IOException;

public abstract class zzyc<M extends zzyc<M>> extends zzyi
{
  protected zzye zzcev;

  public final <T> T zza(zzyd<M, T> paramzzyd)
  {
    if (this.zzcev == null);
    zzyf localzzyf;
    do
    {
      return null;
      localzzyf = this.zzcev.zzce(paramzzyd.tag >>> 3);
    }
    while (localzzyf == null);
    return localzzyf.zzb(paramzzyd);
  }

  public void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzcev == null);
    while (true)
    {
      return;
      for (int i = 0; i < this.zzcev.size(); i++)
        this.zzcev.zzcf(i).zza(paramzzya);
    }
  }

  protected final boolean zza(zzxz paramzzxz, int paramInt)
    throws IOException
  {
    int i = paramzzxz.getPosition();
    if (!paramzzxz.zzaq(paramInt))
      return false;
    int j = paramInt >>> 3;
    zzyk localzzyk = new zzyk(paramInt, paramzzxz.zzs(i, paramzzxz.getPosition() - i));
    zzyf localzzyf = null;
    if (this.zzcev == null)
      this.zzcev = new zzye();
    while (true)
    {
      if (localzzyf == null)
      {
        localzzyf = new zzyf();
        this.zzcev.zza(j, localzzyf);
      }
      localzzyf.zza(localzzyk);
      return true;
      localzzyf = this.zzcev.zzce(j);
    }
  }

  protected int zzf()
  {
    int i = 0;
    if (this.zzcev != null)
    {
      j = 0;
      while (i < this.zzcev.size())
      {
        j += this.zzcev.zzcf(i).zzf();
        i++;
      }
    }
    int j = 0;
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzyc
 * JD-Core Version:    0.6.2
 */