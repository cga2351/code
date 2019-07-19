package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzwq
{
  private final byte[] zzbzf;
  private int zzbzg;
  private int zzbzh;

  private zzwq(zzwm paramzzwm, byte[] paramArrayOfByte)
  {
    this.zzbzf = paramArrayOfByte;
  }

  public final zzwq zzbx(int paramInt)
  {
    this.zzbzg = paramInt;
    return this;
  }

  public final zzwq zzby(int paramInt)
  {
    this.zzbzh = paramInt;
    return this;
  }

  public final void zzdj()
  {
    try
    {
      if (this.zzbzi.zzbzd)
      {
        this.zzbzi.zzbzc.zzc(this.zzbzf);
        this.zzbzi.zzbzc.zzl(this.zzbzg);
        this.zzbzi.zzbzc.zzm(this.zzbzh);
        this.zzbzi.zzbzc.zza(null);
        this.zzbzi.zzbzc.zzdj();
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      while (true)
        zzbae.zzb("Clearcut log failed", localRemoteException);
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwq
 * JD-Core Version:    0.6.2
 */