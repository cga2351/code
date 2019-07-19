package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfo extends zzyc<zzfo>
{
  private static volatile zzfo[] zzawi;
  public String name = null;
  public Boolean zzawj = null;
  public Boolean zzawk = null;
  public Integer zzawl = null;

  public zzfo()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfo[] zzmv()
  {
    if (zzawi == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzawi == null)
        zzawi = new zzfo[0];
      return zzawi;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfo localzzfo;
    do
    {
      return true;
      if (!(paramObject instanceof zzfo))
        return false;
      localzzfo = (zzfo)paramObject;
      if (this.name == null)
      {
        if (localzzfo.name != null)
          return false;
      }
      else if (!this.name.equals(localzzfo.name))
        return false;
      if (this.zzawj == null)
      {
        if (localzzfo.zzawj != null)
          return false;
      }
      else if (!this.zzawj.equals(localzzfo.zzawj))
        return false;
      if (this.zzawk == null)
      {
        if (localzzfo.zzawk != null)
          return false;
      }
      else if (!this.zzawk.equals(localzzfo.zzawk))
        return false;
      if (this.zzawl == null)
      {
        if (localzzfo.zzawl != null)
          return false;
      }
      else if (!this.zzawl.equals(localzzfo.zzawl))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfo.zzcev == null) || (localzzfo.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfo.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label63: int i3;
    label83: int i4;
    int i5;
    if (this.name == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzawj != null)
        break label141;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzawk != null)
        break label153;
      i1 = 0;
      int i2 = 31 * (i1 + n);
      if (this.zzawl != null)
        break label165;
      i3 = 0;
      i4 = 31 * (i3 + i2);
      zzye localzzye = this.zzcev;
      i5 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i5 = 0;
        if (!bool)
          break label177;
      }
    }
    while (true)
    {
      return i4 + i5;
      j = this.name.hashCode();
      break;
      label141: m = this.zzawj.hashCode();
      break label44;
      label153: i1 = this.zzawk.hashCode();
      break label63;
      label165: i3 = this.zzawl.hashCode();
      break label83;
      label177: i5 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.name != null)
      paramzzya.zzb(1, this.name);
    if (this.zzawj != null)
      paramzzya.zzb(2, this.zzawj.booleanValue());
    if (this.zzawk != null)
      paramzzya.zzb(3, this.zzawk.booleanValue());
    if (this.zzawl != null)
      paramzzya.zzd(4, this.zzawl.intValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.name != null)
      i += zzya.zzc(1, this.name);
    if (this.zzawj != null)
    {
      this.zzawj.booleanValue();
      i += 1 + zzya.zzbd(2);
    }
    if (this.zzawk != null)
    {
      this.zzawk.booleanValue();
      i += 1 + zzya.zzbd(3);
    }
    if (this.zzawl != null)
      i += zzya.zzh(4, this.zzawl.intValue());
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfo
 * JD-Core Version:    0.6.2
 */