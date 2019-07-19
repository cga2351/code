package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfj extends zzyc<zzfj>
{
  private static volatile zzfj[] zzavl;
  public Boolean zzavj = null;
  public Boolean zzavk = null;
  public Integer zzavm = null;
  public String zzavn = null;
  public zzfk[] zzavo = zzfk.zzmt();
  private Boolean zzavp = null;
  public zzfl zzavq = null;

  public zzfj()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfj[] zzms()
  {
    if (zzavl == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzavl == null)
        zzavl = new zzfj[0];
      return zzavl;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfj localzzfj;
    do
    {
      return true;
      if (!(paramObject instanceof zzfj))
        return false;
      localzzfj = (zzfj)paramObject;
      if (this.zzavm == null)
      {
        if (localzzfj.zzavm != null)
          return false;
      }
      else if (!this.zzavm.equals(localzzfj.zzavm))
        return false;
      if (this.zzavn == null)
      {
        if (localzzfj.zzavn != null)
          return false;
      }
      else if (!this.zzavn.equals(localzzfj.zzavn))
        return false;
      if (!zzyg.equals(this.zzavo, localzzfj.zzavo))
        return false;
      if (this.zzavp == null)
      {
        if (localzzfj.zzavp != null)
          return false;
      }
      else if (!this.zzavp.equals(localzzfj.zzavp))
        return false;
      if (this.zzavq == null)
      {
        if (localzzfj.zzavq != null)
          return false;
      }
      else if (!this.zzavq.equals(localzzfj.zzavq))
        return false;
      if (this.zzavj == null)
      {
        if (localzzfj.zzavj != null)
          return false;
      }
      else if (!this.zzavj.equals(localzzfj.zzavj))
        return false;
      if (this.zzavk == null)
      {
        if (localzzfj.zzavk != null)
          return false;
      }
      else if (!this.zzavk.equals(localzzfj.zzavk))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfj.zzcev == null) || (localzzfj.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfj.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: int i1;
    label74: zzfl localzzfl;
    int i4;
    label102: int i6;
    label122: int i8;
    label142: int i9;
    int i10;
    if (this.zzavm == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzavn != null)
        break label200;
      m = 0;
      int n = 31 * (31 * (m + k) + zzyg.hashCode(this.zzavo));
      if (this.zzavp != null)
        break label212;
      i1 = 0;
      int i2 = i1 + n;
      localzzfl = this.zzavq;
      int i3 = i2 * 31;
      if (localzzfl != null)
        break label224;
      i4 = 0;
      int i5 = 31 * (i4 + i3);
      if (this.zzavj != null)
        break label234;
      i6 = 0;
      int i7 = 31 * (i6 + i5);
      if (this.zzavk != null)
        break label246;
      i8 = 0;
      i9 = 31 * (i8 + i7);
      zzye localzzye = this.zzcev;
      i10 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i10 = 0;
        if (!bool)
          break label258;
      }
    }
    while (true)
    {
      return i9 + i10;
      j = this.zzavm.hashCode();
      break;
      label200: m = this.zzavn.hashCode();
      break label44;
      label212: i1 = this.zzavp.hashCode();
      break label74;
      label224: i4 = localzzfl.hashCode();
      break label102;
      label234: i6 = this.zzavj.hashCode();
      break label122;
      label246: i8 = this.zzavk.hashCode();
      break label142;
      label258: i10 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzavm != null)
      paramzzya.zzd(1, this.zzavm.intValue());
    if (this.zzavn != null)
      paramzzya.zzb(2, this.zzavn);
    if ((this.zzavo != null) && (this.zzavo.length > 0))
      for (int i = 0; i < this.zzavo.length; i++)
      {
        zzfk localzzfk = this.zzavo[i];
        if (localzzfk != null)
          paramzzya.zza(3, localzzfk);
      }
    if (this.zzavp != null)
      paramzzya.zzb(4, this.zzavp.booleanValue());
    if (this.zzavq != null)
      paramzzya.zza(5, this.zzavq);
    if (this.zzavj != null)
      paramzzya.zzb(6, this.zzavj.booleanValue());
    if (this.zzavk != null)
      paramzzya.zzb(7, this.zzavk.booleanValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzavm != null)
      i += zzya.zzh(1, this.zzavm.intValue());
    if (this.zzavn != null)
      i += zzya.zzc(2, this.zzavn);
    if ((this.zzavo != null) && (this.zzavo.length > 0))
    {
      int j = i;
      for (int k = 0; k < this.zzavo.length; k++)
      {
        zzfk localzzfk = this.zzavo[k];
        if (localzzfk != null)
          j += zzya.zzb(3, localzzfk);
      }
      i = j;
    }
    if (this.zzavp != null)
    {
      this.zzavp.booleanValue();
      i += 1 + zzya.zzbd(4);
    }
    if (this.zzavq != null)
      i += zzya.zzb(5, this.zzavq);
    if (this.zzavj != null)
    {
      this.zzavj.booleanValue();
      i += 1 + zzya.zzbd(6);
    }
    if (this.zzavk != null)
    {
      this.zzavk.booleanValue();
      i += 1 + zzya.zzbd(7);
    }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfj
 * JD-Core Version:    0.6.2
 */