package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.ag;
import com.google.android.exoplayer2.g.r;

public final class x
  implements ae
{
  private final w a;
  private final r b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;

  public x(w paramw)
  {
    this.a = paramw;
    this.b = new r(32);
  }

  public void a()
  {
    this.f = true;
  }

  public void a(ad paramad, i parami, ae.d paramd)
  {
    this.a.a(paramad, parami, paramd);
    this.f = true;
  }

  public void a(r paramr, int paramInt)
  {
    int i;
    if ((paramInt & 0x1) != 0)
    {
      i = 1;
      if (i == 0)
        break label438;
    }
    label424: label438: for (int j = paramr.h() + paramr.d(); ; j = -1)
    {
      if (this.f)
      {
        if (i == 0)
        {
          return;
          i = 0;
          break;
        }
        this.f = false;
        paramr.c(j);
        this.d = 0;
      }
      label56: 
      while (paramr.b() > 0)
        if (this.d < 3)
        {
          if (this.d == 0)
          {
            int i2 = paramr.h();
            paramr.c(-1 + paramr.d());
            if (i2 == 255)
            {
              this.f = true;
              return;
            }
          }
          int m = Math.min(paramr.b(), 3 - this.d);
          paramr.a(this.b.a, this.d, m);
          this.d = (m + this.d);
          if (this.d == 3)
          {
            this.b.a(3);
            this.b.d(1);
            int n = this.b.h();
            int i1 = this.b.h();
            if ((n & 0x80) != 0);
            for (boolean bool = true; ; bool = false)
            {
              this.e = bool;
              this.c = (3 + (i1 | (n & 0xF) << 8));
              if (this.b.e() >= this.c)
                break;
              byte[] arrayOfByte = this.b.a;
              this.b.a(Math.min(4098, Math.max(this.c, 2 * arrayOfByte.length)));
              System.arraycopy(arrayOfByte, 0, this.b.a, 0, 3);
              break;
            }
          }
        }
        else
        {
          int k = Math.min(paramr.b(), this.c - this.d);
          paramr.a(this.b.a, this.d, k);
          this.d = (k + this.d);
          if (this.d == this.c)
          {
            if (!this.e)
              break label424;
            if (ag.a(this.b.a, 0, this.c, -1) != 0)
            {
              this.f = true;
              return;
            }
            this.b.a(-4 + this.c);
          }
        }
      while (true)
      {
        this.a.a(this.b);
        this.d = 0;
        break label56;
        break;
        this.b.a(this.c);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.x
 * JD-Core Version:    0.6.2
 */