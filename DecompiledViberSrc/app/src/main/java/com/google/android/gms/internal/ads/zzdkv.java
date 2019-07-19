package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.util.Arrays;

public final class zzdkv
  implements zzdbi
{
  private final zzdlj zzhal;
  private final zzdbx zzham;
  private final int zzhan;

  public zzdkv(zzdlj paramzzdlj, zzdbx paramzzdbx, int paramInt)
  {
    this.zzhal = paramzzdlj;
    this.zzham = paramzzdbx;
    this.zzhan = paramInt;
  }

  public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    byte[] arrayOfByte1 = this.zzhal.zzo(paramArrayOfByte1);
    if (paramArrayOfByte2 == null)
      paramArrayOfByte2 = new byte[0];
    byte[] arrayOfByte2 = Arrays.copyOf(ByteBuffer.allocate(8).putLong(8L * paramArrayOfByte2.length).array(), 8);
    return zzdjr.zza(new byte[][] { arrayOfByte1, this.zzham.zzk(zzdjr.zza(new byte[][] { paramArrayOfByte2, arrayOfByte1, arrayOfByte2 })) });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdkv
 * JD-Core Version:    0.6.2
 */