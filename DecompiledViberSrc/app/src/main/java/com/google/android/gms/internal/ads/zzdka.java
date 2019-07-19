package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;

public final class zzdka
  implements zzdbo
{
  private static final byte[] zzgpx = new byte[0];
  private final ECPrivateKey zzgyo;
  private final zzdkc zzgyp;
  private final String zzgyq;
  private final byte[] zzgyr;
  private final zzdku zzgys;
  private final zzdjz zzgyt;

  public zzdka(ECPrivateKey paramECPrivateKey, byte[] paramArrayOfByte, String paramString, zzdku paramzzdku, zzdjz paramzzdjz)
    throws GeneralSecurityException
  {
    this.zzgyo = paramECPrivateKey;
    this.zzgyp = new zzdkc(paramECPrivateKey);
    this.zzgyr = paramArrayOfByte;
    this.zzgyq = paramString;
    this.zzgys = paramzzdku;
    this.zzgyt = paramzzdjz;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdka
 * JD-Core Version:    0.6.2
 */