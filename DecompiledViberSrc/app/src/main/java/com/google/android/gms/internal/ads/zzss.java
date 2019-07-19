package com.google.android.gms.internal.ads;

public final class zzss
{
  private byte[] data;
  private int zzbnl;
  private int zzbnm;
  private int zzbnn;

  public zzss()
  {
  }

  public zzss(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, paramArrayOfByte.length);
  }

  private zzss(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.zzbnn = paramInt;
  }

  public final int zzbn(int paramInt)
  {
    if (paramInt == 0)
      return 0;
    int i = paramInt / 8;
    int j = 0;
    int k = 0;
    if (j < i)
    {
      if (this.zzbnm != 0);
      for (int i2 = (0xFF & this.data[this.zzbnl]) << this.zzbnm | (0xFF & this.data[(1 + this.zzbnl)]) >>> 8 - this.zzbnm; ; i2 = this.data[this.zzbnl])
      {
        paramInt -= 8;
        k |= (i2 & 0xFF) << paramInt;
        this.zzbnl = (1 + this.zzbnl);
        j++;
        break;
      }
    }
    int n;
    int i1;
    int m;
    if (paramInt > 0)
    {
      n = paramInt + this.zzbnm;
      i1 = (byte)(255 >> 8 - paramInt);
      if (n > 8)
      {
        m = k | i1 & ((0xFF & this.data[this.zzbnl]) << n - 8 | (0xFF & this.data[(1 + this.zzbnl)]) >> 16 - n);
        this.zzbnl = (1 + this.zzbnl);
        this.zzbnm = (n % 8);
      }
    }
    while (true)
    {
      if ((this.zzbnl >= 0) && (this.zzbnm >= 0) && (this.zzbnm < 8) && ((this.zzbnl < this.zzbnn) || ((this.zzbnl == this.zzbnn) && (this.zzbnm == 0))));
      for (boolean bool = true; ; bool = false)
      {
        zzsk.checkState(bool);
        return m;
        m = k | i1 & (0xFF & this.data[this.zzbnl]) >> 8 - n;
        if (n != 8)
          break;
        this.zzbnl = (1 + this.zzbnl);
        break;
      }
      m = k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzss
 * JD-Core Version:    0.6.2
 */