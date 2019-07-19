package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzdcr
  implements zzdbi
{
  private static final byte[] zzgpx = new byte[0];
  private final zzdgv zzgpy;
  private final zzdbi zzgpz;

  public zzdcr(zzdgv paramzzdgv, zzdbi paramzzdbi)
  {
    this.zzgpy = paramzzdgv;
    this.zzgpz = paramzzdbi;
  }

  public final byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    byte[] arrayOfByte1 = zzdce.zzb(this.zzgpy).toByteArray();
    byte[] arrayOfByte2 = this.zzgpz.zzc(arrayOfByte1, zzgpx);
    byte[] arrayOfByte3 = ((zzdbi)zzdce.zza(this.zzgpy.zzart(), arrayOfByte1, zzdbi.class)).zzc(paramArrayOfByte1, paramArrayOfByte2);
    return ByteBuffer.allocate(4 + arrayOfByte2.length + arrayOfByte3.length).putInt(arrayOfByte2.length).put(arrayOfByte2).put(arrayOfByte3).array();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdcr
 * JD-Core Version:    0.6.2
 */