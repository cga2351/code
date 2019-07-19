package com.google.android.gms.internal.ads;

import java.security.InvalidKeyException;

final class zzdjs extends zzdjt
{
  zzdjs(byte[] paramArrayOfByte, int paramInt)
    throws InvalidKeyException
  {
    super(paramArrayOfByte, paramInt);
  }

  final int zzauv()
  {
    return 12;
  }

  final int[] zzb(int[] paramArrayOfInt, int paramInt)
  {
    if (paramArrayOfInt.length != 3)
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramArrayOfInt.length << 5);
      throw new IllegalArgumentException(String.format("ChaCha20 uses 96-bit nonces, but got a %d-bit nonce", arrayOfObject));
    }
    int[] arrayOfInt = new int[16];
    zzdjt.zza(arrayOfInt, this.zzgyf);
    arrayOfInt[12] = paramInt;
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 13, paramArrayOfInt.length);
    return arrayOfInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjs
 * JD-Core Version:    0.6.2
 */