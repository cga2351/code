package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

public final class zzdjr
{
  public static final void zza(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, ByteBuffer paramByteBuffer3, int paramInt)
  {
    if ((paramInt < 0) || (paramByteBuffer2.remaining() < paramInt) || (paramByteBuffer3.remaining() < paramInt) || (paramByteBuffer1.remaining() < paramInt))
      throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    for (int i = 0; i < paramInt; i++)
      paramByteBuffer1.put((byte)(paramByteBuffer2.get() ^ paramByteBuffer3.get()));
  }

  public static final byte[] zza(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, int paramInt3)
  {
    if ((paramInt3 < 0) || (paramArrayOfByte1.length - paramInt3 < paramInt1) || (paramArrayOfByte2.length - paramInt3 < paramInt2))
      throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    byte[] arrayOfByte = new byte[paramInt3];
    for (int i = 0; i < paramInt3; i++)
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[(i + paramInt1)] ^ paramArrayOfByte2[(i + paramInt2)]));
    return arrayOfByte;
  }

  public static byte[] zza(byte[][] paramArrayOfByte)
    throws GeneralSecurityException
  {
    int i = paramArrayOfByte.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      byte[] arrayOfByte3 = paramArrayOfByte[j];
      if (k > 2147483647 - arrayOfByte3.length)
        throw new GeneralSecurityException("exceeded size limit");
      k += arrayOfByte3.length;
      j++;
    }
    byte[] arrayOfByte1 = new byte[k];
    int m = paramArrayOfByte.length;
    int n = 0;
    int i1 = 0;
    while (n < m)
    {
      byte[] arrayOfByte2 = paramArrayOfByte[n];
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i1, arrayOfByte2.length);
      i1 += arrayOfByte2.length;
      n++;
    }
    return arrayOfByte1;
  }

  public static final byte[] zzd(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length != paramArrayOfByte2.length)
      throw new IllegalArgumentException("The lengths of x and y should match.");
    return zza(paramArrayOfByte1, 0, paramArrayOfByte2, 0, paramArrayOfByte1.length);
  }

  public static final boolean zze(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null));
    int j;
    do
    {
      do
        return false;
      while (paramArrayOfByte1.length != paramArrayOfByte2.length);
      int i = 0;
      j = 0;
      while (i < paramArrayOfByte1.length)
      {
        j |= paramArrayOfByte1[i] ^ paramArrayOfByte2[i];
        i++;
      }
    }
    while (j != 0);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjr
 * JD-Core Version:    0.6.2
 */