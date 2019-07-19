package com.google.android.exoplayer2.extractor.f;

import com.google.android.exoplayer2.extractor.i;
import com.google.android.exoplayer2.g.ad;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.g.q;
import com.google.android.exoplayer2.w;

public final class r
  implements ae
{
  private final j a;
  private final q b;
  private int c;
  private int d;
  private ad e;
  private boolean f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private boolean k;
  private long l;

  public r(j paramj)
  {
    this.a = paramj;
    this.b = new q(new byte[10]);
    this.c = 0;
  }

  private void a(int paramInt)
  {
    this.c = paramInt;
    this.d = 0;
  }

  private boolean a(com.google.android.exoplayer2.g.r paramr, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramr.b(), paramInt - this.d);
    if (m <= 0)
      return true;
    if (paramArrayOfByte == null)
      paramr.d(m);
    while (true)
    {
      this.d = (m + this.d);
      if (this.d == paramInt)
        break;
      return false;
      paramr.a(paramArrayOfByte, this.d, m);
    }
  }

  private boolean b()
  {
    this.b.a(0);
    int m = this.b.c(24);
    if (m != 1)
    {
      l.c("PesReader", "Unexpected start code prefix: " + m);
      this.j = -1;
      return false;
    }
    this.b.b(8);
    int n = this.b.c(16);
    this.b.b(5);
    this.k = this.b.e();
    this.b.b(2);
    this.f = this.b.e();
    this.g = this.b.e();
    this.b.b(6);
    this.i = this.b.c(8);
    if (n == 0);
    for (this.j = -1; ; this.j = (-9 + (n + 6) - this.i))
      return true;
  }

  private void c()
  {
    this.b.a(0);
    this.l = -9223372036854775807L;
    if (this.f)
    {
      this.b.b(4);
      long l1 = this.b.c(3) << 30;
      this.b.b(1);
      long l2 = l1 | this.b.c(15) << 15;
      this.b.b(1);
      long l3 = l2 | this.b.c(15);
      this.b.b(1);
      if ((!this.h) && (this.g))
      {
        this.b.b(4);
        long l4 = this.b.c(3) << 30;
        this.b.b(1);
        long l5 = l4 | this.b.c(15) << 15;
        this.b.b(1);
        long l6 = l5 | this.b.c(15);
        this.b.b(1);
        this.e.b(l6);
        this.h = true;
      }
      this.l = this.e.b(l3);
    }
  }

  public final void a()
  {
    this.c = 0;
    this.d = 0;
    this.h = false;
    this.a.a();
  }

  public void a(ad paramad, i parami, ae.d paramd)
  {
    this.e = paramad;
    this.a.a(parami, paramd);
  }

  public final void a(com.google.android.exoplayer2.g.r paramr, int paramInt)
    throws w
  {
    if ((paramInt & 0x1) != 0)
      switch (this.c)
      {
      default:
        throw new IllegalStateException();
      case 2:
        l.c("PesReader", "Unexpected start indicator reading extended header");
      case 0:
      case 1:
        a(1);
      case 3:
      }
    while (true)
      if (paramr.b() > 0)
        switch (this.c)
        {
        default:
          throw new IllegalStateException();
          if (this.j != -1)
            l.c("PesReader", "Unexpected start indicator: expected " + this.j + " more bytes");
          this.a.b();
          break;
        case 0:
          paramr.d(paramr.b());
          break;
        case 1:
          if (a(paramr, this.b.a, 9))
          {
            if (b());
            for (int i3 = 2; ; i3 = 0)
            {
              a(i3);
              break;
            }
          }
          break;
        case 2:
          int i1 = Math.min(10, this.i);
          if ((a(paramr, this.b.a, i1)) && (a(paramr, null, this.i)))
          {
            c();
            if (this.k);
            for (int i2 = 4; ; i2 = 0)
            {
              paramInt |= i2;
              this.a.a(this.l, paramInt);
              a(3);
              break;
            }
          }
          break;
        case 3:
          int m = paramr.b();
          if (this.j == -1);
          for (int n = 0; ; n = m - this.j)
          {
            if (n > 0)
            {
              m -= n;
              paramr.b(m + paramr.d());
            }
            this.a.a(paramr);
            if (this.j == -1)
              break;
            this.j -= m;
            if (this.j != 0)
              break;
            this.a.b();
            a(1);
            break;
          }
        }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.extractor.f.r
 * JD-Core Version:    0.6.2
 */