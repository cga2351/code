package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.g.a;
import java.util.Arrays;

final class q
{
  public byte[] a;
  public int b;
  private final int c;
  private boolean d;
  private boolean e;

  public q(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.a = new byte[paramInt2 + 3];
    this.a[2] = 1;
  }

  public void a()
  {
    this.d = false;
    this.e = false;
  }

  public void a(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    if (!this.d)
    {
      bool2 = bool1;
      a.b(bool2);
      if (paramInt != this.c)
        break label51;
    }
    while (true)
    {
      this.d = bool1;
      if (this.d)
      {
        this.b = 3;
        this.e = false;
      }
      return;
      bool2 = false;
      break;
      label51: bool1 = false;
    }
  }

  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.d)
      return;
    int i = paramInt2 - paramInt1;
    if (this.a.length < i + this.b)
      this.a = Arrays.copyOf(this.a, 2 * (i + this.b));
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, this.b, i);
    this.b = (i + this.b);
  }

  public boolean b()
  {
    return this.e;
  }

  public boolean b(int paramInt)
  {
    if (!this.d)
      return false;
    this.b -= paramInt;
    this.d = false;
    this.e = true;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.q
 * JD-Core Version:    0.6.2
 */