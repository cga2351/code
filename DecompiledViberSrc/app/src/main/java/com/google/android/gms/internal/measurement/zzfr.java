package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfr extends zzyc<zzfr>
{
  private static volatile zzfr[] zzawu;
  public Integer zzavg = null;
  public zzfx zzawv = null;
  public zzfx zzaww = null;
  public Boolean zzawx = null;

  public zzfr()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfr[] zzmx()
  {
    if (zzawu == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzawu == null)
        zzawu = new zzfr[0];
      return zzawu;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfr localzzfr;
    do
    {
      return true;
      if (!(paramObject instanceof zzfr))
        return false;
      localzzfr = (zzfr)paramObject;
      if (this.zzavg == null)
      {
        if (localzzfr.zzavg != null)
          return false;
      }
      else if (!this.zzavg.equals(localzzfr.zzavg))
        return false;
      if (this.zzawv == null)
      {
        if (localzzfr.zzawv != null)
          return false;
      }
      else if (!this.zzawv.equals(localzzfr.zzawv))
        return false;
      if (this.zzaww == null)
      {
        if (localzzfr.zzaww != null)
          return false;
      }
      else if (!this.zzaww.equals(localzzfr.zzaww))
        return false;
      if (this.zzawx == null)
      {
        if (localzzfr.zzawx != null)
          return false;
      }
      else if (!this.zzawx.equals(localzzfr.zzawx))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfr.zzcev == null) || (localzzfr.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfr.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    zzfx localzzfx1;
    int n;
    label51: zzfx localzzfx2;
    int i3;
    label79: int i5;
    label99: int i6;
    int i7;
    if (this.zzavg == null)
    {
      j = 0;
      int k = j + i;
      localzzfx1 = this.zzawv;
      int m = k * 31;
      if (localzzfx1 != null)
        break label157;
      n = 0;
      int i1 = n + m;
      localzzfx2 = this.zzaww;
      int i2 = i1 * 31;
      if (localzzfx2 != null)
        break label167;
      i3 = 0;
      int i4 = 31 * (i3 + i2);
      if (this.zzawx != null)
        break label177;
      i5 = 0;
      i6 = 31 * (i5 + i4);
      zzye localzzye = this.zzcev;
      i7 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i7 = 0;
        if (!bool)
          break label189;
      }
    }
    while (true)
    {
      return i6 + i7;
      j = this.zzavg.hashCode();
      break;
      label157: n = localzzfx1.hashCode();
      break label51;
      label167: i3 = localzzfx2.hashCode();
      break label79;
      label177: i5 = this.zzawx.hashCode();
      break label99;
      label189: i7 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzavg != null)
      paramzzya.zzd(1, this.zzavg.intValue());
    if (this.zzawv != null)
      paramzzya.zza(2, this.zzawv);
    if (this.zzaww != null)
      paramzzya.zza(3, this.zzaww);
    if (this.zzawx != null)
      paramzzya.zzb(4, this.zzawx.booleanValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzavg != null)
      i += zzya.zzh(1, this.zzavg.intValue());
    if (this.zzawv != null)
      i += zzya.zzb(2, this.zzawv);
    if (this.zzaww != null)
      i += zzya.zzb(3, this.zzaww);
    if (this.zzawx != null)
    {
      this.zzawx.booleanValue();
      i += 1 + zzya.zzbd(4);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfr
 * JD-Core Version:    0.6.2
 */