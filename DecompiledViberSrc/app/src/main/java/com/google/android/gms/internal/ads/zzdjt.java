package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzdjt
  implements zzdlj
{
  private static final int[] zzgye = zzr(new byte[] { 101, 120, 112, 97, 110, 100, 32, 51, 50, 45, 98, 121, 116, 101, 32, 107 });
  int[] zzgyf;
  private final int zzgyg;

  zzdjt(byte[] paramArrayOfByte, int paramInt)
    throws InvalidKeyException
  {
    if (paramArrayOfByte.length != 32)
      throw new InvalidKeyException("The key length in bytes must be 32.");
    this.zzgyf = zzr(paramArrayOfByte);
    this.zzgyg = paramInt;
  }

  private static int rotateLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 << paramInt2 | paramInt1 >>> -paramInt2;
  }

  private static void zza(int[] paramArrayOfInt, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramArrayOfInt[paramInt1] += paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt4] = rotateLeft(paramArrayOfInt[paramInt4] ^ paramArrayOfInt[paramInt1], 16);
    paramArrayOfInt[paramInt3] += paramArrayOfInt[paramInt4];
    paramArrayOfInt[paramInt2] = rotateLeft(paramArrayOfInt[paramInt2] ^ paramArrayOfInt[paramInt3], 12);
    paramArrayOfInt[paramInt1] += paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt4] = rotateLeft(paramArrayOfInt[paramInt4] ^ paramArrayOfInt[paramInt1], 8);
    paramArrayOfInt[paramInt3] += paramArrayOfInt[paramInt4];
    paramArrayOfInt[paramInt2] = rotateLeft(paramArrayOfInt[paramInt2] ^ paramArrayOfInt[paramInt3], 7);
  }

  static void zza(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    System.arraycopy(zzgye, 0, paramArrayOfInt1, 0, zzgye.length);
    System.arraycopy(paramArrayOfInt2, 0, paramArrayOfInt1, zzgye.length, 8);
  }

  static void zzc(int[] paramArrayOfInt)
  {
    for (int i = 0; i < 10; i++)
    {
      zza(paramArrayOfInt, 0, 4, 8, 12);
      zza(paramArrayOfInt, 1, 5, 9, 13);
      zza(paramArrayOfInt, 2, 6, 10, 14);
      zza(paramArrayOfInt, 3, 7, 11, 15);
      zza(paramArrayOfInt, 0, 5, 10, 15);
      zza(paramArrayOfInt, 1, 6, 11, 12);
      zza(paramArrayOfInt, 2, 7, 8, 13);
      zza(paramArrayOfInt, 3, 4, 9, 14);
    }
  }

  private static int[] zzr(byte[] paramArrayOfByte)
  {
    IntBuffer localIntBuffer = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
    int[] arrayOfInt = new int[localIntBuffer.remaining()];
    localIntBuffer.get(arrayOfInt);
    return arrayOfInt;
  }

  final void zza(ByteBuffer paramByteBuffer, byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    if (paramByteBuffer.remaining() - zzauv() < paramArrayOfByte.length)
      throw new IllegalArgumentException("Given ByteBuffer output is too small");
    byte[] arrayOfByte = zzdln.zzff(zzauv());
    paramByteBuffer.put(arrayOfByte);
    ByteBuffer localByteBuffer1 = ByteBuffer.wrap(paramArrayOfByte);
    int i = localByteBuffer1.remaining();
    int j = 1 + i / 64;
    int k = 0;
    if (k < j)
    {
      ByteBuffer localByteBuffer2 = zzc(arrayOfByte, k + this.zzgyg);
      if (k == j - 1)
        zzdjr.zza(paramByteBuffer, localByteBuffer1, localByteBuffer2, i % 64);
      while (true)
      {
        k++;
        break;
        zzdjr.zza(paramByteBuffer, localByteBuffer1, localByteBuffer2, 64);
      }
    }
  }

  abstract int zzauv();

  abstract int[] zzb(int[] paramArrayOfInt, int paramInt);

  final ByteBuffer zzc(byte[] paramArrayOfByte, int paramInt)
  {
    int[] arrayOfInt1 = zzb(zzr(paramArrayOfByte), paramInt);
    int[] arrayOfInt2 = (int[])arrayOfInt1.clone();
    zzc(arrayOfInt2);
    for (int i = 0; i < arrayOfInt1.length; i++)
      arrayOfInt1[i] += arrayOfInt2[i];
    ByteBuffer localByteBuffer = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
    localByteBuffer.asIntBuffer().put(arrayOfInt1, 0, 16);
    return localByteBuffer;
  }

  public final byte[] zzo(byte[] paramArrayOfByte)
    throws GeneralSecurityException
  {
    if (paramArrayOfByte.length > 2147483647 - zzauv())
      throw new GeneralSecurityException("plaintext too long");
    ByteBuffer localByteBuffer = ByteBuffer.allocate(zzauv() + paramArrayOfByte.length);
    zza(localByteBuffer, paramArrayOfByte);
    return localByteBuffer.array();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjt
 * JD-Core Version:    0.6.2
 */