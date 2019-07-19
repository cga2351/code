package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfz extends zzyc<zzfz>
{
  private static volatile zzfz[] zzayv;
  public String name = null;
  public String zzamn = null;
  private Float zzauo = null;
  public Double zzaup = null;
  public Long zzaxg = null;
  public Long zzayw = null;

  public zzfz()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfz[] zznd()
  {
    if (zzayv == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzayv == null)
        zzayv = new zzfz[0];
      return zzayv;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfz localzzfz;
    do
    {
      return true;
      if (!(paramObject instanceof zzfz))
        return false;
      localzzfz = (zzfz)paramObject;
      if (this.zzayw == null)
      {
        if (localzzfz.zzayw != null)
          return false;
      }
      else if (!this.zzayw.equals(localzzfz.zzayw))
        return false;
      if (this.name == null)
      {
        if (localzzfz.name != null)
          return false;
      }
      else if (!this.name.equals(localzzfz.name))
        return false;
      if (this.zzamn == null)
      {
        if (localzzfz.zzamn != null)
          return false;
      }
      else if (!this.zzamn.equals(localzzfz.zzamn))
        return false;
      if (this.zzaxg == null)
      {
        if (localzzfz.zzaxg != null)
          return false;
      }
      else if (!this.zzaxg.equals(localzzfz.zzaxg))
        return false;
      if (this.zzauo == null)
      {
        if (localzzfz.zzauo != null)
          return false;
      }
      else if (!this.zzauo.equals(localzzfz.zzauo))
        return false;
      if (this.zzaup == null)
      {
        if (localzzfz.zzaup != null)
          return false;
      }
      else if (!this.zzaup.equals(localzzfz.zzaup))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfz.zzcev == null) || (localzzfz.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfz.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label63: int i3;
    label83: int i5;
    label103: int i7;
    label123: int i8;
    int i9;
    if (this.zzayw == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.name != null)
        break label181;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzamn != null)
        break label193;
      i1 = 0;
      int i2 = 31 * (i1 + n);
      if (this.zzaxg != null)
        break label205;
      i3 = 0;
      int i4 = 31 * (i3 + i2);
      if (this.zzauo != null)
        break label217;
      i5 = 0;
      int i6 = 31 * (i5 + i4);
      if (this.zzaup != null)
        break label229;
      i7 = 0;
      i8 = 31 * (i7 + i6);
      zzye localzzye = this.zzcev;
      i9 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i9 = 0;
        if (!bool)
          break label241;
      }
    }
    while (true)
    {
      return i8 + i9;
      j = this.zzayw.hashCode();
      break;
      label181: m = this.name.hashCode();
      break label44;
      label193: i1 = this.zzamn.hashCode();
      break label63;
      label205: i3 = this.zzaxg.hashCode();
      break label83;
      label217: i5 = this.zzauo.hashCode();
      break label103;
      label229: i7 = this.zzaup.hashCode();
      break label123;
      label241: i9 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzayw != null)
      paramzzya.zzi(1, this.zzayw.longValue());
    if (this.name != null)
      paramzzya.zzb(2, this.name);
    if (this.zzamn != null)
      paramzzya.zzb(3, this.zzamn);
    if (this.zzaxg != null)
      paramzzya.zzi(4, this.zzaxg.longValue());
    if (this.zzauo != null)
      paramzzya.zza(5, this.zzauo.floatValue());
    if (this.zzaup != null)
      paramzzya.zza(6, this.zzaup.doubleValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzayw != null)
      i += zzya.zzd(1, this.zzayw.longValue());
    if (this.name != null)
      i += zzya.zzc(2, this.name);
    if (this.zzamn != null)
      i += zzya.zzc(3, this.zzamn);
    if (this.zzaxg != null)
      i += zzya.zzd(4, this.zzaxg.longValue());
    if (this.zzauo != null)
    {
      this.zzauo.floatValue();
      i += 4 + zzya.zzbd(5);
    }
    if (this.zzaup != null)
    {
      this.zzaup.doubleValue();
      i += 8 + zzya.zzbd(6);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfz
 * JD-Core Version:    0.6.2
 */