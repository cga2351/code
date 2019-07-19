package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfu extends zzyc<zzfu>
{
  private static volatile zzfu[] zzaxf;
  public String name = null;
  public String zzamn = null;
  private Float zzauo = null;
  public Double zzaup = null;
  public Long zzaxg = null;

  public zzfu()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfu[] zzna()
  {
    if (zzaxf == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzaxf == null)
        zzaxf = new zzfu[0];
      return zzaxf;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfu localzzfu;
    do
    {
      return true;
      if (!(paramObject instanceof zzfu))
        return false;
      localzzfu = (zzfu)paramObject;
      if (this.name == null)
      {
        if (localzzfu.name != null)
          return false;
      }
      else if (!this.name.equals(localzzfu.name))
        return false;
      if (this.zzamn == null)
      {
        if (localzzfu.zzamn != null)
          return false;
      }
      else if (!this.zzamn.equals(localzzfu.zzamn))
        return false;
      if (this.zzaxg == null)
      {
        if (localzzfu.zzaxg != null)
          return false;
      }
      else if (!this.zzaxg.equals(localzzfu.zzaxg))
        return false;
      if (this.zzauo == null)
      {
        if (localzzfu.zzauo != null)
          return false;
      }
      else if (!this.zzauo.equals(localzzfu.zzauo))
        return false;
      if (this.zzaup == null)
      {
        if (localzzfu.zzaup != null)
          return false;
      }
      else if (!this.zzaup.equals(localzzfu.zzaup))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfu.zzcev == null) || (localzzfu.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfu.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label63: int i3;
    label83: int i5;
    label103: int i6;
    int i7;
    if (this.name == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzamn != null)
        break label161;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzaxg != null)
        break label173;
      i1 = 0;
      int i2 = 31 * (i1 + n);
      if (this.zzauo != null)
        break label185;
      i3 = 0;
      int i4 = 31 * (i3 + i2);
      if (this.zzaup != null)
        break label197;
      i5 = 0;
      i6 = 31 * (i5 + i4);
      zzye localzzye = this.zzcev;
      i7 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i7 = 0;
        if (!bool)
          break label209;
      }
    }
    while (true)
    {
      return i6 + i7;
      j = this.name.hashCode();
      break;
      label161: m = this.zzamn.hashCode();
      break label44;
      label173: i1 = this.zzaxg.hashCode();
      break label63;
      label185: i3 = this.zzauo.hashCode();
      break label83;
      label197: i5 = this.zzaup.hashCode();
      break label103;
      label209: i7 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.name != null)
      paramzzya.zzb(1, this.name);
    if (this.zzamn != null)
      paramzzya.zzb(2, this.zzamn);
    if (this.zzaxg != null)
      paramzzya.zzi(3, this.zzaxg.longValue());
    if (this.zzauo != null)
      paramzzya.zza(4, this.zzauo.floatValue());
    if (this.zzaup != null)
      paramzzya.zza(5, this.zzaup.doubleValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.name != null)
      i += zzya.zzc(1, this.name);
    if (this.zzamn != null)
      i += zzya.zzc(2, this.zzamn);
    if (this.zzaxg != null)
      i += zzya.zzd(3, this.zzaxg.longValue());
    if (this.zzauo != null)
    {
      this.zzauo.floatValue();
      i += 4 + zzya.zzbd(4);
    }
    if (this.zzaup != null)
    {
      this.zzaup.doubleValue();
      i += 8 + zzya.zzbd(5);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfu
 * JD-Core Version:    0.6.2
 */