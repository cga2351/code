package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicInteger;

@zzare
@Deprecated
public class zzbbx<T>
{
  private final zzbbs<T> zzeaq = new zzbbs();
  private final AtomicInteger zzear = new AtomicInteger(0);

  public zzbbx()
  {
    zzbas.zza(this.zzeaq, new zzbby(this), zzbbn.zzeah);
  }

  @Deprecated
  public final int getStatus()
  {
    return this.zzear.get();
  }

  @Deprecated
  public final void reject()
  {
    this.zzeaq.setException(new Exception());
  }

  @Deprecated
  public final void zza(zzbbw<T> paramzzbbw, zzbbu paramzzbbu)
  {
    zzbas.zza(this.zzeaq, new zzbbz(this, paramzzbbw, paramzzbbu), zzbbn.zzeah);
  }

  @Deprecated
  public final void zzo(T paramT)
  {
    this.zzeaq.set(paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbbx
 * JD-Core Version:    0.6.2
 */