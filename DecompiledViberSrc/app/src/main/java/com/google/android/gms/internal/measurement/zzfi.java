package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfi extends zzyc<zzfi>
{
  private static volatile zzfi[] zzavf;
  public Integer zzavg = null;
  public zzfm[] zzavh = zzfm.zzmu();
  public zzfj[] zzavi = zzfj.zzms();
  private Boolean zzavj = null;
  private Boolean zzavk = null;

  public zzfi()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfi[] zzmr()
  {
    if (zzavf == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzavf == null)
        zzavf = new zzfi[0];
      return zzavf;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfi localzzfi;
    do
    {
      return true;
      if (!(paramObject instanceof zzfi))
        return false;
      localzzfi = (zzfi)paramObject;
      if (this.zzavg == null)
      {
        if (localzzfi.zzavg != null)
          return false;
      }
      else if (!this.zzavg.equals(localzzfi.zzavg))
        return false;
      if (!zzyg.equals(this.zzavh, localzzfi.zzavh))
        return false;
      if (!zzyg.equals(this.zzavi, localzzfi.zzavi))
        return false;
      if (this.zzavj == null)
      {
        if (localzzfi.zzavj != null)
          return false;
      }
      else if (!this.zzavj.equals(localzzfi.zzavj))
        return false;
      if (this.zzavk == null)
      {
        if (localzzfi.zzavk != null)
          return false;
      }
      else if (!this.zzavk.equals(localzzfi.zzavk))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfi.zzcev == null) || (localzzfi.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfi.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label66: int i1;
    label85: int i2;
    int i3;
    if (this.zzavg == null)
    {
      j = 0;
      int k = 31 * (31 * (31 * (j + i) + zzyg.hashCode(this.zzavh)) + zzyg.hashCode(this.zzavi));
      if (this.zzavj != null)
        break label143;
      m = 0;
      int n = 31 * (m + k);
      if (this.zzavk != null)
        break label155;
      i1 = 0;
      i2 = 31 * (i1 + n);
      zzye localzzye = this.zzcev;
      i3 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i3 = 0;
        if (!bool)
          break label167;
      }
    }
    while (true)
    {
      return i2 + i3;
      j = this.zzavg.hashCode();
      break;
      label143: m = this.zzavj.hashCode();
      break label66;
      label155: i1 = this.zzavk.hashCode();
      break label85;
      label167: i3 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzavg != null)
      paramzzya.zzd(1, this.zzavg.intValue());
    if ((this.zzavh != null) && (this.zzavh.length > 0))
      for (int k = 0; k < this.zzavh.length; k++)
      {
        zzfm localzzfm = this.zzavh[k];
        if (localzzfm != null)
          paramzzya.zza(2, localzzfm);
      }
    if (this.zzavi != null)
    {
      int i = this.zzavi.length;
      int j = 0;
      if (i > 0)
        while (j < this.zzavi.length)
        {
          zzfj localzzfj = this.zzavi[j];
          if (localzzfj != null)
            paramzzya.zza(3, localzzfj);
          j++;
        }
    }
    if (this.zzavj != null)
      paramzzya.zzb(4, this.zzavj.booleanValue());
    if (this.zzavk != null)
      paramzzya.zzb(5, this.zzavk.booleanValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzavg != null)
      i += zzya.zzh(1, this.zzavg.intValue());
    if ((this.zzavh != null) && (this.zzavh.length > 0))
    {
      int m = i;
      for (int n = 0; n < this.zzavh.length; n++)
      {
        zzfm localzzfm = this.zzavh[n];
        if (localzzfm != null)
          m += zzya.zzb(2, localzzfm);
      }
      i = m;
    }
    if (this.zzavi != null)
    {
      int j = this.zzavi.length;
      int k = 0;
      if (j > 0)
        while (k < this.zzavi.length)
        {
          zzfj localzzfj = this.zzavi[k];
          if (localzzfj != null)
            i += zzya.zzb(3, localzzfj);
          k++;
        }
    }
    if (this.zzavj != null)
    {
      this.zzavj.booleanValue();
      i += 1 + zzya.zzbd(4);
    }
    if (this.zzavk != null)
    {
      this.zzavk.booleanValue();
      i += 1 + zzya.zzbd(5);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfi
 * JD-Core Version:    0.6.2
 */