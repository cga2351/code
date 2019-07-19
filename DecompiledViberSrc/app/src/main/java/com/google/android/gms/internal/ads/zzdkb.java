package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPublicKey;

public final class zzdkb
  implements zzdbp
{
  private static final byte[] zzgpx = new byte[0];
  private final String zzgyq;
  private final byte[] zzgyr;
  private final zzdku zzgys;
  private final zzdjz zzgyt;
  private final zzdkd zzgyu;

  public zzdkb(ECPublicKey paramECPublicKey, byte[] paramArrayOfByte, String paramString, zzdku paramzzdku, zzdjz paramzzdjz)
    throws GeneralSecurityException
  {
    zzdkq.zza(paramECPublicKey);
    this.zzgyu = new zzdkd(paramECPublicKey);
    this.zzgyr = paramArrayOfByte;
    this.zzgyq = paramString;
    this.zzgys = paramzzdku;
    this.zzgyt = paramzzdjz;
  }

  public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    zzdke localzzdke = this.zzgyu.zza(this.zzgyq, this.zzgyr, paramArrayOfByte2, this.zzgyt.zzanz(), this.zzgys);
    byte[] arrayOfByte1 = this.zzgyt.zzm(localzzdke.zzaux()).zzc(paramArrayOfByte1, zzgpx);
    byte[] arrayOfByte2 = localzzdke.zzauw();
    return ByteBuffer.allocate(arrayOfByte2.length + arrayOfByte1.length).put(arrayOfByte2).put(arrayOfByte1).array();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdkb
 * JD-Core Version:    0.6.2
 */