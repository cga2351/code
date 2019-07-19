package com.google.android.gms.internal.ads;

public final class zzdmg
{
  private final byte[] zzhcc = new byte[256];
  private int zzhcd;
  private int zzhce;

  public zzdmg(byte[] paramArrayOfByte)
  {
    for (int i = 0; i < 256; i++)
      this.zzhcc[i] = ((byte)i);
    int j = 0;
    for (int k = 0; k < 256; k++)
    {
      j = 0xFF & j + this.zzhcc[k] + paramArrayOfByte[(k % paramArrayOfByte.length)];
      int m = this.zzhcc[k];
      this.zzhcc[k] = this.zzhcc[j];
      this.zzhcc[j] = m;
    }
    this.zzhcd = 0;
    this.zzhce = 0;
  }

  public final void zzy(byte[] paramArrayOfByte)
  {
    int i = this.zzhcd;
    int j = this.zzhce;
    for (int k = 0; k < paramArrayOfByte.length; k++)
    {
      i = 0xFF & i + 1;
      j = 0xFF & j + this.zzhcc[i];
      int m = this.zzhcc[i];
      this.zzhcc[i] = this.zzhcc[j];
      this.zzhcc[j] = m;
      paramArrayOfByte[k] = ((byte)(paramArrayOfByte[k] ^ this.zzhcc[(0xFF & this.zzhcc[i] + this.zzhcc[j])]));
    }
    this.zzhcd = i;
    this.zzhce = j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdmg
 * JD-Core Version:    0.6.2
 */