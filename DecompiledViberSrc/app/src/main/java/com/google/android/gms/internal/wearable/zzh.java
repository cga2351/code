package com.google.android.gms.internal.wearable;

import java.io.IOException;

public final class zzh extends zzn<zzh>
{
  private static volatile zzh[] zzfz;
  public String name = "";
  public zzi zzga = null;

  public zzh()
  {
    this.zzhc = null;
    this.zzhl = -1;
  }

  public static zzh[] zzh()
  {
    if (zzfz == null);
    synchronized (zzr.zzhk)
    {
      if (zzfz == null)
        zzfz = new zzh[0];
      return zzfz;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzh localzzh;
    do
    {
      return true;
      if (!(paramObject instanceof zzh))
        return false;
      localzzh = (zzh)paramObject;
      if (this.name == null)
      {
        if (localzzh.name != null)
          return false;
      }
      else if (!this.name.equals(localzzh.name))
        return false;
      if (this.zzga == null)
      {
        if (localzzh.zzga != null)
          return false;
      }
      else if (!this.zzga.equals(localzzh.zzga))
        return false;
      if ((this.zzhc != null) && (!this.zzhc.isEmpty()))
        break;
    }
    while ((localzzh.zzhc == null) || (localzzh.zzhc.isEmpty()));
    return false;
    return this.zzhc.equals(localzzh.zzhc);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode());
    int j;
    zzi localzzi;
    int n;
    label51: int i1;
    int i2;
    if (this.name == null)
    {
      j = 0;
      int k = j + i;
      localzzi = this.zzga;
      int m = k * 31;
      if (localzzi != null)
        break label109;
      n = 0;
      i1 = 31 * (n + m);
      zzp localzzp = this.zzhc;
      i2 = 0;
      if (localzzp != null)
      {
        boolean bool = this.zzhc.isEmpty();
        i2 = 0;
        if (!bool)
          break label119;
      }
    }
    while (true)
    {
      return i1 + i2;
      j = this.name.hashCode();
      break;
      label109: n = localzzi.hashCode();
      break label51;
      label119: i2 = this.zzhc.hashCode();
    }
  }

  public final void zza(zzl paramzzl)
    throws IOException
  {
    paramzzl.zza(1, this.name);
    if (this.zzga != null)
      paramzzl.zza(2, this.zzga);
    super.zza(paramzzl);
  }

  protected final int zzg()
  {
    int i = super.zzg() + zzl.zzb(1, this.name);
    if (this.zzga != null)
      i += zzl.zzb(2, this.zzga);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzh
 * JD-Core Version:    0.6.2
 */