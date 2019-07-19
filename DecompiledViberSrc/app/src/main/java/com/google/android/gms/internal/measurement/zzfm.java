package com.google.android.gms.internal.measurement;

import java.io.IOException;

public final class zzfm extends zzyc<zzfm>
{
  private static volatile zzfm[] zzawb;
  public Boolean zzavj = null;
  public Boolean zzavk = null;
  public Integer zzavm = null;
  public String zzawc = null;
  public zzfk zzawd = null;

  public zzfm()
  {
    this.zzcev = null;
    this.zzcff = -1;
  }

  public static zzfm[] zzmu()
  {
    if (zzawb == null);
    synchronized (zzyg.zzcfe)
    {
      if (zzawb == null)
        zzawb = new zzfm[0];
      return zzawb;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzfm localzzfm;
    do
    {
      return true;
      if (!(paramObject instanceof zzfm))
        return false;
      localzzfm = (zzfm)paramObject;
      if (this.zzavm == null)
      {
        if (localzzfm.zzavm != null)
          return false;
      }
      else if (!this.zzavm.equals(localzzfm.zzavm))
        return false;
      if (this.zzawc == null)
      {
        if (localzzfm.zzawc != null)
          return false;
      }
      else if (!this.zzawc.equals(localzzfm.zzawc))
        return false;
      if (this.zzawd == null)
      {
        if (localzzfm.zzawd != null)
          return false;
      }
      else if (!this.zzawd.equals(localzzfm.zzawd))
        return false;
      if (this.zzavj == null)
      {
        if (localzzfm.zzavj != null)
          return false;
      }
      else if (!this.zzavj.equals(localzzfm.zzavj))
        return false;
      if (this.zzavk == null)
      {
        if (localzzfm.zzavk != null)
          return false;
      }
      else if (!this.zzavk.equals(localzzfm.zzavk))
        return false;
      if ((this.zzcev != null) && (!this.zzcev.isEmpty()))
        break;
    }
    while ((localzzfm.zzcev == null) || (localzzfm.zzcev.isEmpty()));
    return false;
    return this.zzcev.equals(localzzfm.zzcev);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    int m;
    label44: zzfk localzzfk;
    int i2;
    label71: int i4;
    label91: int i6;
    label111: int i7;
    int i8;
    if (this.zzavm == null)
    {
      j = 0;
      int k = 31 * (j + i);
      if (this.zzawc != null)
        break label169;
      m = 0;
      int n = m + k;
      localzzfk = this.zzawd;
      int i1 = n * 31;
      if (localzzfk != null)
        break label181;
      i2 = 0;
      int i3 = 31 * (i2 + i1);
      if (this.zzavj != null)
        break label191;
      i4 = 0;
      int i5 = 31 * (i4 + i3);
      if (this.zzavk != null)
        break label203;
      i6 = 0;
      i7 = 31 * (i6 + i5);
      zzye localzzye = this.zzcev;
      i8 = 0;
      if (localzzye != null)
      {
        boolean bool = this.zzcev.isEmpty();
        i8 = 0;
        if (!bool)
          break label215;
      }
    }
    while (true)
    {
      return i7 + i8;
      j = this.zzavm.hashCode();
      break;
      label169: m = this.zzawc.hashCode();
      break label44;
      label181: i2 = localzzfk.hashCode();
      break label71;
      label191: i4 = this.zzavj.hashCode();
      break label91;
      label203: i6 = this.zzavk.hashCode();
      break label111;
      label215: i8 = this.zzcev.hashCode();
    }
  }

  public final void zza(zzya paramzzya)
    throws IOException
  {
    if (this.zzavm != null)
      paramzzya.zzd(1, this.zzavm.intValue());
    if (this.zzawc != null)
      paramzzya.zzb(2, this.zzawc);
    if (this.zzawd != null)
      paramzzya.zza(3, this.zzawd);
    if (this.zzavj != null)
      paramzzya.zzb(4, this.zzavj.booleanValue());
    if (this.zzavk != null)
      paramzzya.zzb(5, this.zzavk.booleanValue());
    super.zza(paramzzya);
  }

  protected final int zzf()
  {
    int i = super.zzf();
    if (this.zzavm != null)
      i += zzya.zzh(1, this.zzavm.intValue());
    if (this.zzawc != null)
      i += zzya.zzc(2, this.zzawc);
    if (this.zzawd != null)
      i += zzya.zzb(3, this.zzawd);
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
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfm
 * JD-Core Version:    0.6.2
 */