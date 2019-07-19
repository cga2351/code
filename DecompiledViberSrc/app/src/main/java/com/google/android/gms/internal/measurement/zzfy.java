package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfy extends zzyc<zzfy>
{
  private static volatile zzfy[] zzayt;
  public Integer zzawz = null;
  public long[] zzayu = zzyl.zzcfk;

  public zzfy()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfy[] zznc()
  {
    if (zzayt == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzayt == null)
        zzayt = new zzfy[0];
      return zzayt;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfy localzzfy;
    do
    {
      return true;
      if (!(paramObject instanceof zzfy))
        return false;
      localzzfy = (zzfy)paramObject;
      if (this.zzawz == null)
      {
        if (localzzfy.zzawz != null)
          return false;
      }
      else if (!this.zzawz.equals(localzzfy.zzawz))
        return false;
      if (!zzyg.equals(this.zzayu, localzzfy.zzayu))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfy.zzcev == null) || (localzzfy.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfy.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int k;
    int m;
    if (this.zzawz == null)
    {
      j = 0;
      k = 31 * (31 * (j + i) + zzyg.hashCode(this.zzayu));
      zzye localzzye = this.zzcev;
      m = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        m = 0;
        if (!bool)
          break label92;
      }
    }
    while (true)
    {
      return k + m;
      j = this.zzawz.hashCode();
      break;
      label92: m = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzawz != null)
      paramzzya.zzd(1, this.zzawz.intValue());
    if ((this.zzayu != null) && (this.zzayu.length > 0))
      for (int i = 0; i < this.zzayu.length; i++)
        paramzzya.zzi(2, this.zzayu[i]);
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = 0;
    int j = super.zzf();
    if (this.zzawz != null)
      j += zzya.zzh(1, this.zzawz.intValue());
    if ((this.zzayu != null) && (this.zzayu.length > 0))
    {
      int k = 0;
      while (i < this.zzayu.length)
      {
        k += zzya.zzbg(this.zzayu[i]);
        i++;
      }
      j = j + k + 1 * this.zzayu.length;
    }
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfy
 * JD-Core Version:    0.6.2
 */