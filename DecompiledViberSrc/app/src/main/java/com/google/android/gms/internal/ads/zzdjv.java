package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzdjv
  implements zzdbi
{
  private final zzdjt zzgyh = zzd(paramArrayOfByte, 1);
  private final zzdjt zzgyi = zzd(paramArrayOfByte, 0);

  public zzdjv(byte[] paramArrayOfByte)
    throws InvalidKeyException
  {
  }

  public byte[] zzc(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws GeneralSecurityException
  {
    if (paramArrayOfByte1.length > -16 + (2147483647 - this.zzgyh.zzauv()))
      throw new GeneralSecurityException("plaintext too long");
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(16 + (paramArrayOfByte1.length + this.zzgyh.zzauv()));
    if (localByteBuffer1.remaining() < 16 + (paramArrayOfByte1.length + this.zzgyh.zzauv()))
      throw new IllegalArgumentException("Given ByteBuffer output is too small");
    int i = localByteBuffer1.position();
    this.zzgyh.zza(localByteBuffer1, paramArrayOfByte1);
    localByteBuffer1.position(i);
    byte[] arrayOfByte1 = new byte[this.zzgyh.zzauv()];
    localByteBuffer1.get(arrayOfByte1);
    localByteBuffer1.limit(-16 + localByteBuffer1.limit());
    if (paramArrayOfByte2 == null)
      paramArrayOfByte2 = new byte[0];
    ByteBuffer localByteBuffer2 = this.zzgyi.zzc(arrayOfByte1, 0);
    byte[] arrayOfByte2 = new byte[32];
    localByteBuffer2.get(arrayOfByte2);
    int j;
    int k;
    if (paramArrayOfByte2.length % 16 == 0)
    {
      j = paramArrayOfByte2.length;
      k = localByteBuffer1.remaining();
      if (k % 16 != 0)
        break label313;
    }
    label313: for (int m = k; ; m = k + 16 - k % 16)
    {
      ByteBuffer localByteBuffer3 = ByteBuffer.allocate(16 + (j + m)).order(ByteOrder.LITTLE_ENDIAN);
      localByteBuffer3.put(paramArrayOfByte2);
      localByteBuffer3.position(j);
      localByteBuffer3.put(localByteBuffer1);
      localByteBuffer3.position(j + m);
      localByteBuffer3.putLong(paramArrayOfByte2.length);
      localByteBuffer3.putLong(k);
      byte[] arrayOfByte3 = zzdlm.zzf(arrayOfByte2, localByteBuffer3.array());
      localByteBuffer1.limit(16 + localByteBuffer1.limit());
      localByteBuffer1.put(arrayOfByte3);
      return localByteBuffer1.array();
      j = 16 + paramArrayOfByte2.length - paramArrayOfByte2.length % 16;
      break;
    }
  }

  abstract zzdjt zzd(byte[] paramArrayOfByte, int paramInt)
    throws InvalidKeyException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjv
 * JD-Core Version:    0.6.2
 */