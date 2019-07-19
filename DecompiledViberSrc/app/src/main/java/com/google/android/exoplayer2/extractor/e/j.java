package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.g.a;

final class j
{
  private final byte[] a;
  private final int b;
  private int c;
  private int d;

  public j(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.b = paramArrayOfByte.length;
  }

  private void c()
  {
    if ((this.c >= 0) && ((this.c < this.b) || ((this.c == this.b) && (this.d == 0))));
    for (boolean bool = true; ; bool = false)
    {
      a.b(bool);
      return;
    }
  }

  public int a(int paramInt)
  {
    int i = this.c;
    int j = Math.min(paramInt, 8 - this.d);
    byte[] arrayOfByte1 = this.a;
    int k = i + 1;
    int m = (0xFF & arrayOfByte1[i]) >> this.d & 255 >> 8 - j;
    while (j < paramInt)
    {
      byte[] arrayOfByte2 = this.a;
      int i1 = k + 1;
      m |= (0xFF & arrayOfByte2[k]) << j;
      j += 8;
      k = i1;
    }
    int n = m & -1 >>> 32 - paramInt;
    b(paramInt);
    return n;
  }

  public boolean a()
  {
    if ((0x1 & (0xFF & this.a[this.c]) >> this.d) == 1);
    for (boolean bool = true; ; bool = false)
    {
      b(1);
      return bool;
    }
  }

  public int b()
  {
    return 8 * this.c + this.d;
  }

  public void b(int paramInt)
  {
    int i = paramInt / 8;
    this.c = (i + this.c);
    this.d += paramInt - i * 8;
    if (this.d > 7)
    {
      this.c = (1 + this.c);
      this.d = (-8 + this.d);
    }
    c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.j
 * JD-Core Version:    0.6.2
 */