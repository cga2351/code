package com.google.android.gms.internal.measurement;

import android.net.Uri;

public final class zzso
{
  private final String zzbru = null;
  private final Uri zzbrv;
  private final String zzbrw;
  private final String zzbrx;
  private final boolean zzbry;
  private final boolean zzbrz;
  private final boolean zzbsa;

  public zzso(Uri paramUri)
  {
    this(null, paramUri, "", "", false, false, false);
  }

  private zzso(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.zzbrv = paramUri;
    this.zzbrw = paramString2;
    this.zzbrx = paramString3;
    this.zzbry = false;
    this.zzbrz = false;
    this.zzbsa = false;
  }

  public final zzsi<Double> zzb(String paramString, double paramDouble)
  {
    return zzsi.zzb(this, paramString, paramDouble);
  }

  public final zzsi<Integer> zzd(String paramString, int paramInt)
  {
    return zzsi.zzb(this, paramString, paramInt);
  }

  public final zzsi<Boolean> zzd(String paramString, boolean paramBoolean)
  {
    return zzsi.zzb(this, paramString, paramBoolean);
  }

  public final zzsi<Long> zze(String paramString, long paramLong)
  {
    return zzsi.zzb(this, paramString, paramLong);
  }

  public final zzsi<String> zzy(String paramString1, String paramString2)
  {
    return zzsi.zzb(this, paramString1, paramString2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzso
 * JD-Core Version:    0.6.2
 */