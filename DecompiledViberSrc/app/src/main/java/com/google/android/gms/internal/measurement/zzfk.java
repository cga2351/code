package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfk extends zzyc<zzfk>
{
  private static volatile zzfk[] zzavr;
  public zzfn zzavs = null;
  public zzfl zzavt = null;
  public Boolean zzavu = null;
  public String zzavv = null;

  public zzfk()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfk[] zzmt()
  {
    if (zzavr == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzavr == null)
        zzavr = new zzfk[0];
      return zzavr;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfk localzzfk;
    do
    {
      return true;
      if (!(paramObject instanceof zzfk))
        return false;
      localzzfk = (zzfk)paramObject;
      if (this.zzavs == null)
      {
        if (localzzfk.zzavs != null)
          return false;
      }
      else if (!this.zzavs.equals(localzzfk.zzavs))
        return false;
      if (this.zzavt == null)
      {
        if (localzzfk.zzavt != null)
          return false;
      }
      else if (!this.zzavt.equals(localzzfk.zzavt))
        return false;
      if (this.zzavu == null)
      {
        if (localzzfk.zzavu != null)
          return false;
      }
      else if (!this.zzavu.equals(localzzfk.zzavu))
        return false;
      if (this.zzavv == null)
      {
        if (localzzfk.zzavv != null)
          return false;
      }
      else if (!this.zzavv.equals(localzzfk.zzavv))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfk.zzcev == null) || (localzzfk.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfk.zzcev);
  }

  public final int hashCode()
  {
    int i = 527 + getClass().getName().hashCode();
    zzfn localzzfn = this.zzavs;
    int j = i * 31;
    int k;
    zzfl localzzfl;
    int i1;
    label59: int i3;
    label79: int i5;
    label99: int i6;
    int i7;
    if (localzzfn == null)
    {
      k = 0;
      int m = k + j;
      localzzfl = this.zzavt;
      int n = m * 31;
      if (localzzfl != null)
        break label155;
      i1 = 0;
      int i2 = 31 * (i1 + n);
      if (this.zzavu != null)
        break label165;
      i3 = 0;
      int i4 = 31 * (i3 + i2);
      if (this.zzavv != null)
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
      k = localzzfn.hashCode();
      break;
      label155: i1 = localzzfl.hashCode();
      break label59;
      label165: i3 = this.zzavu.hashCode();
      break label79;
      label177: i5 = this.zzavv.hashCode();
      break label99;
      label189: i7 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzavs != null)
      paramzzya.zza(1, this.zzavs);
    if (this.zzavt != null)
      paramzzya.zza(2, this.zzavt);
    if (this.zzavu != null)
      paramzzya.zzb(3, this.zzavu.booleanValue());
    if (this.zzavv != null)
      paramzzya.zzb(4, this.zzavv);
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzavs != null)
      i += zzya.zzb(1, this.zzavs);
    if (this.zzavt != null)
      i += zzya.zzb(2, this.zzavt);
    if (this.zzavu != null)
    {
      this.zzavu.booleanValue();
      i += 1 + zzya.zzbd(3);
    }
    if (this.zzavv != null)
      i += zzya.zzc(4, this.zzavv);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfk
 * JD-Core Version:    0.6.2
 */