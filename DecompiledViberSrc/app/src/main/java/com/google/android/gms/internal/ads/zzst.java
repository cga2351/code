package com.google.android.gms.internal.ads;

public final class zzst
{
  public byte[] data;
  private int limit;
  private int position;

  public zzst()
  {
  }

  public zzst(int paramInt)
  {
    this.data = new byte[paramInt];
    this.limit = paramInt;
  }

  public zzst(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    this.limit = paramArrayOfByte.length;
  }

  public final int capacity()
  {
    if (this.data == null)
      return 0;
    return this.data.length;
  }

  public final int getPosition()
  {
    return this.position;
  }

  public final int limit()
  {
    return this.limit;
  }

  public final int readInt()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 24;
    byte[] arrayOfByte2 = this.data;
    int k = this.position;
    this.position = (k + 1);
    int m = j | (0xFF & arrayOfByte2[k]) << 16;
    byte[] arrayOfByte3 = this.data;
    int n = this.position;
    this.position = (n + 1);
    int i1 = m | (0xFF & arrayOfByte3[n]) << 8;
    byte[] arrayOfByte4 = this.data;
    int i2 = this.position;
    this.position = (i2 + 1);
    return i1 | 0xFF & arrayOfByte4[i2];
  }

  public final long readLong()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = (0xFF & arrayOfByte1[i]) << 56;
    byte[] arrayOfByte2 = this.data;
    int j = this.position;
    this.position = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 48;
    byte[] arrayOfByte3 = this.data;
    int k = this.position;
    this.position = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 40;
    byte[] arrayOfByte4 = this.data;
    int m = this.position;
    this.position = (m + 1);
    long l4 = l3 | (0xFF & arrayOfByte4[m]) << 32;
    byte[] arrayOfByte5 = this.data;
    int n = this.position;
    this.position = (n + 1);
    long l5 = l4 | (0xFF & arrayOfByte5[n]) << 24;
    byte[] arrayOfByte6 = this.data;
    int i1 = this.position;
    this.position = (i1 + 1);
    long l6 = l5 | (0xFF & arrayOfByte6[i1]) << 16;
    byte[] arrayOfByte7 = this.data;
    int i2 = this.position;
    this.position = (i2 + 1);
    long l7 = l6 | (0xFF & arrayOfByte7[i2]) << 8;
    byte[] arrayOfByte8 = this.data;
    int i3 = this.position;
    this.position = (i3 + 1);
    return l7 | 0xFF & arrayOfByte8[i3];
  }

  public final short readShort()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.data;
    int k = this.position;
    this.position = (k + 1);
    return (short)(j | 0xFF & arrayOfByte2[k]);
  }

  public final int readUnsignedByte()
  {
    byte[] arrayOfByte = this.data;
    int i = this.position;
    this.position = (i + 1);
    return 0xFF & arrayOfByte[i];
  }

  public final int readUnsignedShort()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.data;
    int k = this.position;
    this.position = (k + 1);
    return j | 0xFF & arrayOfByte2[k];
  }

  public final void reset()
  {
    this.position = 0;
    this.limit = 0;
  }

  public final void reset(int paramInt)
  {
    if (capacity() < paramInt);
    for (byte[] arrayOfByte = new byte[paramInt]; ; arrayOfByte = this.data)
    {
      zzb(arrayOfByte, paramInt);
      return;
    }
  }

  public final void setPosition(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.limit));
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      this.position = paramInt;
      return;
    }
  }

  public final void zzac(int paramInt)
  {
    setPosition(paramInt + this.position);
  }

  public final void zzb(byte[] paramArrayOfByte, int paramInt)
  {
    this.data = paramArrayOfByte;
    this.limit = paramInt;
    this.position = 0;
  }

  public final void zzb(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    System.arraycopy(this.data, this.position, paramArrayOfByte, paramInt1, paramInt2);
    this.position = (paramInt2 + this.position);
  }

  public final void zzbo(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= this.data.length));
    for (boolean bool = true; ; bool = false)
    {
      zzsk.checkArgument(bool);
      this.limit = paramInt;
      return;
    }
  }

  public final String zzbp(int paramInt)
  {
    if (paramInt == 0)
      return "";
    int i = -1 + (paramInt + this.position);
    if ((i < this.limit) && (this.data[i] == 0));
    for (int j = paramInt - 1; ; j = paramInt)
    {
      String str = new String(this.data, this.position, j);
      this.position = (paramInt + this.position);
      return str;
    }
  }

  public final long zzge()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = (0xFF & arrayOfByte1[i]) << 24;
    byte[] arrayOfByte2 = this.data;
    int j = this.position;
    this.position = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 16;
    byte[] arrayOfByte3 = this.data;
    int k = this.position;
    this.position = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 8;
    byte[] arrayOfByte4 = this.data;
    int m = this.position;
    this.position = (m + 1);
    return l3 | 0xFF & arrayOfByte4[m];
  }

  public final int zzgf()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    int j = (0xFF & arrayOfByte1[i]) << 8;
    byte[] arrayOfByte2 = this.data;
    int k = this.position;
    this.position = (k + 1);
    int m = j | 0xFF & arrayOfByte2[k];
    this.position = (2 + this.position);
    return m;
  }

  public final int zzgg()
  {
    int i = readInt();
    if (i < 0)
      throw new IllegalStateException(29 + "Top bit not zero: " + i);
    return i;
  }

  public final long zzgh()
  {
    long l = readLong();
    if (l < 0L)
      throw new IllegalStateException(38 + "Top bit not zero: " + l);
    return l;
  }

  public final int zzjz()
  {
    return this.limit - this.position;
  }

  public final int zzka()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    int j = 0xFF & arrayOfByte1[i];
    byte[] arrayOfByte2 = this.data;
    int k = this.position;
    this.position = (k + 1);
    return j | (0xFF & arrayOfByte2[k]) << 8;
  }

  public final long zzkb()
  {
    byte[] arrayOfByte1 = this.data;
    int i = this.position;
    this.position = (i + 1);
    long l1 = 0xFF & arrayOfByte1[i];
    byte[] arrayOfByte2 = this.data;
    int j = this.position;
    this.position = (j + 1);
    long l2 = l1 | (0xFF & arrayOfByte2[j]) << 8;
    byte[] arrayOfByte3 = this.data;
    int k = this.position;
    this.position = (k + 1);
    long l3 = l2 | (0xFF & arrayOfByte3[k]) << 16;
    byte[] arrayOfByte4 = this.data;
    int m = this.position;
    this.position = (m + 1);
    return l3 | (0xFF & arrayOfByte4[m]) << 24;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzst
 * JD-Core Version:    0.6.2
 */