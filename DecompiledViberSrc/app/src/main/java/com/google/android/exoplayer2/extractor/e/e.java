package com.google.android.exoplayer2.extractor.e;

import com.google.android.exoplayer2.extractor.h;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.r;
import java.io.IOException;
import java.util.Arrays;

final class e
{
  private final f a = new f();
  private final r b = new r(new byte[65025], 0);
  private int c = -1;
  private int d;
  private boolean e;

  private int a(int paramInt)
  {
    int i = 0;
    this.d = 0;
    int k;
    do
    {
      if (paramInt + this.d >= this.a.g)
        break;
      int[] arrayOfInt = this.a.j;
      int j = this.d;
      this.d = (j + 1);
      k = arrayOfInt[(j + paramInt)];
      i += k;
    }
    while (k == 255);
    return i;
  }

  public void a()
  {
    this.a.a();
    this.b.a();
    this.c = -1;
    this.e = false;
  }

  public boolean a(h paramh)
    throws IOException, InterruptedException
  {
    if (paramh != null);
    for (boolean bool1 = true; ; bool1 = false)
    {
      a.b(bool1);
      if (this.e)
      {
        this.e = false;
        this.b.a();
      }
      if (this.e)
        break label296;
      if (this.c >= 0)
        break label126;
      if (this.a.a(paramh, true))
        break;
      return false;
    }
    int m = this.a.h;
    if (((0x1 & this.a.b) == 1) && (this.b.c() == 0))
      m += a(0);
    for (int n = 0 + this.d; ; n = 0)
    {
      paramh.b(m);
      this.c = n;
      label126: int i = a(this.c);
      int j = this.c + this.d;
      boolean bool2;
      if (i > 0)
      {
        if (this.b.e() < i + this.b.c())
          this.b.a = Arrays.copyOf(this.b.a, i + this.b.c());
        paramh.b(this.b.a, this.b.c(), i);
        this.b.b(i + this.b.c());
        if (this.a.j[(j - 1)] != 255)
        {
          bool2 = true;
          label253: this.e = bool2;
        }
      }
      else
      {
        if (j != this.a.g)
          break label289;
      }
      label289: for (int k = -1; ; k = j)
      {
        this.c = k;
        break;
        bool2 = false;
        break label253;
      }
      label296: return true;
    }
  }

  public f b()
  {
    return this.a;
  }

  public r c()
  {
    return this.b;
  }

  public void d()
  {
    if (this.b.a.length == 65025)
      return;
    this.b.a = Arrays.copyOf(this.b.a, Math.max(65025, this.b.c()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.e.e
 * JD-Core Version:    0.6.2
 */