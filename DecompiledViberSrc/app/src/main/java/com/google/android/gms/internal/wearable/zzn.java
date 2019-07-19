package com.google.android.gms.internal.wearable;

import java.io.IOException;

public abstract class zzn<M extends zzn<M>> extends zzt
{
  protected zzp zzhc;

  public void zza(zzl paramzzl)
    throws IOException
  {
    if (this.zzhc == null);
    while (true)
    {
      return;
      for (int i = 0; i < this.zzhc.size(); i++)
        this.zzhc.zzp(i).zza(paramzzl);
    }
  }

  protected final boolean zza(zzk paramzzk, int paramInt)
    throws IOException
  {
    int i = paramzzk.getPosition();
    if (!paramzzk.zzd(paramInt))
      return false;
    int j = paramInt >>> 3;
    zzv localzzv = new zzv(paramInt, paramzzk.zzb(i, paramzzk.getPosition() - i));
    zzq localzzq = null;
    if (this.zzhc == null)
      this.zzhc = new zzp();
    while (true)
    {
      if (localzzq == null)
      {
        localzzq = new zzq();
        this.zzhc.zza(j, localzzq);
      }
      localzzq.zza(localzzv);
      return true;
      localzzq = this.zzhc.zzo(j);
    }
  }

  protected int zzg()
  {
    int i = 0;
    if (this.zzhc != null)
    {
      j = 0;
      while (i < this.zzhc.size())
      {
        j += this.zzhc.zzp(i).zzg();
        i++;
      }
    }
    int j = 0;
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.wearable.zzn
 * JD-Core Version:    0.6.2
 */