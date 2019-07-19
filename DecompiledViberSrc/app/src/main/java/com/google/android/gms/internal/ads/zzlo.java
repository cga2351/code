package com.google.android.gms.internal.ads;

import java.io.IOException;

public abstract interface zzlo extends zzkx
{
  public abstract void disable();

  public abstract int getState();

  public abstract int getTrackType();

  public abstract boolean isReady();

  public abstract void setIndex(int paramInt);

  public abstract void start()
    throws zzku;

  public abstract void stop()
    throws zzku;

  public abstract void zza(zzlq paramzzlq, zzlh[] paramArrayOfzzlh, zzqw paramzzqw, long paramLong1, boolean paramBoolean, long paramLong2)
    throws zzku;

  public abstract void zza(zzlh[] paramArrayOfzzlh, zzqw paramzzqw, long paramLong)
    throws zzku;

  public abstract void zzc(long paramLong1, long paramLong2)
    throws zzku;

  public abstract void zzdx(long paramLong)
    throws zzku;

  public abstract boolean zzdx();

  public abstract zzlp zzgi();

  public abstract zzso zzgj();

  public abstract zzqw zzgk();

  public abstract boolean zzgl();

  public abstract void zzgm();

  public abstract boolean zzgn();

  public abstract void zzgo()
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzlo
 * JD-Core Version:    0.6.2
 */