package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;
import java.util.Arrays;

final class zzdly extends zzdjt
{
  zzdly(byte[] paramArrayOfByte, int paramInt)
    throws InvalidKeyException
  {
    super(paramArrayOfByte, paramInt);
  }

  final int zzauv()
  {
    return 24;
  }

  final int[] zzb(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt.length != 6)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramArrayOfInt.length << 5);
      throw new IllegalArgumentException(String.format("XChaCha20 uses 192-bit nonces, but got a %d-bit nonce", arrayOfObject));
    }
    int[] arrayOfInt1 = new int[16];
    int[] arrayOfInt2 = this.zzgyf;
    int[] arrayOfInt3 = new int[16];
    zzdjt.zza(arrayOfInt3, arrayOfInt2);
    arrayOfInt3[12] = paramArrayOfInt[0];
    arrayOfInt3[13] = paramArrayOfInt[1];
    arrayOfInt3[14] = paramArrayOfInt[2];
    arrayOfInt3[15] = paramArrayOfInt[3];
    zzdjt.zzc(arrayOfInt3);
    arrayOfInt3[4] = arrayOfInt3[12];
    arrayOfInt3[5] = arrayOfInt3[13];
    arrayOfInt3[6] = arrayOfInt3[14];
    arrayOfInt3[7] = arrayOfInt3[15];
    zzdjt.zza(arrayOfInt1, Arrays.copyOf(arrayOfInt3, 8));
    arrayOfInt1[12] = paramInt;
    arrayOfInt1[13] = 0;
    arrayOfInt1[14] = paramArrayOfInt[4];
    arrayOfInt1[15] = paramArrayOfInt[5];
    return arrayOfInt1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdly
 * JD-Core Version:    0.6.2
 */