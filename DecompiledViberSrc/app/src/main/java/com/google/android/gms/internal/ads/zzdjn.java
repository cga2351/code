package com.google.android.gms.internal.ads;

final class zzdjn
{
  static byte[] zzq(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length != 16)
      throw new IllegalArgumentException("value must be a block.");
    byte[] arrayOfByte = new byte[16];
    for (int i = 0; i < 16; i++)
    {
      arrayOfByte[i] = ((byte)(0xFE & paramArrayOfByte[i] << 1));
      if (i < 15)
        arrayOfByte[i] = ((byte)(arrayOfByte[i] | (byte)(0x1 & paramArrayOfByte[(i + 1)] >> 7)));
    }
    arrayOfByte[15] = ((byte)(arrayOfByte[15] ^ (byte)(0x87 & paramArrayOfByte[0] >> 7)));
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdjn
 * JD-Core Version:    0.6.2
 */