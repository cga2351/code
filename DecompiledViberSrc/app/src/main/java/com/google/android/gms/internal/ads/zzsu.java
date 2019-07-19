package com.google.android.gms.internal.ads;

public final class zzsu
{
  private byte[] data;
  private int zzbnl;
  private int zzbnm;
  private int zzbnn;

  public zzsu(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.data = paramArrayOfByte;
    this.zzbnl = paramInt1;
    this.zzbnn = paramInt2;
    this.zzbnm = 0;
    zzkg();
  }

  private final boolean zzbr(int paramInt)
  {
    return (2 <= paramInt) && (paramInt < this.zzbnn) && (this.data[paramInt] == 3) && (this.data[(paramInt - 2)] == 0) && (this.data[(paramInt - 1)] == 0);
  }

  private final int zzkf()
  {
    for (int i = 0; !zzkc(); i++);
    int j = -1 + (1 << i);
    int k = 0;
    if (i > 0)
      k = zzbn(i);
    return j + k;
  }

  private final void zzkg()
  {
    if ((this.zzbnl >= 0) && (this.zzbnm >= 0) && (this.zzbnm < 8) && ((this.zzbnl < this.zzbnn) || ((this.zzbnl == this.zzbnn) && (this.zzbnm == 0))));
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkState(bool);
      return;
    }
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
      int i3;
      if (zzbr(1 + this.zzbnl))
      {
        i3 = 2 + this.zzbnl;
        label42: if (this.zzbnm == 0)
          break label128;
      }
      label128: for (int i4 = (0xFF & this.data[this.zzbnl]) << this.zzbnm | (0xFF & this.data[i3]) >>> 8 - this.zzbnm; ; i4 = this.data[this.zzbnl])
      {
        paramInt -= 8;
        k |= (i4 & 0xFF) << paramInt;
        this.zzbnl = i3;
        j++;
        break;
        i3 = 1 + this.zzbnl;
        break label42;
      }
    }
    int n;
    int i1;
    int i2;
    int m;
    if (paramInt > 0)
    {
      n = paramInt + this.zzbnm;
      i1 = (byte)(255 >> 8 - paramInt);
      if (zzbr(1 + this.zzbnl))
      {
        i2 = 2 + this.zzbnl;
        if (n <= 8)
          break label271;
        m = k | i1 & ((0xFF & this.data[this.zzbnl]) << n - 8 | (0xFF & this.data[i2]) >> 16 - n);
        this.zzbnl = i2;
        label244: this.zzbnm = (n % 8);
      }
    }
    while (true)
    {
      zzkg();
      return m;
      i2 = 1 + this.zzbnl;
      break;
      label271: m = k | i1 & (0xFF & this.data[this.zzbnl]) >> 8 - n;
      if (n != 8)
        break label244;
      this.zzbnl = i2;
      break label244;
      m = k;
    }
  }

  public final void zzbq(int paramInt)
  {
    int i = this.zzbnl;
    this.zzbnl += paramInt / 8;
    this.zzbnm += paramInt % 8;
    if (this.zzbnm > 7)
    {
      this.zzbnl = (1 + this.zzbnl);
      this.zzbnm = (-8 + this.zzbnm);
    }
    for (int j = i + 1; j <= this.zzbnl; j++)
      if (zzbr(j))
      {
        this.zzbnl = (1 + this.zzbnl);
        j += 2;
      }
    zzkg();
  }

  public final boolean zzkc()
  {
    return zzbn(1) == 1;
  }

  public final int zzkd()
  {
    return zzkf();
  }

  public final int zzke()
  {
    int i = zzkf();
    if (i % 2 == 0);
    for (int j = -1; ; j = 1)
      return j * ((i + 1) / 2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsu
 * JD-Core Version:    0.6.2
 */