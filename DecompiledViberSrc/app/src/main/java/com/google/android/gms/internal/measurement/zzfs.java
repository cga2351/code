package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfs extends zzyc<zzfs>
{
  private static volatile zzfs[] zzawy;
  public Integer zzawz = null;
  public Long zzaxa = null;

  public zzfs()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfs[] zzmy()
  {
    if (zzawy == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzawy == null)
        zzawy = new zzfs[0];
      return zzawy;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfs localzzfs;
    do
    {
      return true;
      if (!(paramObject instanceof zzfs))
        return false;
      localzzfs = (zzfs)paramObject;
      if (this.zzawz == null)
      {
        if (localzzfs.zzawz != null)
          return false;
      }
      else if (!this.zzawz.equals(localzzfs.zzawz))
        return false;
      if (this.zzaxa == null)
      {
        if (localzzfs.zzaxa != null)
          return false;
      }
      else if (!this.zzaxa.equals(localzzfs.zzaxa))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfs.zzcev == null) || (localzzfs.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfs.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int n;
    int i1;
    if (this.zzawz == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzaxa != null)
        break label101;
      m = 0;
      n = 31 * (m + k);
      zzye localzzye = this.zzcev;
      i1 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i1 = 0;
        if (!bool)
          break label113;
      }
    }
    while (true)
    {
      return n + i1;
      j = this.zzawz.hashCode();
      break;
      label101: m = this.zzaxa.hashCode();
      break label44;
      label113: i1 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzawz != null)
      paramzzya.zzd(1, this.zzawz.intValue());
    if (this.zzaxa != null)
      paramzzya.zzi(2, this.zzaxa.longValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzawz != null)
      i += zzya.zzh(1, this.zzawz.intValue());
    if (this.zzaxa != null)
      i += zzya.zzd(2, this.zzaxa.longValue());
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfs
 * JD-Core Version:    0.6.2
 */