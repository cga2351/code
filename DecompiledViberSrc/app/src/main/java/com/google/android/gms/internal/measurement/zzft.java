package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzft extends zzyc<zzft>
{
  private static volatile zzft[] zzaxb;
  public Integer count = null;
  public String name = null;
  public zzfu[] zzaxc = zzfu.zzna();
  public Long zzaxd = null;
  public Long zzaxe = null;

  public zzft()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzft[] zzmz()
  {
    if (zzaxb == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzaxb == null)
        zzaxb = new zzft[0];
      return zzaxb;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzft localzzft;
    do
    {
      return true;
      if (!(paramObject instanceof zzft))
        return false;
      localzzft = (zzft)paramObject;
      if (!zzyg.equals(this.zzaxc, localzzft.zzaxc))
        return false;
      if (this.name == null)
      {
        if (localzzft.name != null)
          return false;
      }
      else if (!this.name.equals(localzzft.name))
        return false;
      if (this.zzaxd == null)
      {
        if (localzzft.zzaxd != null)
          return false;
      }
      else if (!this.zzaxd.equals(localzzft.zzaxd))
        return false;
      if (this.zzaxe == null)
      {
        if (localzzft.zzaxe != null)
          return false;
      }
      else if (!this.zzaxe.equals(localzzft.zzaxe))
        return false;
      if (this.count == null)
      {
        if (localzzft.count != null)
          return false;
      }
      else if (!this.count.equals(localzzft.count))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzft.zzcev == null) || (localzzft.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzft.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (527 + getClass().getName().hashCode()) + zzyg.hashCode(this.zzaxc));
    int j;
    int m;
    label55: int i1;
    label74: int i3;
    label94: int i4;
    int i5;
    if (this.name == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzaxd != null)
        break label152;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzaxe != null)
        break label164;
      i1 = 0;
      int i2 = 31 * (i1 + n);
      if (this.count != null)
        break label176;
      i3 = 0;
      i4 = 31 * (i3 + i2);
      zzye localzzye = this.zzcev;
      i5 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i5 = 0;
        if (!bool)
          break label188;
      }
    }
    while (true)
    {
      return i4 + i5;
      j = this.name.hashCode();
      break;
      label152: m = this.zzaxd.hashCode();
      break label55;
      label164: i1 = this.zzaxe.hashCode();
      break label74;
      label176: i3 = this.count.hashCode();
      break label94;
      label188: i5 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if ((this.zzaxc != null) && (this.zzaxc.length > 0))
      for (int i = 0; i < this.zzaxc.length; i++)
      {
        zzfu localzzfu = this.zzaxc[i];
        if (localzzfu != null)
          paramzzya.zza(1, localzzfu);
      }
    if (this.name != null)
      paramzzya.zzb(2, this.name);
    if (this.zzaxd != null)
      paramzzya.zzi(3, this.zzaxd.longValue());
    if (this.zzaxe != null)
      paramzzya.zzi(4, this.zzaxe.longValue());
    if (this.count != null)
      paramzzya.zzd(5, this.count.intValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if ((this.zzaxc != null) && (this.zzaxc.length > 0))
      for (int j = 0; j < this.zzaxc.length; j++)
      {
        zzfu localzzfu = this.zzaxc[j];
        if (localzzfu != null)
          i += zzya.zzb(1, localzzfu);
      }
    if (this.name != null)
      i += zzya.zzc(2, this.name);
    if (this.zzaxd != null)
      i += zzya.zzd(3, this.zzaxd.longValue());
    if (this.zzaxe != null)
      i += zzya.zzd(4, this.zzaxe.longValue());
    if (this.count != null)
      i += zzya.zzh(5, this.count.intValue());
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzft
 * JD-Core Version:    0.6.2
 */