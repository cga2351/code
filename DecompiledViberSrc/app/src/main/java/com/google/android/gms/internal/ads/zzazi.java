package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@zzare
public final class zzazi
{
  private Map<Integer, Bitmap> zzdxw = new ConcurrentHashMap();
  private AtomicInteger zzdxx = new AtomicInteger(0);

  public final Bitmap zza(Integer paramInteger)
  {
    return (Bitmap)this.zzdxw.get(paramInteger);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazi
 * JD-Core Version:    0.6.2
 */