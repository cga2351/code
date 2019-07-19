package com.google.android.gms.internal.ads;

import java.util.Map;

final class zzayy extends zzax
{
  zzayy(zzayv paramzzayv, int paramInt, String paramString, zzaa paramzzaa, zzz paramzzz, byte[] paramArrayOfByte, Map paramMap, zzazy paramzzazy)
  {
    super(paramInt, paramString, paramzzaa, paramzzz);
  }

  public final Map<String, String> getHeaders()
    throws zza
  {
    if (this.zzdxo == null)
      return super.getHeaders();
    return this.zzdxo;
  }

  public final byte[] zzg()
    throws zza
  {
    if (this.zzdxn == null)
      return super.zzg();
    return this.zzdxn;
  }

  protected final void zzh(String paramString)
  {
    this.zzdxp.zzek(paramString);
    super.zzh(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayy
 * JD-Core Version:    0.6.2
 */