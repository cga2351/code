package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzddg
  implements zzdbp
{
  private final zzdbz<zzdbp> zzgqa;

  public zzddg(zzdbz<zzdbp> paramzzdbz)
  {
    this.zzgqa = paramzzdbz;
  }

  public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    byte[][] arrayOfByte = new byte[2][];
    arrayOfByte[0] = this.zzgqa.zzanu().zzanx();
    arrayOfByte[1] = ((zzdbp)this.zzgqa.zzanu().zzanv()).zzc(paramArrayOfByte1, paramArrayOfByte2);
    return zzdjr.zza(arrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddg
 * JD-Core Version:    0.6.2
 */