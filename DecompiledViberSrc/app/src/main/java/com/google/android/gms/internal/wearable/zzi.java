package com.google.android.gms.internal.wearable;

import java.io.IOException;

public final class zzi extends zzn<zzi>
{
  private static volatile zzi[] zzgb;
  public int type = 1;
  public zzj zzgc = null;

  public zzi()
  {
    this.zzhc = null;
    this.zzhl = -1;
  }

  private final zzi zzb(zzk paramzzk)
    throws IOException
  {
    while (true)
    {
      int i = paramzzk.zzj();
      switch (i)
      {
      default:
        if (super.zza(paramzzk, i))
          continue;
      case 0:
        return this;
      case 8:
        int j = paramzzk.getPosition();
        int k;
        try
        {
          k = paramzzk.zzk();
          if ((k <= 0) || (k > 15))
            break label100;
          this.type = k;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          paramzzk.zzg(j);
          zza(paramzzk, i);
        }
        continue;
        label100: throw new IllegalArgumentException(36 + k + " is not a valid enum Type");
      case 18:
      }
      if (this.zzgc == null)
        this.zzgc = new zzj();
      paramzzk.zza(this.zzgc);
    }
  }

  public static zzi[] zzi()
  {
    if (zzgb == null);
    synchronized (zzr.zzhk)
    {
      if (zzgb == null)
        zzgb = new zzi[0];
      return zzgb;
    }
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzi localzzi;
    do
    {
      return true;
      if (!(paramObject instanceof zzi))
        return false;
      localzzi = (zzi)paramObject;
      if (this.type != localzzi.type)
        return false;
      if (this.zzgc == null)
      {
        if (localzzi.zzgc != null)
          return false;
      }
      else if (!this.zzgc.equals(localzzi.zzgc))
        return false;
      if ((this.zzhc != null) && (!this.zzhc.isEmpty()))
        break;
    }
    while ((localzzi.zzhc == null) || (localzzi.zzhc.isEmpty()));
    return false;
    return this.zzhc.equals(localzzi.zzhc);
  }

  public final int hashCode()
  {
    int i = 31 * (527 + getClass().getName().hashCode()) + this.type;
    zzj localzzj = this.zzgc;
    int j = i * 31;
    int k;
    int m;
    int n;
    if (localzzj == null)
    {
      k = 0;
      m = 31 * (k + j);
      zzp localzzp = this.zzhc;
      n = 0;
      if (localzzp != null)
      {
        boolean bool = this.zzhc.isEmpty();
        n = 0;
        if (!bool)
          break label95;
      }
    }
    while (true)
    {
      return m + n;
      k = localzzj.hashCode();
      break;
      label95: n = this.zzhc.hashCode();
    }
  }

  public final void zza(zzl paramzzl)
    throws IOException
  {
    paramzzl.zzd(1, this.type);
    if (this.zzgc != null)
      paramzzl.zza(2, this.zzgc);
    super.zza(paramzzl);
  }

  protected final int zzg()
  {
    int i = super.zzg() + zzl.zze(1, this.type);
    if (this.zzgc != null)
      i += zzl.zzb(2, this.zzgc);
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzi
 * JD-Core Version:    0.6.2
 */