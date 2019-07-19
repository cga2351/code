package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfq extends zzyc<zzfq>
{
  private static volatile zzfq[] zzawt;
  public String value = null;
  public String zzoj = null;

  public zzfq()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfq[] zzmw()
  {
    if (zzawt == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzawt == null)
        zzawt = new zzfq[0];
      return zzawt;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfq localzzfq;
    do
    {
      return true;
      if (!(paramObject instanceof zzfq))
        return false;
      localzzfq = (zzfq)paramObject;
      if (this.zzoj == null)
      {
        if (localzzfq.zzoj != null)
          return false;
      }
      else if (!this.zzoj.equals(localzzfq.zzoj))
        return false;
      if (this.value == null)
      {
        if (localzzfq.value != null)
          return false;
      }
      else if (!this.value.equals(localzzfq.value))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfq.zzcev == null) || (localzzfq.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfq.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int n;
    int i1;
    if (this.zzoj == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.value != null)
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
      j = this.zzoj.hashCode();
      break;
      label101: m = this.value.hashCode();
      break label44;
      label113: i1 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzoj != null)
      paramzzya.zzb(1, this.zzoj);
    if (this.value != null)
      paramzzya.zzb(2, this.value);
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzoj != null)
      i += zzya.zzc(1, this.zzoj);
    if (this.value != null)
      i += zzya.zzc(2, this.value);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfq
 * JD-Core Version:    0.6.2
 */