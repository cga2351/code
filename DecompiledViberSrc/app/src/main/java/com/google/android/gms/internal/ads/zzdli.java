package com.google.android.gms.internal.ads;

public final class zzdli
{
  private final byte[] data;

  private zzdli(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, 0, this.data, 0, paramInt2);
  }

  public static zzdli zzv(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null)
      return null;
    return new zzdli(paramArrayOfByte, 0, paramArrayOfByte.length);
  }

  public final byte[] getBytes()
  {
    byte[] arrayOfByte = new byte[this.data.length];
    System.arraycopy(this.data, 0, arrayOfByte, 0, this.data.length);
    return arrayOfByte;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdli
 * JD-Core Version:    0.6.2
 */