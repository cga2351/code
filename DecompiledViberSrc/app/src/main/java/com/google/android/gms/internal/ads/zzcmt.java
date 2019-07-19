package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzcmt
{
  private final Clock zzbsb;
  private final List<String> zzgbg = Collections.synchronizedList(new ArrayList());

  public zzcmt(Clock paramClock)
  {
    this.zzbsb = paramClock;
  }

  private final void zza(String paramString, int paramInt, long paramLong)
  {
    this.zzgbg.add(33 + String.valueOf(paramString).length() + paramString + "." + paramInt + "." + paramLong);
  }

  public final <T> zzbbi<T> zza(zzcxl paramzzcxl, zzbbi<T> paramzzbbi)
  {
    long l = this.zzbsb.elapsedRealtime();
    String str = paramzzcxl.zzdel;
    if (str != null)
      zzbas.zza(paramzzbbi, new zzcmu(this, str, l), zzbbn.zzeah);
    return paramzzbbi;
  }

  public final String zzaku()
  {
    return TextUtils.join("_", this.zzgbg);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcmt
 * JD-Core Version:    0.6.2
 */