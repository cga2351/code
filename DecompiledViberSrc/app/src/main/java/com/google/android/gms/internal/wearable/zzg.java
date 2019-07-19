package com.google.android.gms.internal.wearable;

import java.io.IOException;

public final class zzg extends zzn<zzg>
{
  public zzh[] zzfy = zzh.zzh();

  public zzg()
  {
    this.zzhc = null;
    this.zzhl = -1;
  }

  public static zzg zza(byte[] paramArrayOfByte)
    throws zzs
  {
    return (zzg)zzt.zza(new zzg(), paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public final boolean equals(Object paramObject)
  {
    if (paramObject == this);
    zzg localzzg;
    do
    {
      return true;
      if (!(paramObject instanceof zzg))
        return false;
      localzzg = (zzg)paramObject;
      if (!zzr.equals(this.zzfy, localzzg.zzfy))
        return false;
      if ((this.zzhc != null) && (!this.zzhc.isEmpty()))
        break;
    }
    while ((localzzg.zzhc == null) || (localzzg.zzhc.isEmpty()));
    return false;
    return this.zzhc.equals(localzzg.zzhc);
  }

  public final int hashCode()
  {
    int i = 31 * (31 * (527 + getClass().getName().hashCode()) + zzr.hashCode(this.zzfy));
    if ((this.zzhc == null) || (this.zzhc.isEmpty()));
    for (int j = 0; ; j = this.zzhc.hashCode())
      return j + i;
  }

  public final void zza(zzl paramzzl)
    throws IOException
  {
    if ((this.zzfy != null) && (this.zzfy.length > 0))
      for (int i = 0; i < this.zzfy.length; i++)
      {
        zzh localzzh = this.zzfy[i];
        if (localzzh != null)
          paramzzl.zza(1, localzzh);
      }
    super.zza(paramzzl);
  }

  protected final int zzg()
  {
    int i = super.zzg();
    if ((this.zzfy != null) && (this.zzfy.length > 0))
      for (int j = 0; j < this.zzfy.length; j++)
      {
        zzh localzzh = this.zzfy[j];
        if (localzzh != null)
          i += zzl.zzb(1, localzzh);
      }
    return i;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzg
 * JD-Core Version:    0.6.2
 */